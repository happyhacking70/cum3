/**
 * 
 */
package jp.happyhacking70.cum3.comLyr;

import java.util.concurrent.ConcurrentLinkedDeque;

import jp.happyhacking70.cum3.cmd.XMLableCmdIntf;
import jp.happyhacking70.cum3.presSvr.comLyr.SvrAdmIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class DummySrvAdm implements SvrAdmIntf {
	protected ConcurrentLinkedDeque<XMLableCmdIntf> wrongCmds = new ConcurrentLinkedDeque<XMLableCmdIntf>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.comLyr.SvrAdmIntf#xmlGenErrDetected(jp
	 * .happyhacking70.cum3.cmd.XMLableCmdIntf)
	 */
	@Override
	public void xmlGenErrDetected(XMLableCmdIntf cmd) {
		wrongCmds.add(cmd);
	}

	public XMLableCmdIntf pollCmd() {
		return wrongCmds.poll();
	}

}
