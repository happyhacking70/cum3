/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.discnHdlr;

import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrDisconIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class DiscnHdlrPrestr extends DiscnHdlrAbst {
	protected String seshName;

	/**
	 * @param presSvr
	 */
	public DiscnHdlrPrestr(SeshMgrPresSvrDisconIntf seshMgr, String seshName) {
		super(seshMgr);
		this.seshName = seshName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.presSvr.adptrLyr.disconHdlr.DisconHdlrAbst#
	 * notifyDiscon()
	 */
	@Override
	public void notifyDiscon() {
		seshMgr.prestrDisconned(seshName);
	}

}
