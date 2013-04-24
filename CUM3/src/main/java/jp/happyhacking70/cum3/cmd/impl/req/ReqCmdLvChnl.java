/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.req;

import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.ReqCmdChnlAudAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdLvChnl extends ReqCmdChnlAudAbst {

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public ReqCmdLvChnl(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	/**
	 * @param seshName
	 * @param chnlName
	 * @param audName
	 */
	public ReqCmdLvChnl(String seshName, String chnlName, String audName) {
		super(seshName, chnlName, audName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = CmdActions.LvChnl.name();
	}

}
