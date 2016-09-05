package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import javax.rmi.CORBA.UtilDelegate;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void testIsAnyNull() {
        assertTrue(Utils.isAnyNull(null, "Hello", 123, new Integer(10)));
    }
    
    @Test
    public void testIsAnyNotNull() {
        assertFalse(Utils.isAnyNull("hello",123,new Integer(20)));
    }

    @Test
    public void testElementsAreUnique() {
        List<Integer> testVals = new ArrayList<Integer>();
       
        for(int i = 0; i < 5; i++){
            testVals.add(i);
        }
        
        assertTrue(Utils.elementsAreUnique(testVals));
    }
    
    @Test
    public void testElementsAreNotUnique() {
        List<Integer> testVals = new ArrayList<Integer>();
        
        for(int i = 0; i < 5; i++){
            testVals.add(i);
        }
        testVals.add(0);
        
        assertFalse(Utils.elementsAreUnique(testVals));
    }

}
