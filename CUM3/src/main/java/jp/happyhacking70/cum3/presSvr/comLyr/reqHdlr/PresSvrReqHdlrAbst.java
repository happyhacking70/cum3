/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.comLyr.reqHdlr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.happyhacking70.cum3.excp.impl.comLyr.CumExcpParamMissing;
import jp.happyhacking70.cum3.excp.impl.comLyr.CumExcpParamShouldOne;
import jp.happyhacking70.cum3.presSvr.adptrLyr.PresSvrAdptr;
import jp.happyhacking70.cum3.presSvr.seshLyr.SeshMgrPresSvrAllIntf;

/**
 * Request Handler
 * 
 * @author happyhacking70@gmail.com
 * 
 */
public abstract class PresSvrReqHdlrAbst implements PresSvrReqHdlrIntf {
	/**
	 * Pathes
	 * 
	 * @author happyhacking70@gmail.com
	 * 
	 */
	public enum Pathes {
		/** Register Session */
		regSesh,
		/** Register Channel */
		regChnl,
		/** Join Session */
		joinSesh,
		/** Other commands */
		normalCmd
	}

	/**
	 * parameter name for xml representation fo command
	 */
	static final String cmdXmlParamName = "cmd";

	/**
	 * Adaptor bridging server and {@link SeshMgrPresSvrAllIntf}
	 */
	protected PresSvrAdptr adptr;

	/**
	 * {@link ArrayList} of required parameters
	 */
	protected ArrayList<String> requiredParams = new ArrayList<String>();

	/**
	 * XML representation of command
	 */
	protected String cmdXml;

	/**
	 * @param adptr
	 */
	public PresSvrReqHdlrAbst(PresSvrAdptr adptr) {
		super();
		this.adptr = adptr;
		setRequiredParams();

	}

	/**
	 * set up required parameters. This is invoked in constructor. Since all
	 * handlers requires XML representation of command, this abstract class
	 * takes care of XML representation of command. Implementation class has to
	 * handle specific parameters in
	 * {@link PresSvrReqHdlrAbst#setMyRequiredParams()}.
	 */
	protected void setRequiredParams() {
		requiredParams.add(cmdXmlParamName);
		setMyRequiredParams();
	}

	/**
	 * set up implementation class specific required parameters
	 */
	abstract protected void setMyRequiredParams();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.comLyr.reqHdlr.PresSvrReqHdlrIntf#setParams
	 * (java.util.Map)
	 */
	@Override
	public void setParams(Map<String, List<String>> params) {
		cmdXml = params.get(cmdXmlParamName).get(0);
		setMyParams(params);
	}

	/**
	 * set up implementation specific properties from parameters. This is
	 * invoked by {@link PresSvrReqHdlrAbst#setParams(Map)}. Since all
	 * implementation has XML representation of command, it is handled by
	 * {@link PresSvrReqHdlrAbst#setParams(Map)}. Implementation class has to
	 * handle only implementation specific properties.
	 * 
	 * @param params
	 */
	abstract protected void setMyParams(Map<String, List<String>> params);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.comLyr.reqHdlr.PresSvrReqHdlrIntf#checkParams
	 * (java.util.Map)
	 */
	@Override
	public void checkParams(Map<String, List<String>> params)
			throws CumExcpParamMissing, CumExcpParamShouldOne {

		for (String requiredParam : requiredParams) {
			List<String> vals = params.get(requiredParam);
			if (vals == null) {
				throw new CumExcpParamMissing(requiredParam);
			}
			if (vals.size() != 1) {
				throw new CumExcpParamShouldOne(requiredParam);
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.comLyr.reqHdlr.PresSvrReqHdlrIntf#handleReq
	 * ()
	 */
	@Override
	abstract public void handleReq();
}
