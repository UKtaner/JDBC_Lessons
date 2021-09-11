package summer21jdbc;
import java.sql.*;
public class Test01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Class.forName("oracle.jdbc.driver.OracleDriver");	
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "taner1", "1987");
		Statement st = con.createStatement();

//	Create a function which returns the name of a student from students table when you enter student id 
		
		String q1="CREATE OR REPLACE FUNCTION addF(a NUMBER, b NUMBER)"
				+ "RETURN NUMBER IS"
					+ "BEGIN"
					+ "		RETURN a+b"
					+ "END;";
		boolean isCreated=st.execute(q1);
		System.out.println(!isCreated);
	
		CallableStatement cst = con.prepareCall("{? = call additionf(?, ?)}");
    	
    	cst.registerOutParameter(1, Types.INTEGER);
    	cst.setInt(2, 15);
    	cst.setInt(3, 17);
    	
    	cst.execute();
    	
    	System.out.println("The result: " + cst.getInt(1));//12
		
		
		con.close();
		st.close();
		
		
		
		}
}

		