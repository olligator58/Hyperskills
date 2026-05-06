import java.io.*;

class UserProfile implements Serializable {
    private static final long serialVersionUID = 26292552485L;

    private String login;
    private String email;
    private transient String password;

    public UserProfile(String login, String email, String password) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    private void writeObject(ObjectOutputStream oos) throws Exception {
        oos.defaultWriteObject();
        oos.writeObject(encryptPassword(password));
    }

    private void readObject(ObjectInputStream ois) throws Exception {
        ois.defaultReadObject();
        password = decryptPassword((String) ois.readObject());
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    private String encryptPassword(String password) {
        return password.chars()
                .map(i -> i + 1)
                .mapToObj(i -> (char) i)
                .reduce("", (str, c) -> str + c, String::concat);
    }

    private String decryptPassword(String password) {
        return password.chars()
                .map(i -> i - 1)
                .mapToObj(i -> (char) i)
                .reduce("", (str, c) -> str + c, String::concat);
    }

    /*@Override
    public String toString() {
        return "UserProfile{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }*/
}

/*
class Testus {
    private static final String FILE_NAME = "C:\\Temp\\flud\\profile.dat";

    public static void main(String[] args) {
        UserProfile profile = new UserProfile("login", "email", "password");
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(profile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            UserProfile loadedProfile = (UserProfile) ois.readObject();
            System.out.println(loadedProfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/
