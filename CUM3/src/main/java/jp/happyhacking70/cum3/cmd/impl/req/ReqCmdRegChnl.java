/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.req;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.ReqCmdChnlRscAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdRegChnl extends ReqCmdChnlRscAbst {

	/**
	 * @param seshName
	 * @param chnlName
	 */
	public ReqCmdRegChnl(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

	/**
	 * @param doc
	 * @param rcses
	 * @throws CumExcpIllegalCmdDoc
	 */
	public ReqCmdRegChnl(Document doc, ArrayList<ChnlRscIntf> rcses)
			throws CumExcpIllegalCmdDoc {
		super(doc, rcses);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = "RegChnl";

	}

}
