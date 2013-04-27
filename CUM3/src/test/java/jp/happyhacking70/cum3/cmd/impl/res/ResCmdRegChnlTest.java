/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.res;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscImg;
import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.ResCmdChnlTestAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.junit.BeforeClass;
import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdRegChnlTest extends ResCmdChnlTestAbst {

	static final public String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"RegChnl\" CHNL=\"testChannel\" RSLT=\"Reged\" SESH=\"testSession\" TYPE=\"RES\"><RSC NAME=\"a\"/><RSC NAME=\"b\"/></CMD></CUM>";
	static final ResCmdRegChnl.RsltTypes rslt = ResCmdRegChnl.RsltTypes.Reged;

	@Override
	protected String getXMLNormal() {
		return xml;
	}

	@Override
	protected String getActionName() {
		return "RegChnl";
	}

	@BeforeClass
	public static final void setBeforeClass() {
		System.out.println(xml);
	}

	@Override
	protected CmdAbst getCmdNormal() {
		ResCmdRegChnl cmd = new ResCmdRegChnl(seshName, chnlName, rslt);

		cmd.addRscData(new ChnlRscImg("a", null));
		cmd.addRscData(new ChnlRscImg("b", null));

		return cmd;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.cmd.CmdTestAbst#getCmdNormal(org.w3c.dom.Document)
	 */
	@Override
	protected CmdAbst getCmdNormal(Document doc) throws CumExcpIllegalCmdDoc {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		rsces.add(new ChnlRscImg("a", null));
		rsces.add(new ChnlRscImg("b", null));
		ResCmdRegChnl cmd = new ResCmdRegChnl(doc);
		return cmd;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.ResCmdTestIntf#getNormalRslt()
	 */
	@Override
	public String getNormalRslt() {
		return rslt.name();

	}

}
