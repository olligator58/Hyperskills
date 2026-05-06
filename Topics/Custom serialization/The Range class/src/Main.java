import java.io.*;

/**
 * Represents inclusive integer range.
 */
class Range implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @serial
     */
    private final int from;
    /**
     * @serial
     */
    private final int to;

    /**
     * Creates Range.
     *
     * @param from start
     * @param to   end
     * @throws IllegalArgumentException if start is greater than end.
     */
    public Range(int from, int to) {
        if (from > to) {
            throw new IllegalArgumentException("Start is greater than end");
        }
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    private void readObject(ObjectInputStream ois) throws Exception {
        ois.defaultReadObject();
        if (from > to) {
            throw new IllegalArgumentException("Start is greater than end");
        }
    }

}

/*
class Testus {
    private static final String FILE_NAME = "C:\\Temp\\flud\\range.dat";

    public static void main(String[] args) {
        Range range = new Range(2, 1);
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(range);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            Range loadedRange = (Range) ois.readObject();
            System.out.println(loadedRange);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/
