package summer21jdbc;
/*
By the help of JDBC (Java Database Connectivity),
Making a connection to a database.
Creating SQL  statements.
Executing SQL queries in the database.
Viewing & Modifying the resulting records.	
 */

//1.Step:Having phone means "importing SQL Package"
import java.sql.*;

public class JdbcExecuteQuery01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//2.Step: Registering gsm operator means "registering to our driver(Oracle Driver)"
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//3.Step:Call your friend means "establish connection with the database"
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "taner1", "1987");
		
		//4.Step: Create some sentences to tell to your friend means "Create Statement"
		Statement st = con.createStatement();
		
		//5.Step:Start to talk with your friend means "Create SQL Query and execute it"
		
		//1. Example:
		String q1 = "SELECT * FROM my_companies";//my query.in java the queries are String
		ResultSet r1 = st.executeQuery(q1);//sending(execute) my q1 to database than will get the Resultset(obj), it will be unique.
		//executeQuery() going to database and get the data than by ResultSet object , we store in resultset r1  obj
		
		
		//6.Step: Do some actions according to the result
		while(r1.next()) {
			System.out.println(r1.getInt(1) + " - " + r1.getString(2));
								//column name or column index		//column name or column index
			// 1. column int, 2.column string in table
			// 
		}
		
		System.out.println("===================");
		
		//2. Example:
		String q2 = "SELECT * FROM my_companies WHERE company_id < 102";
		
		ResultSet r2 = st.executeQuery(q2);
		//Note: Inside the get methods both column name and column index can be used
		while(r2.next()) {
			System.out.println(r2.getString("company_name"));
		}
		
		System.out.println("===================");
		
		//3.Example: Select third company_id and company_name after sorting in descending order
		String q3 = "SELECT company_id, company_name "
				  + "FROM my_companies "
				  + "ORDER BY company_id DESC "
				  + "OFFSET 2 ROW "
				  + "FETCH NEXT 1 ROW ONLY";
		ResultSet r3 = st.executeQuery(q3);
		while(r3.next()) {
			System.out.println(r3.getInt("company_id") + " --> " + r3.getString("company_name"));
										//column name or column index		//column name or column index
		
		}
		
		System.out.println("===================");
		
		//4.Example: Select the company whose id is the second lowest
		String q4 = "SELECT company_name FROM my_companies ORDER BY company_id ASC OFFSET 1 ROW FETCH NEXT 1 ROW ONLY";
		ResultSet r4 = st.executeQuery(q3);
		while(r4.next()) {
			System.out.println(r4.getString("company_name"));
		}
		
		//7.Step: End the call means "Close the DB Connection"
		con.close();
		st.close();
		r1.close();
		r2.close();
		r3.close();
		r4.close();
	}
}
