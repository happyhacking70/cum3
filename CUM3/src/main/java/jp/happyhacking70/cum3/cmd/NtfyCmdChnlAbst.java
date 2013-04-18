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
