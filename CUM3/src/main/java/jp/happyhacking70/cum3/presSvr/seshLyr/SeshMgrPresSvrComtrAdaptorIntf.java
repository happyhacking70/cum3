/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.ResCmdIntf;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdLvChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdLvSesh;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRegSesh;
import jp.happyhacking70.cum3.cmd.impl.req.ReqCmdRjctChnl;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface SeshMgrPresSvrComtrAdaptorIntf {
	/**
	 * @param xmledCmd
	 * @param sender
	 * @param rsces
	 * @return
	 */
	ResCmdIntf hdlCmd(String xmledCmd, CmdSenderIntf sender,
			ArrayList<ChnlRscIntf> rsces);

	/**
	 * @param cmd
	 * @param sender
	 * @param rsces
	 * @return ResCmdRegSesh
	 */
	ResCmdIntf hdlCmd(ReqCmdRegSesh cmd, CmdSenderIntf sender,
			ArrayList<ChnlRscIntf> rsces);

	/**
	 * @param cmd
	 * @param sender
	 * @param rsces
	 * @return ResCmdClsSesh
	 */
	ResCmdIntf hdlCmd(ReqCmdClsSesh cmd, CmdSenderIntf sender,
			ArrayList<ChnlRscIntf> rsces);

	/**
	 * @param cmd
	 * @param sender
	 * @param rsces
	 * @return ResCmdRegChnl
	 */
	ResCmdIntf hdlCmd(ReqCmdRegChnl cmd, CmdSenderIntf sender,
			ArrayList<ChnlRscIntf> rsces);

	/**
	 * @param cmd
	 * @param sender
	 * @param rsces
	 * @return ResCmdClsChnl
	 */
	ResCmdIntf hdlCmd(ReqCmdClsChnl cmd, CmdSenderIntf sender,
			ArrayList<ChnlRscIntf> rsces);

	/**
	 * @param cmd
	 * @param sender
	 * @param rsces
	 * @return ResCmdJoinSesh
	 */
	ResCmdIntf hdlCmd(ReqCmdJoinSesh cmd, CmdSenderIntf sender,
			ArrayList<ChnlRscIntf> rsces);

	/**
	 * @param cmd
	 * @param sender
	 * @param rsces
	 * @return ResCmdJoinChnl
	 */
	ResCmdIntf hdlCmd(ReqCmdJoinChnl cmd, CmdSenderIntf sender,
			ArrayList<ChnlRscIntf> rsces);

	/**
	 * @param cmd
	 * @param sender
	 * @param rsces
	 * @return ResCmdLvChnl
	 */
	ResCmdIntf hdlCmd(ReqCmdLvChnl cmd, CmdSenderIntf sender,
			ArrayList<ChnlRscIntf> rsces);

	/**
	 * @param cmd
	 * @param sender
	 * @param rsces
	 * @return ResCmdLvSesh
	 */
	ResCmdIntf hdlCmd(ReqCmdLvSesh cmd, CmdSenderIntf sender,
			ArrayList<ChnlRscIntf> rsces);

	/**
	 * @param cmd
	 * @param sender
	 * @param rsces
	 * @return ResCmdRjctChnl
	 */
	ResCmdIntf hdlCmd(ReqCmdRjctChnl cmd, CmdSenderIntf sender,
			ArrayList<ChnlRscIntf> rsces);

}
