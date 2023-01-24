package ncs.test7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class PropTest {
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("name", "apple,banana,grape,orange,melon");
		prop.setProperty("price", "1200,2500,4500,800,5000");
		prop.setProperty("quantity", "3,2,5,10,2");
		
		fileSave(prop);
		fileOpen(prop);
		
	}
	
	public static void fileSave(Properties p) {
		
		try {
			p.storeToXML(new FileOutputStream("src/ncs/test7/data.xml"), "data.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void fileOpen(Properties p) {
		
		try {
			p.loadFromXML(new FileInputStream("src/ncs/test7/data.xml"));
			
			Fruit[] fruit = new Fruit[5];
			
			for(int i = 0 ; i < 5 ; i++) {
				String[] name = p.getProperty("name").split(",");			
				String[] price = p.getProperty("price").split(",");
				String[] quantity = p.getProperty("quantity").split(",");
				
				fruit[i] = new Fruit(name[i], Integer.parseInt(price[i]), Integer.parseInt(quantity[i]));
				
				System.out.println(i+1 + " " + fruit[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
