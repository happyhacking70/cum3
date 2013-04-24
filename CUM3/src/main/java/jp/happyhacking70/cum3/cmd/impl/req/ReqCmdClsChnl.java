/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.req;

import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.ReqCmdChnlAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ReqCmdClsChnl extends ReqCmdChnlAbst {

	/**
	 * @param seshName
	 * @param chnlName
	 */
	public ReqCmdClsChnl(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

	public ReqCmdClsChnl(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);

	}

	@Override
	protected void setActionName() {
		actionName = CmdActions.ClsChnl.name();
	}

}
