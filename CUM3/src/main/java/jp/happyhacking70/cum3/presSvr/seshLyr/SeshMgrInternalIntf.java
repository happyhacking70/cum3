/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import jp.happyhacking70.cum3.cmd.impl.NtfyCmdSeshDisconned;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface SeshMgrInternalIntf {

	/**
	 * <UL>
	 * <LI>send {@link NtfyCmdSeshDisconned} to all session audiences/LI>
	 * <LI>remove session from sessions</LI>
	 * </UL
	 * 
	 * @param seshName
	 */
	void hndlSeshDsiconned(String seshName);

	void removeSesh(String seshName);

}
