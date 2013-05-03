/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.adptrLyr.discnHdlr;

import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrDisconIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class DiscnHdlrAud extends DiscnHdlrAbst {
	protected String seshName;
	protected String audName;

	/**
	 * @param presSvr
	 */
	public DiscnHdlrAud(SeshMgrPresSvrDisconIntf seshMgr, String seshName,
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
	public void notifyDiscon() {
		seshMgr.audDisconned(seshName, audName);
	}

}
