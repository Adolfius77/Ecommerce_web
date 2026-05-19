/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import model.Producto;
import org.bson.types.ObjectId;

/**
 *
 * @author USER
 */
public interface IProductoDAO {
    List<Producto> obtenerProductos();
    Producto obtenerProductoPorId(ObjectId _id);
    void crearProducto(Producto producto);
    void actualizarProducto(Producto producto);
    void eliminar(ObjectId _id);
    List<Producto> buscarPorNombre(String nombre);
    List<Producto> buscarPorCategoria(String categoria);
    List<Producto> buscarPorRangoPrecio(Double precioMin, Double precioMax);
    List<Producto> filtrar(String nombre, String categoria, Double precioMin, Double precioMax);
}
