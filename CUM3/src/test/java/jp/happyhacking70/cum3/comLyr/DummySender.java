/**
 * 
 */
package jp.happyhacking70.cum3.comLyr;

import java.util.concurrent.ConcurrentLinkedQueue;

import jp.happyhacking70.cum3.cmd.CmdAbst;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class DummySender implements CmdSenderIntf {

	ConcurrentLinkedQueue<CmdAbst> cmdsSent = new ConcurrentLinkedQueue<CmdAbst>();

	public void sendCmd(CmdAbst cmd) {
		try {
			System.out.println(cmd.toXmlStr());
			cmdsSent.offer(cmd);

		} catch (CumExcpXMLGenFailed e) {
			e.printStackTrace();
		}
	}

	public CmdAbst pollCmd() {
		return cmdsSent.poll();
	}

}
