/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscImg;
import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdAbst.CmdTypes;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.comLyr.DummySender;
import jp.happyhacking70.cum3.excp.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.CumExcpChnlNotEixt;
import jp.happyhacking70.cum3.excp.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.CumExcptNullRsces;

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
	 */
	@Test
	public void testRegChnl_OK() throws CumExcpChnlExists, CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpChnlNotEixt,
			CumExcpAudNotExist {
		DummySender sender = new DummySender();
		SeshPresSvr sesh = new SeshPresSvr(seshName, sender);
		sesh.regChnl(chnlName, new ArrayList<ChnlRscIntf>());

		NtfyCmdRegChnl cmd = (NtfyCmdRegChnl) sender
				.getCmdSent(NtfyCmdRegChnl.class);

		//
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
	 */
	@Test
	public void testGetRsc() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdChnlAbst, java.lang.String)}
	 * .
	 */
	@Test
	public void testSendChnlCmdCmdChnlAbstString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdChnlAbst)}
	 * .
	 */
	@Test
	public void testSendChnlCmdCmdChnlAbst() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#clsChnl(java.lang.String)}
	 * .
	 */
	@Test
	public void testClsChnl() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#joinSesh(java.lang.String, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf)}
	 * .
	 */
	@Test
	public void testJoinSesh() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#joinChnl(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testJoinChnl() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#lvChnl(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testLvChnl() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvr#lvSesh(java.lang.String)}
	 * .
	 */
	@Test
	public void testLvSesh() {
		fail("Not yet implemented");
	}

}
