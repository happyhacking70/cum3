/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr.impl;

import jp.happyhacking70.cum3.presSvr.seshLyr.AcptSeshDisconnedIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class DummyDeshDisconnedAcpter implements AcptSeshDisconnedIntf {
	protected String seshName;

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.presSvr.seshLyr.AcptSeshDisconnedIntf#
	 * acceptSeshDisconned(java.lang.String)
	 */
	public void acceptSeshDisconned(String seshName) {
		this.seshName = seshName;
	}

	public String getSeshName() {
		return seshName;
	}

}
