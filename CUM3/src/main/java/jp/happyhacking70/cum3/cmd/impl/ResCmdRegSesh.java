/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import jp.happyhacking70.cum3.cmd.ResCmdSeshAbst;
import jp.happyhacking70.cum3.excp.CumExcpXMLGenFailed;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdRegSesh extends ResCmdSeshAbst {
	public enum RsltTypes {
		Reged, Exists
	}

	/**
	 * @param seshName
	 * @param rslt
	 */
	public ResCmdRegSesh(String seshName, RsltTypes rslt) {
		super(seshName, rslt.name());
	}

	@Override
	protected void setActionName() {
		actionName = "RegSesh";
	}

	public static void main(String[] args) throws CumExcpXMLGenFailed {
		ResCmdRegSesh cmd = new ResCmdRegSesh("testSession", RsltTypes.Reged);
		System.out.println(cmd.toXmlStr());
	}
}
