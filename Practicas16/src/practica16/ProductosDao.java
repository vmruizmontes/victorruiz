package practica16;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductosDao {

	ArrayList<Productos> producto = new ArrayList<>();

	/**
	 * Listar productos obtenidos de la base de datos mediante un string recibido
	 * 
	 * @param busqueda
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<Productos> listar(String busqueda) throws ClassNotFoundException, SQLException {

		Conexion conexion = new Conexion();
		
		
		// Conectar con la base de datos
		Connection conn = conexion.conectar();
		
		String selectSQL = "SELECT * FROM productos WHERE nombre like ?" ;
		PreparedStatement st = conn.prepareStatement(selectSQL);
		st.setString(1, "%"+busqueda+"%");
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Productos listado = new Productos();
			int id = rs.getInt("id");
			listado.setId(id);
			String nombre = rs.getString("nombre");
			listado.setNombre(nombre);
			int cantidad = rs.getInt("cantidad");
			listado.setCantidad(cantidad);
			int precio = rs.getInt("precio");
			listado.setPrecio(precio);
			String comentario = rs.getString("comentario");
			listado.setComentario(comentario);
			Date fechasql = rs.getDate("fecha");
			java.util.Date fechaUtil = fechasql;
			listado.setFecha(fechaUtil);
			
			producto.add(listado);
			
		}

		conexion.desconectar(conn);

		return producto;

	}

	/**
	 * Insertar producto en una bd
	 * 
	 * @param p
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void insertar(Productos p) throws ClassNotFoundException, SQLException {

		Conexion conexion = new Conexion();		
		
		// Conectar con la base de datos
		Connection conn = conexion.conectar();

		String insertTableSQL = "INSERT INTO productos" + "(nombre, cantidad, precio, comentario, fecha) VALUES"
				+ "(?, ?, ?, ?, ?)";
		PreparedStatement st = conn.prepareStatement(insertTableSQL);
		
		st.setString(1, p.getNombre());
		st.setInt(2, p.getCantidad());
		st.setInt(3, p.getPrecio());
		st.setString(4, p.getComentario());
		st.setTimestamp(5, getCurrentTimeStamp());
		// execute insert SQL stetement
		st.executeUpdate();
		// Cerrar el PrepareStatement
		st.close();
		// Cerrar la conexión
		conn.close();

	}

	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}

}
