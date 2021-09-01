package summer21jdbc;


import java.sql.*;

public class JavaExecuteDT01 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "taner1", "1987");
		// Create a statement

				Statement st = con.createStatement();
				
				
				//Execute Statement to Drop Table called Demo.
				String q0 = "DROP TABLE demo PURGE";
				
				Boolean r0 = st.execute(q0);
				System.out.println("From DROP: "+r0);
				
				//Create a table called demo
				String q1 = "CREATE TABLE demo(demo_id NUMBER(2), demo_name VARCHAR2(20))";
				
				Boolean r1 =st.execute(q1); //false

				System.out.println("From CREATE: "+r1); 

				//Add demo_address field into demo table
				
				String q2 = "ALTER TABLE demo ADD demo_address VARCHAR(20)";
				Boolean r2 = st.execute(q2);
				
				System.out.println("From ALTER 1 : "+r2); 

				// Add demo_code and demo_price fields into demo table 
				String q3 = "ALTER TABLE demo ADD (demo_code CHAR(3),demo_price NUMBER(5))";
				Boolean r3 = st.execute(q3);
				System.out.println("From ALTER 2 : "+r3); 

				
				
				
				String q4 ="ALTER TABLE demo MODIFY demo_code NUMBER(3)";
				Boolean r4=st.execute(q4);
				System.out.println("From alter 3: "+ r4);
				
				// Drop demo_price field from demo tabe
				String q5 = "ALTER TABLE demo DROP COLUMN demo_price";

				Boolean r5 = st.execute(q5);
				System.out.println("FROM ALTER 4: " + r5);

				// Renaming demo name field to name_of_demo

				String q6 = "ALTER TABLE demo RENAME COLUMN demo_name TO name_of_demo";
				Boolean r6 = st.execute(q6);
				System.out.println("FROM ALTER 5: " + r6);

				// Renaming demo table to my_demo
				String q7 = "ALTER TABLE demo RENAME TO my_demo";
				boolean r7 = st.execute(q7);
				System.out.println("FROM ALTER 6" + r7);

				con.close();
				st.close();

			}
		}