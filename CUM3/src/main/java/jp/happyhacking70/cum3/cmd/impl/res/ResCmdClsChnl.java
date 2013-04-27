/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.res;

import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.ResCmdChnlAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdClsChnl extends ResCmdChnlAbst {
	/**
	 * @author happyhacking70@gmail.com
	 * 
	 */
	public enum RsltTypes {
		/** closed Successfully */
		Clsed,
		/** Channle not exists */
		NotExist,
		/** Session does not exits */
		SeshNotExist
	}

	/**
	 * @param seshName
	 * @param chnlName
	 * @param rslt
	 */
	public ResCmdClsChnl(String seshName, String chnlName, RsltTypes rslt) {
		super(seshName, chnlName, rslt.name());
	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public ResCmdClsChnl(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = CmdActions.ClsChnl.name();
	}

}
