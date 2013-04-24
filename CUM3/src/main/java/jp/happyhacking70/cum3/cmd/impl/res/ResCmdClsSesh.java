/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.res;

import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.ResCmdSeshAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdClsSesh extends ResCmdSeshAbst {
	/**
	 * @author happyhacking70@gmail.com
	 * 
	 */
	public enum RsltTypes {
		Clsed, NotExist, NotEmp
	}

	/**
	 * @param seshName
	 * @param rslt
	 */
	public ResCmdClsSesh(String seshName, RsltTypes rslt) {
		super(seshName, rslt.name());
	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public ResCmdClsSesh(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = CmdActions.ClsSesh.name();
	}

}
