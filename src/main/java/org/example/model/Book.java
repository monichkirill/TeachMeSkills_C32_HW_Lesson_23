package org.example.model;

public class Book {
    private String title;
    private String author;
    private int year;
    private int pages;
    private String genre;

    public Book() {
    }

    public Book(String title, String author, int year, int pages, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                ", genre='" + genre + '\'' +
                '}';
    }
}
