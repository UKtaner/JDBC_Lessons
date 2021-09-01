package summer21jdbc;

import java.sql.*;

public class JdbcCallableStatement02 {
	 /*
 	What is the difference between "Function" and "Procedure"?
 	Answer: Functions in SQL definitely returns value but Procedures(Like void return type in Java) do not return value
 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "taner1", "1987");
		Statement st = con.createStatement();

		//1.Example: Create a procedure to find the minimum one of 2 numbers
//		String q1 = "CREATE OR REPLACE PROCEDURE findMin(x IN NUMBER, y IN NUMBER, result OUT NUMBER) IS "
//					+ "BEGIN "
//					+ "IF x<y THEN result := x; "
//					+ "ELSE result := y; "
//					+ "END IF; "
//					+ "END;";
//		boolean isFindMinProcedureCreated = st.execute(q1);
//		System.out.println("Was findMin() procedure created? " + !isFindMinProcedureCreated);
		
		//How to call findMin() procedure
		CallableStatement cst = con.prepareCall("{call findMin(?, ?, ?)}");
		
		cst.setInt(1, 5);
		cst.setInt(2, 7);
		cst.registerOutParameter(3, Types.INTEGER);
		
		cst.execute();
		
		System.out.println("Minimum is " + cst.getInt(3));//5
		
		//2.Example: Create a procedure to get the name from students table when you enter student id
		String q2 = "CREATE OR REPLACE";
			
		
/*
 := assignment operator in sql 		
 */
	
		//How to call findMin() procedure
//		CallableStatement cst = con.prepareCall("{call findMin(?, ?, ?)}");
//		
//		cst.setInt(1, 5);
//		cst.setInt(2, 7);
//		cst.registerOutParameter(3, Types.INTEGER);
//		
//		cst.execute();
//		
//		System.out.println("Minimum is " + cst.getInt(3));//5
		
		//2.Example: Create a procedure to get the name from students table when you enter student id
//		String q2 = "CREATE OR REPLACE PROCEDURE getName(id IN NUMBER, name OUT VARCHAR2) IS "
//					+ "BEGIN  "
//					+ "SELECT std_name INTO name FROM students WHERE std_id = id;"
//					+ "END;";
//		boolean isGetNameProcedureCreated = st.execute(q2);
//		System.out.println("Was getName() procedure created? " + !isGetNameProcedureCreated);
		
		//How to call getName() procedure
//		CallableStatement cst1 = con.prepareCall("{call getName(?, ?)}");
//		
//		cst1.setInt(1, 101);
//		cst1.registerOutParameter(2, Types.VARCHAR);
//		
//		cst1.execute();
//		
//		System.out.println("Name is " + cst1.getString(2));
		
		//3.Example: Create a procedure to increase the id by 1 for the student selected by name.
//		String q3 = "CREATE OR REPLACE PROCEDURE increaseId(name IN VARCHAR2, id OUT NUMBER) IS "
//				+ "BEGIN  "
//				+ "UPDATE students SET std_id = std_id + 1 WHERE std_name = name; "
//				+ "SELECT std_id INTO id FROM students WHERE std_name = name; "
//				+ "END;";
//		boolean isIncreaseIdProcedureCreated = st.execute(q3);
//		System.out.println("Was increaseId() procedure created? " + !isIncreaseIdProcedureCreated);
//		
//		//How to call increaseId() procedure
//		CallableStatement cst = con.prepareCall("{call increaseId(?, ?)}");
//		
//		cst.setString(1, "Ali Can");
//		cst.registerOutParameter(2, Types.INTEGER);
//		
//		cst.execute();
//		
//		System.out.println("Increased id is " + cst.getInt(2));
		
		//4.Example:Create a procedure to withdraw money from an account.
		//          Account id and withdraw amount will be given by user.
		//          If the withdraw amount is greater than the balance withdraw cannot be done
		//          Otherwise, do withdraw and display the remaining balance on the output console.
		
		String q4 ="CREATE OR REPLACE PROCEDURE withdraw(a_id IN NUMBER, w_amount IN NUMBER, r_balance OUT NUMBER) IS "
				+ "BEGIN "
				+ "a_id NUMBER := '&AccountId'; "
				+ "w_amount NUMBER := '&WithdrawAmount'; "
				+ "r_balance NUMBER; "
				+ "a_balance NUMBER; "
				+ "SELECT balance INTO a_balance FROM accounts WHERE id = a_id;"
				+ "IF(w_amount<=a_balance) THEN "
				+ "UPDATE accounts SET balance = balance - w_amount WHERE id = a_id;"
				+ "ELSE DBMS_OUTPUT.PUT_LINE(w_amount || ' is greater than the active balance');"
				+ "END IF; "
				+ "SELECT balance INTO r_balance FROM accounts WHERE id = a_id; "
				+ "END;";
		
		
	}

}
