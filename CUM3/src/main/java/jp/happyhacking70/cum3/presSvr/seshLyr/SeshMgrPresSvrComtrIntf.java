/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import jp.happyhacking70.cum3.cmd.impl.ReqCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.ReqCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.ReqCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.ReqCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.ReqCmdRegSesh;
import jp.happyhacking70.cum3.cmd.impl.ResCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.ResCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.ResCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.ResCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.ResCmdRegSesh;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface SeshMgrPresSvrComtrIntf {
	ResCmdRegSesh hdlCmd(ReqCmdRegSesh cmd);

	ResCmdClsSesh hdlCmd(ReqCmdClsSesh cmd);

	ResCmdRegChnl hdlCmd(ReqCmdRegChnl cmd);

	ResCmdClsChnl hdlCmd(ReqCmdClsChnl cmd);

	ResCmdJoinSesh hdlCmd(ReqCmdJoinSesh cmd);

	// ResCmdJoinChnl hdlCmd(ReqCmdJoinChnl cmd);
	//
	// ResCmdLvChnl hdlCmd(ReqCmdLvChnl cmd);
	//
	// ResCmdLvSesh hdlCmd(ReqCmdLvSesh cmd);
	//
	// ResCmdRjctChnl hdlCmd(ReqCmdRjctChnl cmd);

}
