class Movie {
    private String title;
    private String desc;
    private int year;

    public Movie(String title, String desc, int year) {
        this.title = title;
        this.desc = desc;
        this.year = year;
    }

    public Movie(String title, int year) {
        this.title = title;
        this.desc = "empty";
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getYear() {
        return year;
    }
}

class Test {
    public static void main(String[] args) {
        Movie movie = new Movie("Mission impossible", "Action", 1998);
        System.out.println("title:" + movie.getTitle() + ",desc:" + movie.getDesc() + ",year:" + movie.getYear());
        movie = new Movie("F1", 2025);
        System.out.println("title:" + movie.getTitle() + ",desc:" + movie.getDesc() + ",year:" + movie.getYear());
    }
}