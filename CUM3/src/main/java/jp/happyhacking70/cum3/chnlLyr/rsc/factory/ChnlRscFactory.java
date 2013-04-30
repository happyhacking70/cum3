/**
 * 
 */
package jp.happyhacking70.cum3.chnlLyr.rsc.factory;

import java.util.concurrent.ConcurrentHashMap;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscImg;
import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.excp.impl.rsc.CumExcpRscInstantiateFailed;
import jp.happyhacking70.cum3.excp.impl.rsc.CumExcpUnknowDataTypeForChnlRsc;

/**
 * Factory class to get ChnlRscIntf by name, mime-type and byte[]. Currently
 * only {@link ChnlRscImg} is available. But you can add more implementation of
 * {@link ChnlRscfactoryHdlrIntf} to take care of more types.
 * 
 * 
 * @author happyhacking70@gmail.com
 * 
 */
public class ChnlRscFactory implements ChnlRscFactoryIntf {
	protected ConcurrentHashMap<String, Class<? extends ChnlRscfactoryHdlrIntf>> hdlrs = new ConcurrentHashMap<String, Class<? extends ChnlRscfactoryHdlrIntf>>();

	public ChnlRscFactory() {
		super();
		addDefaultHdlr();
	}

	/**
	 * add default handler. Currently only handler for {@link ChnlRscImg} is
	 * available.
	 */
	protected void addDefaultHdlr() {
		addHdlr("image/jpeg", ChnlRscFactoryHdlrImg.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.presSvr.comLyr.rsc.junk#getChnlRsc(java.lang.String
	 * , java.lang.String, byte[])
	 */
	@Override
	public ChnlRscIntf getChnlRsc(String mimeType, String name, byte[] bin)
			throws CumExcpUnknowDataTypeForChnlRsc, CumExcpRscInstantiateFailed {
		ChnlRscIntf chnlRsc = null;

		Class<? extends ChnlRscfactoryHdlrIntf> hdlrClass = hdlrs.get(mimeType);

		if (hdlrClass == null) {
			throw new CumExcpUnknowDataTypeForChnlRsc(name);
		}

		try {
			ChnlRscfactoryHdlrIntf hdlr = hdlrClass.newInstance();
			chnlRsc = hdlr.getChnlRsc(name, bin);
		} catch (InstantiationException e) {
			throw new CumExcpRscInstantiateFailed(e);
		} catch (IllegalAccessException e) {
			throw new CumExcpRscInstantiateFailed(e);
		} catch (CumExcpRscInstantiateFailed e) {
			throw e;
		}

		return chnlRsc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.happyhacking70.cum3.chnlLyr.rsc.factory.ChnlRscFactoryIntf#addHdlr
	 * (java.lang.String, java.lang.Class)
	 */
	@Override
	public void addHdlr(String mimeType,
			Class<? extends ChnlRscfactoryHdlrIntf> hdlrClass) {
		hdlrs.put(mimeType, hdlrClass);
	}
}
