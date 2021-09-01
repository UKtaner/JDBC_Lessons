package summer21jdbc;
import java.sql.*;//s1
public class Test01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");//s2
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "taner1", "1987");//s3
		
		Statement st = con.createStatement();//s4
		
		
		String q1="SELECT * FROM my_companies";
		ResultSet r1=st.executeQuery(q1);
		while(r1.next()) {
		
			
			
			
		System.out.println(r1.getInt(1)+" - "+ r1.getString(2));
		}		
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
}
}