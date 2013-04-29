/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface PresSvrAdptrIntf {

	public String hndlCmd(String xml);

	public String hndlCmd(String xml, CmdSenderIntf sender);

	public String hndlCmd(String xml, ArrayList<ChnlRscIntf> rsces);

}