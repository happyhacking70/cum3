/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdLvSesh;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdLvSesh;
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
import jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl.PresSvrAdptrHdlrLvSesh;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr;
import jp.happyhacking70.cum3.test.CumTestAbst;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdptrHdlrLvSeshTest extends CumTestAbst {

	/**
	 * @throws IOException
	 */
	public PresSvrAdptrHdlrLvSeshTest() throws IOException {
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
			CumExcpChnlExists, CumExcpRscNull, CumExcpSeshNotExist,
			CumExcpAudExists, CumExcpAudNotExist, CumExcpChnlNotExist,
			CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc {

		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);

		seshMgr.joinSesh(seshName, audName, senderForAudA);

		PresSvrAdptrHdlrLvSesh hdlr = new PresSvrAdptrHdlrLvSesh();

		ResCmdLvSesh resCmd = (ResCmdLvSesh) hdlr.hndlCmd(new ReqCmdLvSesh(
				seshName, audName), seshMgr);

		assertEquals(ResCmdLvSesh.class, resCmd.getClass());
		assertEquals(ResCmdLvSesh.RsltTypes.Left.name(), resCmd.getRslt());
	}

	@Test
	public void testHndlCmd_NOSESH() throws CumExcpSeshExists,
			CumExcpRscExists, CumExcpChnlExists, CumExcpRscNull,
			CumExcpSeshNotExist, CumExcpAudExists, CumExcpAudNotExist,
			CumExcpChnlNotExist, CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc {

		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);

		seshMgr.joinSesh(seshName, audName, senderForAudA);

		PresSvrAdptrHdlrLvSesh hdlr = new PresSvrAdptrHdlrLvSesh();

		ResCmdLvSesh resCmd = (ResCmdLvSesh) hdlr.hndlCmd(new ReqCmdLvSesh(
				"XXX", audName), seshMgr);

		assertEquals(ResCmdLvSesh.class, resCmd.getClass());
		assertEquals(ResCmdLvSesh.RsltTypes.SeshNotExist.name(),
				resCmd.getRslt());
	}

	@Test
	public void testHndlCmd_NOAUD() throws CumExcpSeshExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcpRscNull, CumExcpSeshNotExist,
			CumExcpAudExists, CumExcpAudNotExist, CumExcpChnlNotExist,
			CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc {

		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);

		seshMgr.joinSesh(seshName, audName, senderForAudA);

		PresSvrAdptrHdlrLvSesh hdlr = new PresSvrAdptrHdlrLvSesh();

		ResCmdLvSesh resCmd = (ResCmdLvSesh) hdlr.hndlCmd(new ReqCmdLvSesh(
				seshName, "XXX"), seshMgr);

		assertEquals(ResCmdLvSesh.class, resCmd.getClass());
		assertEquals(ResCmdLvSesh.RsltTypes.NotExist.name(), resCmd.getRslt());
	}
}
