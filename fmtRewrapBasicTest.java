//fmtRewrapTest.java
//James Dressel
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

//TODO: happy path
//TODO: width shorter than word
//TODO: width same size as word
//TODO: line break
//TODO: white space
//TODO: no spaces
//TODO: non-printable

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
	
}
