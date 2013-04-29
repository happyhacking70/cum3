/**
 * 
 */
package jp.happyhacking70.cum3.cmd;

import java.util.List;

import jp.happyhacking70.cum3.chnlLyr.rsc.ChnlRscIntf;

/**
 * @author happyhacking70@gmail.com
 * 
 */
public interface CmdWithRscIntf {
	public void addRscData(ChnlRscIntf chnlRsc);

	public List<ChnlRscIntf> getRscData();
}
