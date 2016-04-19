package br.com.mv.genkey;

public class FailTest extends Test {

	public void run() {
		should(false, "this test always fails");
	}
}