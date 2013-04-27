/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.comLyr.adaptor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdClsChnl;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlExists;
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
public class PresSvrAdaptorHdlrClsChnlTest extends CumTestBast {

	/**
	 * @throws IOException
	 */
	public PresSvrAdaptorHdlrClsChnlTest() throws IOException {
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
	 */
	@Test
	public void testHndlCmd() throws CumExcpSeshExists, CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc, CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpSeshNotExist {
		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);
		seshMgr.regChnl(seshName, chnlName, rscesArray);

		PresSvrAdaptorHdlrClsChnl hdlr = new PresSvrAdaptorHdlrClsChnl();

		ResCmdClsChnl resCmd = (ResCmdClsChnl) hdlr.hndlCmd(new ReqCmdClsChnl(
				seshName, chnlName), seshMgr);

		assertEquals(ResCmdClsChnl.class, resCmd.getClass());
		assertEquals(ResCmdClsChnl.RsltTypes.Clsed.name(), resCmd.getRslt());
	}

	@Test
	public void testHndlCmd_NOSESH() throws CumExcpSeshExists,
			CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc {
		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		PresSvrAdaptorHdlrClsChnl hdlr = new PresSvrAdaptorHdlrClsChnl();

		ResCmdClsChnl resCmd = (ResCmdClsChnl) hdlr.hndlCmd(new ReqCmdClsChnl(
				seshName, chnlName), seshMgr);

		assertEquals(ResCmdClsChnl.class, resCmd.getClass());
		assertEquals(ResCmdClsChnl.RsltTypes.SeshNotExist.name(),
				resCmd.getRslt());
	}

	@Test
	public void testHndlCmd_NOCHNL() throws CumExcpSeshExists,
			CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc {
		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);

		PresSvrAdaptorHdlrClsChnl hdlr = new PresSvrAdaptorHdlrClsChnl();

		ResCmdClsChnl resCmd = (ResCmdClsChnl) hdlr.hndlCmd(new ReqCmdClsChnl(
				seshName, chnlName), seshMgr);

		assertEquals(ResCmdClsChnl.class, resCmd.getClass());
		assertEquals(ResCmdClsChnl.RsltTypes.NotExist.name(), resCmd.getRslt());
	}
}
