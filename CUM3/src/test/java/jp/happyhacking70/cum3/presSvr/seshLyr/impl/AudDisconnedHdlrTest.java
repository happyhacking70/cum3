/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class AudDisconnedHdlrTest {
	static final String audName = "testAudience";
	static final String seshName = "testSession";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("AudDisconnedHdlrTest");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.AudDisconnedHdlr#run()}
	 * .
	 */
	@Test
	public void testRun() {
		DummySeshInternalIntf sesh = new DummySeshInternalIntf(seshName);
		DummyDeshDisconnedAcpter acpter = new DummyDeshDisconnedAcpter();

		AudDisconnedHdlr audDisconnedHdlr = new AudDisconnedHdlr(audName, sesh,
				acpter);
		Thread thread = new Thread(audDisconnedHdlr);
		thread.start();

		while (thread.isAlive()) {
			System.out.println("thread alive");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		assertEquals(sesh.getAudName(), audName);
		assertNull(acpter.getSeshName());
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.seshLyr.impl.AudDisconnedHdlr#run()}
	 * .
	 */
	@Test
	public void testRun_SeshSendErr() {
		DummySeshInternalIntf sesh = new DummySeshInternalIntf(seshName);
		DummyDeshDisconnedAcpter acpter = new DummyDeshDisconnedAcpter();

		AudDisconnedHdlr audDisconnedHdlr = new AudDisconnedHdlr(audName, sesh,
				acpter);

		sesh.emulateComErr();
		Thread thread = new Thread(audDisconnedHdlr);
		thread.start();
		while (thread.isAlive()) {
			System.out.println("thread alive");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		assertEquals(sesh.getAudName(), audName);
		assertEquals(acpter.getSeshName(), seshName);
	}

}
