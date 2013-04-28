/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdLvChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdLvSesh;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRegSesh;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRjctChnl;
import jp.happyhacking70.cum3.excp.impl.CumExcptAdptrHdlrNotFound;
import jp.happyhacking70.cum3.presSvr.adptrLyr.PresSvrAdptrHdlrIntfBase;
import jp.happyhacking70.cum3.test.CumTestBast;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdptrHdlrFactoryTest extends CumTestBast {
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
}
