/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.comLyr.adaptor;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRjctChnl;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdRjctChnl;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshNotExist;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdaptorHdlrRjctChnl implements PresSvrAdaptorHdlrIntf {

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

		ReqCmdRjctChnl reqCmd = (ReqCmdRjctChnl) cmd;
		ResCmdRjctChnl resCmd;

		try {
			seshMgr.rjctChnl(reqCmd.getSeshName(), reqCmd.getChnlName(),
					reqCmd.getAudName());
			resCmd = new ResCmdRjctChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), reqCmd.getAudName(),
					ResCmdRjctChnl.RsltTypes.Rjcted.name());

		} catch (CumExcpAudExists e) {
			resCmd = new ResCmdRjctChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), reqCmd.getAudName(),
					ResCmdRjctChnl.RsltTypes.Exists.name());

		} catch (CumExcpChnlNotExist e) {
			resCmd = new ResCmdRjctChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), reqCmd.getAudName(),
					ResCmdRjctChnl.RsltTypes.ChnlNotExist.name());

		} catch (CumExcpSeshNotExist e) {
			resCmd = new ResCmdRjctChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), reqCmd.getAudName(),
					ResCmdRjctChnl.RsltTypes.SeshNotExist.name());

		}

		return resCmd;
	}
}
