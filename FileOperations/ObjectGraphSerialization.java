import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Serializable classes
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}

class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    @Override
    public String toString() {
        return "Department{name='" + name + "', employees=" + employees + "}";
    }
}

public class ObjectGraphSerialization {
    public static void main(String[] args) {
        // Create department with employees
        Department dept = new Department("Engineering");
        dept.addEmployee(new Employee("Bob", 50000));
        dept.addEmployee(new Employee("Charlie", 60000));

        // Serialize to file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("dept.ser"))) {
            out.writeObject(dept);
            System.out.println("Serialized: " + dept);
        } catch (IOException e) {
            System.err.println("Error serializing: " + e.getMessage());
        }

        // Deserialize from file
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("dept.ser"))) {
            Department deserialized = (Department) in.readObject();
            System.out.println("Deserialized: " + deserialized);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing: " + e.getMessage());
        }
    }
}