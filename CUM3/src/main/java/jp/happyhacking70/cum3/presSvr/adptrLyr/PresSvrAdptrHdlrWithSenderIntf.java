/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.cmd.res.ResCmdIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface PresSvrAdptrHdlrWithSenderIntf extends
		PresSvrAdptrHdlrIntfBase {
	public ResCmdIntf hndlCmd(CmdAbst cmd, CmdSenderIntf sender,
			SeshMgrPresSvrAllIntf seshMgr) throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc;
}
