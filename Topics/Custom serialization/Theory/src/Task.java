import java.io.*;

public class Task {
  private static final String FILE_NAME = "C:\\Temp\\flud\\person.dat";

  public static void main(String[] args) {
    Person person = new Person("John", "Doe", 27, "qwerty");
    try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
         BufferedOutputStream bos = new BufferedOutputStream(fos);
         ObjectOutputStream oos = new ObjectOutputStream(bos)) {
      oos.writeObject(person);
    } catch (Exception e) {
      e.printStackTrace();
    }

    try (FileInputStream fis = new FileInputStream(FILE_NAME);
         BufferedInputStream bis = new BufferedInputStream(fis);
         ObjectInputStream ois = new ObjectInputStream(bis)) {
      Person loadedPerson = (Person) ois.readObject();
      System.out.println(loadedPerson);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

class Person implements Serializable {
  private static final long serialVersionUID = 1L;
  private String firstName;
  private String lastName;
  private int age;
  private transient String password;

  public Person(String firstName, String lastName, int age, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.password = password;
  }

  private void writeObject(ObjectOutputStream oos) throws Exception {
//        oos.defaultWriteObject();
    oos.writeUTF(firstName);
    oos.writeUTF(lastName);
    oos.writeInt(age);
  }

  private void readObject(ObjectInputStream ois) throws Exception {
//        ois.defaultReadObject();
    firstName = ois.readUTF();
    lastName = ois.readUTF();
    age = ois.readInt();
    password = "huy";
  }

  @Override
  public String toString() {
    return "Person{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", age=" + age +
            ", password='" + password + '\'' +
            '}';
  }
}
