package seedu.addressbook.parser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Name;

public class NameTest {
    
    private static final String ORIGINAL_NAME = "John K Doe";
    private static final String CASE_INSENSITIVE_NAME = "JoHn k DOe";

    @Test
    public void testIsExactName() throws IllegalValueException {
        Name name = new Name(ORIGINAL_NAME);
        Name other= new Name(ORIGINAL_NAME);
        assertTrue(name.isSimilar(other));
    }

    @Test
    public void testIsNull() throws IllegalValueException {
        Name name = new Name(ORIGINAL_NAME);
        Name other = null;
        
        assertFalse(name.isSimilar(other));
    }
    
    @Test
    public void testIsCaseInsensitive() throws IllegalValueException {
        Name name = new Name(ORIGINAL_NAME);
        Name other = new Name(CASE_INSENSITIVE_NAME);
        
        assertTrue(name.isSimilar(other));
    }
}
