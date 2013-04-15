/**
 * 
 */
package jp.happyhacking70.cum3.comLyr;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.excp.CumExcpXMLGenFailed;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class DummySender implements CmdSenderIntf {

	public void sendCmd(CmdAbst cmd) {
		try {
			System.out.println(cmd.toXmlStr());
		} catch (CumExcpXMLGenFailed e) {
			e.printStackTrace();
		}
	}

}
