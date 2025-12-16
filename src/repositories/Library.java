package repositories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import models.Book;

public final class Library {

    private Library() {
    }

    private final static Map<String, Book> books = new HashMap<>();
    private final static File BOOKS_FILE = new File("books.txt");

    public static void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public static boolean removeBook(String id) {
        Book removedBook = books.remove(id);

        if (removedBook == null)
            return false;

        return true;
    }

    public static boolean sync() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books.values()) {
                bw.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getYear());
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean load() {
        if (!BOOKS_FILE.exists()) {
            return false;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length != 4) {
                    continue;
                }

                String id = parts[0];
                String title = parts[1];
                String author = parts[2];
                int year = Integer.parseInt(parts[3]);

                Book book = new Book(id, title, author, year);

                books.put(id, book);
            }

            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
