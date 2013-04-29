/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.hdlr.impl;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.ResCmdIntf;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdJoinChnl;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshNotExist;
import jp.happyhacking70.cum3.presSvr.adptrLyr.PresSvrAdptrHdlrIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdptrHdlrJoinChnl implements PresSvrAdptrHdlrIntf {

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

		ReqCmdJoinChnl reqCmd = (ReqCmdJoinChnl) cmd;
		ResCmdJoinChnl resCmd;

		try {
			seshMgr.joinChnl(reqCmd.getSeshName(), reqCmd.getChnlName(),
					reqCmd.getAudName());
			resCmd = new ResCmdJoinChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), reqCmd.getAudName(),
					ResCmdJoinChnl.RsltTypes.Joined.name());

		} catch (CumExcpAudExists e) {
			resCmd = new ResCmdJoinChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), reqCmd.getAudName(),
					ResCmdJoinChnl.RsltTypes.Exists.name());
		} catch (CumExcpAudNotExist e) {
			resCmd = new ResCmdJoinChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), reqCmd.getAudName(),
					ResCmdJoinChnl.RsltTypes.AudNotExist.name());
		} catch (CumExcpChnlNotExist e) {
			resCmd = new ResCmdJoinChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), reqCmd.getAudName(),
					ResCmdJoinChnl.RsltTypes.ChnlNotExist.name());
		} catch (CumExcpSeshNotExist e) {
			resCmd = new ResCmdJoinChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), reqCmd.getAudName(),
					ResCmdJoinChnl.RsltTypes.SeshNotExist.name());
		}

		return resCmd;
	}
}
