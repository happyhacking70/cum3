/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.presSvr.adptrLyr.disconHdlr.DisconHdlrAbst;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;

import org.javatuples.Pair;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface PresSvrAdptrIntf {

	public Pair<String, DisconHdlrAbst> hndlCmd(String xml);

	public Pair<String, DisconHdlrAbst> hndlCmd(String xml, CmdSenderIntf sender);

	public Pair<String, DisconHdlrAbst> hndlCmd(String xml,
			ArrayList<ChnlRscIntf> rsces);

}