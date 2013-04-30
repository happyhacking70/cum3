/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.impl.res.ResCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdIllegalXML;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdRegSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdUnknowCmd;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshExists;
import jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr;
import jp.happyhacking70.cum3.test.CumTestAbst;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdptrTest extends CumTestAbst {

	protected PresSvrAdptr adptr = new PresSvrAdptr(new SeshMgrPresSvr());

	/**
	 * @throws IOException
	 */
	public PresSvrAdptrTest() throws IOException {
		super();
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.adptrLyr.PresSvrAdptr#hndlCmd(java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpXMLGenFailed
	 */
	@Test
	public void testHndlCmdString() throws CumExcpSeshExists,
			CumExcpXMLGenFailed {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsSesh\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);

		PresSvrAdptr adptr = new PresSvrAdptr(seshMgr);

		assertEquals(
				new ResCmdClsSesh(seshName, ResCmdClsSesh.RsltTypes.Clsed)
						.toXmlStr(),
				adptr.hndlCmd(xml));
	}

	@Test
	public void testHndlCmdStringBrokenXML() throws CumExcpSeshExists,
			CumExcpXMLGenFailed {
		String xml = "XXXX";
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);

		PresSvrAdptr adptr = new PresSvrAdptr(seshMgr);

		assertEquals(new ResCmdIllegalXML().toXmlStr(), adptr.hndlCmd(xml));

	}

	@Test
	public void testHndlCmdStringUnknownCmd() throws CumExcpSeshExists,
			CumExcpXMLGenFailed {
		senderForPrestr.clearQueue();
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsSesh\" RSLT=\"Clsed\" SESH=\"testSession\" TYPE=\"RES\"/></CUM>";
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);

		PresSvrAdptr adptr = new PresSvrAdptr(seshMgr);

		assertEquals(new ResCmdUnknowCmd().toXmlStr(), adptr.hndlCmd(xml));

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.adptrLyr.PresSvrAdptr#hndlCmd(java.lang.String, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf)}
	 * .
	 * 
	 * @throws CumExcpXMLGenFailed
	 */
	@Test
	public void testHndlCmdStringCmdSenderIntf() throws CumExcpXMLGenFailed {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"RegSesh\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();

		PresSvrAdptr adptr = new PresSvrAdptr(seshMgr);

		assertNull(adptr.hndlCmd(xml, senderForPrestr));
		String resCmdXml = senderForPrestr.pollCmd();
		assertEquals(
				new ResCmdRegSesh(seshName, ResCmdRegSesh.RsltTypes.Reged)
						.toXmlStr(),
				resCmdXml);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.adptrLyr.PresSvrAdptr#hndlCmd(java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcpXMLGenFailed
	 * @throws CumExcpSeshExists
	 */
	@Test
	public void testHndlCmdStringArrayListOfChnlRscIntf()
			throws CumExcpXMLGenFailed, CumExcpSeshExists {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"RegChnl\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"REQ\"><RSC NAME=\"a\"/><RSC NAME=\"b\"/></CMD></CUM>";
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, senderForPrestr);

		PresSvrAdptr adptr = new PresSvrAdptr(seshMgr);

		assertEquals(new ResCmdRegChnl(seshName, chnlName, rscesArray,
				ResCmdRegChnl.RsltTypes.Reged).toXmlStr(), adptr.hndlCmd(xml,
				rscesArray));
	}

}
