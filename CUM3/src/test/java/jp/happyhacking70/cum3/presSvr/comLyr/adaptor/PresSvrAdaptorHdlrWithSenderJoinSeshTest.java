/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.comLyr.adaptor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdJoinSesh;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshNotExist;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr;
import jp.happyhacking70.cum3.test.CumTestBast;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdaptorHdlrWithSenderJoinSeshTest extends CumTestBast {

	/**
	 * @throws IOException
	 */
	public PresSvrAdaptorHdlrWithSenderJoinSeshTest() throws IOException {
		super();
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.comLyr.adaptor.PresSvrAdaptorHdlrWithSenderJoinSesh#hndlCmd(jp.happyhacking70.cum3.cmd.CmdAbst, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf, jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpIllegalCmdDoc
	 * @throws CumExcpIllegalCmdXML
	 * @throws CumExcpXMLGenFailed
	 */
	@Test
	public void testHndlCmd() throws CumExcpSeshExists, CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc, CumExcpXMLGenFailed {
		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);

		PresSvrAdaptorHdlrWithSenderJoinSesh hdlr = new PresSvrAdaptorHdlrWithSenderJoinSesh();
		ReqCmdJoinSesh reqCmd = new ReqCmdJoinSesh(seshName, audName);
		ResCmdJoinSesh resCmd = null;
		resCmd = (ResCmdJoinSesh) hdlr.hndlCmd(reqCmd, senderForAudA, seshMgr);
		assertNull(resCmd);
		String resCmdXML = senderForAudA.pollCmd();
		ResCmdJoinSesh resCmdShouldBe = new ResCmdJoinSesh(seshName, audName,
				ResCmdJoinSesh.RsltTypes.Joined);

		assertEquals(resCmdShouldBe.toXmlStr(), resCmdXML);

	}

	@Test
	public void testHndlCmd_NOSESH() throws CumExcpSeshExists,
			CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc, CumExcpXMLGenFailed {
		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);

		PresSvrAdaptorHdlrWithSenderJoinSesh hdlr = new PresSvrAdaptorHdlrWithSenderJoinSesh();
		ReqCmdJoinSesh reqCmd = new ReqCmdJoinSesh("XXX", audName);
		ResCmdJoinSesh resCmd = null;
		resCmd = (ResCmdJoinSesh) hdlr.hndlCmd(reqCmd, senderForAudA, seshMgr);
		assertEquals(ResCmdJoinSesh.class, resCmd.getClass());
		assertEquals(resCmd.getSeshName(), "XXX");
		assertEquals(ResCmdJoinSesh.RsltTypes.NotExist.name(), resCmd.getRslt());

	}

	@Test
	public void testHndlCmd_AUDEXISTS() throws CumExcpSeshExists,
			CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc, CumExcpXMLGenFailed,
			CumExcpAudExists, CumExcpSeshNotExist {
		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);
		seshMgr.joinSesh(seshName, audName, senderForAudA);

		PresSvrAdaptorHdlrWithSenderJoinSesh hdlr = new PresSvrAdaptorHdlrWithSenderJoinSesh();
		ReqCmdJoinSesh reqCmd = new ReqCmdJoinSesh(seshName, audName);
		ResCmdJoinSesh resCmd = null;
		resCmd = (ResCmdJoinSesh) hdlr.hndlCmd(reqCmd, senderForAudA, seshMgr);
		assertEquals(ResCmdJoinSesh.class, resCmd.getClass());
		assertEquals(resCmd.getSeshName(), seshName);
		assertEquals(ResCmdJoinSesh.RsltTypes.Exists.name(), resCmd.getRslt());

	}
}