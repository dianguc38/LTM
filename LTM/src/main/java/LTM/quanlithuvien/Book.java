package LTM.quanlithuvien;

import java.io.Serializable;

public class Book implements Serializable {

    private int id;
    private String name;
    private String author;
    private int total;
    private int remain;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        return "[" + id +"]Book: " + name + "   [Author: " + author + "  -  Total: " + total + "   -   remain: " + remain + "]";
    }
}
