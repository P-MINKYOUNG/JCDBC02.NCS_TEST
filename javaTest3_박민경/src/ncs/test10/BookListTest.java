package ncs.test10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BookListTest {

	public static void main(String[] args) {

		BookListTest test10 = new BookListTest();
		ArrayList<Book> list = new ArrayList<Book>();

		test10.storeList(list);
//		test10.saveFile(list);
//		List<Book> booksList = test10.loadFile();
//		test10.printList(booksList);

	}

	public void storeList(List<Book> list) {

		list.add(new Book("자바의 정석", "남궁성", 30000, "도우출판", 0.15));
		list.add(new Book("열혈강의 자바", "구정은", 29000, "프리렉", 0.2));
		list.add(new Book("객체지향 자바", "금영욱", 30000, "북스홈", 0.1));

	}

	public void saveFile(List<Book> list) {
		
		Properties prop = new Properties();
		
		list.iterator();
		
		

		
	}

	public List<Book> loadFile() {
		List<Book> bookList = null;
		
		return bookList;
	}

	public void printList(List<Book> list) {

		for(Book book : list) {
			System.out.println(list.toString());
			System.out.println("할인 된 가격 : " + (book.getPrice() - book.getPrice()*book.getDiscountRate()));
		}

	}

}
