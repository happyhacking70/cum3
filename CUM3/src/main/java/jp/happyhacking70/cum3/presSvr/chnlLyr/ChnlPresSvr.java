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
import jp.happyhacking70.cum3.excp.CumExcpAudExists;
import jp.happyhacking70.cum3.excp.CumExcpAudNotExist;
import jp.happyhacking70.cum3.excp.CumExcpRscExists;
import jp.happyhacking70.cum3.excp.CumExcpRscNotExist;
import jp.happyhacking70.cum3.excp.CumExcpRscNull;
import jp.happyhacking70.cum3.excp.CumExcptNullRsces;
import jp.happyhacking70.cum3.presSvr.audLyr.AudIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ChnlPresSvr implements ChnlAudIntf, ChnlPrestrIntf {
	protected String seshName;
	protected String chnlName;
	protected ConcurrentHashMap<String, ChnlRscIntf> rsces = new ConcurrentHashMap<String, ChnlRscIntf>();
	protected ConcurrentHashMap<String, AudIntf> auds = new ConcurrentHashMap<String, AudIntf>();

	public ChnlPresSvr(String seshName, String chnlName,
			ArrayList<ChnlRscIntf> rsces) throws CumExcpRscExists,
			CumExcptNullRsces, CumExcpRscNull {
		super();
		this.seshName = seshName;
		this.chnlName = chnlName;
		addRsces(rsces);
	}

	protected void addRsces(ArrayList<ChnlRscIntf> rsces)
			throws CumExcpRscExists, CumExcptNullRsces, CumExcpRscNull {

		if (rsces == null) {
			throw new CumExcptNullRsces(chnlName);
		}
		for (ChnlRscIntf rsc : rsces) {
			addRsc(rsc);
		}
	}

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

	synchronized public void sendChnlCmd(CmdChnlAbst cmd, AudIntf aud)
			throws CumExcpAudNotExist {

		if (auds.containsKey(aud.getAudName()) == false) {
			throw new CumExcpAudNotExist(chnlName, aud.getAudName());
		}
		aud.sendCmd(cmd);
	}

	synchronized public void sendChnlCmd(CmdChnlAbst cmd)
			throws CumExcpAudNotExist {
		for (AudIntf aud : auds.values()) {
			sendChnlCmd(cmd, aud);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.presSvr.chnlLyr.ChnlPrestrIntf#clsChnl()
	 */
	synchronized public void clsChnl() {
		for (AudIntf aud : auds.values()) {
			NtfyCmdClsChnl cmd = new NtfyCmdClsChnl(seshName, chnlName);
			aud.sendCmd(cmd);
		}
	}

	synchronized public ChnlRscIntf getRsc(String rscName)
			throws CumExcpRscNotExist {
		ChnlRscIntf rsc = rsces.get(rscName);

		if (rsc == null) {
			throw new CumExcpRscNotExist(rscName);
		}

		return rsc;
	}

	synchronized public NtfyCmdJoinChnl joinChnl(AudIntf aud)
			throws CumExcpAudExists {
		if (auds.containsKey(aud.getAudName())) {
			throw new CumExcpAudExists(chnlName, aud.getAudName());
		}

		auds.put(aud.getAudName(), aud);

		return new NtfyCmdJoinChnl(seshName, chnlName, aud.getAudName());

	}

	synchronized public NtfyCmdLvChnl lvChnl(AudIntf aud)
			throws CumExcpAudNotExist {
		if (auds.containsKey(aud.getAudName()) == false) {
			throw new CumExcpAudNotExist(chnlName, aud.getAudName());
		}

		auds.remove(aud.getAudName());
		return new NtfyCmdLvChnl(seshName, chnlName, aud.getAudName());

	}

	/**
	 * @return
	 */
	public CmdChnlAbst getNtfyRegChnlCmd() {
		NtfyCmdRegChnl cmd = new NtfyCmdRegChnl(seshName, chnlName,
				new ArrayList<ChnlRscIntf>(rsces.values()));
		return cmd;
	}
}
