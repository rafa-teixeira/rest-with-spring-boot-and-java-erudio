package br.com.erudio.services.assembler;

import br.com.erudio.controllers.BookController;
import br.com.erudio.data.dto.v1.BookDTO;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BookAssembler {

    public BookDTO toModel(BookDTO dto){
        dto.add(
                linkTo(methodOn(BookController.class)
                        .findById(dto.getId()))
                        .withSelfRel()
        );
        return dto;
    }
}