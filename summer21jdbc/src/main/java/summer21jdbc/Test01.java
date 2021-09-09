package summer21jdbc;
import java.sql.*;
public class Test01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Class.forName("oracle.jdbc.driver.OracleDriver");	
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "taner1", "1987");
		Statement st = con.createStatement();

		String q1 ="CREATE OR REPLACE FUNCTION addF(x NUMBER, Y NUMBER, z NUMBER)"
				+ "RETURN NUMBER IS"
				+ "BEGIN "
				+ "RETURN x+y+z"
				+ "END;";
		
		boolean isFuncCreated = st.execute(q1);
		System.out.println("Was the addition function created? " + !isFuncCreated);
		CallableStatement cst = con.prepareCall("{? = call additionf(?, ?, ?)}");
		
		
		
		con.close();
		st.close();
		
		
		
		}
}

		