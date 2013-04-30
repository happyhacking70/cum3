/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.comLyr;

import java.io.IOException;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.chnlLyr.rsc.factory.ChnlRscFactory;
import jp.happyhacking70.cum3.excp.impl.rsc.CumExcpRscInstantiateFailed;
import jp.happyhacking70.cum3.excp.impl.rsc.CumExcpUnknowDataTypeForChnlRsc;

import org.jboss.netty.handler.codec.http.multipart.FileUpload;
import org.jboss.netty.handler.codec.http.multipart.InterfaceHttpData;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ChnlRscFactoryByHttpData extends ChnlRscFactory {

	public ChnlRscFactoryByHttpData() {
		super();
	}

	public ChnlRscIntf getChnlRsc(InterfaceHttpData data)
			throws CumExcpUnknowDataTypeForChnlRsc, CumExcpRscInstantiateFailed {
		ChnlRscIntf chnlRsc = null;

		if (!(data instanceof FileUpload)) {
			throw new CumExcpUnknowDataTypeForChnlRsc(data.getHttpDataType()
					.name());
		}
		FileUpload f = (FileUpload) data;

		try {
			chnlRsc = getChnlRsc(f.getContentType(), f.getName(), f.get());
		} catch (IOException e) {
			throw new CumExcpRscInstantiateFailed(e);
		}

		return chnlRsc;
	}

}
