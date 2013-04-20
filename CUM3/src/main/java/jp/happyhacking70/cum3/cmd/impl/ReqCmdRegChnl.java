/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import java.util.concurrent.CopyOnWriteArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.ReqCmdChnlAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

import org.w3c.dom.Element;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdRegChnl extends ReqCmdChnlAbst {
	protected CopyOnWriteArrayList<ChnlRscIntf> rscData = new CopyOnWriteArrayList<ChnlRscIntf>();

	/**
	 * @param seshName
	 * @param chnlName
	 */
	public ReqCmdRegChnl(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

	@Override
	protected void setActionName() {
		actionName = "RegChnl";

	}

	public void addRscData(ChnlRscIntf chnlRsc) {
		rscData.add(chnlRsc);
	}

	public CopyOnWriteArrayList<ChnlRscIntf> getRscData() {
		return rscData;
	}

	@Override
	protected void configureDomCocument(Element cmdElem)
			throws CumExcpXMLGenFailed {
		super.configureDomCocument(cmdElem);

		for (ChnlRscIntf chnl : rscData) {
			Element rscElem = cmdElem.getOwnerDocument().createElement("RSC");
			rscElem.setAttribute("NAME", chnl.getName());
			cmdElem.appendChild(rscElem);
		}
	}

}
