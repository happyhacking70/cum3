/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.chnlLyr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscImg;
import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdLvChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.ReqCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.ReqCmdRegChnl;
import jp.happyhacking70.cum3.comLyr.DummySender;
import jp.happyhacking70.cum3.excp.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.CumExcpRscNotExist;
import jp.happyhacking70.cum3.excp.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.CumExcpXMLGenFailed;
import jp.happyhacking70.cum3.excp.CumExcptNullRsces;
import jp.happyhacking70.cum3.presSvr.audLyr.Aud;
import jp.happyhacking70.cum3.presSvr.audLyr.AudIntf;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ChnlPreesSvrTest {
	protected static final String seshName = "testSession";
	protected static final String chnlName = "testChannel";
	protected static final String audName = "testAudience";
	protected DummySender sender = new DummySender();
	protected AudIntf aud = new Aud(audName, sender);

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr#ChnlPresSvr(java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpRscNull
	 */
	@Test(expected = CumExcptNullRsces.class)
	public void testChnlPresSvr_NullRsces() throws CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull {

		new ChnlPresSvr(seshName, chnlName, null);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr#ChnlPresSvr(java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpRscNull
	 */
	@Test(expected = CumExcpRscNull.class)
	public void testChnlPresSvr_NullRsc() throws CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		rsces.add(new ChnlRscImg("rscA", null));
		rsces.add(null);
		rsces.add(new ChnlRscImg("rscB", null));

		new ChnlPresSvr(seshName, chnlName, rsces);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr#ChnlPresSvr(java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpRscNull
	 */
	@Test(expected = CumExcpRscExists.class)
	public void testChnlPresSvr_RscExist() throws CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		rsces.add(new ChnlRscImg("rscA", null));
		rsces.add(new ChnlRscImg("rscA", null));

		new ChnlPresSvr(seshName, chnlName, rsces);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr#ChnlPresSvr(java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpRscNull
	 */
	@Test
	public void testChnlPresSvr_OK() throws CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		rsces.add(new ChnlRscImg("rscA", null));
		rsces.add(new ChnlRscImg("rscB", null));

		new ChnlPresSvr(seshName, chnlName, rsces);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr#ChnlPresSvr(java.lang.String, java.util.ArrayList)}
	 * .
	 * 
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpRscNull
	 */
	@Test
	public void testChnlPresSvr_NoRscOK() throws CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();

		new ChnlPresSvr(seshName, chnlName, rsces);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdAbst, jp.happyhacking70.cum3.presSvr.audLyr.AudIntf)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpAudNotExist
	 */
	@Test(expected = CumExcpAudNotExist.class)
	public void testSendChnlCmdCmdAbstAudIntf_NoAud() throws CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpAudExists,
			CumExcpAudNotExist {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		ChnlPresSvr chnl = new ChnlPresSvr(seshName, chnlName, rsces);

		ReqCmdClsChnl cmd = new ReqCmdClsChnl("testSession", chnlName);
		chnl.sendChnlCmd(cmd, aud);

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdAbst, jp.happyhacking70.cum3.presSvr.audLyr.AudIntf)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testSendChnlCmdCmdAbstAudIntf_OK() throws CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpAudExists,
			CumExcpAudNotExist {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		ChnlPresSvr chnl = new ChnlPresSvr(seshName, chnlName, rsces);
		chnl.joinChnl(aud);

		ReqCmdClsChnl cmd = new ReqCmdClsChnl("testSession", chnlName);
		chnl.sendChnlCmd(cmd, aud);

		ReqCmdClsChnl cmdReturned = (ReqCmdClsChnl) sender.pollCmd();
		assertEquals(cmd, cmdReturned);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr#sendChnlCmd(jp.happyhacking70.cum3.cmd.CmdAbst)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testSendChnlCmdCmdAbst() throws CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpAudExists,
			CumExcpAudNotExist {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		ChnlPresSvr chnl = new ChnlPresSvr(seshName, chnlName, rsces);
		chnl.joinChnl(aud);

		DummySender senderFor2 = new DummySender();
		chnl.joinChnl(new Aud("testAudience2", senderFor2));

		ReqCmdRegChnl cmd = new ReqCmdRegChnl("testSession", "testChannel");
		chnl.sendChnlCmd(cmd);

		ReqCmdRegChnl cmdReturned;
		cmdReturned = (ReqCmdRegChnl) sender.pollCmd();
		assertEquals(cmd, cmdReturned);
		cmdReturned = (ReqCmdRegChnl) senderFor2.pollCmd();
		assertEquals(cmd, cmdReturned);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr#clsChnl(java.lang.String)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 */
	@Test
	public void testClsChnl() throws CumExcpRscExists, CumExcptNullRsces,
			CumExcpRscNull, CumExcpAudExists {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();

		ChnlPresSvr chnl = new ChnlPresSvr(seshName, chnlName, rsces);
		chnl.joinChnl(aud);

		DummySender senderFor2 = new DummySender();
		AudIntf aud2 = new Aud("testAudience2", senderFor2);
		chnl.joinChnl(aud2);
		chnl.clsChnl();

		NtfyCmdClsChnl cmd;
		cmd = (NtfyCmdClsChnl) sender.pollCmd();
		assertEquals(cmd.getChnlName(), chnlName);
		assertEquals(cmd.getSeshName(), seshName);
		cmd = (NtfyCmdClsChnl) senderFor2.pollCmd();
		assertNotNull(cmd);

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr#getRsc(java.lang.String)}
	 * .
	 * 
	 * @throws IOException
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpRscNotExist
	 */
	@Test
	public void testGetRsc_OK() throws CumExcpRscExists, CumExcptNullRsces,
			CumExcpRscNull, CumExcpRscNotExist, IOException {

		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		BufferedImage bImg = ImageIO.read(new File("src/test/resources/1.jpg"));

		ChnlRscIntf r = new ChnlRscImg("rscA", bImg);
		rsces.add(r);
		ChnlPresSvr chnl = new ChnlPresSvr(seshName, chnlName, rsces);

		assertEquals(chnl.getRsc("rscA"), r);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr#getRsc(java.lang.String)}
	 * .
	 * 
	 * @throws IOException
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpRscNotExist
	 */
	@Test(expected = CumExcpRscNotExist.class)
	public void testGetRsc_CumExcpRscNotExist() throws IOException,
			CumExcpRscExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpRscNotExist {

		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		BufferedImage bImg = ImageIO.read(new File("src/test/resources/1.jpg"));

		ChnlRscIntf r = new ChnlRscImg("rscA", bImg);
		rsces.add(r);
		ChnlPresSvr chnl = new ChnlPresSvr(seshName, chnlName, rsces);

		chnl.getRsc("rscB");
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr#joinChnl(jp.happyhacking70.cum3.presSvr.audLyr.AudIntf)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 */
	@Test
	public void testJoinChnl_OK() throws CumExcpRscExists, CumExcptNullRsces,
			CumExcpRscNull, CumExcpAudExists {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();

		ChnlPresSvr chnl = new ChnlPresSvr(seshName, chnlName, rsces);
		NtfyCmdJoinChnl cmd = chnl.joinChnl(aud);
		assertEquals(cmd.getAudName(), audName);
		assertEquals(cmd.getChnlName(), chnlName);
		assertEquals(cmd.getSeshName(), seshName);

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr#joinChnl(jp.happyhacking70.cum3.presSvr.audLyr.AudIntf)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 */
	@Test(expected = CumExcpAudExists.class)
	public void testJoinChnl_AudExists() throws CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpAudExists {

		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();

		ChnlPresSvr chnl = new ChnlPresSvr(seshName, chnlName, rsces);
		chnl.joinChnl(aud);
		chnl.joinChnl(aud);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr#lvChnl(jp.happyhacking70.cum3.presSvr.audLyr.AudIntf)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpAudNotExist
	 */
	@Test
	public void testLvChnl_OK() throws CumExcpRscExists, CumExcptNullRsces,
			CumExcpRscNull, CumExcpAudExists, CumExcpAudNotExist {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();

		ChnlPresSvr chnl = new ChnlPresSvr(seshName, chnlName, rsces);
		chnl.joinChnl(aud);
		NtfyCmdLvChnl cmd = chnl.lvChnl(aud);
		assertEquals(cmd.getAudName(), audName);
		assertEquals(cmd.getChnlName(), chnlName);
		assertEquals(cmd.getSeshName(), seshName);

	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr#lvChnl(jp.happyhacking70.cum3.presSvr.audLyr.AudIntf)}
	 * .
	 * 
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpAudExists
	 * @throws CumExcpAudNotExist
	 */
	@Test(expected = CumExcpAudNotExist.class)
	public void testLvChnl_NoAud() throws CumExcpRscExists, CumExcptNullRsces,
			CumExcpRscNull, CumExcpAudExists, CumExcpAudNotExist {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();

		ChnlPresSvr chnl = new ChnlPresSvr(seshName, chnlName, rsces);

		chnl.lvChnl(aud);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr#getNtfyRegChnlCmd()}
	 * .
	 * 
	 * @throws IOException
	 * @throws CumExcpRscNull
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscExists
	 * @throws CumExcpXMLGenFailed
	 */
	@Test
	public void testGetNtfyRegChnlCmd() throws IOException, CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull, CumExcpXMLGenFailed {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		BufferedImage bImg = ImageIO.read(new File("src/test/resources/1.jpg"));

		ChnlRscIntf r = new ChnlRscImg("a", bImg);
		rsces.add(r);
		r = new ChnlRscImg("b", bImg);
		rsces.add(r);
		ChnlPresSvr chnl = new ChnlPresSvr(seshName, chnlName, rsces);

		NtfyCmdRegChnl cmd = chnl.getNtfyCmdRegChnl();
		assertEquals(cmd.getChnlName(), chnlName);
		assertEquals(cmd.getSeshName(), seshName);
		assertEquals(
				cmd.toXmlStr(),
				"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"RegChnl\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"NTFY\"><RSC NAME=\"a\"/><RSC NAME=\"b\"/></CMD></CUM>");

	}
}
