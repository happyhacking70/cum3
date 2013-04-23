/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.ReqCmdChnlAudTestAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.junit.BeforeClass;
import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdJoinChnlTest extends ReqCmdChnlAudTestAbst {
	static final public String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"JoinChnl\" AUD=\"testAudience\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(xml);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdTestAbst#getCmdNormal()
	 */
	@Override
	protected CmdAbst getCmdNormal() {
		return new ReqCmdJoinChnl(seshName, chnlName, audName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.cmd.CmdTestAbst#getCmdNormal(org.w3c.dom.Document)
	 */
	@Override
	protected CmdAbst getCmdNormal(Document doc) throws CumExcpIllegalCmdDoc {
		return new ReqCmdJoinChnl(doc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdTestAbst#getXMLNormal()
	 */
	@Override
	protected String getXMLNormal() {
		return xml;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdTestAbst#getActionName()
	 */
	@Override
	protected String getActionName() {
		return "JoinChnl";
	}

}
