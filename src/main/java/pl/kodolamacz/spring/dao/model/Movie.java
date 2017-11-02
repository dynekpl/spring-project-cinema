package pl.kodolamacz.spring.dao.model;

public class Movie extends Entity {

    private String title;
    private String category;
    private String year;
    private int price; // in grosze

    public Movie(String title, String category, String year, int price) {
        this.title = title;
        this.category = category;
        this.year = year;
        this.price = price;
    }

    public Movie(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
