//fmtRewrapTest.java
//James Dressel
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


/**
 * Test file for fmtRewrap
 * @author James Dressel
 * 
 */
public class fmtRewrapBasicTest {
	String input;
	String expected;
	int width;
	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Tests the happy path of execution
	 * 
	 * Ironically, this test fails because the formatter adds an extra new line
	 */
	@Test 
	public void happyPathTest(){
		input = "A test string";
		width = 10;
		expected = "A test \n string";
		assertEquals(expected,fmtRewrap.fmtRewrap(input, width));
	}
	
	@Test
	public void nullStringTest(){
		try{
			fmtRewrap.fmtRewrap(null,10);
			fail("Should have NullPointerException");
		}catch(NullPointerException e){
			
		}
	}

	@Test
	public void zeroSizeTest(){
		//Note, it does give ArrayIndexOutOfBoundsException, which is close
		//to what I have here, but it exposes the inner workings of the class
		//in a way that it should not. 
		input = "A test string";
		width = 0;
		try{
			System.out.print(fmtRewrap.fmtRewrap(input,width));
			fail("This code should have caused an IllegalArgumentException");
		} catch(IllegalArgumentException e){
			
		}
		
	}
	
	@Test
	public void negativeSizeTest(){
		//Note, it does give ArrayIndexOutOfBoundsException, which is close
		//to what I have here, but it exposes the inner workings of the class
		//in a way that it should not. 
		input = "A test string";
		width = -4;
		
		try{
			System.out.print(fmtRewrap.fmtRewrap(input,width));
			fail("This code should have caused an IllegalArgumentException");
		} catch(IllegalArgumentException e){
			
		}
		
	}
	
	/**
	 * Test when given an empty String.
	 * Note: This test fails because it returns an extra line break. I chose
	 * to interpret the expected behavior to not add a line break. 
	 */
	@Test
	public void emptyStringTest(){
		input = "";
		expected = "";
		width = 10;
		assertEquals(expected, fmtRewrap.fmtRewrap(input,width));
	}
	
	/**
	 * Test when given all spaces
	 * Note: This test fails because it returns an extra line break. I chose
	 * to interpret the expected behavior to not add a line break. 
	 */
	@Test
	public void allSpacesTest(){
		input = "            ";
		expected = "            ";
		width = 10;
		assertEquals(expected, fmtRewrap.fmtRewrap(input,width));
	}
	
	/**
	 * Test when the string contains a new line
	 * The formatter should remove any newlines. 
	 * Note: This test fails because it returns an extra line break. I chose
	 * to interpret the expected behavior to not add a line break. 
	 */
	@Test
	public void newLineTest(){
		input = "Test \n test";
		expected = "Test \n test";
		width = 10;
		assertEquals(expected, fmtRewrap.fmtRewrap(input,width));
	}
	

	/**
	 * Test when the string contains a word this is longer than the width. 
	 */
	@Test
	public void wordLongerThanWidthTest(){
		input = "Thisisareallylongword";
		expected = "Thisisarea\nllylongwor\nd";
		width = 10;
		assertEquals(expected, fmtRewrap.fmtRewrap(input,width));
	}
	
}
