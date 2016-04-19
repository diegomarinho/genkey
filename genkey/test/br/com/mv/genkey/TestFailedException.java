package br.com.mv.genkey;

public class TestFailedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TestFailedException(String aMessage) {
		super(aMessage);
	}
}