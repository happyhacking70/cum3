/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl;

import java.util.HashMap;

import jp.happyhacking70.cum3.cmd.CmdAbst;
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

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdptrHdlrFactory {
	HashMap<Class<? extends CmdAbst>, PresSvrAdptrHdlrIntfBase> hdlrs = new HashMap<Class<? extends CmdAbst>, PresSvrAdptrHdlrIntfBase>();

	public PresSvrAdptrHdlrFactory() {
		super();
		setHdlrs();
	}

	/**
	 * set up hasmMap
	 */
	protected void setHdlrs() {

		hdlrs.put(ReqCmdClsSesh.class, new PresSvrAdptrHdlrClsSesh());
		hdlrs.put(ReqCmdRegChnl.class, new PresSvrAdptrHdlrRegChnl());
		hdlrs.put(ReqCmdClsChnl.class, new PresSvrAdptrHdlrClsChnl());
		hdlrs.put(ReqCmdJoinChnl.class, new PresSvrAdptrHdlrJoinChnl());
		hdlrs.put(ReqCmdLvChnl.class, new PresSvrAdptrHdlrLvChnl());
		hdlrs.put(ReqCmdLvSesh.class, new PresSvrAdptrHdlrLvSesh());
		hdlrs.put(ReqCmdRjctChnl.class, new PresSvrAdptrHdlrRjctChnl());
		hdlrs.put(ReqCmdRegSesh.class, new PresSvrAdptrHdlrRegSesh());
		hdlrs.put(ReqCmdJoinSesh.class, new PresSvrAdptrHdlrJoinSesh());
	}

	public PresSvrAdptrHdlrIntfBase getHdlr(CmdAbst cmd)
			throws CumExcptAdptrHdlrNotFound {
		PresSvrAdptrHdlrIntfBase hdlr = hdlrs.get(cmd.getClass());
		if (hdlr == null) {
			throw new CumExcptAdptrHdlrNotFound(cmd);
		}
		return hdlr;
	}

}
