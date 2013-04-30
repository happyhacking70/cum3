/**
 * 
 */
package jp.happyhacking70.cum3.chnlLyr.rsc.factory;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.excp.impl.CumExcpRscBinariseFailed;
import jp.happyhacking70.cum3.excp.impl.rsc.CumExcpRscInstantiateFailed;
import jp.happyhacking70.cum3.test.CumTestAbst;

import org.junit.Test;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ChnlRscFactoryHdlrImgTest extends CumTestAbst {

	/**
	 * @throws IOException
	 */
	public ChnlRscFactoryHdlrImgTest() throws IOException {
		super();
	}

	/**
	 * Test method for
	 * {@link jp.happyhacking70.cum3.chnlLyr.rsc.factory.ChnlRscFactoryHdlrImg#getChnlRsc(java.lang.String, byte[])}
	 * .
	 * 
	 * @throws CumExcpRscBinariseFailed
	 * @throws CumExcpRscInstantiateFailed
	 */
	@Test
	public void testGetChnlRsc() throws CumExcpRscInstantiateFailed,
			CumExcpRscBinariseFailed {
		ChnlRscFactoryHdlrImg hdlr = new ChnlRscFactoryHdlrImg();
		ChnlRscIntf rsc = hdlr.getChnlRsc(rscImgA.getName(),
				rscImgA.getBinary());

		assertEquals(rscImgA.getName(), rsc.getName());
		assertEquals(rscImgA.getMimeType(), rsc.getMimeType());
		// Current implementation of ImageIO for JPEG is not reversal
	}

}
