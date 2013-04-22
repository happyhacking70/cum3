/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr.impl;

import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrInternalIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class DummySeshMgrInternalIntf implements SeshMgrInternalIntf {
	protected String seshDisconned;
	protected String seshRemoved;

	public String getSeshDisconned() {
		return seshDisconned;
	}

	public String getSeshRemoved() {
		return seshRemoved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrInternalIntf#hndlSeshDsiconned
	 * (java.lang.String)
	 */
	public void hndlSeshDsiconned(String seshName) {
		seshDisconned = seshName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrInternalIntf#removeSesh
	 * (java.lang.String)
	 */
	public void removeSesh(String seshName) {
		seshRemoved = seshName;
	}

}
