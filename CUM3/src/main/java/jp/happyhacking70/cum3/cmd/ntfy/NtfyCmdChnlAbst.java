/**
 * 
 */
package jp.happyhacking70.cum3.cmd.ntfy;

import jp.happyhacking70.cum3.cmd.CmdChnlAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public abstract class NtfyCmdChnlAbst extends CmdChnlAbst implements
		NtfyCmdIntf {

	/**
	 * @param seshName
	 * @param chnlName
	 */
	public NtfyCmdChnlAbst(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

	public NtfyCmdChnlAbst(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	@Override
	final protected void setCmdType() {
		cmdType = CmdTypes.NTFY;

	}

}
