/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.res.impl.ResCmdClsSesh;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdIllegalXML;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdRegChnl;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdRegSesh;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdUnknowCmd;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshNotExist;
import jp.happyhacking70.cum3.presSvr.adptrLyr.disconHdlr.DisconHdlrAbst;
import jp.happyhacking70.cum3.presSvr.adptrLyr.disconHdlr.DisconHdlrAud;
import jp.happyhacking70.cum3.presSvr.adptrLyr.disconHdlr.DisconHdlrPrestr;
import jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr;
import jp.happyhacking70.cum3.test.CumTestAbst;

import org.javatuples.Pair;
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
	public void testHndlCmdStringPrestrCmd() throws CumExcpSeshExists,
			CumExcpXMLGenFailed {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsSesh\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);

		PresSvrAdptr adptr = new PresSvrAdptr(seshMgr);

		Pair<String, DisconHdlrAbst> p = adptr.hndlCmd(xml);

		assertEquals(DisconHdlrPrestr.class, p.getValue1().getClass());
		assertEquals(
				new ResCmdClsSesh(seshName, ResCmdClsSesh.RsltTypes.Clsed)
						.toXmlStr(),
				p.getValue0());
	}

	@Test
	public void testHndlCmdStringAudCmdCmd() throws CumExcpSeshExists,
			CumExcpXMLGenFailed, CumExcpRscExists, CumExcpChnlExists,
			CumExcpRscNull, CumExcpSeshNotExist, CumExcpAudExists {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"JoinChnl\" AUD=\"testAudience\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);
		seshMgr.regChnl(seshName, chnlName, rscesArray);
		seshMgr.joinSesh(seshName, audName, senderForAudA);

		PresSvrAdptr adptr = new PresSvrAdptr(seshMgr);

		Pair<String, DisconHdlrAbst> p = adptr.hndlCmd(xml);

		assertEquals(DisconHdlrAud.class, p.getValue1().getClass());
		assertEquals(new ResCmdJoinChnl(seshName, chnlName, audName,
				ResCmdJoinChnl.RsltTypes.Joined.name()).toXmlStr(),
				p.getValue0());
	}

	@Test
	public void testHndlCmdStringBrokenXML() throws CumExcpSeshExists,
			CumExcpXMLGenFailed {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><A></A>";
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);

		PresSvrAdptr adptr = new PresSvrAdptr(seshMgr);
		Pair<String, DisconHdlrAbst> p = adptr.hndlCmd(xml);
		assertEquals(new ResCmdIllegalXML().toXmlStr(), p.getValue0());
		assertNull(p.getValue1());

	}

	@Test
	public void testHndlCmdStringUnknownCmd() throws CumExcpSeshExists,
			CumExcpXMLGenFailed {
		senderForPrestr.clearQueue();
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsSesh\" RSLT=\"Clsed\" SESH=\"testSession\" TYPE=\"RES\"/></CUM>";
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();

		seshMgr.regSesh(seshName, senderForPrestr);

		PresSvrAdptr adptr = new PresSvrAdptr(seshMgr);
		Pair<String, DisconHdlrAbst> p = adptr.hndlCmd(xml);
		assertEquals(new ResCmdUnknowCmd().toXmlStr(), p.getValue0());
		assertNull(p.getValue1());

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
		Pair<String, DisconHdlrAbst> p = adptr.hndlCmd(xml, senderForPrestr);
		assertNull(senderForPrestr.pollCmd());
		assertEquals(DisconHdlrPrestr.class, p.getValue1().getClass());
		assertEquals(
				new ResCmdRegSesh(seshName, ResCmdRegSesh.RsltTypes.Reged)
						.toXmlStr(),
				p.getValue0());
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
		Pair<String, DisconHdlrAbst> p = adptr.hndlCmd(xml, rscesArray);

		assertEquals(new ResCmdRegChnl(seshName, chnlName, rscesArray,
				ResCmdRegChnl.RsltTypes.Reged).toXmlStr(), p.getValue0());
		assertEquals(DisconHdlrPrestr.class, p.getValue1().getClass());
	}
}
