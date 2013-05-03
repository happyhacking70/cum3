/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.discnHdlr;

import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrDisconIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class DiscnHdlrAbst {
	SeshMgrPresSvrDisconIntf seshMgr;

	public DiscnHdlrAbst(SeshMgrPresSvrDisconIntf seshMgr) {
		super();
		this.seshMgr = seshMgr;
	}

	abstract public void notifyDiscon();
}
