/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr.impl;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdChnlAbst;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdAudDisconned;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdLvChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdLvSesh;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdRjctChnl;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdSeshDisconned;
import jp.happyhacking70.cum3.excp.impl.CumExcpComError;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotEixt;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcptNullRsces;
import jp.happyhacking70.cum3.presSvr.audLyr.Aud;
import jp.happyhacking70.cum3.presSvr.audLyr.AudIntf;
import jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr;
import jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPrestrIntf;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.AcptAudDisconnedIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.AcptSeshDisconnedIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshAudIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshIntfInternal;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshPrestrIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class SeshPresSvr implements SeshAudIntf, SeshPrestrIntf,
		AcptAudDisconnedIntf, SeshIntfInternal {
	protected String seshName;
	protected CmdSenderIntf sender;
	protected ConcurrentHashMap<String, ChnlPresSvr> chnls = new ConcurrentHashMap<String, ChnlPresSvr>();
	protected ConcurrentHashMap<String, AudIntf> auds = new ConcurrentHashMap<String, AudIntf>();
	protected AcptSeshDisconnedIntf seshDisconnedAcpter;

	public SeshPresSvr(String seshName, CmdSenderIntf sender,
			AcptSeshDisconnedIntf seshDisconnedAcpter) {
		super();
		this.seshName = seshName;
		this.sender = sender;
		this.seshDisconnedAcpter = seshDisconnedAcpter;
	}

	/**
	 * @return session name
	 */
	public String getSeshName() {
		return seshName;
	}

	/**
	 * @param audName
	 * @return audience
	 * @throws CumExcpAudNotExist
	 */
	protected AudIntf getAud(String audName) throws CumExcpAudNotExist {
		AudIntf aud = auds.get(audName);
		if (aud == null) {
			throw new CumExcpAudNotExist(seshName, new CumExcpAudNotExist("",
					audName));
		}
		return aud;
	}

	/**
	 * @param chnlName
	 * @return channel
	 * @throws CumExcpChnlNotEixt
	 */
	protected ChnlPresSvr getChnl(String chnlName) throws CumExcpChnlNotEixt {

		ChnlPresSvr chnl = chnls.get(chnlName);
		if (chnl == null) {
			throw new CumExcpChnlNotEixt(seshName, chnlName);
		}
		return chnl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshPrestrIntf#regChnl(java.lang
	 * .String, java.util.ArrayList)
	 */
	synchronized public void regChnl(String chnlName,
			ArrayList<ChnlRscIntf> chnlRsces) throws CumExcpChnlExists,
			CumExcpRscExists, CumExcptNullRsces, CumExcpRscNull {

		if (chnls.containsKey(chnlName) == true) {
			throw new CumExcpChnlExists(seshName, chnlName);
		}

		// Create new channel
		ChnlPresSvr newChnl = null;
		try {
			newChnl = new ChnlPresSvr(seshName, chnlName, chnlRsces);
		} catch (CumExcpRscExists e) {
			throw new CumExcpRscExists(seshName, e);
		} catch (CumExcptNullRsces e) {
			throw new CumExcptNullRsces(seshName, e);
		} catch (CumExcpRscNull e) {
			throw new CumExcpRscNull(seshName, e);
		}
		chnls.put(chnlName, newChnl);

		NtfyCmdRegChnl cmd = new NtfyCmdRegChnl(seshName, chnlName);
		for (ChnlRscIntf rsc : chnlRsces) {
			cmd.addRscData(rsc);
		}

		// Send NtfyCmdRegChnl to session audiences
		for (AudIntf aud : auds.values()) {
			aud.sendCmd(cmd);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshPrestrIntf#sendChnlCmd(jp.
	 * happyhacking70.cum3.cmd.CmdChnlAbst, java.lang.String)
	 */
	synchronized public void sendChnlCmd(CmdChnlAbst cmd, String audName)
			throws CumExcpChnlNotEixt, CumExcpAudNotExist {

		String chnlName = cmd.getChnlName();

		ChnlPresSvr chnl;
		chnl = getChnl(chnlName);

		// send command to specific audience
		try {
			// chnl.sendChnlCmd(cmd, getAud(audName));
			chnl.sendChnlCmd(cmd, audName);
		} catch (CumExcpAudNotExist e) {
			throw new CumExcpAudNotExist(seshName, e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshPrestrIntf#sendChnlCmd(jp.
	 * happyhacking70.cum3.cmd.CmdChnlAbst)
	 */
	synchronized public void sendChnlCmd(CmdChnlAbst cmd)
			throws CumExcpChnlNotEixt, CumExcpAudNotExist {

		String chnlName = cmd.getChnlName();
		ChnlPresSvr chnl;

		chnl = getChnl(chnlName);

		// send command to all channel audiences
		// delegate to channel
		try {
			chnl.sendChnlCmd(cmd);
		} catch (CumExcpAudNotExist e) {
			throw new CumExcpAudNotExist(seshName, e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshPrestrIntf#clsChnl(java.lang
	 * .String)
	 */
	synchronized public void clsChnl(String chnlName) throws CumExcpChnlNotEixt {
		ChnlPresSvr chnl;

		chnl = getChnl(chnlName);

		// send NtfyCmdClsChnl to all session audiences
		// delegate to channel

		NtfyCmdClsChnl cmd = chnl.getNtfyCmdClsChnl();
		for (AudIntf aud : auds.values()) {
			aud.sendCmd(cmd);
		}

		// close channel
		chnls.remove(chnlName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshAudIntf#joinSesh(java.lang
	 * .String, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf)
	 */
	synchronized public void joinSesh(String audName, CmdSenderIntf sender,
			AcptAudDisconnedIntf hdlr) throws CumExcpAudExists {
		if (auds.containsKey(audName) == true) {
			throw new CumExcpAudExists(seshName, new CumExcpAudExists("",
					audName));
		}

		AudIntf aud = new Aud(audName, sender, this);
		// add audience to session
		auds.put(audName, aud);

		// send NtfyCmdJoinSesh to presenter
		try {
			this.sender.sendCmd(new NtfyCmdJoinSesh(seshName, audName));
			// send NtfyCmdRegChnl to audience for all existing channels
			for (ChnlPrestrIntf chnl : chnls.values()) {
				aud.sendCmd(chnl.getNtfyCmdRegChnl());
			}
		} catch (CumExcpComError e) {
			seshDisconnedAcpter.acceptSeshDisconned(seshName);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshAudIntf#joinChnl(java.lang
	 * .String, java.lang.String)
	 */
	synchronized public void joinChnl(String chnlName, String audName)
			throws CumExcpChnlNotEixt, CumExcpAudExists, CumExcpAudNotExist {
		ChnlPresSvr chnl;
		chnl = getChnl(chnlName);
		AudIntf aud;
		try {
			aud = getAud(audName);
		} catch (CumExcpAudNotExist e) {
			throw new CumExcpAudNotExist(seshName, chnlName, audName);
		}

		// add audience to channel
		NtfyCmdJoinChnl cmd;
		try {
			cmd = chnl.joinChnl(aud);
		} catch (CumExcpAudExists e) {
			throw new CumExcpAudExists(seshName, e);
		}

		// send NtfyCmdJoinChnl to presenter
		try {
			sender.sendCmd(cmd);
		} catch (CumExcpComError e) {
			seshDisconnedAcpter.acceptSeshDisconned(seshName);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshAudIntf#lvChnl(java.lang.String
	 * , java.lang.String, java.lang.String)
	 */
	synchronized public void lvChnl(String chnlName, String audName)
			throws CumExcpChnlNotEixt, CumExcpAudNotExist {
		ChnlPresSvr chnl = getChnl(chnlName);
		AudIntf aud = null;
		try {
			aud = getAud(audName);
		} catch (CumExcpAudNotExist e) {
			throw new CumExcpAudNotExist(seshName, chnlName, audName);
		}

		// remove audience from channel
		NtfyCmdLvChnl cmd = chnl.lvChnl(aud);

		// send NtfyCmdLvChnl to presenter
		try {
			sender.sendCmd(cmd);
		} catch (CumExcpComError e) {
			seshDisconnedAcpter.acceptSeshDisconned(seshName);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshAudIntf#getRsc(java.lang.String
	 * , java.lang.String)
	 */
	synchronized public ChnlRscIntf getRsc(String chnlName, String rscName)
			throws CumExcpChnlNotEixt, CumExcpRscNotExist {
		ChnlPresSvr chnl;
		try {
			chnl = getChnl(chnlName);
		} catch (CumExcpChnlNotEixt e) {
			throw new CumExcpChnlNotEixt(seshName, chnlName);
		}
		ChnlRscIntf rsc = null;
		try {
			rsc = chnl.getRsc(rscName);
		} catch (CumExcpRscNotExist e) {
			throw new CumExcpRscNotExist(seshName, e);
		}
		return rsc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshAudIntf#lvSesh(java.lang.String
	 * )
	 */
	synchronized public void lvSesh(String audName) throws CumExcpAudNotExist {

		AudIntf aud = null;
		try {
			aud = getAud(audName);
		} catch (CumExcpAudNotExist e) {
			throw new CumExcpAudNotExist(seshName, "", audName);
		}

		// remove audience from session
		auds.remove(audName);

		for (ChnlPresSvr chnl : chnls.values()) {

			try {
				// remove audience from all channels
				// no need to send NtfyCmdLvChnl to presenter because presenter
				// takes care of it
				chnl.lvChnl(aud);
			} catch (CumExcpAudNotExist e) {
				// Just fine. Audience may have rejected some channel
			}
		}
		// send NtfyCmdLvSesh to presenter
		NtfyCmdLvSesh cmd = new NtfyCmdLvSesh(seshName, audName);
		try {
			sender.sendCmd(cmd);
		} catch (CumExcpComError e) {
			seshDisconnedAcpter.acceptSeshDisconned(seshName);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.presSvr.seshLyr.SeshPrestrIntf#clsSesh()
	 */
	synchronized public void clsSesh() {
		NtfyCmdClsSesh cmd = new NtfyCmdClsSesh(seshName);

		// send NtfyCmdClsSesh to all session audiences
		for (AudIntf aud : auds.values()) {
			aud.sendCmd(cmd);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshAudIntf#rjctChnl(java.lang
	 * .String)
	 */
	public void rjctChnl(String chnlName, String audName)
			throws CumExcpChnlNotEixt, CumExcpAudExists {
		ChnlPresSvr chnl = getChnl(chnlName);
		try {
			chnl.rjctChnl(audName);
		} catch (CumExcpAudExists e) {
			throw new CumExcpAudExists(seshName, e);
		}

		NtfyCmdRjctChnl cmd = new NtfyCmdRjctChnl(audName, chnlName, audName);
		try {
			sender.sendCmd(cmd);
		} catch (CumExcpComError e) {
			seshDisconnedAcpter.acceptSeshDisconned(seshName);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshIntfInternal#ntfySeshDisconned
	 * ()
	 */
	public void ntfySeshDisconned() {
		NtfyCmdSeshDisconned cmd = new NtfyCmdSeshDisconned(seshName);
		for (AudIntf aud : auds.values()) {
			aud.sendCmd(cmd);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshIntfInternal#ntfyAudDisconned
	 * (java.lang.String)
	 */
	public void ntfyAudDisconned(String audName) {
		NtfyCmdAudDisconned cmd = new NtfyCmdAudDisconned(audName);
		try {
			sender.sendCmd(cmd);
		} catch (CumExcpComError e) {
			seshDisconnedAcpter.acceptSeshDisconned(seshName);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.presSvr.seshLyr.AcptAudDisconnedIntf#
	 * acceptAudDisconned(java.lang.String)
	 */
	public void acceptAudDisconned(String audName) {
		Thread hdlrThread = new Thread(new AudDisconnedHdlr(audName, this,
				seshDisconnedAcpter));

		hdlrThread.start();

	}

}