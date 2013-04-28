/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.ntfy;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.NtfyCmdChnlRscAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class NtfyCmdRegChnl extends NtfyCmdChnlRscAbst {

	public NtfyCmdRegChnl(String seshName, String chnlName,
			ArrayList<ChnlRscIntf> rsces) {
		super(seshName, chnlName, rsces);
	}

	/**
	 * @param seshName
	 * @param chnlName
	 * @param chnlRsces
	 */
	public NtfyCmdRegChnl(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public NtfyCmdRegChnl(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	@Override
	protected void setActionName() {
		actionName = CmdActions.RegChnl.name();
	}

}
