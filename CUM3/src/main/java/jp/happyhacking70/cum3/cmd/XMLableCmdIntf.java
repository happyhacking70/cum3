/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import jp.happyhacking70.cum3.excp.impl.CumExcpXMLGenFailed;

import org.w3c.dom.Document;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface XMLableCmdIntf {
	String toXmlStr() throws CumExcpXMLGenFailed;

	Document toXmlDom() throws CumExcpXMLGenFailed;

}
