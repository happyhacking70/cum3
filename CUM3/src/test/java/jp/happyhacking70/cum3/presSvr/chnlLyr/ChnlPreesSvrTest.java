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
import jp.happyhacking70.cum3.cmd.impl.ReqCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.ReqCmdRegChnl;
import jp.happyhacking70.cum3.comLyr.DummySender;
import jp.happyhacking70.cum3.excp.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.CumExcpRscNotExist;
import jp.happyhacking70.cum3.excp.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.CumExcptNullRsces;
import jp.happyhacking70.cum3.presSvr.audLyr.Aud;
import jp.happyhacking70.cum3.presSvr.audLyr.AudIntf;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;

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
	protected CmdSenderIntf sender = new DummySender();
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

		chnl.sendChnlCmd(new ReqCmdClsChnl("testSession", chnlName), aud);
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
		chnl.sendChnlCmd(new ReqCmdClsChnl("testSession", chnlName), aud);
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
		chnl.joinChnl(new Aud("testAudience2", sender));

		chnl.sendChnlCmd(new ReqCmdRegChnl("testSession", "testChannel"));
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
		chnl.clsChnl();
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
		chnl.joinChnl(aud);
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
		chnl.lvChnl(aud);
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

}
