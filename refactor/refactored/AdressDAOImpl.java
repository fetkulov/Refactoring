package refactored;

import refactored.Entities.Person;
import refactored.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdressDAOImpl implements AdressDAO {


    private DAOFactory daoFactory;

    /**
     * Construct an AdressDAOImpl for the given DAOFactory.
     *
     * @param daoFactory The DAOFactory to construct this AdressDAOImpl for.
     */
    AdressDAOImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }


    @Override
    public List<Person> findPersons(String name) throws SQLException{
        Person person = null;
        List<Person> result = new ArrayList<Person>();

        try( Connection connection = daoFactory.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT person_id, person_name,phone_number, p_date FROM AddressEntry WHERE person_name = ? ");)
          {
            pstmt.setString(1, name);

            try(ResultSet resultSet = pstmt.executeQuery();){
                 if (resultSet.next()) {
                    person = new Person(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4));
                    result.add(person);
                }
             }
          } catch (SQLException e) {
              throw new DAOException(e);
          }

        return result;
    }

    @Override
    public Person findPerson(long id) throws SQLException {

        Person person = null;

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                "SELECT person_name,phone_number, p_date FROM AddressEntry WHERE person_id = ? ");){

            pstmt.setLong(1, id);

            try (ResultSet resultSet = pstmt.executeQuery()){
                person = new Person(id, resultSet.getString(1), resultSet.getString(2),
                    resultSet.getDate(3));
              if (resultSet.next()) {
                person = new Person(id, resultSet.getString(1), resultSet.getString(2),
                        resultSet.getDate(3));
              }
            }

        } catch (SQLException e) {
          throw new DAOException(e);
        }
      return person;
    }

    @Override
    public void addPerson(Person person) throws SQLException {

        try (Connection connection = daoFactory.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
              "INSERT INTO AddressEntry VALUES (AddressEntry_seq.NEXTVAL, ?,?,?)");){

            pstmt.setString(1, person.getName());
            pstmt.setDate(2, new java.sql.Date(person.getDate().getTime()));
            pstmt.setString(3, person.getPhoneNumber().getNumber());
            pstmt.execute();
        } catch (SQLException sqlEx) {
            throw new DAOException(sqlEx);
        }
    }

    @Override
    public List<Person> getAll() throws SQLException {
        List<Person> result = new ArrayList<Person>();
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT person_id, person_name, p_date FROM AddressEntry");) {
            try (ResultSet resultSet = pstmt.executeQuery();) {


                while (resultSet.next()) {
                    result.add(new Person(resultSet.getLong(0), resultSet.getString(1), resultSet.getString(2),
                            resultSet.getDate(3)));
                }
                // if zero entities - throws error
                if (result.size() == 0) {
                    throw new DAOException("Inconsistent Database!");
                }
            }

        } catch (SQLException sqlEx) {
            throw new DAOException(sqlEx);
        }
        return result;
    }
    /**
     * Close PreparedStatement and Connection. It is not correct for Java 7 because
     * those interfaces implements AutoCloseable.
     @param  pstmt
      *         value for PreparedStatement
     @param  connection
      *         value for Connection

     **/
    private void close(PreparedStatement pstmt, Connection connection) throws SQLException {

        if (pstmt != null) {
            pstmt.close();
        }

        if (connection != null) {
            connection.close();
        }
    }
}
