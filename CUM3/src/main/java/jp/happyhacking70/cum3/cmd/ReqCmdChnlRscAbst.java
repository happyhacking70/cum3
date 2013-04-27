/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import java.util.ArrayList;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpIllegalCmdDoc;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class ReqCmdChnlRscAbst extends CmdChnlRscAbst implements
		ReqCmdIntf {

	/**
	 * @param seshName
	 * @param chnlName
	 */
	public ReqCmdChnlRscAbst(String seshName, String chnlName) {
		super(seshName, chnlName);
	}

	/**
	 * @throws CumExcpIllegalCmdDoc
	 * 
	 */
	public ReqCmdChnlRscAbst(Document doc) throws CumExcpIllegalCmdDoc {
		super(doc);
	}

	public void addRsces(ArrayList<ChnlRscIntf> rsces) {
		for (ChnlRscIntf rsc : rsces) {
			addRscData(rsc);
		}
	}

	@Override
	protected void setCmdType() {
		cmdType = CmdTypes.REQ;

	}

}
