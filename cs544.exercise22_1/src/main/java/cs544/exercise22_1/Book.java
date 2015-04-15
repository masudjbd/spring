package cs544.exercise22_1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;
    @NotNull(message = "title should not empty")
    private String title;
//    @Pattern(regexp = "\\d{3-\\d{10}",message="ISBN invalid ")
    private String ISBN;
     @NotNull(message = "author should not empty")
    private String author;
    private double price;

    public Book() {
        super();
    }

    public Book(String title, String iSBN, String author, double price) {
        super();
        this.title = title;
        ISBN = iSBN;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
