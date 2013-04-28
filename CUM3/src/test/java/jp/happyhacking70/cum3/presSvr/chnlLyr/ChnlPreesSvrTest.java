/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.chnlLyr;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscImg;
import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdLvChnl;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRegChnl;
import jp.happyhacking70.cum3.comLyr.DummySender;
import jp.happyhacking70.cum3.comLyr.DummySrvAdm;
import jp.happyhacking70.cum3.excp.impl.CumExcpComError;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNull;
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
	protected DummySrvAdm svrAdm = new DummySrvAdm();
	protected DummySender sender = new DummySender(svrAdm);
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
	@Test(expected = CumExcpRscNull.class)
	public void testChnlPresSvr_NullRsc() throws CumExcpRscExists,
			CumExcpRscNull {
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
			CumExcpRscNull {
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
	public void testChnlPresSvr_OK() throws CumExcpRscExists, CumExcpRscNull {
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
			CumExcpRscNull {
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
	 * @throws CumExcpComError
	 */
	@Test(expected = CumExcpAudNotExist.class)
	public void testSendChnlCmdCmdAbstAudIntf_NoAud() throws CumExcpRscExists,
			CumExcpRscNull, CumExcpAudExists, CumExcpAudNotExist,
			CumExcpComError {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		ChnlPresSvr chnl = new ChnlPresSvr(seshName, chnlName, rsces);

		ReqCmdClsChnl cmd = new ReqCmdClsChnl("testSession", chnlName);
		chnl.sendChnlCmd(cmd, aud.getAudName());

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
	 * @throws CumExcpComError
	 * @throws CumExcpXMLGenFailed
	 */
	@Test
	public void testSendChnlCmdCmdAbstAudIntf_OK() throws CumExcpRscExists,
			CumExcpRscNull, CumExcpAudExists, CumExcpAudNotExist,
			CumExcpComError, CumExcpXMLGenFailed {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		ChnlPresSvr chnl = new ChnlPresSvr(seshName, chnlName, rsces);
		chnl.joinChnl(aud);

		ReqCmdClsChnl cmd = new ReqCmdClsChnl("testSession", chnlName);
		chnl.sendChnlCmd(cmd, aud.getAudName());

		assertEquals(cmd.toXmlStr(), sender.pollCmd());
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
	 * @throws CumExcpComError
	 * @throws CumExcpXMLGenFailed
	 */
	@Test
	public void testSendChnlCmdCmdAbst() throws CumExcpRscExists,
			CumExcpRscNull, CumExcpAudExists, CumExcpAudNotExist,
			CumExcpComError, CumExcpXMLGenFailed {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		ChnlPresSvr chnl = new ChnlPresSvr(seshName, chnlName, rsces);
		chnl.joinChnl(aud);

		DummySender senderFor2 = new DummySender(new DummySrvAdm());
		chnl.joinChnl(new Aud("testAudience2", senderFor2));

		ReqCmdRegChnl cmd = new ReqCmdRegChnl("testSession", "testChannel");
		chnl.sendChnlCmd(cmd);

		assertEquals(cmd.toXmlStr(), sender.pollCmd());
		assertEquals(cmd.toXmlStr(), senderFor2.pollCmd());
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
	public void testGetRsc_OK() throws CumExcpRscExists, CumExcpRscNull,
			CumExcpRscNotExist, IOException {

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
			CumExcpRscExists, CumExcpRscNull, CumExcpRscNotExist {

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
	public void testJoinChnl_OK() throws CumExcpRscExists, CumExcpRscNull,
			CumExcpAudExists {
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
			CumExcpRscNull, CumExcpAudExists {

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
	public void testLvChnl_OK() throws CumExcpRscExists, CumExcpRscNull,
			CumExcpAudExists, CumExcpAudNotExist {
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
	public void testLvChnl_NoAud() throws CumExcpRscExists, CumExcpRscNull,
			CumExcpAudExists, CumExcpAudNotExist {
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
			CumExcpRscNull, CumExcpXMLGenFailed {
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
	public void testGetNtfyClsChnlCmd() throws IOException, CumExcpRscExists,
			CumExcpRscNull, CumExcpXMLGenFailed {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		BufferedImage bImg = ImageIO.read(new File("src/test/resources/1.jpg"));

		ChnlRscIntf r = new ChnlRscImg("a", bImg);
		rsces.add(r);
		r = new ChnlRscImg("b", bImg);
		rsces.add(r);
		ChnlPresSvr chnl = new ChnlPresSvr(seshName, chnlName, rsces);

		NtfyCmdClsChnl cmd = chnl.getNtfyCmdClsChnl();
		assertEquals(cmd.getChnlName(), chnlName);
		assertEquals(cmd.getSeshName(), seshName);
		assertEquals(
				cmd.toXmlStr(),
				"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsChnl\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"NTFY\"/></CUM>");

	}
}
