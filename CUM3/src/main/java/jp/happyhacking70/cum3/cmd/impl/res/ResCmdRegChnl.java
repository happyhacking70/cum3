/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl.res;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.ResCmdChnlRscAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdRegChnl extends ResCmdChnlRscAbst {

	/**
	 * @author happyhacking70@gmail.com
	 * 
	 */
	public enum RsltTypes {
		Reged, Exists, DupRsc
	}

	/**
	 * @param seshName
	 * @param chnlName
	 * @param rslt
	 */
	public ResCmdRegChnl(String seshName, String chnlName, RsltTypes rslt) {
		super(seshName, chnlName, rslt.name());

	}

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public ResCmdRegChnl(Document doc, ArrayList<ChnlRscIntf> rcses)
			throws CumExcpIllegalCmdDoc {
		super(doc, rcses);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.cmd.CmdAbst#setActionName()
	 */
	@Override
	protected void setActionName() {
		actionName = CmdActions.RegChnl.name();
	}

}
