package com.deloitte.library.services;

import com.deloitte.library.dao.BooksDAO;
import com.deloitte.library.model.Books;

public class BookServiceImpl implements BooksInterfaceServices {

	// BookImpl b=new BookImpl();

	@Override
	public Books addBooks(String bookName, String bookPrice, String authorName) {
		Books book = new Books();
		// int bookId=id;
		// book.set
		book.setBookId(Books.getCounter());
		// String bookName=name;
		book.setBookName(bookName);
		// String bookPrice=price;
		book.setBookPrice(Double.parseDouble(bookPrice));
		// String bookAuthor=author;
		book.setBookAuthor(authorName);

		// return book;
		BooksDAO.addBook(book); // no need of object...since it is static method
		return book;

	}

	public Books displayBooks(int id, String name, double price, String author) {

		return null;

	}

}
