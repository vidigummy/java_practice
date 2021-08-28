package test.test1.repository;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import java.sql.ResultSetMetaData;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestDbConnector {
    Connection connection;
    public void connect() {
		// String url = "jdbc:mysql://localhost:3306/test?serverTimezone=KST";
        String url = "jdbc:mysql://localhost:3306/test";
		String user = "ryu";
		String password = "fbehddls1";
		String driverName = "com.mysql.cj.jdbc.Driver";

		try {
			// 하지만 개발자는 실제로 `com.mysql.cj.jdbc.Driver`를 다룰 일은 없다.
			// 내부적으로 JDBC가 알아서 다 해주기 때문에 우리는 JDBC의 DriverManager 를 통해서 DB와의 연결을 얻으면 된다.
			Class.forName(driverName);

			// ② 연결
			connection = DriverManager.getConnection(url, user, password);
            System.out.print("[DB 연결 성공] \n");
		} catch (ClassNotFoundException e) {
			// `com.mysql.cj.jdbc.Driver` 라는 클래스가 라이브러리로 추가되지 않았다면 오류발생
			System.out.println("[로드 오류]\n" + e.getStackTrace());
		} catch (SQLException e) {
			// DB접속정보가 틀렸다면 오류발생
			System.out.println("[연결 오류]\n" + e.getStackTrace());
        
            System.out.println(e);
		}
	}
    public boolean modify(String sql){
        Statement statement = null;
        boolean rs;
        
        try{
            statement = this.connection.createStatement();
            rs = statement.execute(sql);
            return rs;
        }catch(SQLException e){
            System.out.println(e.getStackTrace());
            return false;
        }
    }

    public ArrayList<HashMap<String,Object>> search(String sql){
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<HashMap<String,Object>> list  = new ArrayList<HashMap<String,Object>>();
        try{
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();

            
            ResultSetMetaData md = rs.getMetaData();
            int column = md.getColumnCount();
            while(rs.next()){
                HashMap<String,Object> row = new HashMap<String,Object>();
                for(int i =1; i <= column; i++){
                    row.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(row);
            }
            return list;
        }catch(SQLException e){
            System.out.println(e.getStackTrace());
            return null;
        }
    }

    public void close(){
        try{
            if(connection != null){
                System.out.println("안뇽DB");
                connection.close();
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
