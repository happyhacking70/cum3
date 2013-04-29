/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRjctChnl;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdRjctChnl;
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
import jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl.PresSvrAdptrHdlrRjctChnl;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr;
import jp.happyhacking70.cum3.test.CumTestBast;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdptrrHdlrRjctChnlTest extends CumTestBast {

	/**
	 * @throws IOException
	 */
	public PresSvrAdptrrHdlrRjctChnlTest() throws IOException {
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
	 */
	@Test
	public void testHndlCmd() throws CumExcpSeshExists, CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc, CumExcpRscExists, CumExcpChnlExists,
			CumExcpRscNull, CumExcpSeshNotExist, CumExcpAudExists {
		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);
		seshMgr.regChnl(seshName, chnlName, rscesArray);
		seshMgr.joinSesh(seshName, audName, senderForAudA);

		PresSvrAdptrHdlrRjctChnl hdlr = new PresSvrAdptrHdlrRjctChnl();

		ResCmdRjctChnl resCmd = (ResCmdRjctChnl) hdlr.hndlCmd(
				new ReqCmdRjctChnl(seshName, chnlName, audName), seshMgr);

		assertEquals(ResCmdRjctChnl.class, resCmd.getClass());
		assertEquals(ResCmdRjctChnl.RsltTypes.Rjcted.name(), resCmd.getRslt());
	}

	@Test
	public void testHndlCmd_NOSESH() throws CumExcpSeshExists,
			CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc, CumExcpRscExists,
			CumExcpChnlExists, CumExcpRscNull, CumExcpSeshNotExist,
			CumExcpAudExists {
		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, senderForPrestr);
		seshMgr.regChnl(seshName, chnlName, rscesArray);
		seshMgr.joinSesh(seshName, audName, senderForAudA);
		PresSvrAdptrHdlrRjctChnl hdlr = new PresSvrAdptrHdlrRjctChnl();

		ResCmdRjctChnl resCmd = (ResCmdRjctChnl) hdlr.hndlCmd(
				new ReqCmdRjctChnl("XXX", chnlName, audName), seshMgr);

		assertEquals(ResCmdRjctChnl.class, resCmd.getClass());
		assertEquals(ResCmdRjctChnl.RsltTypes.SeshNotExist.name(),
				resCmd.getRslt());
	}

	@Test
	public void testHndlCmd_NOCHNL() throws CumExcpSeshExists,
			CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc, CumExcpAudExists,
			CumExcpSeshNotExist, CumExcpRscExists, CumExcpChnlExists,
			CumExcpRscNull {
		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);
		seshMgr.regChnl(seshName, chnlName, rscesArray);
		seshMgr.joinSesh(seshName, audName, senderForAudA);

		PresSvrAdptrHdlrRjctChnl hdlr = new PresSvrAdptrHdlrRjctChnl();

		ResCmdRjctChnl resCmd = (ResCmdRjctChnl) hdlr.hndlCmd(
				new ReqCmdRjctChnl(seshName, "XXX", audName), seshMgr);

		assertEquals(ResCmdRjctChnl.class, resCmd.getClass());
		assertEquals(ResCmdRjctChnl.RsltTypes.ChnlNotExist.name(),
				resCmd.getRslt());
	}

	@Test
	public void testHndlCmd_AUDEXIST() throws CumExcpSeshExists,
			CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc, CumExcpAudExists,
			CumExcpSeshNotExist, CumExcpRscExists, CumExcpChnlExists,
			CumExcpRscNull, CumExcpAudNotExist, CumExcpChnlNotExist {
		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);
		seshMgr.regChnl(seshName, chnlName, rscesArray);
		seshMgr.joinSesh(seshName, audName, senderForAudA);
		seshMgr.joinChnl(seshName, chnlName, audName);

		PresSvrAdptrHdlrRjctChnl hdlr = new PresSvrAdptrHdlrRjctChnl();

		ResCmdRjctChnl resCmd = (ResCmdRjctChnl) hdlr.hndlCmd(
				new ReqCmdRjctChnl(seshName, chnlName, audName), seshMgr);

		assertEquals(ResCmdRjctChnl.class, resCmd.getClass());
		assertEquals(ResCmdRjctChnl.RsltTypes.Exists.name(), resCmd.getRslt());
	}
}
