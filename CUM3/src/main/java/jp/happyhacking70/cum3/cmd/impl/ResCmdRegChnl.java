/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import jp.happyhacking70.cum3.cmd.ResCmdChnlAbst;
import jp.happyhacking70.cum3.excp.CumExcpXMLGenFailed;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdRegChnl extends ResCmdChnlAbst {
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

	@Override
	protected void setActionName() {
		actionName = "RegChnl";
	}

	public static void main(String[] args) throws CumExcpXMLGenFailed {
		ResCmdRegChnl cmd = new ResCmdRegChnl("testSession", "testChannel",
				RsltTypes.Reged);
		System.out.println(cmd.toXmlStr());
	}
}
