package com.example.library.service;

import com.example.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    private final Map<Integer, Book> bookStore = new HashMap<>();
    private int currentId = 1;

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookStore.values());
    }

    public Book getBookById(Integer id) {
        return bookStore.get(id);
    }

    public Book addBook(Book book) {
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }
        book.setId(currentId++);
        bookStore.put(book.getId(), book);
        return book;
    }

    public boolean deleteBook(Integer id) {
        return bookStore.remove(id) != null;
    }

    public Book updateAvailability(Integer id, Boolean available) {
        Book book = bookStore.get(id);
        if (book != null) {
            book.setAvailable(available);
        }
        return book;
    }
}
