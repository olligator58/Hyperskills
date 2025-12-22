import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Article implements Comparable<Article> {
    private String title;
    private int size;

    public Article(String title, int size) {
        this.title = title;
        this.size = size;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int compareTo(Article otherArticle) {
        return (size != otherArticle.size) ? Integer.valueOf(size).compareTo(otherArticle.size) :
                title.compareTo(otherArticle.title);
    }

/*
    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", size=" + size +
                '}';
    }
*/
}

class Testus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String[] vals = sc.nextLine().split("-");
            articles.add(new Article(vals[0], Integer.parseInt(vals[1])));
        }
        Collections.sort(articles);
        System.out.println(articles);
        sc.close();
    }
}