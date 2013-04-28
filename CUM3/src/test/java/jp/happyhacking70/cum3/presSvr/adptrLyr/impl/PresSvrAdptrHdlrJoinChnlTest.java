/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdJoinChnl;
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
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr;
import jp.happyhacking70.cum3.test.CumTestBast;

import org.junit.Before;
import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdptrHdlrJoinChnlTest extends CumTestBast {

	/**
	 * @throws IOException
	 */
	public PresSvrAdptrHdlrJoinChnlTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		senderForAudA.clearQueue();
		senderForAudB.clearQueue();
		senderForPrestr.clearQueue();
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.adptrLyr.impl.PresSvrAdptrHdlrJoinChnl#hndlCmd(jp.happyhacking70.cum3.cmd.CmdAbst, jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpIllegalCmdDoc
	 * @throws CumExcpIllegalCmdXML
	 */
	@Test
	public void testHndlCmd() throws CumExcpSeshExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcpRscNull, CumExcpSeshNotExist,
			CumExcpAudExists, CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc {

		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);
		seshMgr.regChnl(seshName, chnlName, rscesArray);
		seshMgr.joinSesh(seshName, audName, senderForAudA);
		senderForAudA.pollCmd();

		PresSvrAdptrHdlrJoinChnl hdlr = new PresSvrAdptrHdlrJoinChnl();

		ResCmdJoinChnl resCmd = (ResCmdJoinChnl) hdlr.hndlCmd(
				new ReqCmdJoinChnl(seshName, chnlName, audName), seshMgr);

		assertEquals(ResCmdJoinChnl.class, resCmd.getClass());
		assertEquals(seshName, resCmd.getSeshName());
		assertEquals(chnlName, resCmd.getChnlName());
		assertEquals(audName, resCmd.getAudName());
		assertEquals(ResCmdJoinChnl.RsltTypes.Joined.name(), resCmd.getRslt());

	}

	@Test
	public void testHndlCmd_NOSESH() throws CumExcpSeshExists,
			CumExcpRscExists, CumExcpChnlExists, CumExcpRscNull,
			CumExcpAudExists, CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc,
			CumExcpSeshNotExist {

		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);
		seshMgr.regChnl(seshName, chnlName, rscesArray);
		seshMgr.joinSesh(seshName, audName, senderForAudA);
		senderForAudA.pollCmd();

		PresSvrAdptrHdlrJoinChnl hdlr = new PresSvrAdptrHdlrJoinChnl();

		ResCmdJoinChnl resCmd = (ResCmdJoinChnl) hdlr.hndlCmd(
				new ReqCmdJoinChnl("XXX", chnlName, audName), seshMgr);

		assertEquals(ResCmdJoinChnl.class, resCmd.getClass());
		assertEquals("XXX", resCmd.getSeshName());
		assertEquals(chnlName, resCmd.getChnlName());
		assertEquals(audName, resCmd.getAudName());
		assertEquals(ResCmdJoinChnl.RsltTypes.SeshNotExist.name(),
				resCmd.getRslt());

	}

	@Test
	public void testHndlCmd_NOCHNL() throws CumExcpSeshExists,
			CumExcpRscExists, CumExcpChnlExists, CumExcpRscNull,
			CumExcpSeshNotExist, CumExcpAudExists, CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {

		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);
		seshMgr.regChnl(seshName, chnlName, rscesArray);
		seshMgr.joinSesh(seshName, audName, senderForAudA);
		senderForAudA.pollCmd();

		PresSvrAdptrHdlrJoinChnl hdlr = new PresSvrAdptrHdlrJoinChnl();

		ResCmdJoinChnl resCmd = (ResCmdJoinChnl) hdlr.hndlCmd(
				new ReqCmdJoinChnl(seshName, "XXX", audName), seshMgr);

		assertEquals(ResCmdJoinChnl.class, resCmd.getClass());
		assertEquals(seshName, resCmd.getSeshName());
		assertEquals("XXX", resCmd.getChnlName());
		assertEquals(audName, resCmd.getAudName());
		assertEquals(ResCmdJoinChnl.RsltTypes.ChnlNotExist.name(),
				resCmd.getRslt());

	}

	@Test
	public void testHndlCmd_AUDEXIST() throws CumExcpSeshExists,
			CumExcpRscExists, CumExcpChnlExists, CumExcpRscNull,
			CumExcpSeshNotExist, CumExcpAudExists, CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc, CumExcpAudNotExist, CumExcpChnlNotExist {

		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);
		seshMgr.regChnl(seshName, chnlName, rscesArray);
		seshMgr.joinSesh(seshName, audName, senderForAudA);
		senderForAudA.pollCmd();
		seshMgr.joinChnl(seshName, chnlName, audName);

		PresSvrAdptrHdlrJoinChnl hdlr = new PresSvrAdptrHdlrJoinChnl();

		ResCmdJoinChnl resCmd = (ResCmdJoinChnl) hdlr.hndlCmd(
				new ReqCmdJoinChnl(seshName, chnlName, audName), seshMgr);

		assertEquals(ResCmdJoinChnl.class, resCmd.getClass());
		assertEquals(seshName, resCmd.getSeshName());
		assertEquals(chnlName, resCmd.getChnlName());
		assertEquals(audName, resCmd.getAudName());
		assertEquals(ResCmdJoinChnl.RsltTypes.Exists.name(), resCmd.getRslt());

	}

	@Test
	public void testHndlCmd_AUDNOTEXIST() throws CumExcpSeshExists,
			CumExcpRscExists, CumExcpChnlExists, CumExcpRscNull,
			CumExcpSeshNotExist, CumExcpAudExists, CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {

		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);
		seshMgr.regChnl(seshName, chnlName, rscesArray);

		PresSvrAdptrHdlrJoinChnl hdlr = new PresSvrAdptrHdlrJoinChnl();

		ResCmdJoinChnl resCmd = (ResCmdJoinChnl) hdlr.hndlCmd(
				new ReqCmdJoinChnl(seshName, chnlName, audName), seshMgr);

		assertEquals(ResCmdJoinChnl.class, resCmd.getClass());
		assertEquals(seshName, resCmd.getSeshName());
		assertEquals(chnlName, resCmd.getChnlName());
		assertEquals(audName, resCmd.getAudName());
		assertEquals(ResCmdJoinChnl.RsltTypes.AudNotExist.name(),
				resCmd.getRslt());

	}
}
