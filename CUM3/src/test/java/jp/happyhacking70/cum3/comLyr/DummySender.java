/**
 * 
 */
package jp.happyhacking70.cum3.comLyr;

import java.util.concurrent.ConcurrentLinkedQueue;

import jp.happyhacking70.cum3.cmd.XMLableCmdIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpComError;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;
import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class DummySender implements CmdSenderIntf {

	ConcurrentLinkedQueue<XMLableCmdIntf> cmdsSent = new ConcurrentLinkedQueue<XMLableCmdIntf>();
	protected boolean emulateComErro = false;

	// public void sendCmd(CmdAbst cmd) {
	// try {
	// System.out.println(cmd.toXmlStr());
	// cmdsSent.offer(cmd);
	//
	// } catch (CumExcpXMLGenFailed e) {
	// e.printStackTrace();
	// }
	// }

	public XMLableCmdIntf pollCmd() {
		return cmdsSent.poll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf#sendCmd(jp.happyhacking70
	 * .cum3.cmd.XMLableCmdIntf)
	 */
	public void sendCmd(XMLableCmdIntf cmd) throws CumExcpComError {

		if (emulateComErro == true) {
			throw new CumExcpComError("DUMMY");
		}
		try {
			System.out.println(cmd.toXmlStr());
			cmdsSent.offer(cmd);

		} catch (CumExcpXMLGenFailed e) {
			e.printStackTrace();
		}

	}

	public void emulateComErr() {
		emulateComErro = true;
	}

}
