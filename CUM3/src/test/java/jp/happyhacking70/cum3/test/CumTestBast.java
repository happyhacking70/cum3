/**
 * 
 */
package jp.happyhacking70.cum3.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscImg;
import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;
import jp.happyhacking70.cum3.comLyr.DummySender;
import jp.happyhacking70.cum3.comLyr.DummySrvAdm;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public abstract class CumTestBast {

	protected static final String seshName = "testSession";
	protected static final String chnlName = "testChannel";
	protected static final String audName = "testAudience";
	protected static final String audNameA = "testAudienceA";
	protected static final String audNameB = "testAudienceB";

	protected static final String rscNameA = "a";
	protected BufferedImage bImgA;
	protected ChnlRscImg rscImgA;

	protected static final String rscNameb = "b";
	protected BufferedImage bImgB;
	protected ChnlRscImg rscImgB;

	protected ArrayList<ChnlRscIntf> rscesArray = new ArrayList<ChnlRscIntf>();

	protected static final DummySrvAdm srvAdm = new DummySrvAdm();
	protected static final DummySender senderForPrestr = new DummySender(srvAdm);
	protected static final DummySender senderForAudA = new DummySender(srvAdm);
	protected static final DummySender senderForAudB = new DummySender(srvAdm);

	public CumTestBast() throws IOException {
		super();
		bImgA = ImageIO.read(new File("src/test/resources/1.jpg"));
		bImgB = ImageIO.read(new File("src/test/resources/2.jpg"));

		rscImgA = new ChnlRscImg(rscNameA, bImgA);
		rscImgB = new ChnlRscImg(rscNameb, bImgB);
		rscesArray.add(rscImgA);
		rscesArray.add(rscImgB);
	}

}
