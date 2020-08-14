package LTM.quanlithuvien;

import java.io.Serializable;
import java.util.List;

public class Message implements Serializable {

    private int choice;
    private List<Book> Listbooks;
    private Book book;
    private String name;
    private String res;

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public List<Book> getListbooks() {
        return Listbooks;
    }

    public void setListbooks(List<Book> listbooks) {
        Listbooks = listbooks;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

}
