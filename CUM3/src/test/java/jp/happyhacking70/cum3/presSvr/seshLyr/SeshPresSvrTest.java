/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscImg;
import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.CmdAbst.CmdTypes;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdLvChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdLvSesh;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.comLyr.DummySender;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotEixt;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcptNullRsces;

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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#getSeshName()}.
	 */
	@Test
	public void testGetSeshName() {
		SeshPresSvr sesh = new SeshPresSvr(seshName, new DummySender());
		assertEquals(sesh.getSeshName(), seshName);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#regChnl(java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlExists
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudExists
	 */
	@Test
	public void testRegChnl_OK() throws CumExcpChnlExists, CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpChnlNotEixt,
			CumExcpAudNotExist, CumExcpAudExists {
		DummySender senderForPresenter = new DummySender();

		DummySender senderForAudA = new DummySender();
		DummySender senderForAudB = new DummySender();

		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPresenter);

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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#regChnl(java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlExists
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpChnlNotEixt
	 */
	@Test(expected = CumExcpChnlExists.class)
	public void testRegChnl_ChnlExists() throws CumExcpChnlExists,
			CumExcpRscExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpChnlNotEixt, CumExcpAudNotExist {
		SeshPresSvr sesh = new SeshPresSvr(seshName, new DummySender());
		sesh.regChnl(chnlName, new ArrayList<ChnlRscIntf>());
		sesh.regChnl(chnlName, new ArrayList<ChnlRscIntf>());
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#regChnl(java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlExists
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpChnlNotEixt
	 */
	@Test(expected = CumExcptNullRsces.class)
	public void testRegChnl_NulRsces() throws CumExcpChnlExists,
			CumExcpRscExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpChnlNotEixt, CumExcpAudNotExist {
		SeshPresSvr sesh = new SeshPresSvr(seshName, new DummySender());
		sesh.regChnl(chnlName, null);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#regChnl(java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlExists
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpChnlNotEixt
	 */
	@Test(expected = CumExcpRscNull.class)
	public void testRegChnl_NulRsce() throws CumExcpChnlExists,
			CumExcpRscExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpChnlNotEixt, CumExcpAudNotExist {
		SeshPresSvr sesh = new SeshPresSvr(seshName, new DummySender());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		rsces.add(new ChnlRscImg("rscA", null));
		rsces.add(null);
		rsces.add(new ChnlRscImg("rscB", null));

		sesh.regChnl(chnlName, rsces);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#regChnl(java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlExists
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpChnlNotEixt
	 */
	@Test(expected = CumExcpRscExists.class)
	public void testRegChnl_rscExists() throws CumExcpChnlExists,
			CumExcpRscExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpChnlNotEixt, CumExcpAudNotExist {
		SeshPresSvr sesh = new SeshPresSvr(seshName, new DummySender());
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		rsces.add(new ChnlRscImg("rscA", null));
		rsces.add(new ChnlRscImg("rscA", null));

		sesh.regChnl(chnlName, rsces);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#getRsc(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscNotExist
	 * @throws CumExcpChnlNotEixt
	 */
	@Test
	public void testGetRsc_OK() throws CumExcpChnlExists, CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpChnlNotEixt,
			CumExcpRscNotExist {
		SeshPresSvr sesh = new SeshPresSvr(seshName, new DummySender());
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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#getRsc(java.lang.String, java.lang.String)}
	 * 
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscNull
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpRscNotExist
	 */
	@Test
	public void testGetRsc_NoRsc() throws CumExcpChnlExists, CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpChnlNotEixt {
		SeshPresSvr sesh = new SeshPresSvr(seshName, new DummySender());
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
		SeshPresSvr sesh = new SeshPresSvr(seshName, new DummySender());

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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdChnlAbst, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testSendChnlCmdToAud() throws CumExcpRscExists,
			CumExcpChnlExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpAudExists, CumExcpAudNotExist, CumExcpChnlNotEixt {

		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr);
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		DummySender senderForAud = new DummySender();
		sesh.joinSesh("audA", senderForAud);
		sesh.joinChnl(chnlName, "audA");

		NtfyCmdRegChnl cmd = new NtfyCmdRegChnl(seshName, chnlName, rsces);
		sesh.sendChnlCmd(cmd, "audA");

		CmdAbst cmdSent = senderForAud.pollCmd();
		cmdSent = senderForAud.pollCmd();
		assertEquals(cmdSent, cmd);

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdChnlAbst, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testSendChnlCmdToAudNoChnl() throws CumExcpAudNotExist {

		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr);
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();

		NtfyCmdRegChnl cmd = new NtfyCmdRegChnl(seshName, "NOCHNL", rsces);
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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdChnlAbst, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testSendChnlCmdToAudNoAud() throws CumExcpRscExists,
			CumExcpChnlExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpAudExists, CumExcpChnlNotEixt {
		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr);
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		// DummySender senderForAud = new DummySender();
		// sesh.joinSesh("audA", senderForAud);

		boolean ok = false;
		NtfyCmdRegChnl cmd = new NtfyCmdRegChnl(seshName, chnlName, rsces);
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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdChnlAbst)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testSendChnlCmdToAuds_OK() throws CumExcpRscExists,
			CumExcpChnlExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpAudExists, CumExcpAudNotExist, CumExcpChnlNotEixt {
		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr);
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		sesh.regChnl(chnlName, rsces);

		DummySender senderForAudA = new DummySender();
		sesh.joinSesh("audA", senderForAudA);
		sesh.joinChnl(chnlName, "audA");

		DummySender senderForAudB = new DummySender();
		sesh.joinSesh("audB", senderForAudB);
		sesh.joinChnl(chnlName, "audB");

		NtfyCmdRegChnl cmd = new NtfyCmdRegChnl(seshName, chnlName, rsces);
		sesh.sendChnlCmd(cmd);

		CmdAbst cmdSent = senderForAudA.pollCmd();
		cmdSent = senderForAudA.pollCmd();
		assertEquals(cmdSent, cmd);
		cmdSent = senderForAudB.pollCmd();
		cmdSent = senderForAudB.pollCmd();
		assertEquals(cmdSent, cmd);

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdChnlAbst)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testSendChnlCmdToAuds_NOCHNL() throws CumExcpAudNotExist {
		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr);
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();

		NtfyCmdRegChnl cmd = new NtfyCmdRegChnl(seshName, "NOCHNL", rsces);
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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#clsChnl(java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testClsChnl_OK() throws CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpAudExists,
			CumExcpChnlNotEixt, CumExcpAudNotExist {

		System.out.println("LLLLLLLLLLLLLLLLLLLLLLL");
		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr);
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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#clsChnl(java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 */
	@Test
	public void testClsChnl_NOCHNL() throws CumExcpAudExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcptNullRsces, CumExcpRscNull {
		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr);
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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#joinSesh(java.lang.String, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 */
	@Test
	public void testJoinSesh_OK() throws CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpAudExists {
		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr);
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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#joinSesh(java.lang.String, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 */
	@Test
	public void testJoinSesh_AUDEXISTS() throws CumExcpAudExists,
			CumExcpRscExists, CumExcpChnlExists, CumExcptNullRsces,
			CumExcpRscNull {

		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr);
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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#joinChnl(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testJoinChnl_OK() throws CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpAudExists,
			CumExcpAudNotExist, CumExcpChnlNotEixt {
		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr);
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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#joinChnl(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testJoinChnl_NOCHNL() throws CumExcpRscExists,
			CumExcpChnlExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpAudExists, CumExcpAudNotExist {

		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr);
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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#joinChnl(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testJoinChnl_NOAUD() throws CumExcpAudExists,
			CumExcpChnlNotEixt, CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull {

		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr);
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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#joinChnl(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testJoinChnl_AUDEXISTS() throws CumExcpAudNotExist,
			CumExcpChnlNotEixt, CumExcpAudExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcptNullRsces, CumExcpRscNull {
		DummySender senderForPrestr = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPrestr);
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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#lvChnl(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testLvChnl() throws CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpAudExists,
			CumExcpAudNotExist, CumExcpChnlNotEixt {

		DummySender senderForPresenter = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPresenter);

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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#lvChnl(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testLvChnl_NOCHNL() throws CumExcpAudNotExist,
			CumExcpAudExists, CumExcpChnlNotEixt, CumExcpRscExists,
			CumExcpChnlExists, CumExcptNullRsces, CumExcpRscNull {

		DummySender senderForPresenter = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPresenter);

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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#lvChnl(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testLvChnl_NOAUD() throws CumExcpChnlNotEixt, CumExcpAudExists,
			CumExcpAudNotExist, CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull {

		DummySender senderForPresenter = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPresenter);

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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#lvSesh(java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testLvSesh() throws CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpAudExists,
			CumExcpAudNotExist, CumExcpChnlNotEixt {
		DummySender senderForPresenter = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPresenter);

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
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#lvSesh(java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotEixt
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testLvSesh_NOAUD() throws CumExcpAudExists, CumExcpAudNotExist,
			CumExcpChnlNotEixt, CumExcpRscExists, CumExcpChnlExists,
			CumExcptNullRsces, CumExcpRscNull {
		DummySender senderForPresenter = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, senderForPresenter);

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
}
