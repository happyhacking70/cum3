/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscImg;
import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdClsChnl;
import jp.happyhacking70.cum3.comLyr.DummySender;
import jp.happyhacking70.cum3.comLyr.DummySrvAdm;
import jp.happyhacking70.cum3.excp.impl.CumExcpComError;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshNotExist;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class SeshMgrPresSvrTest {
	protected static String seshName = "testSession";
	protected static String chnlName = "testChannel";
	protected static String audName = "testAudience";
	protected static ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#regSesh(java.lang.String, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 */
	@Test
	public void testRegSesh_OK() throws CumExcpSeshExists {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#regSesh(java.lang.String, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 */
	@Test
	public void testRegSesh_DUP() throws CumExcpSeshExists {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));

		boolean ok = false;
		try {
			seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		} catch (CumExcpSeshExists e) {
			assertEquals(seshName, e.getSeshName());
			ok = true;
		}
		if (ok == false) {
			fail("CumExcpSeshExists not caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#regChnl(java.lang.String, java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpComError
	 */
	@Test
	public void testRegChnl() throws CumExcpSeshExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcpRscNull, CumExcpSeshNotExist,
			CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));

		seshMgr.regChnl(seshName, chnlName, rsces);

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#regChnl(java.lang.String, java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpComError
	 */
	@Test
	public void testRegChnl_NOSESH() throws CumExcpRscExists,
			CumExcpChnlExists, CumExcpRscNull, CumExcpSeshExists,
			CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));

		boolean ok = false;
		try {
			seshMgr.regChnl("NOSESH", chnlName, rsces);
		} catch (CumExcpSeshNotExist e) {
			assertEquals("NOSESH", e.getSeshName());

			ok = true;
		}
		if (ok == false) {
			fail("CumExcpSeshNotExist not caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#clsSesh(java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testClsSesh() throws CumExcpSeshExists, CumExcpSeshNotExist,
			CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		seshMgr.clsSesh(seshName);

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#clsSesh(java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testClsSesh_NOSESH() throws CumExcpSeshExists,
			CumExcpSeshNotExist, CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));

		boolean ok = false;
		try {
			seshMgr.clsSesh("NOSESH");
		} catch (CumExcpSeshNotExist e) {
			assertEquals("NOSESH", e.getSeshName());

			ok = true;
		}
		if (ok == false) {
			fail("CumExcpSeshNotExist not caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdChnlAbst, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpComError
	 */
	@Test
	public void testSendChnlCmdToAud() throws CumExcpSeshExists,
			CumExcpAudNotExist, CumExcpChnlNotExist, CumExcpSeshNotExist,
			CumExcpRscExists, CumExcpChnlExists, CumExcpRscNull,
			CumExcpAudExists, CumExcpComError {

		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		seshMgr.regChnl(seshName, chnlName, rsces);
		seshMgr.joinSesh(seshName, audName, new DummySender(new DummySrvAdm()));
		seshMgr.joinChnl(seshName, chnlName, audName);
		seshMgr.sendChnlCmd(new NtfyCmdClsChnl(seshName, chnlName), audName);

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdChnlAbst, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpComError
	 */
	@Test
	public void testSendChnlCmdToAud_NOSESH() throws CumExcpSeshExists,
			CumExcpAudNotExist, CumExcpChnlNotExist, CumExcpSeshNotExist,
			CumExcpRscExists, CumExcpChnlExists, CumExcpRscNull,
			CumExcpComError {

		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		seshMgr.regChnl(seshName, chnlName, rsces);

		boolean ok = false;
		try {

			seshMgr.sendChnlCmd(new NtfyCmdClsChnl("NOSESH", chnlName), audName);
		} catch (CumExcpSeshNotExist e) {
			assertEquals("NOSESH", e.getSeshName());

			ok = true;
		}
		if (ok == false) {
			fail("CumExcpSeshNotExist not caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdChnlAbst)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testSendChnlCmdToAuds() throws CumExcpSeshExists,
			CumExcpRscExists, CumExcpChnlExists, CumExcpRscNull,
			CumExcpSeshNotExist, CumExcpAudNotExist, CumExcpChnlNotExist,
			CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		seshMgr.regChnl(seshName, chnlName, rsces);
		seshMgr.sendChnlCmd(new NtfyCmdClsChnl(seshName, chnlName));

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdChnlAbst)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testSendChnlCmdToAuds_NOSESH() throws CumExcpSeshExists,
			CumExcpRscExists, CumExcpChnlExists, CumExcpRscNull,
			CumExcpSeshNotExist, CumExcpAudNotExist, CumExcpChnlNotExist,
			CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		seshMgr.regChnl(seshName, chnlName, rsces);

		boolean ok = false;
		try {

			seshMgr.sendChnlCmd(new NtfyCmdClsChnl("NOSESH", chnlName));
		} catch (CumExcpSeshNotExist e) {
			assertEquals("NOSESH", e.getSeshName());

			ok = true;
		}
		if (ok == false) {
			fail("CumExcpSeshNotExist not caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#clsChnl(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testClsChnl() throws CumExcpSeshExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcpRscNull, CumExcpSeshNotExist,
			CumExcpChnlNotExist, CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		seshMgr.regChnl(seshName, chnlName, rsces);
		seshMgr.clsChnl(seshName, chnlName);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#clsChnl(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testClsChnl_NOSESH() throws CumExcpSeshExists,
			CumExcpRscExists, CumExcpChnlExists, CumExcpRscNull,
			CumExcpSeshNotExist, CumExcpChnlNotExist, CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		seshMgr.regChnl(seshName, chnlName, rsces);

		boolean ok = false;
		try {
			seshMgr.clsChnl("NOSESH", chnlName);
		} catch (CumExcpSeshNotExist e) {
			assertEquals("NOSESH", e.getSeshName());

			ok = true;
		}
		if (ok == false) {
			fail("CumExcpSeshNotExist not caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#joinSesh(java.lang.String, java.lang.String, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpAudExists
	 * @throws CumExcpComError
	 */
	@Test
	public void testJoinSesh() throws CumExcpSeshExists, CumExcpAudExists,
			CumExcpSeshNotExist, CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		seshMgr.joinSesh(seshName, audName, new DummySender(new DummySrvAdm()));
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#joinSesh(java.lang.String, java.lang.String, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpAudExists
	 * @throws CumExcpComError
	 */
	@Test
	public void testJoinSesh_NOSESH() throws CumExcpSeshExists,
			CumExcpAudExists, CumExcpSeshNotExist, CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));

		boolean ok = false;
		try {
			seshMgr.joinSesh("NOSESH", audName, new DummySender(
					new DummySrvAdm()));
		} catch (CumExcpSeshNotExist e) {
			assertEquals("NOSESH", e.getSeshName());

			ok = true;
		}
		if (ok == false) {
			fail("CumExcpSeshNotExist not caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#joinChnl(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpComError
	 */
	@Test
	public void testJoinChnl() throws CumExcpSeshExists, CumExcpAudExists,
			CumExcpSeshNotExist, CumExcpAudNotExist, CumExcpChnlNotExist,
			CumExcpRscExists, CumExcpChnlExists, CumExcpRscNull,
			CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		seshMgr.regChnl(seshName, chnlName, rsces);
		seshMgr.joinSesh(seshName, audName, new DummySender(new DummySrvAdm()));
		seshMgr.joinChnl(seshName, chnlName, audName);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#joinChnl(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testJoinChnl_NOSESH() throws CumExcpSeshExists,
			CumExcpAudExists, CumExcpSeshNotExist, CumExcpAudNotExist,
			CumExcpChnlNotExist, CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		seshMgr.joinSesh(seshName, audName, new DummySender(new DummySrvAdm()));

		boolean ok = false;
		try {
			seshMgr.joinChnl("NOSESH", chnlName, audName);
		} catch (CumExcpSeshNotExist e) {
			assertEquals("NOSESH", e.getSeshName());

			ok = true;
		}
		if (ok == false) {
			fail("CumExcpSeshNotExist not caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#rjctChnl(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testRjctChnl() throws CumExcpSeshExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcpRscNull, CumExcpSeshNotExist,
			CumExcpAudExists, CumExcpChnlNotExist, CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		seshMgr.regChnl(seshName, chnlName, rsces);
		seshMgr.joinSesh(seshName, audName, new DummySender(new DummySrvAdm()));
		seshMgr.rjctChnl(seshName, chnlName, audName);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#rjctChnl(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testRjctChnl_NOSESH() throws CumExcpSeshExists,
			CumExcpRscExists, CumExcpChnlExists, CumExcpRscNull,
			CumExcpSeshNotExist, CumExcpAudExists, CumExcpChnlNotExist,
			CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		seshMgr.regChnl(seshName, chnlName, rsces);
		seshMgr.joinSesh(seshName, audName, new DummySender(new DummySrvAdm()));

		boolean ok = false;
		try {
			seshMgr.rjctChnl("NOSESH", chnlName, audName);
		} catch (CumExcpSeshNotExist e) {
			assertEquals("NOSESH", e.getSeshName());

			ok = true;
		}
		if (ok == false) {
			fail("CumExcpSeshNotExist not caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#lvChnl(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testLvChnl() throws CumExcpSeshExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcpRscNull, CumExcpSeshNotExist,
			CumExcpAudExists, CumExcpAudNotExist, CumExcpChnlNotExist,
			CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		seshMgr.regChnl(seshName, chnlName, rsces);
		seshMgr.joinSesh(seshName, audName, new DummySender(new DummySrvAdm()));
		seshMgr.joinChnl(seshName, chnlName, audName);

		seshMgr.lvChnl(seshName, chnlName, audName);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#lvChnl(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testLvChnl_NOSESH() throws CumExcpSeshExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcpRscNull, CumExcpSeshNotExist,
			CumExcpAudExists, CumExcpAudNotExist, CumExcpChnlNotExist,
			CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		seshMgr.regChnl(seshName, chnlName, rsces);
		seshMgr.joinSesh(seshName, audName, new DummySender(new DummySrvAdm()));
		seshMgr.joinChnl(seshName, chnlName, audName);

		boolean ok = false;
		try {
			seshMgr.lvChnl("NOSESH", chnlName, audName);
		} catch (CumExcpSeshNotExist e) {
			assertEquals("NOSESH", e.getSeshName());

			ok = true;
		}
		if (ok == false) {
			fail("CumExcpSeshNotExist not caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#lvSesh(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testLvSesh() throws CumExcpSeshExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcpRscNull, CumExcpSeshNotExist,
			CumExcpAudExists, CumExcpAudNotExist, CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		seshMgr.regChnl(seshName, chnlName, rsces);
		seshMgr.joinSesh(seshName, audName, new DummySender(new DummySrvAdm()));
		seshMgr.lvSesh(seshName, audName);

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#lvSesh(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpAudNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testLvSesh_NOSESH() throws CumExcpSeshExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcpRscNull, CumExcpSeshNotExist,
			CumExcpAudExists, CumExcpAudNotExist, CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		seshMgr.regChnl(seshName, chnlName, rsces);
		seshMgr.joinSesh(seshName, audName, new DummySender(new DummySrvAdm()));

		boolean ok = false;
		try {
			seshMgr.lvSesh("NOSESH", audName);
		} catch (CumExcpSeshNotExist e) {
			assertEquals("NOSESH", e.getSeshName());

			ok = true;
		}
		if (ok == false) {
			fail("CumExcpSeshNotExist not caught");
		}
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#getRsc(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpRscNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testGetRsc() throws CumExcpSeshExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcpRscNull, CumExcpSeshNotExist,
			CumExcpRscNotExist, CumExcpChnlNotExist, CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		ArrayList<ChnlRscIntf> chnlRsces = new ArrayList<ChnlRscIntf>();
		chnlRsces.add(new ChnlRscImg("testRsc", null));

		seshMgr.regChnl(seshName, chnlName, chnlRsces);

		seshMgr.getRsc(seshName, chnlName, "testRsc");

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshMgrPresSvr#getRsc(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 * @throws CumExcpSeshNotExist
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpChnlExists
	 * @throws CumExcpRscExists
	 * @throws CumExcpChnlNotExist
	 * @throws CumExcpRscNotExist
	 * @throws CumExcpComError
	 */
	@Test
	public void testGetRsc_NOSESH() throws CumExcpSeshExists, CumExcpRscExists,
			CumExcpChnlExists, CumExcpRscNull, CumExcpSeshNotExist,
			CumExcpRscNotExist, CumExcpChnlNotExist, CumExcpComError {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		seshMgr.regSesh(seshName, new DummySender(new DummySrvAdm()));
		ArrayList<ChnlRscIntf> chnlRsces = new ArrayList<ChnlRscIntf>();
		chnlRsces.add(new ChnlRscImg("testRsc", null));

		seshMgr.regChnl(seshName, chnlName, chnlRsces);

		boolean ok = false;
		try {
			seshMgr.getRsc("NOSESH", chnlName, "testRsc");
		} catch (CumExcpSeshNotExist e) {
			assertEquals("NOSESH", e.getSeshName());

			ok = true;
		}
		if (ok == false) {
			fail("CumExcpSeshNotExist not caught");
		}
	}
}
