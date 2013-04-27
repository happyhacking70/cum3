/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr.impl;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdChnlAbst;
import jp.happyhacking70.cum3.cmd.XMLableCmdIntf;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdClsChnl;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdClsSesh;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdJoinChnl;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdJoinSesh;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdLvChnl;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdLvSesh;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.cmd.impl.ntfy.NtfyCmdRjctChnl;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpChnlNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNotExist;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.impl.seshChnlAudLyr.CumExcptNullRsces;
import jp.happyhacking70.cum3.presSvr.audLyr.Aud;
import jp.happyhacking70.cum3.presSvr.audLyr.AudIntf;
import jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr;
import jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvrPrestrIntf;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvrAudIntf;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvrPrestrIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class SeshPresSvr implements SeshPresSvrAudIntf, SeshPresSvrPrestrIntf {
	protected String seshName;
	protected CmdSenderIntf sender;
	protected ConcurrentHashMap<String, ChnlPresSvr> chnls = new ConcurrentHashMap<String, ChnlPresSvr>();
	protected ConcurrentHashMap<String, AudIntf> auds = new ConcurrentHashMap<String, AudIntf>();

	/**
	 * @param seshName
	 * @param sender
	 */
	public SeshPresSvr(String seshName, CmdSenderIntf sender) {
		super();
		this.seshName = seshName;
		this.sender = sender;
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
	 * @throws CumExcpChnlNotExist
	 */
	protected ChnlPresSvr getChnl(String chnlName) throws CumExcpChnlNotExist {

		ChnlPresSvr chnl = chnls.get(chnlName);
		if (chnl == null) {
			throw new CumExcpChnlNotExist(seshName, chnlName);
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
	@Override
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
	@Override
	synchronized public void sendChnlCmd(CmdChnlAbst cmd, String audName)
			throws CumExcpChnlNotExist, CumExcpAudNotExist {

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
	@Override
	synchronized public void sendChnlCmd(CmdChnlAbst cmd)
			throws CumExcpChnlNotExist, CumExcpAudNotExist {

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
	@Override
	synchronized public void clsChnl(String chnlName)
			throws CumExcpChnlNotExist {
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
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshPresSvrAudIntf#joinSesh(java
	 * .lang.String, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderAbst)
	 */
	@Override
	synchronized public void joinSesh(String audName, CmdSenderIntf sender)
			throws CumExcpAudExists {

		if (auds.containsKey(audName) == true) {
			throw new CumExcpAudExists(seshName, new CumExcpAudExists("",
					audName));
		}

		AudIntf aud = new Aud(audName, sender);
		// add audience to session
		auds.put(audName, aud);

		// send NtfyCmdJoinSesh to presenter
		sendCmdToPrestr(new NtfyCmdJoinSesh(seshName, audName));
		// send NtfyCmdRegChnl to audience for all existing channels
		for (ChnlPresSvrPrestrIntf chnl : chnls.values()) {
			aud.sendCmd(chnl.getNtfyCmdRegChnl());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshAudIntf#joinChnl(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	synchronized public void joinChnl(String chnlName, String audName)
			throws CumExcpChnlNotExist, CumExcpAudExists, CumExcpAudNotExist {
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
		sendCmdToPrestr(cmd);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshAudIntf#lvChnl(java.lang.String
	 * , java.lang.String, java.lang.String)
	 */
	@Override
	synchronized public void lvChnl(String chnlName, String audName)
			throws CumExcpChnlNotExist, CumExcpAudNotExist {
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
		sendCmdToPrestr(cmd);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshAudIntf#getRsc(java.lang.String
	 * , java.lang.String)
	 */
	@Override
	synchronized public ChnlRscIntf getRsc(String chnlName, String rscName)
			throws CumExcpChnlNotExist, CumExcpRscNotExist {
		ChnlPresSvr chnl;
		try {
			chnl = getChnl(chnlName);
		} catch (CumExcpChnlNotExist e) {
			throw new CumExcpChnlNotExist(seshName, chnlName);
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
	@Override
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

		sendCmdToPrestr(cmd);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.presSvr.seshLyr.SeshPrestrIntf#clsSesh()
	 */
	@Override
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
	@Override
	public void rjctChnl(String chnlName, String audName)
			throws CumExcpChnlNotExist, CumExcpAudExists {
		ChnlPresSvr chnl = getChnl(chnlName);
		try {
			chnl.rjctChnl(audName);
		} catch (CumExcpAudExists e) {
			throw new CumExcpAudExists(seshName, e);
		}

		NtfyCmdRjctChnl cmd = new NtfyCmdRjctChnl(seshName, chnlName, audName);

		sendCmdToPrestr(cmd);
	}

	/**
	 * @param cmd
	 */
	private void sendCmdToPrestr(XMLableCmdIntf cmd) {
		sender.sendCmd(cmd);

	}

}
