/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscImg;
import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.NtfyCmdChnlTestAbst;

import org.junit.BeforeClass;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class NtfyCmdRegChnlTest extends NtfyCmdChnlTestAbst {
	static String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"RegChnl\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"NTFY\"><RSC NAME=\"a\"/><RSC NAME=\"b\"/></CMD></CUM>";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(xml);
	}

	@Override
	protected CmdAbst getCmdNormal() {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		rsces.add(new ChnlRscImg("a", null));
		rsces.add(new ChnlRscImg("b", null));
		return new NtfyCmdRegChnl(seshName, chnlName, rsces);
	}

	@Override
	protected String getXMLNormal() {
		return xml;
	}

	@Override
	protected String getActionName() {
		return "RegChnl";
	}

}
