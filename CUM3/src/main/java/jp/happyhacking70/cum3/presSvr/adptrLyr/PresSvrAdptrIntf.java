/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdXML;
import jp.happyhacking70.cum3.presSvr.adptrLyr.discnHdlr.DiscnHdlrAbst;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;

import org.javatuples.Pair;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface PresSvrAdptrIntf {

	public Pair<String, DiscnHdlrAbst> hndlCmd(String xml)
			throws CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc;

	public Pair<String, DiscnHdlrAbst> hndlCmd(String xml, CmdSenderIntf sender)
			throws CumExcpIllegalCmdXML, CumExcpIllegalCmdDoc;

	public Pair<String, DiscnHdlrAbst> hndlCmd(String xml,
			ArrayList<ChnlRscIntf> rsces) throws CumExcpIllegalCmdXML,
			CumExcpIllegalCmdDoc;

}