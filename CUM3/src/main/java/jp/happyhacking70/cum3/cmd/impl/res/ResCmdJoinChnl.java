/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.res;

import jp.happyhacking70.cum3.cmd.ResCmdChnlAudAbst;
import jp.happyhacking70.cum3.cmd.ResCmdIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdJoinChnl extends ResCmdChnlAudAbst implements ResCmdIntf {

	/**
	 * @author happyhacking70@gmail.com
	 * 
	 */
	public enum RsltTypes {

		/** Session Not Exist */
		SeshNotExist,
		/** Channel Not Exist */
		NotExist,
		/** Successfully joined */
		Joined,
		/** Already joined */
		Exists

	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public ResCmdJoinChnl(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	public ResCmdJoinChnl(String seshName, String chnlName, String audName,
			String rslt) {
		super(seshName, chnlName, audName, rslt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = "JoinChnl";
	}

}
