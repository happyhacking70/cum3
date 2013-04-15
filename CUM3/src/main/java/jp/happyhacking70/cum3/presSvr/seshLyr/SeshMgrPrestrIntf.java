/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.excp.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.CumExcpSeshExists;
import jp.happyhacking70.cum3.excp.CumExcpSeshNotExist;
import jp.happyhacking70.cum3.excp.CumExcptNullRsces;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface SeshMgrPrestrIntf {
	public void regSesh(String seshName) throws CumExcpSeshExists;

	public void regChnl(String seshName, String chnlName,
			ArrayList<ChnlRscIntf> chnlRsces) throws CumExcpSeshNotExist,
			CumExcpChnlExists, CumExcpRscExists, CumExcptNullRsces,
			CumExcpRscNull;

	public void clsSesh(String seshName) throws CumExcpSeshNotExist;

	public void sendChnlCmd(CmdAbst cmd, String audName);

	public void sendChnlCmd(CmdAbst cmd);

	public void clsChnl(String seshName, String chnlName);

}
