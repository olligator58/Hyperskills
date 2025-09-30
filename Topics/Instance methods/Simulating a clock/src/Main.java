class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        minutes++;
        if (minutes == 60) {
            minutes = 0;
            hours++;
        }
        if (hours == 13) {
            hours = 1;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Clock clock = new Clock();
        /*System.out.println(clock.hours + ":" + clock.minutes);
        clock.next();
        System.out.println(clock.hours + ":" + clock.minutes);
        clock.hours = 10;
        clock.minutes = 59;
        System.out.println(clock.hours + ":" + clock.minutes);
        clock.next();
        System.out.println(clock.hours + ":" + clock.minutes);*/
        clock.hours = 11;
        clock.minutes = 59;
        System.out.println(clock.hours + ":" + clock.minutes);
        for (int i = 0; i < 720; i++) {
            clock.next();
            System.out.println(clock.hours + ":" + clock.minutes);
        }

    }
}