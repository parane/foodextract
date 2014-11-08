import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.aliasi.dict.MapDictionary;


public class ReadReviews {
	
	static final double CHUNK_SCORE = 1.0;
	String db="testsys";
	
	
public static void main(String[] a)
{
	new ReadReviews().readReviewFromDB();
}
public void readReviewFromDB()
{
	
	Connection con = null;

	try{

	  Class.forName("com.mysql.jdbc.Driver");
	  con = DriverManager.getConnection
	("jdbc:mysql://localhost:3306/"+db,"root",""); //change
	  try{
	  Statement st = con.createStatement();
	  ResultSet res = st.executeQuery
	("SELECT review FROM "+"reviews"+" NATURAL JOIN "+"restaurants"+" WHERE rest_name ="+"\""+Const.resturant+"\"");  //Join two tables
	  
	  while(res.next()){
	  String review = res.getString("review");
	  Const.reviewList.add(review);
	 // System.out.println(review );
	  }
	  }
	  catch (SQLException s){
	  System.out.println("SQL statement is not executed!"+s);
	  }
	 }
      catch (Exception e){
      e.printStackTrace();
     }
}



}
