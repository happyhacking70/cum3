/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdClsSesh;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshExists;
import jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl.PresSvrAdptrHdlrClsSesh;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr;
import jp.happyhacking70.cum3.test.CumTestAbst;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdptrHdlrClsSeshTest extends CumTestAbst {

	/**
	 * @throws IOException
	 */
	public PresSvrAdptrHdlrClsSeshTest() throws IOException {
		super();

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl.PresSvrAdptrHdlrClsSesh#hndlCmd(jp.happyhacking70.cum3.cmd.CmdAbst, jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpIllegalCmdDoc
	 * @throws CumExcpIllegalCmdXML
	 */
	@Test
	public void testHndlCmd() throws CumExcpSeshExists, CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, senderForPrestr);
		PresSvrAdptrHdlrClsSesh hdlr = new PresSvrAdptrHdlrClsSesh();

		ResCmdClsSesh resCmd = (ResCmdClsSesh) hdlr.hndlCmd(new ReqCmdClsSesh(
				seshName), seshMgr);

		assertEquals(ResCmdClsSesh.class, resCmd.getClass());
		assertEquals(ResCmdClsSesh.RsltTypes.Clsed.name(), resCmd.getRslt());
	}

	@Test
	public void testHndlCmd_NOSESH() throws CumExcpSeshExists,
			CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc {
		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		PresSvrAdptrHdlrClsSesh hdlr = new PresSvrAdptrHdlrClsSesh();

		ResCmdClsSesh resCmd = (ResCmdClsSesh) hdlr.hndlCmd(new ReqCmdClsSesh(
				seshName), seshMgr);

		assertEquals(ResCmdClsSesh.class, resCmd.getClass());
		assertEquals(ResCmdClsSesh.RsltTypes.NotExist.name(), resCmd.getRslt());
	}
}
