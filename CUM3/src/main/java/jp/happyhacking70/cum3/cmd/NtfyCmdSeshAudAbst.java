/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class NtfyCmdSeshAudAbst extends CmdSeshAudAbst implements
		NtfyCmdIntf {

	public NtfyCmdSeshAudAbst(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	public NtfyCmdSeshAudAbst(String seshName, String audName) {
		super(seshName, audName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setCmdType()
	 */
	@Override
	final protected void setCmdType() {
		cmdType = CmdTypes.NTFY;
	}

}
