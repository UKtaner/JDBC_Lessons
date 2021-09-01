package summer21jdbc;
import java.sql.*;
public class JdbcExecuteQueryDT02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "taner1", "1987");
		
		// Create a statement

				Statement st = con.createStatement();

				// Execute query and store the result

				// Select the second highest Salary from Employees Table

				String q2 = "SELECT salary FROM employees ORDER by Salary DESC OFFSET 1 ROW FETCH NEXT 1 ROW ONLY";
				ResultSet rs2 = st.executeQuery(q2);

				while (rs2.next()) {
					System.out.println(rs2.getInt(1));
				}

				// Select all data about the worker who has the third lowest salary

				String q3 = "SELECT * FROM employees ORDER BY salary ASC OFFSET 2 ROW FETCH NEXT 1 ROW ONLY";

				ResultSet rs3 = st.executeQuery(q3);

				while (rs3.next()) {
					System.out.println(
							rs3.getInt(1) + "-" + rs3.getString(2) + "-" + rs3.getString(3) + "-" + rs3.getString(4) + "-"
									+ rs3.getString(5) + "-" + rs3.getDate(6) + "-" + rs3.getString(7) + "-" + rs3.getInt(8)
									+ "-" + rs3.getInt(9) + "-" + rs3.getInt(10) + "-" + rs3.getInt(11) + "-"

					);

				}
				// Closing the connection
				con.close();
				st.close();
				rs2.close();
				rs3.close();
			}

		}