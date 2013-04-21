/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr.impl;

import jp.happyhacking70.cum3.excp.impl.CumExcpComError;
import jp.happyhacking70.cum3.presSvr.seshLyr.AcptSeshDisconnedIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshIntfInternal;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class AudDisconnedHdlr implements Runnable {
	protected String audName;
	protected SeshIntfInternal sesh;
	protected AcptSeshDisconnedIntf seshDisconnedAcpter;

	public AudDisconnedHdlr(String audName, SeshIntfInternal sesh,
			AcptSeshDisconnedIntf seshDisconnedAcpter) {
		super();
		this.audName = audName;
		this.sesh = sesh;
		this.seshDisconnedAcpter = seshDisconnedAcpter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			sesh.ntfyAudDisconned(audName);
		} catch (CumExcpComError e) {
			seshDisconnedAcpter.acceptSeshDisconned(sesh.getSeshName());
		}
	}
}