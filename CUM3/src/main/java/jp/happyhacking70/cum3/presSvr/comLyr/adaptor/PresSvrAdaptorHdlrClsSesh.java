/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.comLyr.adaptor;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdClsSesh;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshNotExist;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdaptorHdlrClsSesh implements PresSvrAdaptorHdlrIntf {

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

		ReqCmdClsSesh reqCmd = (ReqCmdClsSesh) cmd;
		ResCmdClsSesh resCmd;

		try {
			seshMgr.clsSesh(reqCmd.getSeshName());
			resCmd = new ResCmdClsSesh(reqCmd.getSeshName(),
					ResCmdClsSesh.RsltTypes.Clsed);
		} catch (CumExcpSeshNotExist e) {
			resCmd = new ResCmdClsSesh(reqCmd.getSeshName(),
					ResCmdClsSesh.RsltTypes.NotExist);
		}
		return resCmd;
	}
}
