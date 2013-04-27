/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.comLyr.adaptor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdClsSesh;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshExists;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr;
import jp.happyhacking70.cum3.test.CumTestBast;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdaptorHdlrClsSeshTest extends CumTestBast {

	/**
	 * @throws IOException
	 */
	public PresSvrAdaptorHdlrClsSeshTest() throws IOException {
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
	 */
	@Test
	public void testHndlCmd() throws CumExcpSeshExists, CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, senderForPrestr);
		PresSvrAdaptorHdlrClsSesh hdlr = new PresSvrAdaptorHdlrClsSesh();

		ResCmdClsSesh resCmd = (ResCmdClsSesh) hdlr.hndlCmd(new ReqCmdClsSesh(
				seshName), seshMgr);

		assertEquals(ResCmdClsSesh.class, resCmd.getClass());
		assertEquals(ResCmdClsSesh.RsltTypes.Clsed.name(), resCmd.getRslt());
	}

	@Test
	public void testHndlCmd_NOSESH() throws CumExcpSeshExists,
			CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc {
		SeshMgrPresSvrAllIntf seshMgr = new SeshMgrPresSvr();

		PresSvrAdaptorHdlrClsSesh hdlr = new PresSvrAdaptorHdlrClsSesh();

		ResCmdClsSesh resCmd = (ResCmdClsSesh) hdlr.hndlCmd(new ReqCmdClsSesh(
				seshName), seshMgr);

		assertEquals(ResCmdClsSesh.class, resCmd.getClass());
		assertEquals(ResCmdClsSesh.RsltTypes.NotExist.name(), resCmd.getRslt());
	}
}
