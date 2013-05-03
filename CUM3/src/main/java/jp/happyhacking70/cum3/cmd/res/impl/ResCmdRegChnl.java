/**
 * 
 */
package jp.happyhacking70.cum3.cmd.res.impl;

import java.util.List;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.cmd.CmdActions;
import jp.happyhacking70.cum3.cmd.res.ResCmdChnlRscAbst;
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
		/** Registered successfully */
		Reged,

		/** Channel already exists */
		Exists,

		/** Resources duplicated */
		DupRsc,

		/** one of rsces is null */
		RscNull,

		/** Session does not exist */
		SeshNotExist
	}

	/**
	 * @param seshName
	 * @param chnlName
	 * @param rsces
	 * @param clsed
	 */
	public ResCmdRegChnl(String seshName, String chnlName,
			List<ChnlRscIntf> rsces, RsltTypes rslt) {
		super(seshName, chnlName, rsces, rslt.name());

	}

	// /**
	// * @param seshName
	// * @param chnlName
	// * @param rslt
	// */
	// public ResCmdRegChnl(String seshName, String chnlName, RsltTypes rslt) {
	// super(seshName, chnlName, rslt.name());
	//
	// }

	/**
	 * @param doc
	 * @throws CumExcpIllegalCmdDoc
	 */
	public ResCmdRegChnl(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
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
