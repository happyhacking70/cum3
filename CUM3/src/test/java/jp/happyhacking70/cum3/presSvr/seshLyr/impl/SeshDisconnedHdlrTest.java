/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import jp.happyhacking70.cum3.presSvr.seshLyr.impl.dummy.DummySeshInternalIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.impl.dummy.DummySeshMgrInternalIntf;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class SeshDisconnedHdlrTest {
	static final String seshName = "testSession";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.SeshDisconnedHdlr#run()}
	 * .
	 */
	@Test
	public void testRun() {
		DummySeshInternalIntf sesh = new DummySeshInternalIntf(seshName);

		DummySeshMgrInternalIntf seshMgr = new DummySeshMgrInternalIntf();
		SeshDisconnedHdlr hdlr = new SeshDisconnedHdlr(sesh, seshMgr);

		Thread thread = new Thread(hdlr);
		thread.start();
		while (thread.isAlive()) {
			System.out.println("thread alive");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		assertTrue(sesh.isSeshDisconned());
		assertEquals(seshMgr.getSeshRemoved(), seshName);
	}

}
