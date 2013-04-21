/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import jp.happyhacking70.cum3.cmd.impl.NtfyCmdAudDisconned;

/**
 * <UL>
 * <LI>Accept the case audience is disconnected</LI>
 * <LI>send {@link NtfyCmdAudDisconned} to presenter</LI>
 * <LI>remove audience from session and channels</LI>
 * </UL>
 * <BR>
 * Recommended way<BR>
 * <UL>
 * <LI>return to caller as soon as possible</LI>
 * <LI>remaining tasks are executed asynchronously</LI>
 * </UL>
 * 
 * @author happyhacking70@gmail.com
 * 
 */
public interface AcptAudDisconnedIntf {
	void acceptAudDisconned(String audName);
}
