package practica16;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Main {

	public static void main(String[] args) {

		String busqueda = "zapatero";
		Date fecha = null;
		ArrayList<Productos> productosBuscados;

		Productos producto = new Productos();

		producto.setCantidad(37);
		producto.setComentario("mesita de noche grande");
		producto.setFecha(fecha);
		producto.setNombre("mesitanoche");
		producto.setPrecio(150);

		ProductosDao productodao = new ProductosDao();

		try {
			productodao.insertar(producto);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("No se ha podido conectar con la base de datos");
			e.printStackTrace();
		}

		try {
			productosBuscados = productodao.listar(busqueda);

			for (int i = 0; i < productosBuscados.size(); i++) {
				System.out.println("Producto número " + (i + 1));
				System.out.println("-----");
				System.out.println("ID = " + productosBuscados.get(i).getId());
				System.out.println("Nombre = " + productosBuscados.get(i).getNombre());
				System.out.println("Precio = " + productosBuscados.get(i).getPrecio());
				System.out.println("Cantidad = " + productosBuscados.get(i).getCantidad());
				System.out.println("Comentarios = " + productosBuscados.get(i).getComentario());
				System.out.println("Fecha = " + productosBuscados.get(i).getFecha());
				System.out.println("........................................");
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("No se ha podido conectar con la base de datos");
			e.printStackTrace();
		}

	}

}
