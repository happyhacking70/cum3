/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.audLyr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.comLyr.DummySender;
import jp.happyhacking70.cum3.comLyr.DummySrvAdm;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

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
		DummySender sender = new DummySender(new DummySrvAdm());
		Aud aud = new Aud(audName, sender);

		assertEquals(audName, aud.getAudName());

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.audLyr.Aud#sendCmd(jp.happyhacking70.cum3.cmd.CmdAbst)}
	 * .
	 * 
	 * @throws CumExcpXMLGenFailed
	 */
	@Test
	public void testSendCmdOk() throws CumExcpXMLGenFailed {
		DummySender sender = new DummySender(new DummySrvAdm());
		Aud aud = new Aud(audName, sender);

		NtfyCmdRegChnl cmd = new NtfyCmdRegChnl("testSession", "testChnl");
		aud.sendCmd(cmd);
		assertEquals(cmd.toXmlStr(), sender.pollCmd());
		assertNull(sender.pollCmd());
	}

}
