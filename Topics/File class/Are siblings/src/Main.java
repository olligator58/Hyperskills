import java.io.File;

class Siblings {

    public static boolean areSiblings(File f1, File f2) {
        return f1.getParent().equals(f2.getParent());
    }
}

class Testus {
    public static void main(String[] args) {
        System.out.println(Siblings.areSiblings(new File("dir/file1.txt"), new File("dir/file2.txt")));
        System.out.println(Siblings.areSiblings(new File("dir1/file1.txt"), new File("dir2/file2.txt")));
    }
}