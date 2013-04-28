/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.impl;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRegSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdRegSesh;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshExists;
import jp.happyhacking70.cum3.presSvr.adptrLyr.PresSvrAdptrHdlrWithSenderIntf;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdptrHdlrRegSesh implements
		PresSvrAdptrHdlrWithSenderIntf {

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
	public CmdAbst hndlCmd(CmdAbst cmd, CmdSenderIntf sender,
			SeshMgrPresSvrAllIntf seshMgr) throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc {

		ReqCmdRegSesh reqCmd = (ReqCmdRegSesh) cmd;
		ResCmdRegSesh resCmd = null;

		try {
			seshMgr.regSesh(reqCmd.getSeshName(), sender);
			sender.sendCmd(new ResCmdRegSesh(reqCmd.getSeshName(),
					ResCmdRegSesh.RsltTypes.Reged));
		} catch (CumExcpSeshExists e) {
			resCmd = new ResCmdRegSesh(reqCmd.getSeshName(),
					ResCmdRegSesh.RsltTypes.Exists);
		}

		return resCmd;
	}
}
