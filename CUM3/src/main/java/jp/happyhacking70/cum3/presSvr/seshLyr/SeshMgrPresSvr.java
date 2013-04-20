/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdChnlAbst;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotEixt;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcptNullRsces;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;

/**
 * <UL>
 * <LI><B>SeshMgrPresSvr maintains all sessions on presentation server</B></LI>
 * <LI><B>All the detailed management is delegated to SeshPresSvr</B></LI>
 * </UL>
 * 
 * @see SeshPresSvr
 * 
 * @author happyhacking70@gmail.com
 * 
 */
public class SeshMgrPresSvr implements SeshMgrAudIntf, SeshMgrPrestrIntf {
	protected ConcurrentHashMap<String, SeshPresSvr> seshes = new ConcurrentHashMap<String, SeshPresSvr>();

	protected SeshPresSvr getSesh(String seshName) throws CumExcpSeshNotExist {
		SeshPresSvr sesh = seshes.get(seshName);
		if (sesh == null) {
			throw new CumExcpSeshNotExist(seshName);
		}
		return sesh;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPrestrIntf#regSesh(java
	 * .lang.String, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf)
	 */
	public void regSesh(String seshName, CmdSenderIntf sender)
			throws CumExcpSeshExists {

		if (seshes.containsKey(seshName) == true) {
			throw new CumExcpSeshExists(seshName);
		}

		SeshPresSvr sesh = new SeshPresSvr(seshName, sender);

		seshes.put(seshName, sesh);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPrestrIntf#regChnl(java
	 * .lang.String, java.lang.String, java.util.ArrayList)
	 */
	public void regChnl(String seshName, String chnlName,
			ArrayList<ChnlRscIntf> chnlRsces) throws CumExcpSeshNotExist,
			CumExcpChnlExists, CumExcpRscExists, CumExcptNullRsces,
			CumExcpRscNull {

		SeshPresSvr sesh = getSesh(seshName);
		sesh.regChnl(chnlName, chnlRsces);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPrestrIntf#clsSesh(java
	 * .lang.String)
	 */
	public void clsSesh(String seshName) throws CumExcpSeshNotExist {
		SeshPresSvr sesh = getSesh(seshName);
		sesh.clsSesh();
		seshes.remove(seshName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPrestrIntf#sendChnlCmd(
	 * jp.happyhacking70.cum3.cmd.CmdAbst, java.lang.String)
	 */
	public void sendChnlCmd(CmdChnlAbst cmd, String audName)
			throws CumExcpSeshNotExist, CumExcpChnlNotEixt, CumExcpAudNotExist {
		SeshPresSvr sesh = getSesh(cmd.getSeshName());
		sesh.sendChnlCmd(cmd, audName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPrestrIntf#sendChnlCmd(
	 * jp.happyhacking70.cum3.cmd.CmdAbst)
	 */
	public void sendChnlCmd(CmdChnlAbst cmd) throws CumExcpSeshNotExist,
			CumExcpChnlNotEixt, CumExcpAudNotExist {
		SeshPresSvr sesh = getSesh(cmd.getSeshName());
		sesh.sendChnlCmd(cmd);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPrestrIntf#clsChnl(java
	 * .lang.String, java.lang.String)
	 */
	public void clsChnl(String seshName, String chnlName)
			throws CumExcpSeshNotExist, CumExcpChnlNotEixt {

		SeshPresSvr sesh = getSesh(seshName);
		sesh.clsChnl(chnlName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrAudIntf#joinSesh(java.lang
	 * .String, java.lang.String)
	 */
	public void joinSesh(String seshName, String audName, CmdSenderIntf sender)
			throws CumExcpSeshNotExist, CumExcpAudExists {
		SeshPresSvr sesh = getSesh(seshName);
		sesh.joinSesh(audName, sender);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrAudIntf#joinChnl(java.lang
	 * .String, java.lang.String, java.lang.String)
	 */
	public void joinChnl(String seshName, String chnlName, String audName)
			throws CumExcpSeshNotExist, CumExcpChnlNotEixt, CumExcpAudExists,
			CumExcpAudNotExist {
		SeshPresSvr sesh = getSesh(seshName);
		sesh.joinChnl(chnlName, audName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrAudIntf#rjctChnl(java.lang
	 * .String, java.lang.String, java.lang.String)
	 */
	public void rjctChnl(String seshName, String chnlName, String audName)
			throws CumExcpSeshNotExist, CumExcpChnlNotEixt, CumExcpAudExists {
		SeshPresSvr sesh = getSesh(seshName);
		sesh.rjctChnl(chnlName, audName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrAudIntf#lvChnl(java.lang
	 * .String, java.lang.String, java.lang.String)
	 */
	public void lvChnl(String seshName, String chnlName, String audName)
			throws CumExcpSeshNotExist, CumExcpChnlNotEixt, CumExcpAudNotExist {
		SeshPresSvr sesh = getSesh(seshName);
		sesh.lvChnl(chnlName, audName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrAudIntf#lvSesh(java.lang
	 * .String, java.lang.String)
	 */
	public void lvSesh(String seshName, String audName)
			throws CumExcpSeshNotExist, CumExcpAudNotExist {
		SeshPresSvr sesh = getSesh(seshName);
		sesh.lvSesh(audName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrAudIntf#getRsc(java.lang
	 * .String, java.lang.String, java.lang.String)
	 */
	public ChnlRscIntf getRsc(String seshName, String chnlName, String rscName)
			throws CumExcpSeshNotExist, CumExcpChnlNotEixt, CumExcpRscNotExist {
		SeshPresSvr sesh = getSesh(seshName);
		ChnlRscIntf rsc = sesh.getRsc(chnlName, rscName);
		return rsc;
	}

}
