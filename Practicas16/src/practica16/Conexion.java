package practica16;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;


public class Conexion {
	Connection conn;
	
	public Connection conectar() throws ClassNotFoundException, SQLException{
		
		//Cargar driver
		Class.forName("com.mysql.jdbc.Driver");
		//Conectar con la base de datos
		return conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/inventario", "root", "root");
		
	}
	
	public void desconectar(Connection conn) throws SQLException {
		//Cerrar la conexión
		conn.close();
		
	}

}
