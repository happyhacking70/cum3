/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRegSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.res.ResCmdRegSesh;

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
