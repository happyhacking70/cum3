/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdChnlAbst;
import jp.happyhacking70.cum3.cmd.impl.NtfyCmdRegChnl;
import jp.happyhacking70.cum3.excp.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.CumExcpChnlExists;
import jp.happyhacking70.cum3.excp.CumExcpChnlNotEixt;
import jp.happyhacking70.cum3.excp.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.CumExcpRscNotExist;
import jp.happyhacking70.cum3.excp.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.CumExcptNullRsces;
import jp.happyhacking70.cum3.presSvr.audLyr.Aud;
import jp.happyhacking70.cum3.presSvr.audLyr.AudIntf;
import jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPresSvr;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class SeshPresSvr implements SeshAudIntf, SeshPrestrIntf {
	protected String seshName;
	protected CmdSenderIntf sender;

	protected ConcurrentHashMap<String, ChnlPresSvr> chnls = new ConcurrentHashMap<String, ChnlPresSvr>();
	protected ConcurrentHashMap<String, AudIntf> auds = new ConcurrentHashMap<String, AudIntf>();

	public SeshPresSvr(String seshName, CmdSenderIntf sender) {
		super();
		this.seshName = seshName;
		this.sender = sender;
	}

	/**
	 * @return
	 */
	public String getSeshName() {
		return seshName;
	}

	/**
	 * @param audName
	 * @return
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
	 * @return
	 * @throws CumExcpChnlNotEixt
	 */
	protected ChnlPresSvr getChnl(String chnlName) throws CumExcpChnlNotEixt {
		ChnlPresSvr chnl = chnls.get(chnlName);
		if (chnl == null) {
			throw new CumExcpChnlNotEixt(seshName, new CumExcpChnlNotEixt(
					chnlName));
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
			CumExcpRscExists, CumExcptNullRsces, CumExcpRscNull,
			CumExcpChnlNotEixt, CumExcpAudNotExist {

		if (chnls.containsKey(chnlName) == true) {
			throw new CumExcpChnlExists(chnlName);
		}

		ChnlPresSvr newChnl = new ChnlPresSvr(seshName, chnlName, chnlRsces);
		chnls.put(chnlName, newChnl);

		// notify new registration of channel to all session audiences
		for (AudIntf aud : auds.values()) {
			aud.sendCmd(new NtfyCmdRegChnl(chnlName, chnlName, chnlRsces));
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
		ChnlPresSvr chnl = getChnl(chnlName);
		chnl.sendChnlCmd(cmd, getAud(audName));

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
		ChnlPresSvr chnl = getChnl(chnlName);
		chnl.sendChnlCmd(cmd);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshPrestrIntf#clsChnl(java.lang
	 * .String)
	 */
	synchronized public void clsChnl(String chnlName) throws CumExcpChnlNotEixt {
		ChnlPresSvr chnl = getChnl(chnlName);

		// channel will send notification to all audiences. Session does not
		// have to send it
		chnl.clsChnl();

		chnls.remove(chnlName);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshAudIntf#joinSesh(java.lang
	 * .String, jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf)
	 */
	synchronized public void joinSesh(String audName, CmdSenderIntf sender)
			throws CumExcpAudExists {
		if (auds.containsKey(audName) == true) {
			throw new CumExcpAudExists(seshName, new CumExcpAudExists("",
					audName));
		}

		AudIntf aud = new Aud(audName, sender);
		auds.put(audName, aud);

		for (ChnlPresSvr chnl : chnls.values()) {
			aud.sendCmd(chnl.getNtfyRegChnlCmd());
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
			throws CumExcpChnlNotEixt, CumExcpAudNotExist, CumExcpAudExists {
		ChnlPresSvr chnl = getChnl(chnlName);
		AudIntf aud = getAud(audName);

		sender.sendCmd(chnl.joinChnl(aud));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshAudIntf#lvChnl(java.lang.String
	 * , java.lang.String, java.lang.String)
	 */
	synchronized public void lvChnl(String seshName, String chnlName,
			String audName) throws CumExcpChnlNotEixt, CumExcpAudNotExist {
		ChnlPresSvr chnl = getChnl(chnlName);
		AudIntf aud = getAud(audName);

		sender.sendCmd(chnl.lvChnl(aud));

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
		ChnlPresSvr chnl = getChnl(chnlName);
		return chnl.getRsc(rscName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.seshLyr.SeshAudIntf#lvSesh(java.lang.String
	 * )
	 */
	synchronized public void lvSesh(String audName) throws CumExcpAudNotExist {
		AudIntf aud = getAud(audName);

		for (ChnlPresSvr chnl : chnls.values()) {
			sender.sendCmd(chnl.lvChnl(aud));
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.presSvr.seshLyr.SeshPrestrIntf#clsSesh()
	 */
	public void clsSesh() {
		// TODO

	}

}
