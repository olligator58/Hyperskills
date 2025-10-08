class Army {

    public static void createArmy() {
        Unit unit1 = new Unit("Cannon");
        Unit unit2 = new Unit("Truck");
        Unit unit3 = new Unit("Plane");
        Unit unit4 = new Unit("Tank");
        Unit unit5 = new Unit("Rocket missile");

        Knight knight1 = new Knight("Arthur");
        Knight knight2 = new Knight("Lancelot");
        Knight knight3 = new Knight("Charles");

        General general = new General("Smith");

        Doctor doctor = new Doctor("Livesey");
    }

    static class Unit {
        static String nameUnit;
        static int countUnit;

        public Unit(String name) {
            countUnit++;
            nameUnit = name;

        }
    }

    static class Knight {
        static String nameKnight;
        static int countKnight;

        public Knight(String name) {
            countKnight++;
            nameKnight = name;

        }
    }

    static class General {
        static String nameGeneral;
        static int countGeneral;

        public General(String name) {
            countGeneral++;
            nameGeneral = name;

        }
    }

    static class Doctor {
        static String nameDoctor;
        static int countDoctor;

        public Doctor(String name) {
            countDoctor++;
            nameDoctor = name;

        }
    }

    public static void main(String[] args) {
        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

}