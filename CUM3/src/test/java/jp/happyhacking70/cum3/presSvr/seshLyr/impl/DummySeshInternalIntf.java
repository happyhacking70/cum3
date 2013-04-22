/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr.impl;

import jp.happyhacking70.cum3.cmd.XMLableCmdIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpComError;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshInternalIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class DummySeshInternalIntf implements SeshInternalIntf {
	protected String audName;
	protected boolean emulateComErr = false;
	protected String seshName;

	protected boolean seshDisconned = false;

	public boolean isSeshDisconned() {
		return seshDisconned;
	}

	/**
	 * @param seshname
	 */
	public DummySeshInternalIntf(String seshName) {
		this.seshName = seshName;
	}

	public void emulateComErr() {
		emulateComErr = true;
	}

	public String getAudName() {
		return audName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshInternalIntf#ntfySeshDisconned
	 * ()
	 */
	public void ntfySeshDisconned() {
		seshDisconned = true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshInternalIntf#ntfyAudDisconned
	 * (java.lang.String)
	 */
	public void ntfyAudDisconned(String audName) throws CumExcpComError {
		this.audName = audName;
		if (emulateComErr == true) {
			throw new CumExcpComError(audName);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshInternalIntf#getSeshName()
	 */
	public String getSeshName() {
		return this.seshName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshInternalIntf#sendCmdToPrestr
	 * (jp.happyhacking70.cum3.cmd.XMLableCmdIntf)
	 */
	public void sendCmdToPrestr(XMLableCmdIntf cmd) {
		// TODO Auto-generated method stub

	}

}
