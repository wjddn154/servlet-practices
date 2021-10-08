package com.douzone.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.emaillist.vo.EmaillistVO;


public class EmaillistDAO {

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		return conn;
	}
	
	public boolean insert(EmaillistVO vo) {
		boolean result = false;
		Connection conn = null;
	    PreparedStatement pstmt = null;
	      
	    try {
	    	 conn = getConnection();
	         
	         //3. SQL 준비
	         String sql = "insert into emaillist values(null, ?, ?, ?)";
	         pstmt = conn.prepareStatement(sql);
	         
	         //4. 바인딩(binding)
	         pstmt.setString(1, vo.getFirstName());
	         pstmt.setString(2, vo.getLastName());
	         pstmt.setString(3, vo.getEmail());
	         
	         //5. SQL 실행
	         int count = pstmt.executeUpdate();
	         
	         result = count == 1;
	         
	      } catch (SQLException e) {
	         System.out.println("EmaillistDAO insert() 예외 발생 error:" + e);
	      } finally {
	         
	         try {
	        	if(pstmt != null) {
	        	   pstmt.close();
	        	}
	        	 
	            if(conn != null) {
	               conn.close();
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      
	      return result;
	}
	
//	public boolean update(Long no, String status) {
//		boolean result = false;
//		Connection conn = null;
//	    PreparedStatement pstmt = null;
//	      
//	    try {
//	    	 conn = getConnection();
//	         
//	         //3. SQL 준비
//	         String sql = 
//        		  "update book"
//         		+ "   set status=?"
//         		+ " where no=?";
//	         pstmt = conn.prepareStatement(sql);
//	         
//	         //4. 바인딩(binding)
//	         pstmt.setString(1, status);
//	         pstmt.setLong(2, no);
//	         
//	         //5. SQL 실행
//	         int count = pstmt.executeUpdate();
//	         
//	         result = count == 1;
//	         
//	      } catch (SQLException e) {
//	         System.out.println("SQL 예외 발생 error:" + e);
//	      } finally {
//	         
//	         try {
//	        	if(pstmt != null) {
//	        	   pstmt.close();
//	        	}
//	        	 
//	            if(conn != null) {
//	               conn.close();
//	            }
//	         } catch (SQLException e) {
//	            e.printStackTrace();
//	         }
//	      }
//	      
//	      return result;
//	}
	
	
	public List<EmaillistVO> findAll() {
		List<EmaillistVO> result = new ArrayList<>();
		
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	    	 conn = getConnection();
	         
	         //3. SQL 준비
	         String sql = "select no, first_name, last_name, email"
	         		+ "    from emaillist"
	         		+ " order by no desc";
	         pstmt = conn.prepareStatement(sql);
	         
	         //4. 바인딩(binding)
	         
	         //5. SQL 실행
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	        	Long no = rs.getLong(1);
	        	String firstName = rs.getString(2);
	        	String lastName = rs.getString(3);
	        	String email = rs.getString(4);
	        	
	        	EmaillistVO vo = new EmaillistVO();
	        	vo.setNo(no);
	        	vo.setFirstName(firstName);
	        	vo.setLastName(lastName);
	        	vo.setEmail(email);
	        	
	        	result.add(vo);
	         }
	         
	      } catch (SQLException e) {
	         System.out.println("EmaillistDAO findAll() error:" + e);
	      } finally {
	         //clean up
	         try {
	        	if(rs != null) {
	        	   rs.close();
				}
	        	
	        	if(pstmt != null) {
	        	   pstmt.close();
	        	}
	        	 
	            if(conn != null) {
	               conn.close();
	            }
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	      }
	      
	      
	      return result;
	}
	
}
