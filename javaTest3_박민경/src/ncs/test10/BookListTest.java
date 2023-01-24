package ncs.test10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BookListTest {

	public static void main(String[] args) {

		BookListTest test10 = new BookListTest();
		ArrayList<Book> list = new ArrayList<Book>();

		test10.storeList(list);
		test10.saveFile(list);
		List<Book> booksList = test10.loadFile();


	}

	public void storeList(List<Book> list) {

		Book book1 = new Book("자바의 정석", "남궁성", 30000, "도우출판", 0.15);
		Book book2 = new Book("열혈강의 자바", "구정은", 29000, "프리렉", 0.2);
		Book book3 = new Book("객체지향 자바", "금영욱", 30000, "북스홈", 0.1);

		list.add(book1);
		list.add(book2);
		list.add(book3);
	}

	public void saveFile(List<Book> list) {
		
		Properties prop = new Properties();
		
		for(int i = 0 ; i < list.size() ; i++) {
			for(Book book : list) {
			prop.setProperty("title" + Integer.toString(i), book.getTitle());
			prop.setProperty("author" + Integer.toString(i), book.getAuthor());
			prop.setProperty("price" + Integer.toString(i),Integer.toString(book.getPrice()));
			prop.setProperty("publisher" + Integer.toString(i), book.getPublisher());
			prop.setProperty("discountRate" + Integer.toString(i), Double.toString(book.getDiscountRate()));
			
			i++;

			}
		}
		
		try {
			prop.store(new FileOutputStream("src/ncs/test10/books.dat"), "books.dat");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Book> loadFile() {
		
		List<Book> bookList = null;
		Book book = null;
		Properties prop = new Properties();
		
		bookList = new ArrayList<>();
		
		try {
			prop.load(new FileInputStream("src/ncs/test10/books.dat"));
			
			for(int i = 0 ; i < bookList.size() ; i++) {
				book = new Book();
				
				book.setTitle(prop.getProperty("title" + Integer.toString(i)));
				book.setAuthor(prop.getProperty("author") + Integer.toString(i));
				book.setPrice(Integer.parseInt(prop.getProperty("price") + Integer.toString(i)));
				book.setPublisher(prop.getProperty("publisher") + Integer.toString(i));
				book.setDiscountRate(Double.parseDouble(prop.getProperty("discountRate") + Integer.toString(i)));
				
				bookList.add(book);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return bookList;
	}

	public void printList(List<Book> list) {
		
		

	}

}
