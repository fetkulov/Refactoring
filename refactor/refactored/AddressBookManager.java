package refactored;

import refactored.Entities.Person;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * The <code>AddressBookManager</code> class represents Manager like additional tier.
 * For test purposes returns null values
 */
public class AddressBookManager {

    /**
     * Returns a list of person's mobiles with correspondent name.
     *
     * @param name The person name
     * @return ....
     * @throws
     */
    public String getMobile(String name) throws Exception {
        DAOFactory daoFactory = DAOFactory.getInstance("jdbc");
        AdressDAO adressDAO = daoFactory.getUserDAO();
        List<Person> persons = null;
        try {
            persons = adressDAO.findPersons(name);
            for (Person person : persons) {
                // create phone list, etc
            }
            return null;
        } catch (SQLException sqlExc) {
            // Provide info about problem during close resources
            // Some Exception could be thrown depends of chain of responsibility
        }
       return null;

    }

    /**
     * Returns all names in the book. Truncates to the given length.
     */
    public List getNames(int maxLength) {
        return null;

    }

    /**
     * Returns all people who have mobile phone numbers.
     */
    public List getList() {

        return null;
    }

}
