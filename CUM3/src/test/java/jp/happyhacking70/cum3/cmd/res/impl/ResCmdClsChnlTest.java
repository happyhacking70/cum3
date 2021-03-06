/**
 * 
 */
package jp.happyhacking70.cum3.cmd.res.impl;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.ResCmdChnlTestAbst;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdClsChnl;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.junit.BeforeClass;
import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdClsChnlTest extends ResCmdChnlTestAbst {
	/**
	 * @throws IOException
	 */
	public ResCmdClsChnlTest() throws IOException {
		super();
	}

	static final public String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsChnl\" CHNL=\"testChannel\" RSLT=\"Clsed\" SESH=\"testSession\" TYPE=\"RES\"/></CUM>";
	static final ResCmdClsChnl.RsltTypes rslt = ResCmdClsChnl.RsltTypes.Clsed;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(xml);
	}

	@Override
	protected CmdAbst getCmdNormal() {
		return new ResCmdClsChnl(seshName, chnlName,
				ResCmdClsChnl.RsltTypes.Clsed);
	}

	@Override
	protected String getXMLNormal() {
		return xml;
	}

	@Override
	protected String getActionName() {
		return "ClsChnl";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.cmd.CmdTestAbst#getCmdNormal(org.w3c.dom.Document)
	 */
	@Override
	protected CmdAbst getCmdNormal(Document doc) throws CumExcpIllegalCmdDoc {
		return new ResCmdClsChnl(doc);
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
