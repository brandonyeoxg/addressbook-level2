package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Association class for Person and Tag
 * Contains the history of the tag that linked to the person and the tag type(Added or Deleted)
 */
public class Tagging {
    private static final String TAG_DELETE_SYMBOL = "-";
    private static final String TAG_ADD_SYMBOL = "+";
    
    private final Person person;
    private final Tag tag;
    private final TagType tagType;

    public Tagging(Person person, Tag tag, TagType tagType) {
        this.person = person;
        this.tag = tag;
        this.tagType = tagType;
    }

    public String toString() {
        return tagTypeFormat() + " " + person.getName() + " [" + tag.tagName + "]";
    }

    /**
     * Formats the tagging based on the tag type, ADD or DELETE
     * @return The symbol associated to the corresponding tag type
     */
    private String tagTypeFormat(){
        String output = "";
        switch (tagType) {
        case ADD:
            output = TAG_ADD_SYMBOL;
            break;
        case DELETE:
            output = TAG_DELETE_SYMBOL;
            break;
        }
        return output;
    }
}
