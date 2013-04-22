/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.audLyr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.comLyr.DummySender;
import jp.happyhacking70.cum3.presSvr.seshLyr.impl.dummy.DummyAcptAudDisconned;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class AudTest {
	static final String audName = "testAudience";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Aud Test");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.audLyr.Aud#getAudName()}.
	 */
	@Test
	public void testGetAudName() {
		DummySender sender = new DummySender();
		DummyAcptAudDisconned acpter = new DummyAcptAudDisconned();
		Aud aud = new Aud(audName, sender, acpter);

		assertEquals(audName, aud.getAudName());

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.audLyr.Aud#sendCmd(jp.happyhacking70.cum3.cmd.CmdAbst)}
	 * .
	 */
	@Test
	public void testSendCmdOk() {
		DummySender sender = new DummySender();
		DummyAcptAudDisconned acpter = new DummyAcptAudDisconned();
		Aud aud = new Aud(audName, sender, acpter);

		NtfyCmdRegChnl cmd = new NtfyCmdRegChnl("testSession", "testChnl");
		aud.sendCmd(cmd);
		assertNull(acpter.getAudName());
		assertEquals(cmd, sender.pollCmd());
		assertNull(sender.pollCmd());
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.audLyr.Aud#sendCmd(jp.happyhacking70.cum3.cmd.CmdAbst)}
	 * .
	 */
	@Test
	public void testSendCmd_COMERR() {
		DummySender sender = new DummySender();
		DummyAcptAudDisconned acpter = new DummyAcptAudDisconned();
		Aud aud = new Aud(audName, sender, acpter);

		sender.emulateComErr();

		NtfyCmdRegChnl cmd = new NtfyCmdRegChnl("testSession", "testChnl");
		aud.sendCmd(cmd);
		assertNull(sender.pollCmd());
		assertEquals(audName, acpter.getAudName());
	}
}
