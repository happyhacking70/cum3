/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscImg;
import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdAbst.CmdTypes;
import jp.happyhacking70.cum3.cmd.XMLableCmdIntf;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdLvChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdLvSesh;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.comLyr.DummySender;
import jp.happyhacking70.cum3.excp.impl.CumExcpComError;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotEixt;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcptNullRsces;
import jp.happyhacking70.cum3.presSvr.seshLyr.impl.dummy.DummyAcptSeshDisconned;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class SeshPresSvrTest {
	public static final String seshName = "testSession";
	public static final String chnlName = "testChannel";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#getSeshName()}
	 * .
	 */
	@Test
	public void testGetSeshName() {
		SeshPresSvr sesh = new SeshPresSvr(seshName, new DummySender(),
				new DummyAcptSeshDisconned());
		assertEquals(sesh.getSeshName(), seshName);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#regChnl(java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlExists
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudExists
	 * @throws CumExcpComError
	 */
	@Test
	public void testRegChnl_OK() throws CumExcpChnlExists, CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpChnlNotEixt,
			CumExcpAudNotExist, CumExcpAudExists, CumExcpComError {
		DummySender senderForPresenter = new DummySender();

		DummySender senderForAudA = new DummySender();
		DummySender senderForAudB = new DummySender();

		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPresenter,
				new DummyAcptSeshDisconned());

		sesh.joinSesh("audA", senderForAudA);
		sesh.joinSesh("audB", senderForAudB);

		sesh.regChnl(chnlName, new ArrayList<ChnlRscIntf>());

		NtfyCmdRegChnl cmd = (NtfyCmdRegChnl) senderForAudA.pollCmd();
		assertEquals(cmd.getActionName(), "RegChnl");
		assertEquals(cmd.getChnlName(), chnlName);
		assertEquals(cmd.getCmdType(), CmdTypes.NTFY);
		assertEquals(cmd.getSeshName(), seshName);

		cmd = (NtfyCmdRegChnl) senderForAudB.pollCmd();
		assertEquals(cmd.getActionName(), "RegChnl");
		assertEquals(cmd.getChnlName(), chnlName);
		assertEquals(cmd.getCmdType(), CmdTypes.NTFY);
		assertEquals(cmd.getSeshName(), seshName);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#regChnl(java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlExists
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpComError
	 */
	@Test(expected = CumExcpChnlExists.class)
	public void testRegChnl_ChnlExists() throws CumExcpChnlExists,
			CumExcpRscExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpChnlNotEixt, CumExcpAudNotExist, CumExcpComError {
		SeshPresSvr sesh = new SeshPresSvr(seshName, new DummySender(),
				new DummyAcptSeshDisconned());
		sesh.regChnl(chnlName, new ArrayList<ChnlRscIntf>());
		sesh.regChnl(chnlName, new ArrayList<ChnlRscIntf>());
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#regChnl(java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlExists
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpComError
	 */
	@Test(expected = CumExcptNullRsces.class)
	public void testRegChnl_NulRsces() throws CumExcpChnlExists,
			CumExcpRscExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpChnlNotEixt, CumExcpAudNotExist, CumExcpComError {
		SeshPresSvr sesh = new SeshPresSvr(seshName, new DummySender(),
				new DummyAcptSeshDisconned());
		sesh.regChnl(chnlName, null);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#regChnl(java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlExists
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpComError
	 */
	@Test(expected = CumExcpRscNull.class)
	public void testRegChnl_NulRsce() throws CumExcpChnlExists,
			CumExcpRscExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpChnlNotEixt, CumExcpAudNotExist, CumExcpComError {
		SeshPresSvr sesh = new SeshPresSvr(seshName, new DummySender(),
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		rsces.add(new ChnlRscImg("rscA", null));
		rsces.add(null);
		rsces.add(new ChnlRscImg("rscB", null));

		sesh.regChnl(chnlName, rsces);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#regChnl(java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlExists
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpComError
	 */
	@Test(expected = CumExcpRscExists.class)
	public void testRegChnl_rscExists() throws CumExcpChnlExists,
			CumExcpRscExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpChnlNotEixt, CumExcpAudNotExist, CumExcpComError {
		SeshPresSvr sesh = new SeshPresSvr(seshName, new DummySender(),
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		rsces.add(new ChnlRscImg("rscA", null));
		rsces.add(new ChnlRscImg("rscA", null));

		sesh.regChnl(chnlName, rsces);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#getRsc(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscNotExist
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpComError
	 */
	@Test
	public void testGetRsc_OK() throws CumExcpChnlExists, CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpChnlNotEixt,
			CumExcpRscNotExist, CumExcpComError {
		SeshPresSvr sesh = new SeshPresSvr(seshName, new DummySender(),
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();

		ChnlRscImg a = new ChnlRscImg("rscA", null);
		ChnlRscImg b = new ChnlRscImg("rscB", null);
		rsces.add(a);
		rsces.add(b);

		sesh.regChnl(chnlName, rsces);

		ChnlRscIntf rsc = sesh.getRsc(chnlName, "rscA");
		assertEquals(a, rsc);
		rsc = sesh.getRsc(chnlName, "rscB");
		assertEquals(b, rsc);

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#getRsc(java.lang.String, java.lang.String)}
	 * 
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscNull
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpComError
	 * @throws CumExcpRscNotExist
	 */
	@Test
	public void testGetRsc_NoRsc() throws CumExcpChnlExists, CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpChnlNotEixt,
			CumExcpComError {
		SeshPresSvr sesh = new SeshPresSvr(seshName, new DummySender(),
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();

		ChnlRscImg a = new ChnlRscImg("rscA", null);
		ChnlRscImg b = new ChnlRscImg("rscB", null);
		rsces.add(a);
		rsces.add(b);

		sesh.regChnl(chnlName, rsces);

		boolean ok = false;
		try {
			sesh.getRsc(chnlName, "NORSC");
		} catch (CumExcpRscNotExist e) {

			assertEquals(e.getRscName(), "NORSC");
			assertEquals(e.getChnlName(), chnlName);
			assertEquals(e.getSeshName(), seshName);
			ok = true;
		}

		if (ok == false) {
			fail("CumExcpRscNotExist was not caught");
		}
	}

	@Test
	public void testGetRsc_NoChnl() throws CumExcpRscNotExist {
		SeshPresSvr sesh = new SeshPresSvr(seshName, new DummySender(),
				new DummyAcptSeshDisconned());

		boolean ok = false;

		try {
			sesh.getRsc("NOCHNL", "junk");
		} catch (CumExcpChnlNotEixt e) {
			assertEquals(seshName, e.getSeshName());
			assertEquals("NOCHNL", e.getChnlName());
			ok = true;
		}

		if (ok == false) {
			fail("CumExcpChnlNotEixt was not caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdChnlAbst, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testSendChnlCmdToAud() throws CumExcpRscExists,
			CumExcpChnlExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpAudExists, CumExcpAudNotExist, CumExcpChnlNotEixt,
			CumExcpComError {

		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr,
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		DummySender senderForAud = new DummySender();
		sesh.joinSesh("audA", senderForAud);
		sesh.joinChnl(chnlName, "audA");

		NtfyCmdRegChnl cmd = new NtfyCmdRegChnl(seshName, chnlName);
		for (ChnlRscIntf rsc : rsces) {
			cmd.addRscData(rsc);
		}
		sesh.sendChnlCmd(cmd, "audA");

		XMLableCmdIntf cmdSent = senderForAud.pollCmd();
		cmdSent = senderForAud.pollCmd();
		assertEquals(cmdSent, cmd);

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdChnlAbst, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testSendChnlCmdToAudNoChnl() throws CumExcpAudNotExist,
			CumExcpComError {

		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr,
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();

		NtfyCmdRegChnl cmd = new NtfyCmdRegChnl(seshName, "NOCHNL");

		for (ChnlRscIntf rsc : rsces) {
			cmd.addRscData(rsc);
		}
		boolean ok = false;
		try {
			sesh.sendChnlCmd(cmd, "audA");

		} catch (CumExcpChnlNotEixt e) {

			assertEquals(seshName, e.getSeshName());
			assertEquals("NOCHNL", e.getChnlName());

			ok = true;
		}
		if (ok == false) {
			fail("CumExcpChnlNotEixt not caught");
		}

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdChnlAbst, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpComError
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testSendChnlCmdToAudNoAud() throws CumExcpRscExists,
			CumExcpChnlExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpAudExists, CumExcpChnlNotEixt, CumExcpComError {
		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr,
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		// DummySender senderForAud = new DummySender();
		// sesh.joinSesh("audA", senderForAud);

		boolean ok = false;
		NtfyCmdRegChnl cmd = new NtfyCmdRegChnl(seshName, chnlName);
		for (ChnlRscIntf rsc : rsces) {
			cmd.addRscData(rsc);
		}
		try {
			sesh.sendChnlCmd(cmd, "audB");
		} catch (CumExcpAudNotExist e) {
			assertEquals(seshName, e.getSeshName());
			assertEquals(chnlName, e.getChnlName());
			assertEquals("audB", e.getAudName());
			ok = true;
		}

		if (ok == false) {
			fail("CumExcpAudNotExist not caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdChnlAbst)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testSendChnlCmdToAuds_OK() throws CumExcpRscExists,
			CumExcpChnlExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpAudExists, CumExcpAudNotExist, CumExcpChnlNotEixt,
			CumExcpComError {
		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr,
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		DummySender senderForAudA = new DummySender();
		sesh.joinSesh("audA", senderForAudA);
		sesh.joinChnl(chnlName, "audA");

		DummySender senderForAudB = new DummySender();
		sesh.joinSesh("audB", senderForAudB);
		sesh.joinChnl(chnlName, "audB");

		NtfyCmdRegChnl cmd = new NtfyCmdRegChnl(seshName, chnlName);
		for (ChnlRscIntf rsc : rsces) {
			cmd.addRscData(rsc);
		}
		sesh.sendChnlCmd(cmd);

		XMLableCmdIntf cmdSent = senderForAudA.pollCmd();
		cmdSent = senderForAudA.pollCmd();
		assertEquals(cmdSent, cmd);
		cmdSent = senderForAudB.pollCmd();
		cmdSent = senderForAudB.pollCmd();
		assertEquals(cmdSent, cmd);

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdChnlAbst)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testSendChnlCmdToAuds_NOCHNL() throws CumExcpAudNotExist,
			CumExcpComError {
		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr,
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();

		NtfyCmdRegChnl cmd = new NtfyCmdRegChnl(seshName, "NOCHNL");
		for (ChnlRscIntf rsc : rsces) {
			cmd.addRscData(rsc);
		}
		boolean ok = false;
		try {
			sesh.sendChnlCmd(cmd);

		} catch (CumExcpChnlNotEixt e) {

			assertEquals(seshName, e.getSeshName());
			assertEquals("NOCHNL", e.getChnlName());

			ok = true;
		}
		if (ok == false) {
			fail("CumExcpChnlNotEixt not caught");
		}

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#clsChnl(java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testClsChnl_OK() throws CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpAudExists,
			CumExcpChnlNotEixt, CumExcpAudNotExist, CumExcpComError {

		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr,
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();

		sesh.regChnl(chnlName, rsces);
		DummySender senderForAud = new DummySender();
		DummySender senderForAudB = new DummySender();

		sesh.joinSesh("audA", senderForAud);
		senderForAud.pollCmd();
		sesh.joinSesh("audB", senderForAudB);
		senderForAudB.pollCmd();

		sesh.joinChnl(chnlName, "audA");
		senderForAud.pollCmd();

		sesh.clsChnl(chnlName);

		NtfyCmdClsChnl cmd = (NtfyCmdClsChnl) senderForAud.pollCmd();

		assertEquals(seshName, cmd.getSeshName());
		assertEquals(chnlName, cmd.getChnlName());

		cmd = (NtfyCmdClsChnl) senderForAudB.pollCmd();

		assertEquals(seshName, cmd.getSeshName());
		assertEquals(chnlName, cmd.getChnlName());
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#clsChnl(java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpComError
	 * @throws CumExcpChnlNotEixt
	 */
	@Test
	public void testClsChnl_NOCHNL() throws CumExcpAudExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpComError {
		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr,
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();

		sesh.regChnl(chnlName, rsces);
		DummySender senderForAud = new DummySender();

		sesh.joinSesh("audA", senderForAud);
		senderForAud.pollCmd();

		boolean ok = false;
		try {
			sesh.clsChnl("NOCHNL");
		} catch (CumExcpChnlNotEixt e) {
			assertEquals(seshName, e.getSeshName());
			assertEquals("NOCHNL", e.getChnlName());

			ok = true;
		}

		if (ok == false) {
			fail("CumExcpChnlNotEixt not caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#joinSesh(java.lang.String, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpComError
	 */
	@Test
	public void testJoinSesh_OK() throws CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpAudExists,
			CumExcpComError {
		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr,
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		DummySender senderForAudA = new DummySender();
		sesh.joinSesh("audA", senderForAudA);

		NtfyCmdRegChnl cmd = (NtfyCmdRegChnl) senderForAudA.pollCmd();
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(chnlName, cmd.getChnlName());

		NtfyCmdJoinSesh cmdP = (NtfyCmdJoinSesh) senderForPrestr.pollCmd();
		assertEquals(seshName, cmdP.getSeshName());
		assertEquals("audA", cmdP.getAudName());
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#joinSesh(java.lang.String, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpComError
	 */
	@Test
	public void testJoinSesh_AUDEXISTS() throws CumExcpAudExists,
			CumExcpRscExists, CumExcpChnlExists, CumExcptNullRsces,
			CumExcpRscNull, CumExcpComError {

		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr,
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		DummySender senderForAudA = new DummySender();
		sesh.joinSesh("audA", senderForAudA);

		boolean ok = false;
		try {
			sesh.joinSesh("audA", senderForAudA);
		} catch (CumExcpAudExists e) {
			assertEquals(seshName, e.getSeshName());
			assertEquals("", e.getChnlName());
			assertEquals("audA", e.getAudName());
			ok = true;
		}

		if (ok == false) {
			fail("CumExcpAudExists not caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#joinChnl(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testJoinChnl_OK() throws CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpAudExists,
			CumExcpAudNotExist, CumExcpChnlNotEixt, CumExcpComError {
		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr,
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		DummySender senderForAudA = new DummySender();
		sesh.joinSesh("audA", senderForAudA);
		senderForPrestr.pollCmd();
		senderForAudA.pollCmd();

		sesh.joinChnl(chnlName, "audA");

		NtfyCmdJoinChnl cmd = (NtfyCmdJoinChnl) senderForPrestr.pollCmd();

		assertEquals(seshName, cmd.getSeshName());
		assertEquals(chnlName, cmd.getChnlName());
		assertEquals("audA", cmd.getAudName());

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#joinChnl(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testJoinChnl_NOCHNL() throws CumExcpRscExists,
			CumExcpChnlExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpAudExists, CumExcpAudNotExist, CumExcpComError {

		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr,
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		DummySender senderForAudA = new DummySender();
		sesh.joinSesh("audA", senderForAudA);
		senderForPrestr.pollCmd();
		senderForAudA.pollCmd();

		boolean ok = false;
		try {
			sesh.joinChnl("NOCHNL", "audA");
		} catch (CumExcpChnlNotEixt e) {
			assertEquals(seshName, e.getSeshName());
			assertEquals("NOCHNL", e.getChnlName());
			ok = true;
		}
		if (ok == false) {
			fail("CumExcpChnlNotEixt no caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#joinChnl(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpComError
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testJoinChnl_NOAUD() throws CumExcpAudExists,
			CumExcpChnlNotEixt, CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpComError {

		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr,
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		DummySender senderForAudA = new DummySender();
		sesh.joinSesh("audA", senderForAudA);
		senderForPrestr.pollCmd();
		senderForAudA.pollCmd();

		boolean ok = false;
		try {
			sesh.joinChnl(chnlName, "NOAUD");
		} catch (CumExcpAudNotExist e) {
			assertEquals(seshName, e.getSeshName());
			assertEquals(chnlName, e.getChnlName());
			assertEquals("NOAUD", e.getAudName());
			ok = true;
		}

		if (ok == false) {
			fail("CumExcpAudNotExist no caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#joinChnl(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testJoinChnl_AUDEXISTS() throws CumExcpAudNotExist,
			CumExcpChnlNotEixt, CumExcpAudExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpComError {
		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr,
				new DummyAcptSeshDisconned());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		DummySender senderForAudA = new DummySender();
		sesh.joinSesh("audA", senderForAudA);
		senderForPrestr.pollCmd();
		senderForAudA.pollCmd();

		sesh.joinChnl(chnlName, "audA");

		boolean ok = false;
		try {
			sesh.joinChnl(chnlName, "audA");
		} catch (CumExcpAudExists e) {
			assertEquals(seshName, e.getSeshName());
			assertEquals(chnlName, e.getChnlName());
			assertEquals("audA", e.getAudName());
			ok = true;
		}
		if (ok == false) {
			fail("CumExcpAudExists no caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#lvChnl(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testLvChnl() throws CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpAudExists,
			CumExcpAudNotExist, CumExcpChnlNotEixt, CumExcpComError {

		DummySender senderForPresenter = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPresenter,
				new DummyAcptSeshDisconned());

		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		DummySender senderForAudA = new DummySender();
		sesh.joinSesh("audA", senderForAudA);
		senderForPresenter.pollCmd();
		senderForAudA.pollCmd();

		sesh.joinChnl(chnlName, "audA");

		senderForPresenter.pollCmd();

		sesh.lvChnl(chnlName, "audA");
		NtfyCmdLvChnl cmd = (NtfyCmdLvChnl) senderForPresenter.pollCmd();

		assertEquals(seshName, cmd.getSeshName());
		assertEquals(chnlName, cmd.getChnlName());
		assertEquals("audA", cmd.getAudName());

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#lvChnl(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testLvChnl_NOCHNL() throws CumExcpAudNotExist,
			CumExcpAudExists, CumExcpChnlNotEixt, CumExcpRscExists,
			CumExcpChnlExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpComError {

		DummySender senderForPresenter = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPresenter,
				new DummyAcptSeshDisconned());

		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		DummySender senderForAudA = new DummySender();
		sesh.joinSesh("audA", senderForAudA);
		senderForPresenter.pollCmd();
		senderForAudA.pollCmd();

		sesh.joinChnl(chnlName, "audA");

		senderForPresenter.pollCmd();

		boolean ok = false;
		try {
			sesh.lvChnl("NOCHNL", "audA");
		} catch (CumExcpChnlNotEixt e) {
			assertEquals(seshName, e.getSeshName());
			assertEquals("NOCHNL", e.getChnlName());
			ok = true;
		}

		if (ok == false) {
			fail("CumExcpChnlNotEixt not caught");
		}

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#lvChnl(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testLvChnl_NOAUD() throws CumExcpChnlNotEixt, CumExcpAudExists,
			CumExcpAudNotExist, CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpComError {

		DummySender senderForPresenter = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPresenter,
				new DummyAcptSeshDisconned());

		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		DummySender senderForAudA = new DummySender();
		sesh.joinSesh("audA", senderForAudA);
		senderForPresenter.pollCmd();
		senderForAudA.pollCmd();

		sesh.joinChnl(chnlName, "audA");

		senderForPresenter.pollCmd();

		boolean ok = false;

		try {
			sesh.lvChnl(chnlName, "NOAUD");
		} catch (CumExcpAudNotExist e) {
			assertEquals(seshName, e.getSeshName());
			assertEquals(chnlName, e.getChnlName());
			assertEquals("NOAUD", e.getAudName());
			ok = true;
		}

		if (ok == false) {
			fail("CumExcpChnlNotEixt not caught");
		}

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#lvSesh(java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testLvSesh() throws CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpAudExists,
			CumExcpAudNotExist, CumExcpChnlNotEixt, CumExcpComError {
		DummySender senderForPresenter = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPresenter,
				new DummyAcptSeshDisconned());

		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		DummySender senderForAudA = new DummySender();
		sesh.joinSesh("audA", senderForAudA);
		senderForPresenter.pollCmd();
		senderForAudA.pollCmd();

		sesh.joinChnl(chnlName, "audA");
		senderForPresenter.pollCmd();

		sesh.lvSesh("audA");
		NtfyCmdLvSesh cmd = (NtfyCmdLvSesh) senderForPresenter.pollCmd();

		assertEquals(seshName, cmd.getSeshName());
		assertEquals("audA", cmd.getAudName());

		assertNull(senderForAudA.pollCmd());
		assertNull(senderForPresenter.pollCmd());
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshPresSvr#lvSesh(java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testLvSesh_NOAUD() throws CumExcpAudExists, CumExcpAudNotExist,
			CumExcpChnlNotEixt, CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpComError {
		DummySender senderForPresenter = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPresenter,
				new DummyAcptSeshDisconned());

		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		DummySender senderForAudA = new DummySender();
		// sesh.joinSesh("audA", senderForAudA, sesh);
		sesh.joinSesh("audA", senderForAudA);
		senderForPresenter.pollCmd();
		senderForAudA.pollCmd();

		sesh.joinChnl(chnlName, "audA");
		senderForPresenter.pollCmd();

		boolean ok = false;
		try {
			sesh.lvSesh("NOAUD");
		} catch (CumExcpAudNotExist e) {
			assertEquals(seshName, e.getSeshName());
			assertEquals("", e.getChnlName());
			assertEquals("NOAUD", e.getAudName());
			ok = true;
		}
		if (ok == false) {
			fail("CumExcpAudNotExist not caught");
		}
	}

	@Test
	public void testSendCmdToPrestr() {
		DummySender sender = new DummySender();
		DummyAcptSeshDisconned acpter = new DummyAcptSeshDisconned();

		SeshPresSvr sesh = new SeshPresSvr(seshName, sender, acpter);

		NtfyCmdJoinSesh cmd = new NtfyCmdJoinSesh(seshName, "testAudience");
		sesh.sendCmdToPrestr(cmd);

		assertEquals(cmd, sender.pollCmd());
		assertNull(sender.pollCmd());
		assertNull(acpter.getSeshName());

	}

	@Test
	public void testSendCmdToPrestr_COMERR() {
		DummySender sender = new DummySender();
		DummyAcptSeshDisconned acpter = new DummyAcptSeshDisconned();

		SeshPresSvr sesh = new SeshPresSvr(seshName, sender, acpter);

		sender.emulateComErr();
		NtfyCmdJoinSesh cmd = new NtfyCmdJoinSesh(seshName, "testAudience");
		sesh.sendCmdToPrestr(cmd);

		assertNull(sender.pollCmd());
		assertEquals(seshName, acpter.getSeshName());

	}
}
