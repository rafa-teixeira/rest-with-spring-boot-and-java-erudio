package br.com.erudio.services;

import br.com.erudio.data.dto.v1.BookDTO;
import br.com.erudio.exception.RequiredObjectIsNullException;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.mapper.custom.BookMapper;
import br.com.erudio.model.Book;
import br.com.erudio.repository.BookRepository;
import br.com.erudio.services.assembler.BookAssembler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BookServices {

    private final Logger log =Logger.getLogger(BookServices.class.getName());

    private final BookRepository repository;
    private final BookMapper mapper;
    private final BookAssembler assembler;

    public BookServices(BookRepository repository, BookMapper mapper, BookAssembler assembler) {
        this.repository = repository;
        this.mapper = mapper;
        this.assembler = assembler;
    }

    public List<BookDTO> findAll(){
        log.info("Finding all books...");

        List<Book> entities = repository.findAll();

        return entities
                .stream()
                .map(mapper::toDTO)
                .map(assembler::toModel)
                .toList();
    }

    public BookDTO findById(Long id){
        log.info("Finding a book by the ID: " + id);

        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No books found by this id"));

        return assembler.toModel(mapper.toDTO(entity));
    }

    public BookDTO create(BookDTO dto){

        if (dto == null) throw new RequiredObjectIsNullException();

        log.info("Creating a book...");

        Book entity = mapper.toEntity(dto);
        entity =repository.save(entity);

        return assembler.toModel(mapper.toDTO(entity));
    }

    public BookDTO update(BookDTO dto){
        if (dto == null) throw new RequiredObjectIsNullException();

        log.info("Updating a book by the ID: " + dto.getId());

        Book entity = repository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setAuthor(dto.getAuthor());
        entity.setLaunchDate(dto.getLaunchDate());
        entity.setPrice(dto.getPrice());
        entity.setTitle(dto.getTitle());

        Book savedEntity = repository.save(entity);
        return assembler.toModel(mapper.toDTO(savedEntity));
    }

    public void delete(Long id){
        log.info("Deleting a book by the ID: " + id);

        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found with ID: " + id));

        repository.delete(entity);
    }
}