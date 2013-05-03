/**
 * 
 */
package jp.happyhacking70.cum3.presSvr.seshLyr;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface SeshMgrPresSvrDisconIntf {
	void audDisconned(String seshName, String audName);

	void prestrDisconned(String seshName);
}
