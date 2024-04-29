import java.sql.*;
public class JDBCFirst{
	public static void main(String[] args) {
		String jdbcDriver = "org.postgresql.Driver";
		String dbURL= "jdbc:postgresql://local host:5432/aits";
		//String user = "postgres";
		//String pass = "jkc"; 
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(jdbcDriver);
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(dbURL);
			System.out.println("Creating database...");
			stmt = conn.createStatement();
			if(stmt!=null){
				System.out.println("connection established");
				String sqlq ="create table csebstu(rnum varchar(20),name varchar(20),branch varchar(20))"; 
                stmt.executeUpdate(sqlq);
				System.out.println("Table created successfully...");
		    }
        }
        catch(ClassNotFoundException|SQLException e){
            e.printStackTrace();
        }
        finally{
			try{
                conn.close();
                stmt.close();	
			}	
            catch(SQLException e){
			   e.printStackTrace();
			}   
		}   
    }
}  