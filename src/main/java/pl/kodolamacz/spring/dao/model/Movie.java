package pl.kodolamacz.spring.dao.model;

public class Movie extends Entity{

  private String title;
  private int year;
  private String category;
  private int price;

  public Movie(Long id, String title, int year, String category, int price) {
    super(id);
    this.title = title;
    this.year = year;
    this.category = category;
    this.price = price;
  }

  public Movie(Long id, String title, int price) {
    super(id);
    this.title = title;
    this.year = 0;
    this.category = null;
    this.price = price;
  }

}
