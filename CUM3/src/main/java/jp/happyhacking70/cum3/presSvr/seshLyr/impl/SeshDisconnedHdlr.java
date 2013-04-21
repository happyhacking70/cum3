/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr.impl;

import jp.happyhacking70.cum3.presSvr.seshLyr.SeshInternalIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrInternalIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class SeshDisconnedHdlr implements Runnable {
	SeshInternalIntf sesh;
	SeshMgrInternalIntf seshMgr;

	public SeshDisconnedHdlr(SeshInternalIntf sesh, SeshMgrInternalIntf seshMgr) {
		super();
		this.sesh = sesh;
		this.seshMgr = seshMgr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		sesh.ntfySeshDisconned();
		seshMgr.removeSesh(sesh.getSeshName());
	}
}
