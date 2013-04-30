/**
 * 
 */
package jp.happyhacking70.cum3.chnlLyr.rsc.factory;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpRscBinariseFailed;
import jp.happyhacking70.cum3.excp.impl.rsc.CumExcpRscInstantiateFailed;
import jp.happyhacking70.cum3.excp.impl.rsc.CumExcpUnknowDataTypeForChnlRsc;
import jp.happyhacking70.cum3.test.CumTestAbst;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ChnlRscFactoryTest extends CumTestAbst {

	/**
	 * @throws IOException
	 */
	public ChnlRscFactoryTest() throws IOException {
		super();
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.chnlLyr.rsc.factory.ChnlRscFactory#getChnlRsc(java.lang.String, java.lang.String, byte[])}
	 * .
	 * 
	 * @throws CumExcpRscBinariseFailed
	 * @throws CumExcpRscInstantiateFailed
	 * @throws CumExcpUnknowDataTypeForChnlRsc
	 */
	@Test
	public void testGetChnlRsc() throws CumExcpUnknowDataTypeForChnlRsc,
			CumExcpRscInstantiateFailed, CumExcpRscBinariseFailed {
		ChnlRscFactory f = new ChnlRscFactory();

		ChnlRscIntf rsc = f.getChnlRsc(rscImgA.getMimeType(),
				rscImgA.getName(), rscImgA.getBinary());

		assertEquals(rscImgA.getClass(), rsc.getClass());

	}
}
