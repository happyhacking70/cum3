/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.disconHdlr;

import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrDisconIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class DisconHdlrPrestr extends DisconHdlrAbst {
	protected String seshName;

	/**
	 * @param presSvr
	 */
	public DisconHdlrPrestr(SeshMgrPresSvrDisconIntf seshMgr, String seshName) {
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
	void notifyDiscon() {
		seshMgr.prestrDisconned(seshName);
	}

}
