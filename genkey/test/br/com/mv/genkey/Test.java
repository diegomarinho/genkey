package br.com.mv.genkey;

import java.io.IOException;

public class Test {
	
	public boolean success = false;
	public String result = "not run";

	public void run() throws RuntimeException, IOException {
	}

	public void should(boolean aTestPassed, String aMessage) {
		if (!aTestPassed) {
			throw new TestFailedException(aMessage);
		}
	}

	public void runAndCaptureAborts() throws IOException {
		try {
			runAndCaptureFailures();
		} catch (RuntimeException exception) {
			success = false;
			exception.fillInStackTrace();
			result = message("Aborted : " + exception.getMessage());
		}
	}

	private void runAndCaptureFailures() throws RuntimeException, IOException {
		try {
			runAndAllowExceptions();
		} catch (TestFailedException exception) {
			success = false;
			result = message("Failed : " + exception.getMessage());
		}
	}

	private void runAndAllowExceptions() throws TestFailedException, RuntimeException, IOException {
		run();
		success = true;
		result = message("Passed");
	}

	private String message(String aString) {
		return getClass().getName() + " : " + aString;
	}
}