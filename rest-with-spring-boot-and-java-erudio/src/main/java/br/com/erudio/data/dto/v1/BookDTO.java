package br.com.erudio.data.dto.v1;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class BookDTO extends RepresentationModel<BookDTO> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String author;
    private String launchDate;
    private Long price;
    private String title;

    public BookDTO(){};

    public BookDTO(Long id, String author, String launchDate, Long price, String title) {
        this.id = id;
        this.author = author;
        this.launchDate = launchDate;
        this.price = price;
        this.title = title;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getLaunchDate() {
        return launchDate;
    }
    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }
    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookDTO bookDTO = (BookDTO) o;
        return Objects.equals(getId(), bookDTO.getId()) && Objects.equals(getAuthor(), bookDTO.getAuthor()) && Objects.equals(getLaunchDate(), bookDTO.getLaunchDate()) && Objects.equals(getPrice(), bookDTO.getPrice()) && Objects.equals(getTitle(), bookDTO.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getAuthor(), getLaunchDate(), getPrice(), getTitle());
    }
}