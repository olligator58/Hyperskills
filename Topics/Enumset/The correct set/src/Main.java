import java.util.*;

public class Main {

    enum Element {
        FIRE, WIND, EARTH, SKY, WATER
    }

    public static void main(String[] args) {

        Set<Element> set = EnumSet.allOf(Element.class);

        System.out.println(set instanceof EnumSet);
        System.out.println(set);
    }
}