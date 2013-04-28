/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.req;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscImg;
import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.ReqCmdChnlTestAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdRegChnlTest extends ReqCmdChnlTestAbst {
	static final public String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"RegChnl\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"REQ\"><RSC NAME=\"a\"/><RSC NAME=\"b\"/></CMD></CUM>";

	static protected ChnlRscImg rscA = new ChnlRscImg("a", null);
	static protected ChnlRscImg rscB = new ChnlRscImg("b", null);

	@Override
	protected CmdAbst getCmdNormal() {
		ReqCmdRegChnl cmd = new ReqCmdRegChnl(seshName, chnlName);
		cmd.addRscData(rscA);
		cmd.addRscData(rscB);
		return cmd;
	}

	@Override
	protected String getXMLNormal() {
		return xml;
	}

	@Override
	protected String getActionName() {
		return "RegChnl";
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(xml);
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRegChnl#getRscData()}.
	 */
	@Test
	public void testGetRscData() {
		ReqCmdRegChnl cmd = (ReqCmdRegChnl) getCmdNormal();
		List<ChnlRscIntf> rscData = cmd.getRscData();

		if (rscData.size() != 2) {
			fail("Too Many Resources:" + rscData.size());
		}
		if (rscData.contains(rscA) == false) {
			fail("Resource A Not Exist");

		}
		if (rscData.contains(rscB) == false) {
			fail("Resource B Not Exist");

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.cmd.CmdTestAbst#getCmdNormal(org.w3c.dom.Document)
	 */
	@Override
	protected CmdAbst getCmdNormal(Document doc) throws CumExcpIllegalCmdDoc {
		ArrayList<ChnlRscIntf> rsces = new ArrayList<ChnlRscIntf>();
		rsces.add(new ChnlRscImg("a", null));
		rsces.add(new ChnlRscImg("b", null));
		ReqCmdRegChnl cmd = new ReqCmdRegChnl(doc);
		cmd.addRsces(rsces);
		return cmd;
	}
}
