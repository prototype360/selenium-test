package test.util;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import selenium.steps.Login;
import selenium.util.SeleniumConfig;

/**
 * Unit test for simple App.
 */
public class RunTest extends SeleniumConfig
{
	@Before
	public void startUp() throws FileNotFoundException, IOException {
		startBrowser();
	}
	
    /**
     * Rigorous Test :-)
     * @throws Exception 
     */
    @Test
    public void shouldAnswerWithTrue() throws Exception
    {
    	Login loginTest = new Login();
    	loginTest.loginSteps();
        assertTrue( true );
    }
    
    @After
    public void tearDown() throws IOException {
    	closeBrowser();
    }
    
}
