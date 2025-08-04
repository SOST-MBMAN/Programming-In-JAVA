import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Serializable class with custom serialization
class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private transient String password; // Not serialized
    private transient int loginCount;  // Not serialized, computed

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.loginCount = 0;
    }

    // Setter for loginCount
    public void setLoginCount(int count) {
        this.loginCount = count;
    }

    // Custom serialization
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // Serialize non-transient fields
        out.writeObject(password.toUpperCase()); // Custom handling for password
    }

    // Custom deserialization
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Deserialize non-transient fields
        this.password = (String) in.readObject(); // Restore password
        this.loginCount = 0; // Reset transient field
    }

    @Override
    public String toString() {
        return "User{username='" + username + "', password='" + password + "', loginCount=" + loginCount + "}";
    }
}

public class CustomSerialization {
    public static void main(String[] args) {
        // Create a User object
        User user = new User("alice", "secret");
        user.setLoginCount(5); // Will be reset on deserialization

        // Serialize to file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            out.writeObject(user);
            System.out.println("Serialized: " + user);
        } catch (IOException e) {
            System.err.println("Error serializing: " + e.getMessage());
        }

        // Deserialize from file
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.ser"))) {
            User deserialized = (User) in.readObject();
            System.out.println("Deserialized: " + deserialized);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing: " + e.getMessage());
        }
    }
}
