package com.caps.model.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.caps.controller.LoginC;
import com.caps.model.beans.UserAuth;
import com.caps.model.beans.Students;





public class LoginM implements LoginI{
public  Students main(String userid,String Passwd) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LoginC c=new LoginC();
		UserAuth u=new UserAuth();

		Students s=new Students();
		try {
			/*
			 * 1. Load the Driver
			 */
			Class.forName("com.mysql.jdbc.Driver");
			
			/*
			 * 2. Get the DB Connection via Driver
			 */
						String dbUrl="jdbc:mysql://localhost:3306/capsv4_db?user=root&password=9701952121";
						
			//2nd Version of getConnection
			
				con = DriverManager.getConnection(dbUrl);
						

			System.out.println("Connected...");
			
			/*
			 * 3. Issue the SQL query via connection
			 */
			String sql = "select * from students_info where "
					+ " firstname=? and password=?";
/*
String passwd="$rot";


int userId=1;
*/
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			System.out.println(userid);
			pstmt.setString(2, Passwd);
			System.out.println(Passwd);
			rs = pstmt.executeQuery();

			/*
			 * 4. Process the results
			 */
			
			
			if(rs.next()){
			
		
	
				int regno = rs.getInt("sid");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String gender = rs.getString("gender");
				String password = rs.getString("password");
				String type = rs.getString("type");
				s.setFirstname(firstname);
				System.out.println(s.getFirstname());
				s.setGender(gender);
				s.setLastname(lastname);
				s.setPassword(password);
				s.setType(type);
				s.setUserid(regno);
				return s;
			}
			
			else {
				System.out.println("Login Failed");
				
				
			return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 5. close all the JDBC Objects
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
		}
	return null;}	}
