/**
 * 
 */
package jp.happyhacking70.cum3.chnlLyr.rsc;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.happyhacking70.cum2.excp.CumExcpRscBinariseFailed;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class ChnlRscImg extends ChnlRscAbst {

	protected BufferedImage bImg;
	static final String mimeType = "image/jpeg";

	public ChnlRscImg(String name, BufferedImage bImg) {
		super(name);
		this.bImg = bImg;
	}

	@Override
	public String getMimeType() {
		return ChnlRscImg.mimeType;
	}

	@Override
	public byte[] getBinary() throws CumExcpRscBinariseFailed {

		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		try {
			ImageIO.write(bImg, "jpg", byteArray);
		} catch (IOException e) {
			throw new CumExcpRscBinariseFailed(e);
		}
		byte[] byteImage = byteArray.toByteArray();

		return byteImage;
	}

}
