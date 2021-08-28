package test.test1;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import test.test1.repository.TestDbConnector;


@SpringBootApplication
public class Test1Application {

	public static void main(String[] args) {
		SpringApplication.run(Test1Application.class, args);
		// TestDbConnector test = new TestDbConnector();
		// ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		// test.connect();
		// list = test.search("SELECT * FROM student_info");
		// for(HashMap<String,Object> row : list){
		// 	System.out.println(row.get("name"));
		// }
		// test.close();
	}

}
