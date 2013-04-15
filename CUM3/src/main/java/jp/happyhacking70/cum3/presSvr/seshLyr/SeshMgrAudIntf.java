/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface SeshMgrAudIntf {
	public void joinSesh(String seshName, String audName);

	public void joinChnl(String seshName, String chnlName, String audName);

	public void rjctChnl(String seshName, String chnlName, String audName);

	public void lvChnl(String seshName, String chnlName, String audName);

	public void lvSesh(String seshName, String audName);

	public ChnlRscIntf fetchRsc(String seshName, String chnlName, String rscName);

}
