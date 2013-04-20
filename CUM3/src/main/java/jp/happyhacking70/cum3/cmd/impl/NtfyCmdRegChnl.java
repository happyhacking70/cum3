/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.NtfyCmdChnlAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

import org.w3c.dom.Element;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class NtfyCmdRegChnl extends NtfyCmdChnlAbst {
	ArrayList<ChnlRscIntf> chnlRsces;

	/**
	 * @param seshName
	 * @param chnlName
	 * @param chnlRsces
	 */
	public NtfyCmdRegChnl(String seshName, String chnlName,
			ArrayList<ChnlRscIntf> chnlRsces) {
		super(seshName, chnlName);
		this.chnlRsces = chnlRsces;
	}

	@Override
	protected void setActionName() {
		actionName = "RegChnl";
	}

	@Override
	protected void configureDomCocument(Element cmdElem)
			throws CumExcpXMLGenFailed {
		super.configureDomCocument(cmdElem);

		for (ChnlRscIntf chnl : chnlRsces) {
			Element rscElem = cmdElem.getOwnerDocument().createElement("RSC");
			rscElem.setAttribute("NAME", chnl.getName());
			cmdElem.appendChild(rscElem);
		}
	}
}
