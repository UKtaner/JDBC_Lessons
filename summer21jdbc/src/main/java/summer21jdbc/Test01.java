package summer21jdbc;
import java.sql.*;
public class Test01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Class.forName("oracle.jdbc.driver.OracleDriver");	
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "taner1", "1987");
		Statement st = con.createStatement();
		
		//1.Example: Insert 104 and Huavei into my_companies table
		
//		//String q1="INSERT INTO my_companies VALUES(104,'AAAA')";
//		String q1="INSERT INTO my_companies (company_id,company_name) VALUES(201,'BBBB')";
//		//INSERT INTO my_companies (company_id,company_name) VALUES(201,"BBBB");
//		int r1=st.executeUpdate(q1);
//		System.out.println(r1+"row/s inserted.");
//			
		
//	String q2="SELECT * FROM my_companies";
//	ResultSet r2=st.executeQuery(q2);
//	
//	while(r2.next()) {
//		System.out.println(r2.getInt(1)+"==>"+r2.getString(2));
//	}
	//2.Example: Change HUAVEI to SAMSUNG
	
	String q3="UPDATE my_companies SET company_name='BBB' WHERE company_name='GOOGLE'";
	
	int r3=st.executeUpdate(q3);
	System.out.println(r3+"updated");
	
	
	
	
	con.close();
	st.close();
	//r2.close();
	
	
		}
}

		