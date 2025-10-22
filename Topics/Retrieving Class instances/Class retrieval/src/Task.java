// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) throws ClassNotFoundException {
    System.out.println(Class.forName(String.class.getClass().getName()));
    System.out.println("".getClass());
    System.out.println(String.class.getClass());
  }
}
