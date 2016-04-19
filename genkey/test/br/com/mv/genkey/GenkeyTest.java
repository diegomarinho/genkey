package br.com.mv.genkey;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GenkeyTest {

	private static GenKey genKey;
	private static Runtime runtime;
	private static Process processo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		genKey = new GenKey();
		runtime = Runtime.getRuntime();
		processo = null;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testImportCommand() throws IOException {
		
		String aliasName = "nfse";
		String keystoreFilePath = "C:\\cert\\keystore.cer";
		String storepass = "123456";
		String cerFilePath = "C:\\cert\\cert.cer";
		
		processo = runtime.exec("cmd /c start Import.bat " + aliasName + " " + keystoreFilePath + " " + storepass + " " + cerFilePath);
		
	}

}
