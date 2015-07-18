package refactored.Entities;

/**
 * The <code>PhoneNumber</code> class represents Phone number.
 *
 */

public class PhoneNumber {

    private String number;


/**
 * Initializes a newly created {@code PhoneNumber} object so that it represent Phone number.
 **/
    public PhoneNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

}
