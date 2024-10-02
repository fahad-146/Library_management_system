package com.whiteBin.student_library_management_system.service;


import com.whiteBin.student_library_management_system.converter.BookConverter;
import com.whiteBin.student_library_management_system.model.Author;
import com.whiteBin.student_library_management_system.model.Book;
import com.whiteBin.student_library_management_system.repository.AuthorRepository;
import com.whiteBin.student_library_management_system.repository.BookRepository;
import com.whiteBin.student_library_management_system.requestdto.BookRequestDto;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    Logger logger = LoggerFactory.getLogger(BookService.class);
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public String saveBook(BookRequestDto bookRequestDto){
        Book book= BookConverter.convertBookRequestDtoIntoModel(bookRequestDto);

        //we find the author detail using id
        Author author=authorRepository.findById(bookRequestDto.getAuthorId()).get();
        book.setAuthor(author);
        bookRepository.save(book);
        return "book saved";
    }

    public List<Book> getAllBook(){
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    public List<Book> getBookOnPagination(int pageNo, int pageSize){
       Page<Book> bookPage = bookRepository.findAll(PageRequest.of(pageNo,pageSize));
       List<Book> bookList= new ArrayList<>();
       for(Book book: bookPage){
           bookList.add(book);
       }
       return bookList;

    }

    public List<Book> getBookOnPagination(int pageNo, int pageSize, String sortParameter){
        Page<Book> bookPage= bookRepository.findAll(PageRequest.of(pageNo, pageSize, Sort.by(sortParameter).ascending()));
        List<Book> bookList = new ArrayList<>();
        for(Book book: bookPage){
            bookList.add(book);
        }
        return bookList;
    }
    public Book getBookByTitle(String title){
        logger.info("getBookByTitle method started");
        Book book = bookRepository.findByTitle(title);
        if(book==null){
            logger.info("getBookbytitle cause some error");
            throw new RuntimeException(("Book not found"));

        }
        return book;
    }
    public List<Book> getBookByGenre(String genre){
        List<Book> bookList = bookRepository.getBookByGenre(genre);
        return bookList;
    }
    public Book getBookByTitleAndPages(String title, int pages){
        Book book= bookRepository.findByTitleAndPages(title,pages);
        return book;
    }

    public List<Book> getBookByPages(int pages){
        List<Book> bookList = bookRepository.findByPages(pages);
        return bookList;
    }
}
