/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
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
	public NtfyCmdRegChnl(Document doc, ArrayList<ChnlRscIntf> rsces)
			throws CumExcpIllegalCmdDoc {
		super(doc, rsces);
	}

	@Override
	protected void setActionName() {
		actionName = "RegChnl";
	}

	// @Override
	// protected void configureDomCocument(Element cmdElem)
	// throws CumExcpXMLGenFailed {
	// super.configureDomCocument(cmdElem);
	//
	// for (ChnlRscIntf chnl : chnlRsces) {
	// Element rscElem = cmdElem.getOwnerDocument().createElement("RSC");
	// rscElem.setAttribute("NAME", chnl.getName());
	// cmdElem.appendChild(rscElem);
	// }
	// }
}
