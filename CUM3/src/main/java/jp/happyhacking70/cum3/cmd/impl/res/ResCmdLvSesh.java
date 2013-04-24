/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.res;

import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.ResCmdSeshAudAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdLvSesh extends ResCmdSeshAudAbst {
	/**
	 * @author happyhacking70@gmail.com
	 * 
	 */
	public enum RsltTypes {
		/** Session does not exist */
		SeshNotExist,
		/** Audience is not joining the session */
		NotExist,
		/** Audience succesfully left the session */
		Left

	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public ResCmdLvSesh(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	/**
	 * @param seshName
	 * @param audName
	 * @param rslt
	 */
	public ResCmdLvSesh(String seshName, String audName, String rslt) {
		super(seshName, audName, rslt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = CmdActions.LvSesh.name();

	}

}
