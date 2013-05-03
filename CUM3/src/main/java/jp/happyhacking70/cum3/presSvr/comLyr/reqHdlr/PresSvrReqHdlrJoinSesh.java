/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.comLyr.reqHdlr;

import java.util.List;
import java.util.Map;

import jp.happyhacking70.cum3.presSvr.adptrLyr.PresSvrAdptr;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class PresSvrReqHdlrJoinSesh extends PresSvrReqHdlrAbst {

	static final public String path = Pathes.joinSesh.name();
	protected String seshName;

	public enum Params {
		sesh
	}

	/**
	 * @param adptr
	 */
	public PresSvrReqHdlrJoinSesh(PresSvrAdptr adptr) {
		super(adptr);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.comLyr.PresSvrReqHdlrAbst#setMyRequiredParams
	 * ()
	 */
	@Override
	protected void setMyRequiredParams() {
		requiredParams.add(Params.sesh.name());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.comLyr.PresSvrReqHdlrAbst#setMyParams(
	 * java.util.Map)
	 */
	@Override
	protected void setMyParams(Map<String, List<String>> params) {
		seshName = params.get(Params.sesh.name()).get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.comLyr.reqHdlr.PresSvrReqHdlrAbst#handleReq
	 * ()
	 */
	@Override
	public void handleReq() {
		// return adptr.hndlCmd(cmdXml, sender);

	}

}
