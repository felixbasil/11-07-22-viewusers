package view;

import java.util.List;
import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  


public class usersDao {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	public static List<Users> getAllRecords(){  
	    List<Users> list=new ArrayList<Users>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from clientregister");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            Users u=new Users();  
	            u.setId(rs.getInt("id"));  
	            u.setFname(rs.getString("fname"));
	            u.setLname(rs.getString("lname"));  
	            u.setEmail(rs.getString("email"));  
	            u.setMobile(rs.getString("mobile"));
	            u.setGender(rs.getString("gender"));
	            u.setAddress(rs.getString("address")); 
	            u.setCity(rs.getString("city"));
	            list.add(u);  
	            
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  

}
