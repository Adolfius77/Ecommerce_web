/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.interfaces;

import java.util.List;
import java.util.Optional;
import model.Producto;
import org.bson.types.ObjectId;

/**
 *
 * @author USER
 */
public interface IProductoBO {

    List<Producto> listarProductos();

    Optional<Producto> obtenerPorId(ObjectId id);

    void registrarProducto(Producto producto) throws Exception;

    boolean actualizarProducto(Producto producto) throws Exception;

    boolean eliminarProducto(ObjectId id) throws Exception;

    boolean hayStockDisponible(ObjectId id, int cantidad) throws Exception;
    
    List<Producto> buscarPorNombre(String nombre) throws Exception;
    
    List<Producto> buscarPorCategoria(String categoria) throws Exception;
    
    List<Producto> buscarPorRangoPrecio(Double precioMin, Double precioMax) throws Exception;
    
    List<Producto> filtrarProductos(String nombre, String categoria, Double precioMin, Double precioMax) throws Exception;
}
