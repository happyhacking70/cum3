/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.req.impl.ReqCmdClsChnl;
import jp.happyhacking70.cum3.cmd.res.ResCmdIntf;
import jp.happyhacking70.cum3.cmd.res.impl.ResCmdClsChnl;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshNotExist;
import jp.happyhacking70.cum3.presSvr.adptrLyr.PresSvrAdptrHdlrIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdptrHdlrClsChnl implements PresSvrAdptrHdlrIntf {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.comLyr.adaptor.PresSvrAdaptorHdlrIntf#
	 * hndlCmd(java.lang.String)
	 */
	@Override
	public ResCmdIntf hndlCmd(CmdAbst cmd, SeshMgrPresSvrAllIntf seshMgr)
			throws CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc {

		ReqCmdClsChnl reqCmd = (ReqCmdClsChnl) cmd;
		ResCmdClsChnl resCmd;

		try {
			seshMgr.clsChnl(reqCmd.getSeshName(), reqCmd.getChnlName());
			resCmd = new ResCmdClsChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), ResCmdClsChnl.RsltTypes.Clsed);
		} catch (CumExcpSeshNotExist e) {
			resCmd = new ResCmdClsChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), ResCmdClsChnl.RsltTypes.SeshNotExist);
		} catch (CumExcpChnlNotExist e) {
			resCmd = new ResCmdClsChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), ResCmdClsChnl.RsltTypes.NotExist);
		}

		return resCmd;
	}
}
