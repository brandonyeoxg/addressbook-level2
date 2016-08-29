package seedu.addressbook.data.address;

/**
 * Represent the block component of a person's address.
 */
public class Block implements AddressComponent<Integer> {
    private Integer number_;
    
    public Block(Integer number){
        number_ = number;
    }
    
    public Integer getValue(){
        return number_;
    }
}
