package jp.happyhacking70.cum3.excp;

public class CumExcp extends Exception {
	private static final long serialVersionUID = 1L;

	public CumExcp() {
		super();
	}

	public CumExcp(Throwable cause) {
		super(cause);
	}

	public CumExcp(String message) {
		super(message);
	}

	public CumExcp(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
