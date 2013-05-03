/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdClsChnl;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdClsSesh;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdLvChnl;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdLvSesh;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdRegChnl;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdRegSesh;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdRjctChnl;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdUnknowCmd;
import jp.happyhacking70.cum3.excp.impl.CumExcptAdptrHdlrNotFound;
import jp.happyhacking70.cum3.presSvr.adptrLyr.PresSvrAdptrHdlrIntfBase;
import jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl.PresSvrAdptrHdlrClsChnl;
import jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl.PresSvrAdptrHdlrClsSesh;
import jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl.PresSvrAdptrHdlrFactory;
import jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl.PresSvrAdptrHdlrJoinChnl;
import jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl.PresSvrAdptrHdlrJoinSesh;
import jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl.PresSvrAdptrHdlrLvChnl;
import jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl.PresSvrAdptrHdlrLvSesh;
import jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl.PresSvrAdptrHdlrRegChnl;
import jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl.PresSvrAdptrHdlrRegSesh;
import jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl.PresSvrAdptrHdlrRjctChnl;
import jp.happyhacking70.cum3.test.CumTestAbst;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdptrHdlrFactoryTest extends CumTestAbst {
	protected PresSvrAdptrHdlrFactory f = new PresSvrAdptrHdlrFactory();

	/**
	 * @throws IOException
	 */
	public PresSvrAdptrHdlrFactoryTest() throws IOException {
		super();
	}

	@Test
	public void testReqCmdClsSesh() throws CumExcptAdptrHdlrNotFound {
		ReqCmdClsSesh reqCmd = new ReqCmdClsSesh(seshName);
		PresSvrAdptrHdlrIntfBase hdlr = f.getHdlr(reqCmd);
		assertEquals(PresSvrAdptrHdlrClsSesh.class, hdlr.getClass());
	}

	@Test
	public void testReqCmdRegChnl() throws CumExcptAdptrHdlrNotFound {
		ReqCmdRegChnl reqCmd = new ReqCmdRegChnl(seshName, chnlName);
		PresSvrAdptrHdlrIntfBase hdlr = f.getHdlr(reqCmd);
		assertEquals(PresSvrAdptrHdlrRegChnl.class, hdlr.getClass());
	}

	@Test
	public void testReqCmdClsChnl() throws CumExcptAdptrHdlrNotFound {
		ReqCmdClsChnl reqCmd = new ReqCmdClsChnl(seshName, chnlName);
		PresSvrAdptrHdlrIntfBase hdlr = f.getHdlr(reqCmd);
		assertEquals(PresSvrAdptrHdlrClsChnl.class, hdlr.getClass());
	}

	@Test
	public void testReqCmdJoinChnl() throws CumExcptAdptrHdlrNotFound {
		ReqCmdJoinChnl reqCmd = new ReqCmdJoinChnl(seshName, chnlName, audName);
		PresSvrAdptrHdlrIntfBase hdlr = f.getHdlr(reqCmd);
		assertEquals(PresSvrAdptrHdlrJoinChnl.class, hdlr.getClass());
	}

	@Test
	public void testReqCmdLvChnl() throws CumExcptAdptrHdlrNotFound {
		ReqCmdLvChnl reqCmd = new ReqCmdLvChnl(seshName, chnlName, audName);
		PresSvrAdptrHdlrIntfBase hdlr = f.getHdlr(reqCmd);
		assertEquals(PresSvrAdptrHdlrLvChnl.class, hdlr.getClass());
	}

	@Test
	public void testReqCmdLvSesh() throws CumExcptAdptrHdlrNotFound {
		ReqCmdLvSesh reqCmd = new ReqCmdLvSesh(seshName, audName);
		PresSvrAdptrHdlrIntfBase hdlr = f.getHdlr(reqCmd);
		assertEquals(PresSvrAdptrHdlrLvSesh.class, hdlr.getClass());
	}

	@Test
	public void testReqCmdRjctChnl() throws CumExcptAdptrHdlrNotFound {
		ReqCmdRjctChnl reqCmd = new ReqCmdRjctChnl(seshName, chnlName, audName);
		PresSvrAdptrHdlrIntfBase hdlr = f.getHdlr(reqCmd);
		assertEquals(PresSvrAdptrHdlrRjctChnl.class, hdlr.getClass());
	}

	@Test
	public void testReqCmdRegSesh() throws CumExcptAdptrHdlrNotFound {
		ReqCmdRegSesh reqCmd = new ReqCmdRegSesh(seshName);
		PresSvrAdptrHdlrIntfBase hdlr = f.getHdlr(reqCmd);
		assertEquals(PresSvrAdptrHdlrRegSesh.class, hdlr.getClass());
	}

	@Test
	public void testReqCmdJoinSesh() throws CumExcptAdptrHdlrNotFound {
		ReqCmdJoinSesh reqCmd = new ReqCmdJoinSesh(seshName, audName);
		PresSvrAdptrHdlrIntfBase hdlr = f.getHdlr(reqCmd);
		assertEquals(PresSvrAdptrHdlrJoinSesh.class, hdlr.getClass());
	}

	@Test(expected = CumExcptAdptrHdlrNotFound.class)
	public void testUnknown() throws CumExcptAdptrHdlrNotFound {
		CmdAbst reqCmd = new ResCmdUnknowCmd();
		f.getHdlr(reqCmd);
	}
}
