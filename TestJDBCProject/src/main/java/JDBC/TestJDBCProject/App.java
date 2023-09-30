package JDBC.TestJDBCProject;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
	
	static Connection con;
	
	static void add(int prid,String nm,int pr,int qty) throws Exception
		{
			// add a record
			
			// prepareStatement() takes insert, update,delete queries as its string
			// ? is a placeholder , mapped with variable's value
			
			PreparedStatement ps = con.prepareStatement("insert into products values(?,?,?,?)");
			ps.setInt(1, prid);
			ps.setString(2, nm);
			ps.setInt(3, pr);
			ps.setInt(4, qty);
			
			int i = ps.executeUpdate();
			System.out.println(i + " Record Added Successfully");		
			
		}



	static void list() throws SQLException
		{
			
			// Statement interface support search and list queries
			// createStatement() is the JDBC call back method and takes select query as its
			//parameter string or run query at back-end
			// ResultSet interface stores all the records , send by back-end
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from products");
			
			while(rs.next())
			{
				System.out.println(rs.getInt("prid")+"  "+ rs.getString("prname")+"  "+rs.getInt("price")+"  "+rs.getInt("qty"));
			}
			
						
		}
	static void search(int id) throws SQLException
		{
			
		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from products where prid = "+id);
			
			while(rs.next())
			{
				System.out.println(rs.getInt("prid")+"  "+ rs.getString("prname")+"  "+rs.getInt("price")+"  "+rs.getInt("qty"));
			}
			
			
		}
	static void delete(int id) throws SQLException
	{
		PreparedStatement ps = con.prepareStatement("delete from products where prid = ?");
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		System.out.println(i+" Record is deleted successfully!");
	}
	static void update(int id,int pr,int qty) throws Exception
	{
		PreparedStatement ps = con.prepareStatement("update products set price=? , qty=? where prid=?");
		
		ps.setInt(1, pr);
		ps.setInt(2,qty);
		ps.setInt(3, id);
				
		int i = ps.executeUpdate();
		
		System.out.println(i+" Record is updated successfully!");
					
	}

	
    public static void main( String[] args ) throws Exception, InputMismatchException
    {
//        System.out.println( "Hello World!" );
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbcprj", "root", "MySQL");
    	if(con!=null)
    	{
    		System.out.println("Database Created");
    	}
    	else
    	{
    		System.out.println("DB not created");
    	}
    	String ch="Y";
    	int choice;
    	Scanner in = new Scanner(System.in);
    	//System.out.println("Enter choice");
    	while(!ch.toUpperCase().equals("N"))
    	{
    		System.out.println("Main Menu");
    		System.out.println("1: Add");
    		System.out.println("2: List");
    		System.out.println("3: Search By Id");
    		System.out.println("4: Delete");
    		System.out.println("5: Update");
    		System.out.println("6: Exit ");
    		System.out.println("Enter your choice: ");
    		choice = in.nextInt();
    		
    		switch(choice)
    		{
    		case 1:
	    		
	    			System.out.println("\nEnter product id: ");
					int prid = in.nextInt();
					
					System.out.println("\nEnter product name: ");
					String prnm = in.next();
					
					System.out.println("\nEnter price: ");
					int pr = in.nextInt();
					
					System.out.println("\nEnter quantity: ");
					int qty = in.nextInt();
			
					add(prid,prnm,pr,qty);
					
				break;
				
    		case 2: 
				list();
				break;
        
        
  
  
    		case 3:
					int id;
			   
					System.out.println("\nEnter product id to search: ");
					id = in.nextInt();
					search(id);
				
				break;
			case 4:
			    			
			    			System.out.println("\nEnter product id to search: ");
							id = in.nextInt();
							
							delete(id);
							
							break;
			
			
			
			case 5:
			
			    			System.out.println("\nEnter product id to update: ");
							id = in.nextInt();
							
							System.out.println("\nEnter updated price: ");
							pr = in.nextInt();
							
							System.out.println("\nEnter updated quantity: ");
							qty = in.nextInt();
							
							update(id,pr,qty);
							
							break;
			
			case 6:
				System.out.println("--------");
				System.exit(0);
				break;
							
					
    		}
    		System.out.println("\n\nDo you want to continue: ");
    		ch = in.next();   			
    		
    	}
    	
    }
}
