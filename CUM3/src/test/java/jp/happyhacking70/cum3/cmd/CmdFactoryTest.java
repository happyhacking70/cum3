/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdClsChnl;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdClsSesh;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdLvChnl;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdLvSesh;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.cmd.ntfy.impl.NtfyCmdRjctChnl;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdClsChnl;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdClsSesh;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdLvChnl;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdLvSesh;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdRegChnl;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdRegSesh;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdRjctChnl;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdClsChnl;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdClsSesh;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdLvChnl;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdLvSesh;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdRegChnl;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdRegSesh;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdRjctChnl;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CmdFactoryTest {
	CmdFactory cf = new CmdFactory();
	static final String seshName = "testSession";
	static final String channelName = "testChannel";
	static final String audienceName = "testAudience";

	@Test
	public void testReqCmdRegSesh() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"RegSesh\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";
		ReqCmdRegSesh cmd = (ReqCmdRegSesh) cf.getCmdInstance(xml);
		assertEquals(ReqCmdRegSesh.class, cmd.getClass());

		assertEquals(seshName, cmd.getSeshName());

	}

	@Test
	public void testResCmdRegSesh() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"RegSesh\" RSLT=\"Reged\" SESH=\"testSession\" TYPE=\"RES\"/></CUM>";
		ResCmdRegSesh cmd = (ResCmdRegSesh) cf.getCmdInstance(xml);
		assertEquals(ResCmdRegSesh.class, cmd.getClass());

		assertEquals(seshName, cmd.getSeshName());

	}

	@Test
	public void testReqCmdClsSesh() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsSesh\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";
		ReqCmdClsSesh cmd = (ReqCmdClsSesh) cf.getCmdInstance(xml);
		assertEquals(ReqCmdClsSesh.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());

	}

	@Test
	public void testResCmdClsSesh() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsSesh\" RSLT=\"Clsed\" SESH=\"testSession\" TYPE=\"RES\"/></CUM>";
		ResCmdClsSesh cmd = (ResCmdClsSesh) cf.getCmdInstance(xml);
		assertEquals(ResCmdClsSesh.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());

	}

	@Test
	public void testNtfyCmdClsSesh() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsSesh\" SESH=\"testSession\" TYPE=\"NTFY\"/></CUM>";
		NtfyCmdClsSesh cmd = (NtfyCmdClsSesh) cf.getCmdInstance(xml);
		assertEquals(NtfyCmdClsSesh.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());

	}

	@Test
	public void testReqCmdRegChnl() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"RegChnl\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"REQ\"><RSC NAME=\"a\"/><RSC NAME=\"b\"/></CMD></CUM>";
		ReqCmdRegChnl cmd = (ReqCmdRegChnl) cf.getCmdInstance(xml);
		assertEquals(ReqCmdRegChnl.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());

		assertEquals(channelName, cmd.getChnlName());

	}

	protected void checkRsces(List<ChnlRscIntf> rsces) {

		assertEquals(2, rsces.size());
		boolean a = false;
		boolean b = false;
		for (ChnlRscIntf rsc : rsces) {
			if (rsc.getName().equals("a")) {
				a = true;
			}
			if (rsc.getName().equals("b")) {
				b = true;
			}
		}
		assertTrue(a);
		assertTrue(b);
	}

	@Test
	public void testResCmdRegChnl() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"RegChnl\" CHNL=\"testChannel\" RSLT=\"Reged\" SESH=\"testSession\" TYPE=\"RES\"><RSC NAME=\"a\"/><RSC NAME=\"b\"/></CMD></CUM>";
		ResCmdRegChnl cmd = (ResCmdRegChnl) cf.getCmdInstance(xml);
		assertEquals(ResCmdRegChnl.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(channelName, cmd.getChnlName());
		checkRsces(cmd.getRscData());
	}

	@Test
	public void testNtfyCmdRegChnl() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"RegChnl\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"NTFY\"><RSC NAME=\"a\"/><RSC NAME=\"b\"/></CMD></CUM>";
		NtfyCmdRegChnl cmd = (NtfyCmdRegChnl) cf.getCmdInstance(xml);

		assertEquals(NtfyCmdRegChnl.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(channelName, cmd.getChnlName());
		checkRsces(cmd.getRscData());
	}

	@Test
	public void testReqCmdClsChnl() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsChnl\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";
		ReqCmdClsChnl cmd = (ReqCmdClsChnl) cf.getCmdInstance(xml);
		assertEquals(ReqCmdClsChnl.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(channelName, cmd.getChnlName());

	}

	@Test
	public void testResCmdClsChnl() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsChnl\" CHNL=\"testChannel\" RSLT=\"Clsed\" SESH=\"testSession\" TYPE=\"RES\"/></CUM>";
		ResCmdClsChnl cmd = (ResCmdClsChnl) cf.getCmdInstance(xml);
		assertEquals(ResCmdClsChnl.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(channelName, cmd.getChnlName());

	}

	@Test
	public void testNtfyCmdClsChnl() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"ClsChnl\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"NTFY\"/></CUM>";
		NtfyCmdClsChnl cmd = (NtfyCmdClsChnl) cf.getCmdInstance(xml);
		assertEquals(NtfyCmdClsChnl.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(channelName, cmd.getChnlName());

	}

	@Test
	public void testReqCmdJoinSesh() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"JoinSesh\" AUD=\"testAudience\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";
		ReqCmdJoinSesh cmd = (ReqCmdJoinSesh) cf.getCmdInstance(xml);
		assertEquals(ReqCmdJoinSesh.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(audienceName, cmd.getAudName());
	}

	@Test
	public void testResCmdJoinSesh() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"JoinSesh\" AUD=\"testAudience\" RSLT=\"Exists\" SESH=\"testSession\" TYPE=\"RES\"/></CUM>";
		ResCmdJoinSesh cmd = (ResCmdJoinSesh) cf.getCmdInstance(xml);
		assertEquals(ResCmdJoinSesh.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());

	}

	@Test
	public void testNtfyCmdJoinSesh() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"JoinSesh\" AUD=\"testAudience\" SESH=\"testSession\" TYPE=\"NTFY\"/></CUM>";
		NtfyCmdJoinSesh cmd = (NtfyCmdJoinSesh) cf.getCmdInstance(xml);
		assertEquals(NtfyCmdJoinSesh.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());

	}

	@Test
	public void testReqCmdJoinChnl() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"JoinChnl\" AUD=\"testAudience\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";
		ReqCmdJoinChnl cmd = (ReqCmdJoinChnl) cf.getCmdInstance(xml);
		assertEquals(ReqCmdJoinChnl.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(channelName, cmd.getChnlName());

	}

	@Test
	public void testResCmdJoinChnl() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"JoinChnl\" AUD=\"testAudience\" CHNL=\"testChannel\" RSLT=\"Joined\" SESH=\"testSession\" TYPE=\"RES\"/></CUM>";
		ResCmdJoinChnl cmd = (ResCmdJoinChnl) cf.getCmdInstance(xml);
		assertEquals(ResCmdJoinChnl.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(channelName, cmd.getChnlName());

	}

	@Test
	public void testNtfyCmdJoinChnl() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"JoinChnl\" AUD=\"testAudience\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"NTFY\"/></CUM>";
		NtfyCmdJoinChnl cmd = (NtfyCmdJoinChnl) cf.getCmdInstance(xml);
		assertEquals(NtfyCmdJoinChnl.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(channelName, cmd.getChnlName());
		assertEquals(audienceName, cmd.getAudName());
	}

	@Test
	public void testReqCmdLvChnl() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"LvChnl\" AUD=\"testAudience\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";
		ReqCmdLvChnl cmd = (ReqCmdLvChnl) cf.getCmdInstance(xml);
		assertEquals(ReqCmdLvChnl.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(channelName, cmd.getChnlName());
		assertEquals(audienceName, cmd.getAudName());
	}

	@Test
	public void testResCmdLvChnl() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"LvChnl\" AUD=\"testAudience\" CHNL=\"testChannel\" RSLT=\"Left\" SESH=\"testSession\" TYPE=\"RES\"/></CUM>";
		ResCmdLvChnl cmd = (ResCmdLvChnl) cf.getCmdInstance(xml);
		assertEquals(ResCmdLvChnl.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(channelName, cmd.getChnlName());
		assertEquals(audienceName, cmd.getAudName());
	}

	@Test
	public void testNtfyCmdLvChnl() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"LvChnl\" AUD=\"testAudience\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"NTFY\"/></CUM>";
		NtfyCmdLvChnl cmd = (NtfyCmdLvChnl) cf.getCmdInstance(xml);
		assertEquals(NtfyCmdLvChnl.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(channelName, cmd.getChnlName());
		assertEquals(audienceName, cmd.getAudName());
	}

	@Test
	public void testReqCmdLvSesh() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"LvSesh\" AUD=\"testAudience\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";
		ReqCmdLvSesh cmd = (ReqCmdLvSesh) cf.getCmdInstance(xml);
		assertEquals(ReqCmdLvSesh.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(audienceName, cmd.getAudName());
	}

	@Test
	public void testResCmdLvSesh() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"LvSesh\" AUD=\"testAudience\" RSLT=\"Left\" SESH=\"testSession\" TYPE=\"RES\"/></CUM>";
		ResCmdLvSesh cmd = (ResCmdLvSesh) cf.getCmdInstance(xml);
		assertEquals(ResCmdLvSesh.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(audienceName, cmd.getAudName());
	}

	@Test
	public void testNtfyCmdLvSesh() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"LvSesh\" AUD=\"testAudience\" SESH=\"testSession\" TYPE=\"NTFY\"/></CUM>";
		NtfyCmdLvSesh cmd = (NtfyCmdLvSesh) cf.getCmdInstance(xml);
		assertEquals(NtfyCmdLvSesh.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(audienceName, cmd.getAudName());
	}

	@Test
	public void testReqCmdRjctChnl() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"RjctChnl\" AUD=\"testAudience\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"REQ\"/></CUM>";
		ReqCmdRjctChnl cmd = (ReqCmdRjctChnl) cf.getCmdInstance(xml);
		assertEquals(ReqCmdRjctChnl.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(channelName, cmd.getChnlName());
		assertEquals(audienceName, cmd.getAudName());
	}

	@Test
	public void testResCmdRjctChnl() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"RjctChnl\" AUD=\"testAudience\" CHNL=\"testChannel\" RSLT=\"Rjcted\" SESH=\"testSession\" TYPE=\"RES\"/></CUM>";
		ResCmdRjctChnl cmd = (ResCmdRjctChnl) cf.getCmdInstance(xml);
		assertEquals(ResCmdRjctChnl.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(channelName, cmd.getChnlName());
		assertEquals(audienceName, cmd.getAudName());
	}

	@Test
	public void testNtfyCmdRjctChnl() throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><CUM><CMD ACTION=\"RjctChnl\" AUD=\"testAudience\" CHNL=\"testChannel\" SESH=\"testSession\" TYPE=\"NTFY\"/></CUM>";
		NtfyCmdRjctChnl cmd = (NtfyCmdRjctChnl) cf.getCmdInstance(xml);
		assertEquals(NtfyCmdRjctChnl.class, cmd.getClass());
		assertEquals(seshName, cmd.getSeshName());
		assertEquals(channelName, cmd.getChnlName());
		assertEquals(audienceName, cmd.getAudName());
	}

}
