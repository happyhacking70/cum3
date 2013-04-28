/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.impl;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdRegChnl;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshNotExist;
import jp.happyhacking70.cum3.presSvr.adptrLyr.PresSvrAdptrHdlrIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrAdptrHdlrRegChnl implements PresSvrAdptrHdlrIntf {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.comLyr.adaptor.SvrAdaptorHdlrWithRscesIntf
	 * #hndlCmd(jp.happyhacking70.cum3.cmd.CmdAbst, java.util.ArrayList)
	 */
	@Override
	public CmdAbst hndlCmd(CmdAbst cmd, SeshMgrPresSvrAllIntf seshMgr)
			throws CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc {

		ReqCmdRegChnl reqCmd = (ReqCmdRegChnl) cmd;
		ResCmdRegChnl resCmd;

		try {
			seshMgr.regChnl(reqCmd.getSeshName(), reqCmd.getChnlName(),
					reqCmd.getRscData());
			resCmd = new ResCmdRegChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), reqCmd.getRscData(),
					ResCmdRegChnl.RsltTypes.Reged);

		} catch (CumExcpRscExists e) {
			resCmd = new ResCmdRegChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), reqCmd.getRscData(),
					ResCmdRegChnl.RsltTypes.DupRsc);
		} catch (CumExcpChnlExists e) {
			resCmd = new ResCmdRegChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), reqCmd.getRscData(),
					ResCmdRegChnl.RsltTypes.Exists);
		} catch (CumExcpRscNull e) {
			resCmd = new ResCmdRegChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), reqCmd.getRscData(),
					ResCmdRegChnl.RsltTypes.RscNull);
		} catch (CumExcpSeshNotExist e) {
			resCmd = new ResCmdRegChnl(reqCmd.getSeshName(),
					reqCmd.getChnlName(), reqCmd.getRscData(),
					ResCmdRegChnl.RsltTypes.SeshNotExist);
		}
		return resCmd;
	}
}
