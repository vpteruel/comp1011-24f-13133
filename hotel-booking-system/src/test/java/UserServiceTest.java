import com.vinicius.hotelbookingsystem.users.UserEntity;
import com.vinicius.hotelbookingsystem.users.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserServiceTest {

    private static final String DB_URL = "jdbc:sqlite::memory:";

    @BeforeEach
    public void setup() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();

            String createTableSQL = """
CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL
)""";

            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            fail("Failed to set up the database: " + e.getMessage());
        }
    }

    @AfterEach
    public void teardown() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            stmt.execute("DROP TABLE IF EXISTS users");
        } catch (SQLException e) {
            fail("Failed to tear down the database: " + e.getMessage());
        }
    }

    @Test
    public void testAddUserSuccess() {
        UserEntity user = new UserEntity("john_doe", "password123");
        UserService.addUser(user);

        UserEntity retrievedUser = UserService.getUserByLogin("john_doe", "password123");
        assertNotNull(retrievedUser);
        assertEquals("john_doe", retrievedUser.getUsername());
    }

    @Test
    public void testAddDuplicateUser() {
        UserEntity user1 = new UserEntity("jane_doe", "password123");
        UserEntity user2 = new UserEntity("jane_doe", "password456");

        UserService.addUser(user1);
        UserService.addUser(user2);

        UserEntity retrievedUser = UserService.getUserByLogin("jane_doe", "password456");
        assertNull(retrievedUser, "Duplicate user should not be inserted");
    }
}
