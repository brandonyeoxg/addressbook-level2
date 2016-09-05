package seedu.addressbook.parser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Name;

public class NameTest {
    private static Name name;
    
    private static final String ORIGINAL_NAME = "John K Doe";
    private static final String CASE_INSENSITIVE_NAME = "JoHn k DOe";
    private static final String DIFFERENT_NAME = "Jane H Doe";
    private static final String DIFFERENT_ORDER_NAME = "Doe John K";
    private static final String SUBSET_NAME = "John Doe";
    private static final String SUPERSET_NAME = "John K Doe II";
    @Before
    public void setup() throws IllegalValueException {
        name = new Name(ORIGINAL_NAME);
    }
    
    @Test
    public void testIsExactName() throws IllegalValueException {
        Name other= new Name(ORIGINAL_NAME);
        assertTrue(name.isSimilar(other));
    }

    @Test
    public void testIsNull() throws IllegalValueException {
        Name other = null;
        assertFalse(name.isSimilar(other));
    }
    
    @Test
    public void testIsCaseInsensitive() throws IllegalValueException {
        Name other = new Name(CASE_INSENSITIVE_NAME);
        assertTrue(name.isSimilar(other));
    }
    
    @Test
    public void testIsNotSameName() throws IllegalValueException {
        Name other = new Name(DIFFERENT_NAME);
        assertFalse(name.isSimilar(other));
    }
    
    @Test
    public void testIsDifferentOrder() throws IllegalValueException {
        Name other = new Name(DIFFERENT_ORDER_NAME);
        assertTrue(name.isSimilar(other));
    }
    
    @Test
    public void testIsNameSupersetOfOther() throws IllegalValueException {
        Name other = new Name(SUBSET_NAME);
        assertTrue(name.isSimilar(other));
    }
    
    @Test
    public void testIsNameSubsetOfOther() throws IllegalValueException {
        Name other = new Name(SUPERSET_NAME); 
        assertTrue(name.isSimilar(other));
    }
}
