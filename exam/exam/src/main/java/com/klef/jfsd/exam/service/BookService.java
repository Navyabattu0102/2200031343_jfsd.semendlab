package com.klef.jfsd.exam.service;

import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
        
        existingBook.setTitle(bookDetails.getTitle());
        existingBook.setAuthor(bookDetails.getAuthor());
        existingBook.setGenre(bookDetails.getGenre());
        existingBook.setPrice(bookDetails.getPrice());
        existingBook.setPublishedYear(bookDetails.getPublishedYear());

        return bookRepository.save(existingBook);
    }
}
