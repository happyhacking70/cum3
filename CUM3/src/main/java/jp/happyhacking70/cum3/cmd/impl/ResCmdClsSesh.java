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
public class ResCmdClsSesh extends ResCmdSeshAbst {
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

	@Override
	protected void setActionName() {
		actionName = "ClsSesh";
	}

	public static void main(String[] args) throws CumExcpXMLGenFailed {
		ResCmdClsSesh cmd = new ResCmdClsSesh("testSession", RsltTypes.Clsed);
		System.out.println(cmd.toXmlStr());
	}
}
