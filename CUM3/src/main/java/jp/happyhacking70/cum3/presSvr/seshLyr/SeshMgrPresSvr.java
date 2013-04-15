/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

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
public class SeshMgrPresSvr implements SeshMgrAudIntf, SeshMgrPrestrIntf {
	protected ConcurrentHashMap<String, PresSvrSesh> seshes = new ConcurrentHashMap<String, PresSvrSesh>();

	synchronized public void regSesh(String seshName) throws CumExcpSeshExists {
		if (seshes.containsKey(seshName) == true) {
			throw new CumExcpSeshExists(seshName);
		}

		seshes.put(seshName, new PresSvrSesh(seshName));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.seshLyr.SeshMgrPrestrIntf#regChnl()
	 */
	synchronized public void regChnl(String seshName, String chnlName,
			ArrayList<ChnlRscIntf> chnlRsces) throws CumExcpSeshNotExist,
			CumExcpChnlExists, CumExcpRscExists, CumExcptNullRsces,
			CumExcpRscNull {

		PresSvrSesh sesh = seshes.get(seshName);

		// if (sesh == null) {
		// throw new CumExcpSeshNotExist(seshName);
		// }
		// ChnlPresSvr chnl = null;
		// try {
		// chnl = new ChnlPresSvr(chnlName, chnlRsces);
		// } catch (CumExcptNullRsces e) {
		// throw new CumExcptNullRsces(seshName, e);
		//
		// } catch (CumExcpRscNull e) {
		// throw new CumExcpRscNull(seshName, e);
		// }

	}

	synchronized public void clsSesh(String seshName) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.seshLyr.SeshMgrPrestrIntf#sendChnlCmd(jp.
	 * happyhacking70.cum3.cmd.CmdAbst, java.lang.String)
	 */
	synchronized public void sendChnlCmd(CmdAbst cmd, String audName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.seshLyr.SeshMgrPrestrIntf#sendChnlCmd(jp.
	 * happyhacking70.cum3.cmd.CmdAbst)
	 */
	synchronized public void sendChnlCmd(CmdAbst cmd) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.seshLyr.SeshMgrPrestrIntf#clsChnl(java.lang.String
	 * , java.lang.String)
	 */
	synchronized public void clsChnl(String seshName, String chnlName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.seshLyr.SeshMgrAudIntf#joinSesh(java.lang.String,
	 * java.lang.String)
	 */
	synchronized public void joinSesh(String seshName, String audName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.seshLyr.SeshMgrAudIntf#joinChnl(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	synchronized public void joinChnl(String seshName, String chnlName,
			String audName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.seshLyr.SeshMgrAudIntf#rjctChnl(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	synchronized public void rjctChnl(String seshName, String chnlName,
			String audName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.seshLyr.SeshMgrAudIntf#lvChnl(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	synchronized public void lvChnl(String seshName, String chnlName,
			String audName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.seshLyr.SeshMgrAudIntf#lvSesh(java.lang.String,
	 * java.lang.String)
	 */
	synchronized public void lvSesh(String seshName, String audName) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.seshLyr.SeshMgrAudIntf#fetchRsc(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	synchronized public ChnlRscIntf fetchRsc(String seshName, String chnlName,
			String rscName) {
		// TODO Auto-generated method stub
		return null;
	}

}
