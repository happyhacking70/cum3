/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.disconHdlr;

import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrDisconIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class DisconHdlrAud extends DisconHdlrAbst {
	protected String seshName;
	protected String audName;

	/**
	 * @param presSvr
	 */
	public DisconHdlrAud(SeshMgrPresSvrDisconIntf seshMgr, String seshName,
			String audName) {
		super(seshMgr);
		this.seshName = seshName;
		this.audName = audName;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.presSvr.adptrLyr.disconHdlr.DisconHdlrAbst#
	 * notifyDiscon()
	 */
	@Override
	void notifyDiscon() {
		seshMgr.audDisconned(seshName, audName);
	}

}
