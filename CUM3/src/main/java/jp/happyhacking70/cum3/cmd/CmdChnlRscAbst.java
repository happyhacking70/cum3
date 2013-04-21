/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class CmdChnlRscAbst extends CmdChnlAbst {
	final protected CopyOnWriteArrayList<ChnlRscIntf> rscData = new CopyOnWriteArrayList<ChnlRscIntf>();

	public CmdChnlRscAbst(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public CmdChnlRscAbst(Document doc, ArrayList<ChnlRscIntf> rsces)
			throws CumExcpIllegalCmdDoc {
		super(doc);
		setChnlNameFromDoc(rsces);
	}

	/**
	 * @param rsces
	 */
	final protected void setChnlNameFromDoc(ArrayList<ChnlRscIntf> rsces) {
		for (ChnlRscIntf rsc : rsces) {
			addRscData(rsc);
		}

	}

	final public void addRscData(ChnlRscIntf chnlRsc) {
		rscData.add(chnlRsc);
	}

	final public CopyOnWriteArrayList<ChnlRscIntf> getRscData() {
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
