package br.com.erudio.controllers;

import br.com.erudio.data.dto.v1.BookDTO;
import br.com.erudio.services.BookServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book/v1")
public class BookController {

    private final BookServices service;

    public BookController(BookServices service) {
        this.service = service;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<BookDTO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BookDTO findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO create (@RequestBody BookDTO dto){return service.create(dto);}

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO update (@RequestBody BookDTO dto){return service.update(dto);}

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
