/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdRegSesh;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdRegSesh;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshExists;
import jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl.PresSvrAdptrHdlrRegSesh;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr;
import jp.happyhacking70.cum3.test.CumTestAbst;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdptrHdlrRegSeshTest extends CumTestAbst {

	/**
	 * @throws IOException
	 */
	public PresSvrAdptrHdlrRegSeshTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl.PresSvrAdptrHdlrRegSesh#hndlCmd(jp.happyhacking70.cum3.cmd.CmdAbst, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf, jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf)}
	 * .
	 * 
	 * @throws CumExcpIllegalCmdDoc
	 * @throws CumExcpIllegalCmdXML
	 */
	@Test
	public void testHndlCmd() throws CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc {
		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();
		PresSvrAdptrHdlrRegSesh hdlr = new PresSvrAdptrHdlrRegSesh();
		senderForPrestr.clearQueue();
		ReqCmdRegSesh reqCmd = new ReqCmdRegSesh(seshName);
		ResCmdRegSesh resCmd = null;
		resCmd = (ResCmdRegSesh) hdlr.hndlCmd(reqCmd, senderForPrestr, seshMgr);

		assertNull(senderForPrestr.pollCmd());

		assertEquals(seshName, resCmd.getSeshName());
		assertEquals(ResCmdRegSesh.RsltTypes.Reged.name(), resCmd.getRslt());

	}

	@Test
	public void testHndlCmd_EXISTS() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc, CumExcpSeshExists {
		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);
		PresSvrAdptrHdlrRegSesh hdlr = new PresSvrAdptrHdlrRegSesh();

		ReqCmdRegSesh reqCmd = new ReqCmdRegSesh(seshName);
		ResCmdRegSesh resCmd = null;
		resCmd = (ResCmdRegSesh) hdlr.hndlCmd(reqCmd, senderForPrestr, seshMgr);

		assertEquals(ResCmdRegSesh.class, resCmd.getClass());
		assertEquals(ResCmdRegSesh.RsltTypes.Exists.name(), resCmd.getRslt());
	}
}
