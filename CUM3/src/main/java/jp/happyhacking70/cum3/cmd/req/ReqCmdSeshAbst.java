/**
 * 
 */
package jp.happyhacking70.cum3.cmd.req;

import jp.happyhacking70.cum3.cmd.CmdSeshAbst;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public abstract class ReqCmdSeshAbst extends CmdSeshAbst implements ReqCmdIntf {

	/**
	 * @param seshName
	 */
	public ReqCmdSeshAbst(String seshName) {
		super(seshName);
	}

	/**
	 * @param doc
	 */
	public ReqCmdSeshAbst(Document doc) {
		super(getSeshNameFromDoc(doc));
	}

	@Override
	final protected void setCmdType() {
		cmdType = CmdTypes.REQ;
	}

}
