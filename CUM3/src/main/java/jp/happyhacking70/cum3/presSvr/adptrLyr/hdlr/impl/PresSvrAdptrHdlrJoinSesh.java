/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.ResCmdIntf;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdJoinSesh;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshNotExist;
import jp.happyhacking70.cum3.presSvr.adptrLyr.PresSvrAdptrHdlrWithSenderIntf;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdptrHdlrJoinSesh implements PresSvrAdptrHdlrWithSenderIntf {

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.presSvr.comLyr.adaptor.
	 * PresSvrAdaptorHdlrWithSenderIntf
	 * #hndlCmd(jp.happyhacking70.cum3.cmd.CmdAbst,
	 * jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf,
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf)
	 */
	@Override
	public ResCmdIntf hndlCmd(CmdAbst cmd, CmdSenderIntf sender,
			SeshMgrPresSvrAllIntf seshMgr) throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {

		ReqCmdJoinSesh reqCmd = (ReqCmdJoinSesh) cmd;
		ResCmdJoinSesh resCmd = null;

		try {
			seshMgr.joinSesh(reqCmd.getSeshName(), reqCmd.getAudName(), sender);
			sender.sendCmd(new ResCmdJoinSesh(reqCmd.getSeshName(), reqCmd
					.getAudName(), ResCmdJoinSesh.RsltTypes.Joined));

		} catch (CumExcpAudExists e) {
			resCmd = new ResCmdJoinSesh(reqCmd.getSeshName(),
					reqCmd.getAudName(), ResCmdJoinSesh.RsltTypes.Exists);
		} catch (CumExcpSeshNotExist e) {
			resCmd = new ResCmdJoinSesh(reqCmd.getSeshName(),
					reqCmd.getAudName(), ResCmdJoinSesh.RsltTypes.NotExist);
		}

		return resCmd;
	}
}
