package refactored;

import refactored.Entities.Person;

import java.sql.SQLException;
import java.util.List;
/**
 * The <code>AdressDAO</code> class implements CRUD operations.
 *
 */
public interface AdressDAO {


    /**
     * Returns a list of persons with correspondent name.
     * @param name The person name
     * @return ....
     * @throws
     */
    public List<Person> findPersons(String name) throws SQLException;


    /**
     * Returns a person with correspondent name.
     * @param id The person id
     * @return ....
     * @throws
     */
    public Person findPerson(long id) throws SQLException;

    /**
     * Add person to database.
     * @param person The person name
     * @return ....
     * @throws
     */
    public void addPerson (Person person) throws SQLException;

    /**
     * Add person to database.
     * @return ....
     * @throws
     */
    public List<Person> getAll() throws SQLException;

}
