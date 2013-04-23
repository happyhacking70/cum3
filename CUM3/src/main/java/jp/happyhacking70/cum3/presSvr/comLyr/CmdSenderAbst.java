/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.comLyr;

import jp.happyhacking70.cum3.cmd.XMLableCmdIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class CmdSenderAbst implements CmdSenderIntf {

	protected SvrAdmIntf svrAdm;

	/**
	 * @param svrAdm
	 */
	public CmdSenderAbst(SvrAdmIntf svrAdm) {
		super();
		this.svrAdm = svrAdm;
	}

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
			svrAdm.xmlGenErrDetected(cmd);
			return;
		}

		sendCmd(xmledCmd);
	}

	/**
	 * send command
	 * 
	 * @param xmledCmd
	 */
	abstract protected void sendCmd(String xmledCmd);
}
