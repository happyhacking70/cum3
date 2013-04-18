/**
 * 
 */
package jp.happyhacking70.cum3.comLyr;

import java.util.HashMap;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.excp.CumExcpXMLGenFailed;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class DummySender implements CmdSenderIntf {
	HashMap<Class<? extends CmdAbst>, CmdAbst> cmdsSent = new HashMap<Class<? extends CmdAbst>, CmdAbst>();

	public void sendCmd(CmdAbst cmd) {
		try {
			System.out.println(cmd.toXmlStr());
			cmdsSent.put(cmd.getClass(), cmd);

		} catch (CumExcpXMLGenFailed e) {
			e.printStackTrace();
		}
	}

	public CmdAbst getCmdSent(Class<? extends CmdAbst> cnmdClass) {
		return cmdsSent.get(cnmdClass);
	}

}
