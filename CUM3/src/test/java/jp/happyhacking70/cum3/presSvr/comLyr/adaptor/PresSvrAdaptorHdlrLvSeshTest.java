/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.comLyr.adaptor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdLvSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdLvSesh;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcptNullRsces;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr;
import jp.happyhacking70.cum3.test.CumTestBast;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdaptorHdlrLvSeshTest extends CumTestBast {

	/**
	 * @throws IOException
	 */
	public PresSvrAdaptorHdlrLvSeshTest() throws IOException {
		super();

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.comLyr.adaptor.PresSvrAdaptorHdlrClsSesh#hndlCmd(jp.happyhacking70.cum3.cmd.CmdAbst, jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpIllegalCmdDoc
	 * @throws CumExcpIllegalCmdXML
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testHndlCmd() throws CumExcpSeshExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpSeshNotExist, CumExcpAudExists, CumExcpAudNotExist,
			CumExcpChnlNotExist, CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc {

		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);

		seshMgr.joinSesh(seshName, audName, senderForAudA);

		PresSvrAdaptorHdlrLvSesh hdlr = new PresSvrAdaptorHdlrLvSesh();

		ResCmdLvSesh resCmd = (ResCmdLvSesh) hdlr.hndlCmd(new ReqCmdLvSesh(
				seshName, audName), seshMgr);

		assertEquals(ResCmdLvSesh.class, resCmd.getClass());
		assertEquals(ResCmdLvSesh.RsltTypes.Left.name(), resCmd.getRslt());
	}

	@Test
	public void testHndlCmd_NOSESH() throws CumExcpSeshExists,
			CumExcpRscExists, CumExcpChnlExists, CumExcptNullRsces,
			CumExcpRscNull, CumExcpSeshNotExist, CumExcpAudExists,
			CumExcpAudNotExist, CumExcpChnlNotExist, CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {

		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);

		seshMgr.joinSesh(seshName, audName, senderForAudA);

		PresSvrAdaptorHdlrLvSesh hdlr = new PresSvrAdaptorHdlrLvSesh();

		ResCmdLvSesh resCmd = (ResCmdLvSesh) hdlr.hndlCmd(new ReqCmdLvSesh(
				"XXX", audName), seshMgr);

		assertEquals(ResCmdLvSesh.class, resCmd.getClass());
		assertEquals(ResCmdLvSesh.RsltTypes.SeshNotExist.name(),
				resCmd.getRslt());
	}

	@Test
	public void testHndlCmd_NOAUD() throws CumExcpSeshExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpSeshNotExist, CumExcpAudExists, CumExcpAudNotExist,
			CumExcpChnlNotExist, CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc {

		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);

		seshMgr.joinSesh(seshName, audName, senderForAudA);

		PresSvrAdaptorHdlrLvSesh hdlr = new PresSvrAdaptorHdlrLvSesh();

		ResCmdLvSesh resCmd = (ResCmdLvSesh) hdlr.hndlCmd(new ReqCmdLvSesh(
				seshName, "XXX"), seshMgr);

		assertEquals(ResCmdLvSesh.class, resCmd.getClass());
		assertEquals(ResCmdLvSesh.RsltTypes.NotExist.name(), resCmd.getRslt());
	}
}
