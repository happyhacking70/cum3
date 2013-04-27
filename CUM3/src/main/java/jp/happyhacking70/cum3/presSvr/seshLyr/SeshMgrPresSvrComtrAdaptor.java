/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;

/**
 * This class is intended to make implementation of SeshMgrPresSvr easier.
 * SeshMgrPresSvr can forget command level handling. While many cmdHdl(s) do not
 * need to receive {@link CmdSenderIntf} and {@link ArrayList} of
 * {@link ChnlRscIntf}, but to make communicator to handle commands
 * <B>EASIER</B> all cmdHdl(s) recieve both.
 * 
 * @author happyhacking70@gmail.com
 * 
 */

public class SeshMgrPresSvrComtrAdaptor {

	/**
	 * Session Manager
	 */
	protected SeshMgrPresSvrAllIntf seshMgr;

	/**
	 * @param seshMgr
	 */
	public SeshMgrPresSvrComtrAdaptor(SeshMgrPresSvrAllIntf seshMgr) {
		super();
		this.seshMgr = seshMgr;
	}

	// protected CmdAbst getCmdInstance(String xml) {
	//
	// }
}
