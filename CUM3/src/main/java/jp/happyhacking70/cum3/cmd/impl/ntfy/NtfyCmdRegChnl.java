/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.ntfy;

import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.NtfyCmdChnlRscAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class NtfyCmdRegChnl extends NtfyCmdChnlRscAbst {

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
