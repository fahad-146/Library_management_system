package com.whiteBin.student_library_management_system.controller;

import com.whiteBin.student_library_management_system.model.Book;
import com.whiteBin.student_library_management_system.requestdto.BookRequestDto;
import com.whiteBin.student_library_management_system.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/api")
public class BookController {

    //declaring the logger
    Logger logger= LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public String saveBook(@RequestBody BookRequestDto bookRequestDto){
        String response= bookService.saveBook(bookRequestDto);
        return response;
    }

    @GetMapping("/findAll")
    public List<Book> getAllBook() {
        List<Book> bookList = bookService.getAllBook();
        return bookList;
    }

    @GetMapping("/findPage")
    public List<Book> getAllBookBasedOnPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        List<Book> bookList = bookService.getBookOnPagination(pageNo,pageSize);
        return bookList;

    }

    @GetMapping("/findByTitle")
    public ResponseEntity<?> findByTitle(@RequestParam("title") String title){
        logger.info("getBookByTitle API started");
        try {
            Book book = bookService.getBookByTitle(title);
            logger.info("api ended");
            return ResponseEntity.ok(book);
        }catch(Exception e){
            logger.error("getBookByTitle got some error");
            return ResponseEntity.internalServerError().body("some exception occured "+e.getMessage());
        }
    }

    @GetMapping("/findByGenre")
    public List<Book> findByGenre(@RequestParam("genre") String genre){
        List<Book> bookList = bookService.getBookByGenre(genre);
        return bookList;
    }

}
