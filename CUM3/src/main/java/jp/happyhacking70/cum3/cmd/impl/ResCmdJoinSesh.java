/**
 * 
 */
package jp.happyhacking70.cum3.cmd.impl;

import jp.happyhacking70.cum3.cmd.ResCmdSeshAudAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ResCmdJoinSesh extends ResCmdSeshAudAbst {
	public enum RsltTypes {
		NotExist, Joined, Exists
	}

	/**
	 * @param seshName
	 * @param audName
	 * @param rslt
	 */
	public ResCmdJoinSesh(String seshName, String audName, RsltTypes rslt) {
		super(seshName, audName, rslt.name());

	}

	@Override
	protected void setActionName() {
		actionName = "JoinSesh";
	}

	public static void main(String[] args) throws CumExcpXMLGenFailed {
		ResCmdJoinSesh cmd = new ResCmdJoinSesh("testSession", "testAudience",
				RsltTypes.Exists);
		System.out.println(cmd.toXmlStr());
	}

}
