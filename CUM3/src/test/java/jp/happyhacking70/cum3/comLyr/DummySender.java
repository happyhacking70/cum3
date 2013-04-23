/**
 * 
 */
package jp.happyhacking70.cum3.comLyr;

import java.util.concurrent.ConcurrentLinkedQueue;

import jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderAbst;
import jp.happyhacking70.cum3.presSvr.comLyr.SvrAdmIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class DummySender extends CmdSenderAbst {
	ConcurrentLinkedQueue<String> cmdsSent = new ConcurrentLinkedQueue<String>();

	/**
	 * @param svrAdm
	 */
	public DummySender(SvrAdmIntf svrAdm) {
		super(svrAdm);
	}

	/**
	 * @return
	 */
	public String pollCmd() {
		return cmdsSent.poll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.comLyr.CmdSenderAbst#sendCmd(java.lang
	 * .String)
	 */
	@Override
	protected void sendCmd(String xmledCmd) {
		cmdsSent.add(xmledCmd);
	}

}
