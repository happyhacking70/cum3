/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public class DummyAcptAudDisconned implements AcptAudDisconnedIntf {
	protected String audName;

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.happyhacking70.cum3.presSvr.seshLyr.AcptAudDisconnedIntf#
	 * acceptAudDisconned(java.lang.String)
	 */
	public void acceptAudDisconned(String audName) {
		this.audName = audName;
	}

	public String getAudName() {
		return audName;
	}

}
