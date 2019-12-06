
package project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;
/**
 *
 * @author romil
 */
public class Project {

    /**
     * @param args the command line arguments
     */
 
    public static void main(String[] args) {
        try{
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://10.100.71.21:5432/201701014?currentSchema=football_league","201701014","password");
        Statement st = con.createStatement();
        Scanner sc = new Scanner(System.in); 
        while(true){
        System.out.println("input 1 to update , 2 for query and 3 to exit  ");
        int n ;
        n = sc.nextInt();
        sc.nextLine();
        if(n==1){
            System.out.println("Input insert/update/delete query : ");
            String query = sc.nextLine();
            try{
            int rs = st.executeUpdate(query);}
            catch(Exception e){
                System.out.println("query run unsuccesul");
            }
           
           
        }
        else if (n==2)
        {
            System.out.println("Input query : ");
            String query = sc.nextLine();
            try{
                ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
                            
            while (rs.next()) {

                for(int i = 1 ; i <= columnsNumber; i++){

                    System.out.print(rs.getString(i) + " "); 

                }

            System.out.println();//Move to the next line to print the next row.           
            }
            }
            catch(Exception e)
            {
                System.out.println("query run unsuccesufull");
            }
       }
        else
        {     
            st.close();
            System.exit(0);
        }
       }
        
            
        }
        
        catch(Exception ex){
        System.out.println(ex.getMessage());
        }
      
        // TODO code application logic here
    }
    
}


