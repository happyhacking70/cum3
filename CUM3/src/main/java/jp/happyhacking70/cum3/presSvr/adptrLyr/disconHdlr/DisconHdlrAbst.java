/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.disconHdlr;

import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrDisconIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class DisconHdlrAbst {
	SeshMgrPresSvrDisconIntf seshMgr;

	public DisconHdlrAbst(SeshMgrPresSvrDisconIntf seshMgr) {
		super();
		this.seshMgr = seshMgr;
	}

	abstract void notifyDiscon();
}
