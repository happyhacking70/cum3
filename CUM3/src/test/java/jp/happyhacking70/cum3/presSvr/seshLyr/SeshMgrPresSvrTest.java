/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import static org.junit.Assert.fail;
import jp.happyhacking70.cum3.excp.CumExcpSeshExists;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvr;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class SeshMgrPresSvrTest {

	static final String seshName = "testSession";
	static final String seshName2 = "testSession2";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvr#regSesh(java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpSeshExists
	 */
	@Test(expected = CumExcpSeshExists.class)
	public void testRegSesh() throws CumExcpSeshExists {
		SeshMgrPresSvr seshMgr = new SeshMgrPresSvr();
		try {
			seshMgr.regSesh(seshName);
			seshMgr.regSesh(seshName2);
		} catch (CumExcpSeshExists e) {
			fail("Cannot register session");
		}
		seshMgr.regSesh(seshName);

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvr#regChnl()}.
	 */
	@Test
	public void testRegChnl() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvr#clsSesh(java.lang.String)}
	 * .
	 */
	@Test
	public void testClsSesh() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdAbst, java.lang.String)}
	 * .
	 */
	@Test
	public void testSendChnlCmdCmdAbstString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdAbst)}
	 * .
	 */
	@Test
	public void testSendChnlCmdCmdAbst() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvr#clsChnl(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testClsChnl() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvr#joinSesh(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testJoinSesh() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvr#joinChnl(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testJoinChnl() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvr#rjctChnl(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testRjctChnl() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvr#lvChnl(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testLvChnl() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvr#lvSesh(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testLvSesh() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvr#fetchRsc(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testFetchRsc() {
		fail("Not yet implemented");
	}

}
