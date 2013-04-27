/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr.impl;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdChnlAbst;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpSeshNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcptNullRsces;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderAbst;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAudIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrPrestrIntf;

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
public class SeshMgrPresSvr implements SeshMgrPresSvrAudIntf,
		SeshMgrPresSvrPrestrIntf, SeshMgrPresSvrAllIntf {
	protected ConcurrentHashMap<String, SeshPresSvr> seshes = new ConcurrentHashMap<String, SeshPresSvr>();

	/**
	 * @param seshName
	 * @return session
	 * @throws CumExcpSeshNotExist
	 */
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
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrPrestrIntf#regSesh
	 * (java.lang.String, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderAbst)
	 */
	@Override
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
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrPrestrIntf#regChnl
	 * (java.lang.String, java.lang.String, java.util.ArrayList)
	 */
	@Override
	public void regChnl(String seshName, String chnlName,
			ArrayList<ChnlRscIntf> chnlRsces) throws CumExcpSeshNotExist,
			CumExcpRscExists, CumExcpChnlExists, CumExcptNullRsces,
			CumExcpRscNull {

		SeshPresSvr sesh = getSesh(seshName);
		sesh.regChnl(chnlName, chnlRsces);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrPrestrIntf#clsSesh
	 * (java.lang.String)
	 */
	@Override
	public void clsSesh(String seshName) throws CumExcpSeshNotExist {
		SeshPresSvr sesh = getSesh(seshName);
		sesh.clsSesh();
		seshes.remove(seshName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrPrestrIntf#sendChnlCmd
	 * (jp.happyhacking70.cum3.cmd.CmdChnlAbst, java.lang.String)
	 */
	@Override
	public void sendChnlCmd(CmdChnlAbst cmd, String audName)
			throws CumExcpSeshNotExist, CumExcpChnlNotExist, CumExcpAudNotExist {
		SeshPresSvr sesh = getSesh(cmd.getSeshName());
		sesh.sendChnlCmd(cmd, audName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrPrestrIntf#sendChnlCmd
	 * (jp.happyhacking70.cum3.cmd.CmdChnlAbst)
	 */
	@Override
	public void sendChnlCmd(CmdChnlAbst cmd) throws CumExcpSeshNotExist,
			CumExcpChnlNotExist, CumExcpAudNotExist {
		SeshPresSvr sesh = getSesh(cmd.getSeshName());
		sesh.sendChnlCmd(cmd);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrPrestrIntf#clsChnl
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	public void clsChnl(String seshName, String chnlName)
			throws CumExcpSeshNotExist, CumExcpChnlNotExist {

		SeshPresSvr sesh = getSesh(seshName);
		sesh.clsChnl(chnlName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAudIntf#joinSesh
	 * (java.lang.String, java.lang.String,
	 * jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderAbst)
	 */
	@Override
	public void joinSesh(String seshName, String audName, CmdSenderAbst sender)
			throws CumExcpSeshNotExist, CumExcpAudExists {
		SeshPresSvr sesh = getSesh(seshName);
		// sesh.joinSesh(audName, sender, haudDisconnedAcpter);
		sesh.joinSesh(audName, sender);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAudIntf#joinChnl
	 * (java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void joinChnl(String seshName, String chnlName, String audName)
			throws CumExcpSeshNotExist, CumExcpChnlNotExist, CumExcpAudExists,
			CumExcpAudNotExist {
		SeshPresSvr sesh = getSesh(seshName);
		sesh.joinChnl(chnlName, audName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAudIntf#rjctChnl
	 * (java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void rjctChnl(String seshName, String chnlName, String audName)
			throws CumExcpSeshNotExist, CumExcpChnlNotExist, CumExcpAudExists {
		SeshPresSvr sesh = getSesh(seshName);
		sesh.rjctChnl(chnlName, audName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAudIntf#lvChnl(java
	 * .lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void lvChnl(String seshName, String chnlName, String audName)
			throws CumExcpSeshNotExist, CumExcpChnlNotExist, CumExcpAudNotExist {
		SeshPresSvr sesh = getSesh(seshName);
		sesh.lvChnl(chnlName, audName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAudIntf#lvSesh(java
	 * .lang.String, java.lang.String)
	 */
	@Override
	public void lvSesh(String seshName, String audName)
			throws CumExcpSeshNotExist, CumExcpAudNotExist {
		SeshPresSvr sesh = getSesh(seshName);
		sesh.lvSesh(audName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAudIntf#getRsc(java
	 * .lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ChnlRscIntf getRsc(String seshName, String chnlName, String rscName)
			throws CumExcpSeshNotExist, CumExcpChnlNotExist, CumExcpRscNotExist {
		SeshPresSvr sesh = getSesh(seshName);
		ChnlRscIntf rsc = sesh.getRsc(chnlName, rscName);
		return rsc;
	}

}
