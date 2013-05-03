/**
 * 
 */
package jp.happyhacking70.cum3.cmd.ntfy;

import jp.happyhacking70.cum3.cmd.CmdAudAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class NtfyCmdAudAbst extends CmdAudAbst {

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public NtfyCmdAudAbst(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);

	}

	public NtfyCmdAudAbst(String audName) {
		super(audName);
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
