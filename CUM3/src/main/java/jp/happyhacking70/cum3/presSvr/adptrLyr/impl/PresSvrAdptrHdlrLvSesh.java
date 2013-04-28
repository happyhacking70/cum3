/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.impl;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdLvSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdLvSesh;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshNotExist;
import jp.happyhacking70.cum3.presSvr.adptrLyr.PresSvrAdptrHdlrIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdptrHdlrLvSesh implements PresSvrAdptrHdlrIntf {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.comLyr.adaptor.PresSvrAdaptorHdlrIntf#
	 * hndlCmd(java.lang.String)
	 */
	@Override
	public CmdAbst hndlCmd(CmdAbst cmd, SeshMgrPresSvrAllIntf seshMgr)
			throws CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc {

		ReqCmdLvSesh reqCmd = (ReqCmdLvSesh) cmd;
		ResCmdLvSesh resCmd;

		try {
			seshMgr.lvSesh(reqCmd.getSeshName(), reqCmd.getAudName());
			resCmd = new ResCmdLvSesh(reqCmd.getSeshName(),
					reqCmd.getAudName(), ResCmdLvSesh.RsltTypes.Left.name());

		} catch (CumExcpAudNotExist e) {
			resCmd = new ResCmdLvSesh(reqCmd.getSeshName(),
					reqCmd.getAudName(), ResCmdLvSesh.RsltTypes.NotExist.name());

		} catch (CumExcpSeshNotExist e) {
			resCmd = new ResCmdLvSesh(reqCmd.getSeshName(),
					reqCmd.getAudName(),
					ResCmdLvSesh.RsltTypes.SeshNotExist.name());
		}

		return resCmd;
	}
}
