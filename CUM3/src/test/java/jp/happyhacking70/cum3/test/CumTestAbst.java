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

/**
 * @author happyhacking70@gmail.com
 * 
 */
public abstract class CumTestAbst {

	protected static final String seshName = "testSession";
	protected static final String chnlName = "testChannel";
	protected static final String audName = "testAudience";
	protected static final String audNameA = "testAudienceA";
	protected static final String audNameB = "testAudienceB";

	protected static final String rscNameA = "a";
	protected BufferedImage bImgA;
	protected ChnlRscImg rscImgA;

	protected static final String rscNameB = "b";
	protected BufferedImage bImgB;
	protected ChnlRscImg rscImgB;

	protected ArrayList<ChnlRscIntf> rscesArray = new ArrayList<ChnlRscIntf>();

	protected static final DummySender senderForPrestr = new DummySender();
	protected static final DummySender senderForAudA = new DummySender();
	protected static final DummySender senderForAudB = new DummySender();

	public CumTestAbst() throws IOException {
		super();
		bImgA = ImageIO.read(new File("src/test/resources/1.jpg"));
		bImgB = ImageIO.read(new File("src/test/resources/2.jpg"));

		rscImgA = new ChnlRscImg(rscNameA, bImgA);
		rscImgB = new ChnlRscImg(rscNameB, bImgB);
		rscesArray.add(rscImgA);
		rscesArray.add(rscImgB);
	}

}
