
package org.example.model;

public class Article {

    private Long id;
    private String title;
    private String authors;
    private int year;

    public Article(Long id, String title, String authors, int year) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public int getYear() {
        return year;
    }
}
