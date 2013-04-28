/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class NtfyCmdChnlRscAbst extends CmdChnlRscAbst implements
		ReqCmdIntf {
	final protected ArrayList<ChnlRscIntf> chnlRsces = new ArrayList<ChnlRscIntf>();

	/**
	 * @param seshName
	 * @param chnlName
	 * @param rsces
	 */
	public NtfyCmdChnlRscAbst(String seshName, String chnlName,
			ArrayList<ChnlRscIntf> rsces) {
		super(seshName, chnlName, rsces);
	}

	/**
	 * @param seshName
	 * @param chnlName
	 */
	public NtfyCmdChnlRscAbst(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

	/**
	 * @throws CumExcpIllegalCmdDoc
	 * 
	 */
	public NtfyCmdChnlRscAbst(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	@Override
	protected void setCmdType() {
		cmdType = CmdTypes.NTFY;

	}

}
