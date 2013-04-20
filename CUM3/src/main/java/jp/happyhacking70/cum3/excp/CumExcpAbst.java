package jp.happyhacking70.cum3.excp;

/**
 * @author happyhacking70@gmail.com
 * 
 */
abstract public class CumExcpAbst extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public CumExcpAbst() {
		super();
	}

	/**
	 * @param cause
	 */
	public CumExcpAbst(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 */
	public CumExcpAbst(String message) {
		super(message);
	}

	public CumExcpAbst(String message, Throwable cause) {
		super(message, cause);
	}

}
