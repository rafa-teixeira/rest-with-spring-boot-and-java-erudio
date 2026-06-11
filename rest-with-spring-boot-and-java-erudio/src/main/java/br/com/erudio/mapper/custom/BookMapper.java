package br.com.erudio.mapper.custom;

import br.com.erudio.data.dto.v1.BookDTO;
import br.com.erudio.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public BookDTO toDTO(Book entity){
        BookDTO dto = new BookDTO();

        dto.setId(entity.getId());
        dto.setAuthor(entity.getAuthor());
        dto.setLaunchDate(entity.getLaunchDate());
        dto.setPrice(entity.getPrice());
        dto.setTitle(entity.getTitle());

        return dto;
    }

    public Book toEntity(BookDTO dto){
        Book entity = new Book();

        entity.setId(dto.getId());
        entity.setAuthor(dto.getAuthor());
        entity.setLaunchDate(dto.getLaunchDate());
        entity.setPrice(dto.getPrice());
        entity.setTitle(dto.getTitle());

        return entity;
    }
}
