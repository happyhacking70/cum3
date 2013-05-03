package jp.happyhacking70.cum3.presSvr.comLyr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.chnlLyr.rsc.factory.ChnlRscFactoryIntf;
import jp.happyhacking70.cum3.excp.impl.rsc.CumExcpRscInstantiateFailed;
import jp.happyhacking70.cum3.excp.impl.rsc.CumExcpUnknowDataTypeForChnlRsc;
import jp.happyhacking70.cum3.presSvr.adptrLyr.PresSvrAdptr;
import jp.happyhacking70.cum3.presSvr.adptrLyr.discnHdlr.DiscnHdlrAbst;

import org.javatuples.Pair;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.QueryStringDecoder;
import org.jboss.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import org.jboss.netty.handler.codec.http.multipart.FileUpload;
import org.jboss.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import org.jboss.netty.handler.codec.http.multipart.HttpPostRequestDecoder.ErrorDataDecoderException;
import org.jboss.netty.handler.codec.http.multipart.HttpPostRequestDecoder.IncompatibleDataDecoderException;
import org.jboss.netty.handler.codec.http.multipart.HttpPostRequestDecoder.NotEnoughDataDecoderException;
import org.jboss.netty.handler.codec.http.multipart.InterfaceHttpData;

public class PresSvrHttpSvrHdlr extends SimpleChannelUpstreamHandler {

	/**
	 * Pathes
	 * 
	 * @author happyhacking70@gmail.com
	 * 
	 */
	public enum Pathes {
		/** Register Session */
		regSesh,
		/** Register Channel */
		regChnl,
		/** Join Session */
		joinSesh,
		/** Other commands */
		cmd
	}

	protected PresSvrAdptr adaptor;
	protected ChnlRscFactoryIntf chnlRscFactory;

	protected boolean returned = false;
	protected DiscnHdlrAbst discnHdlr = null;

	protected CmdSender cmdSender;
	protected Channel chnl;

	public PresSvrHttpSvrHdlr(PresSvrAdptr adaptor,
			ChnlRscFactoryIntf chnlRscFactory) {
		super();
		this.adaptor = adaptor;
		this.chnlRscFactory = chnlRscFactory;
	}

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
		System.out.println("MSg RECEIVED");
		HttpRequest req = (HttpRequest) e.getMessage();
		QueryStringDecoder qsdec = new QueryStringDecoder(req.getUri());
		String path = qsdec.getPath();
		Map<String, List<String>> params = qsdec.getParameters();

		List<String> vals = params.get("cmd");
		chnl = e.getChannel();
		String xml;

		if (vals == null) {
			chnl.disconnect();
		} else if (vals.size() != 1) {
			chnl.disconnect();
		} else {
			xml = vals.get(0);

			System.out.println("lets go");
			System.out.println(path);
			if (path.equals("/" + Pathes.regSesh.name())) {
				System.out.println("regSesh");
				hndlCmdAndKeep(xml);
			} else if (path.equals("/" + Pathes.regChnl.name())) {
				hndlRegChnl(xml, req);
			} else if (path.equals("/" + Pathes.joinSesh.name())) {
				hndlCmdAndKeep(xml);
			} else if (path.equals("/" + Pathes.cmd.name())) {
				hndlCmdAndClose(xml);
			} else {
				chnl.disconnect();
			}
		}

	}

	protected void hndlRegChnl(String xml, HttpRequest req) {
		List<InterfaceHttpData> httpDatas;
		try {
			httpDatas = new HttpPostRequestDecoder(new DefaultHttpDataFactory(
					DefaultHttpDataFactory.MINSIZE), req).getBodyHttpDatas();
			ArrayList<ChnlRscIntf> rsces = getRsces(httpDatas);

			Pair<String, DiscnHdlrAbst> p = adaptor.hndlCmd(xml, rsces);
			returned = true;
			discnHdlr = p.getValue1();
			sendAndClose(p.getValue0());

		} catch (NotEnoughDataDecoderException e) {
			chnl.disconnect();
		} catch (ErrorDataDecoderException e) {
			chnl.disconnect();
		} catch (IncompatibleDataDecoderException e) {
			chnl.disconnect();
		} catch (CumExcpUnknowDataTypeForChnlRsc e) {
			chnl.disconnect();
		} catch (CumExcpRscInstantiateFailed e) {
			chnl.disconnect();
		} catch (IOException e) {
			chnl.disconnect();
		}

	}

	protected ArrayList<ChnlRscIntf> getRsces(List<InterfaceHttpData> httpDatas)
			throws CumExcpUnknowDataTypeForChnlRsc,
			CumExcpRscInstantiateFailed, IOException {

		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();

		for (InterfaceHttpData data : httpDatas) {
			if (data instanceof FileUpload) {
				FileUpload f = (FileUpload) data;
				rsces.add(chnlRscFactory.getChnlRsc(f.getContentType(),
						f.getName(), f.get()));
			}
		}

		return rsces;
	}

	protected void hndlCmdAndClose(String xml) {
		Pair<String, DiscnHdlrAbst> p = adaptor.hndlCmd(xml);
		returned = true;
		discnHdlr = p.getValue1();
		sendAndClose(p.getValue0());
	}

	protected void hndlCmdAndKeep(String xml) {
		cmdSender = new CmdSender();
		Pair<String, DiscnHdlrAbst> p = adaptor.hndlCmd(xml, cmdSender);
		returned = true;
		discnHdlr = p.getValue1();
		keepSending(p.getValue0());
	}

	protected void sendAndClose(String resCmd) {
		sendResHeader();
		sendContentType();
		sendContentLength(resCmd);
		chnl.write("\r\n");
		chnl.write(resCmd + "\r\n");
	}

	protected void keepSending(String initRes) {
		sendResHeader();
		sendContentType();
		chnl.write("\r\n");
		chnl.write(initRes + "\r\n");
		System.out.println(initRes);
		while (true) {
			String cmd = cmdSender.poll();
			if (cmd != null) {
				chnl.write(cmd + "\r\n");
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	protected void sendContentLength(String cmd) {
		chnl.write("Content-Length: " + Integer.toString(cmd.length()));
		chnl.write("\r\n");

	}

	protected void sendResHeader() {
		chnl.write("HTTP/1.1 200 OK");
		chnl.write("\r\n");
	}

	protected void sendContentType() {
		chnl.write("Content-Type: text/plain; charset=UTF-8");
		chnl.write("\r\n");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
			throws Exception {

		while (returned == false) {
			Thread.sleep(1);
		}

		if (discnHdlr != null) {
			discnHdlr.notifyDiscon();
		}

	}
}
