/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import jp.happyhacking70.cum3.excp.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class ReqCmdSeshAudAbst extends CmdSeshAudAbst implements
		ReqCmdIntf {

	/**
	 * @param seshName
	 * @param audName
	 */
	public ReqCmdSeshAudAbst(String seshName, String audName) {
		super(seshName, audName);
	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public ReqCmdSeshAudAbst(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	@Override
	protected void setCmdType() {
		cmdType = CmdTypes.REQ;
	}

}
