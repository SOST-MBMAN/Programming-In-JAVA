import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

// Serializable class
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class BasicSerialization {
    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person("Alice", 25);

        // Serialize to file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            out.writeObject(person);
            System.out.println("Serialized: " + person);
        } catch (IOException e) {
            System.err.println("Error serializing: " + e.getMessage());
        }

        // Deserialize from file
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person deserialized = (Person) in.readObject();
            System.out.println("Deserialized: " + deserialized);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing: " + e.getMessage());
        }
    }
}