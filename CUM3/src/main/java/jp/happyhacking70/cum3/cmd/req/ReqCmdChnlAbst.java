/**
 * 
 */
package jp.happyhacking70.cum3.cmd.req;

import jp.happyhacking70.cum3.cmd.CmdChnlAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class ReqCmdChnlAbst extends CmdChnlAbst implements ReqCmdIntf {

	/**
	 * @param seshName
	 * @param chnlName
	 */
	public ReqCmdChnlAbst(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

	/**
	 * @throws CumExcpIllegalCmdDoc
	 * 
	 */
	public ReqCmdChnlAbst(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	@Override
	protected void setCmdType() {
		cmdType = CmdTypes.REQ;

	}

}
