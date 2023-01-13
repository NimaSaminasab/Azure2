package no.academy.bookservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository ;

    @GetMapping("/book")
    public List<Book> getbooks() {

        return (List<Book>) bookRepository.findAll();
    }
    @GetMapping("/book/{id}")
    public  Book getbook(@PathVariable long id){
        Optional<Book> book = bookRepository.findById(id) ;
        if(book.isPresent() )
            return book.get();
        return null ;
    }
    @PostMapping("/book")
    public Book postBook(@RequestBody Book book){
        return  bookRepository.save(book) ;
    }

    @PostMapping("/book/{id}")
    public Book oppdaterBook(@PathVariable long id,@RequestBody Book book){
       return bookRepository.save(book) ;
    }

    @DeleteMapping ("/book/{id}")
    public void deleteBook(@PathVariable long id){
        bookRepository.delete(bookRepository.findById(id).get());
    }

}
