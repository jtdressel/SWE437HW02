//fmtRewrapTest.java
//James Dressel
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

//TODO: happy path
//TODO: width shorter than word
//TODO: width same size as word
//TODO: empty string
//TODO: line break
//TODO: white space
//TODO: zero size
//TODO: negative size
//TODO: no spaces
//TODO: all spaces
//TODO: non-printable

/**
 * Test file for fmtRewrap
 * @author James Dressel
 * 
 */
public class fmtRewrapBasicTest {

	@Before
	public void setUp() throws Exception {
		String input;
		String expected;
		int length;
	}

	
	@Test
	public void nullStringTest(){
		try{
			fmtRewrap.fmtRewrap(null,10);
			fail("Should have NullPointerException");
		}catch(NullPointerException e){
			
		}
	}


}
