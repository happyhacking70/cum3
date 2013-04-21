/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.chnlLyr;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdChnlAbst;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdLvChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcptNullRsces;
import jp.happyhacking70.cum3.presSvr.audLyr.AudIntf;

/**
 * Channel in Presentation Server<BR>
 * Maintains:
 * <UL>
 * <LI>name of session which this channel belongs to</LI>
 * <LI>name of this channel</LI>
 * <LI>channel resources</LI>
 * <LI>audiences</LI>
 * </UL>
 * 
 * @author happyhacking70@gmail.com
 * 
 */
public class ChnlPresSvr implements ChnlAudIntf, ChnlPrestrIntf {
	protected String seshName;
	protected String chnlName;
	protected ConcurrentHashMap<String, ChnlRscIntf> rsces = new ConcurrentHashMap<String, ChnlRscIntf>();
	protected ConcurrentHashMap<String, AudIntf> auds = new ConcurrentHashMap<String, AudIntf>();

	/**
	 * @param seshName
	 * @param chnlName
	 * @param rsces
	 * @throws CumExcpRscExists
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscNull
	 */
	public ChnlPresSvr(String seshName, String chnlName,
			ArrayList<ChnlRscIntf> rsces) throws CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull {
		super();
		this.seshName = seshName;
		this.chnlName = chnlName;
		addRsces(rsces);
	}

	/**
	 * add resources
	 * 
	 * @param rsces
	 * @throws CumExcpRscExists
	 * @throws CumExcptNullRsces
	 * @throws CumExcpRscNull
	 */
	protected void addRsces(ArrayList<ChnlRscIntf> rsces)
			throws CumExcpRscExists, CumExcptNullRsces, CumExcpRscNull {

		if (rsces == null) {
			throw new CumExcptNullRsces(chnlName);
		}
		for (ChnlRscIntf rsc : rsces) {
			addRsc(rsc);
		}
	}

	/**
	 * add resource
	 * 
	 * @param rsc
	 * @throws CumExcpRscExists
	 * @throws CumExcpRscNull
	 */
	protected void addRsc(ChnlRscIntf rsc) throws CumExcpRscExists,
			CumExcpRscNull {
		if (rsc == null) {
			throw new CumExcpRscNull(chnlName);
		}
		if (rsces.containsKey(rsc.getName())) {
			throw new CumExcpRscExists(chnlName, rsc.getName());
		}

		rsces.put(rsc.getName(), rsc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPrestrIntf#sendChnlCmd(jp.
	 * happyhacking70.cum3.cmd.CmdChnlAbst,
	 * jp.happyhacking70.cum3.presSvr.audLyr.AudIntf)
	 */
	// synchronized public void sendChnlCmd(CmdChnlAbst cmd, AudIntf aud)
	synchronized public void sendChnlCmd(CmdChnlAbst cmd, String audName)
			throws CumExcpAudNotExist {

		if (auds.containsKey(audName) == false) {
			throw new CumExcpAudNotExist(chnlName, audName);
		}
		AudIntf aud = auds.get(audName);
		aud.sendCmd(cmd);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPrestrIntf#sendChnlCmd(jp.
	 * happyhacking70.cum3.cmd.CmdChnlAbst)
	 */
	synchronized public void sendChnlCmd(CmdChnlAbst cmd)
			throws CumExcpAudNotExist {
		for (AudIntf aud : auds.values()) {
			sendChnlCmd(cmd, aud.getAudName());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlAudIntf#getRsc(java.lang.String
	 * )
	 */
	synchronized public ChnlRscIntf getRsc(String rscName)
			throws CumExcpRscNotExist {
		ChnlRscIntf rsc = rsces.get(rscName);

		if (rsc == null) {
			throw new CumExcpRscNotExist(chnlName, rscName);
		}

		return rsc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlAudIntf#joinChnl(jp.happyhacking70
	 * .cum3.presSvr.audLyr.AudIntf)
	 */
	synchronized public NtfyCmdJoinChnl joinChnl(AudIntf aud)
			throws CumExcpAudExists {
		if (auds.containsKey(aud.getAudName())) {
			throw new CumExcpAudExists(chnlName, aud.getAudName());
		}

		auds.put(aud.getAudName(), aud);

		return new NtfyCmdJoinChnl(seshName, chnlName, aud.getAudName());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlAudIntf#lvChnl(jp.happyhacking70
	 * .cum3.presSvr.audLyr.AudIntf)
	 */
	synchronized public NtfyCmdLvChnl lvChnl(AudIntf aud)
			throws CumExcpAudNotExist {
		if (auds.containsKey(aud.getAudName()) == false) {
			throw new CumExcpAudNotExist(chnlName, aud.getAudName());
		}

		auds.remove(aud.getAudName());
		return new NtfyCmdLvChnl(seshName, chnlName, aud.getAudName());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPrestrIntf#getNtfyRegChnlCmd()
	 */
	public NtfyCmdRegChnl getNtfyCmdRegChnl() {
		NtfyCmdRegChnl cmd = new NtfyCmdRegChnl(seshName, chnlName);
		for (ChnlRscIntf rsc : rsces.values()) {
			cmd.addRscData(rsc);
		}
		return cmd;
	}

	/**
	 * @param audName
	 * @throws CumExcpAudExists
	 */
	public void rjctChnl(String audName) throws CumExcpAudExists {
		if (auds.containsKey(audName) == true) {
			throw new CumExcpAudExists(chnlName, audName);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPrestrIntf#getNtfyCmdClsChnl()
	 */
	public NtfyCmdClsChnl getNtfyCmdClsChnl() {
		return new NtfyCmdClsChnl(seshName, chnlName);
	}
}
