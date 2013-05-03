package jp.happyhacking70.cum3.presSvr.comLyr;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import jp.happyhacking70.cum3.chnlLyr.rsc.factory.ChnlRscFactory;
import jp.happyhacking70.cum3.chnlLyr.rsc.factory.ChnlRscFactoryIntf;
import jp.happyhacking70.cum3.presSvr.adptrLyr.PresSvrAdptr;
import jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class PresSvrHttpSvr implements Runnable {
	protected int port;

	protected ChnlRscFactoryIntf chnlRscFactory;
	protected PresSvrAdptr adaptor;

	protected int maxContentSize;

	public PresSvrHttpSvr(int port, ChnlRscFactoryIntf chnlRscFactory,
			PresSvrAdptr adaptor, int maxContentSize) {
		super();
		this.port = port;
		this.chnlRscFactory = chnlRscFactory;
		this.adaptor = adaptor;
		this.maxContentSize = maxContentSize;
	}

	@Override
	public void run() {
		ChannelFactory channelFactory = new NioServerSocketChannelFactory(
				Executors.newCachedThreadPool(),
				Executors.newCachedThreadPool());

		ServerBootstrap bootstrap = new ServerBootstrap(channelFactory);

		bootstrap.setPipelineFactory(new PresSvrHttSvrPipelineFactory(
				maxContentSize, adaptor, chnlRscFactory));
		bootstrap.setOption("child.keepAlive", false);
		bootstrap.bind(new InetSocketAddress(port));

	}

	public static void main(String[] args) {

		ChnlRscFactory chnlRscFactory = new ChnlRscFactory();

		PresSvrHttpSvr server = new PresSvrHttpSvr(80, chnlRscFactory,
				new PresSvrAdptr(new SeshMgrPresSvr()), 1024 * 1024 * 1024);

		Thread myThread = new Thread(server);
		myThread.start();
	}
}
