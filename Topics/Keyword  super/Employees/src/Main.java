//import java.util.Arrays;

class Employee {
    protected String name;
    protected String email;
    protected int experience;

    public Employee(String name, String email, int experience) {
        this.name = name;
        this.email = email;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getExperience() {
        return experience;
    }
}

class Developer extends Employee {
    private String mainLanguage;
    private String[] skills;

    public Developer(String name, String email, int experience, String mainLanguage, String[] skills) {
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = skills;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    public String[] getSkills() {
        return skills;
    }
}

class DataAnalyst extends Employee {
    private boolean phd;
    private String[] methods;

    public DataAnalyst(String name, String email, int experience, boolean phd, String[] methods) {
        super(name, email, experience);
        this.phd = phd;
        this.methods = methods;
    }

    public boolean isPhd() {
        return phd;
    }

    public String[] getMethods() {
        return methods;
    }
}

/*
class Test {
    public static void main(String[] args) {
        String[] skills = { "git", "Scala", "JBoss", "UML" };
        Developer developer = new Developer("Mary", "mary@mail.com", 3, "Java", skills);
        print(developer);
        String[] methods = { "neural networks", "decision tree", "bayesian algorithms" };
        DataAnalyst analyst = new DataAnalyst("John", "john@gmail.com", 2, true, methods);
        print(analyst);
    }

    public static void print(Developer developer) {
        System.out.println("Developer{" +
                "name='" + developer.getName() + '\'' +
                ", email='" + developer.getEmail() + '\'' +
                ", experience='" + developer.getExperience() + '\'' +
                ", mainLanguage='" + developer.getMainLanguage() + '\'' +
                ", skills=" + Arrays.toString(developer.getSkills()) +
                '}');
    }

    public static void print(DataAnalyst dataAnalyst) {
        System.out.println("DataAnalyst{" +
                "name='" + dataAnalyst.getName() + '\'' +
                ", email='" + dataAnalyst.getEmail() + '\'' +
                ", experience='" + dataAnalyst.getExperience() + '\'' +
                ", phd='" + dataAnalyst.isPhd() + '\'' +
                ", methods=" + Arrays.toString(dataAnalyst.getMethods()) +
                '}');
    }
}*/
