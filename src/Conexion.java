import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
public class Conexion {
	public static final String Controlador = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/" + base + "?useSSL=false"; 
	private Connection con =null;
	public Connection getConexion () {	
			try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("CONECTADO A LA BASE DE DATOS");	
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
				System.out.println("ERROR AL CONECTAR CON LA BASE DE DATOS");		
			} catch (SQLException e) {
				System.out.println("ERROR AL CONECTAR CON LA BASE DE DATOS");
				System.out.println(e);
			}
		return  con;	
		}
}