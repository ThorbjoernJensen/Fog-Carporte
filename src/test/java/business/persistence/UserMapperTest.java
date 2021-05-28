package business.persistence;

import business.entities.User;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.*;

public class UserMapperTest {

    private final static String DATABASE = "carport";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "carport";
    private final static String PASSWORD = "carport";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static UserMapper userMapper;

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            userMapper = new UserMapper(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach
    public void setUp() {
            // reset test database
            try ( Statement stmt = database.connect().createStatement() ) {
                stmt.execute("drop table if exists user");
                stmt.execute("create table " + TESTDATABASE + ".user LIKE " + DATABASE + ".user;" );
                stmt.execute(
                    "insert into user values " +
                    "('Nick','jens@somewhere.com','555','5','customer','lolgade','3700')");
            } catch (SQLException ex) {
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull(database);
    }

      @Test
    public void testLogin() throws UserException {
        // We should get an exception if we use the wrong password
        assertThrows(UserException.class, () ->
            {User user = userMapper.login( "jens@somewhere.com", "8" ); });

    }

    @Test
    public void testLogin03() throws UserException {
        // Jens is supposed to be a customer
        User user = userMapper.login( "jens@somewhere.com", "5" );
        assertEquals( "customer", user.getRole() );
    }

}
