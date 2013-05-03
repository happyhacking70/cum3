/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.comLyr;

import java.util.concurrent.ConcurrentLinkedQueue;

import jp.happyhacking70.cum3.cmd.XMLableCmdIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class CmdSender implements CmdSenderIntf {

	protected ConcurrentLinkedQueue<String> cmdQueue = new ConcurrentLinkedQueue<String>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderIntf#sendCmd(jp.happyhacking70
	 * .cum3.cmd.XMLableCmdIntf)
	 */
	@Override
	final public void sendCmd(XMLableCmdIntf cmd) {
		String xmledCmd = null;
		try {
			xmledCmd = cmd.toXmlStr();
		} catch (CumExcpXMLGenFailed e) {
			e.printStackTrace();
			return;
		}

		cmdQueue.add(xmledCmd);
	}

	public String poll() {
		return cmdQueue.poll();
	}
}
