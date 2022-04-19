package cn.library.book;

public class Book {
    private int id;
    private String bk_name;
    private String author;
    private String publish;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBk_name() {
        return bk_name;
    }

    public void setBk_name(String bk_name) {
        this.bk_name = bk_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bk_name='" + bk_name + '\'' +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
