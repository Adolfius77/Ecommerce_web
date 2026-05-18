/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Config.MongoClientProvider;
import java.util.List;
import java.util.Optional;
import model.Producto;
import negocio.interfaces.IProductoBO;
import org.bson.types.ObjectId;
import persistencia.IProductoDAO;
import persistencia.impl.ProductoDAO;

/**
 *
 * @author USER
 */
public class ProductoBO implements IProductoBO {

    private final IProductoDAO productoDAO;

    public ProductoBO() {
        this.productoDAO = new ProductoDAO(MongoClientProvider.INSTANCE.getcCollection("producto", Producto.class));
    }

    @Override
    public List<Producto> listarProductos() {
        return productoDAO.obtenerProductos();
    }

    @Override
    public Optional<Producto> obtenerPorId(ObjectId id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(productoDAO.obtenerProductoPorId(id));
    }

    @Override
    public void registrarProducto(Producto producto) throws Exception {
        validarProducto(producto, false);
        if (producto.getId() == null) {
            producto.setId(new ObjectId());
        }
        productoDAO.crearProducto(producto);
    }

    @Override
    public boolean actualizarProducto(Producto producto) throws Exception {
        if (producto == null || producto.getId() == null) {
            throw new IllegalArgumentException("El producto debe tener id para actualizar");
        }
        validarProducto(producto, true);
        productoDAO.actualizarProducto(producto);
        return true;
    }

    @Override
    public boolean eliminarProducto(ObjectId id) throws Exception {
        if (id == null) {
            throw new IllegalArgumentException("El id del producto es obligatorio");
        }
        if (obtenerPorId(id).isEmpty()) {
            throw new Exception("Producto no encontrado");
        }
        productoDAO.eliminar(id);
        return true;
    }

    @Override
    public boolean hayStockDisponible(ObjectId id, int cantidad) throws Exception {
        if (id == null) {
            throw new IllegalArgumentException("El id del producto es obligatorio");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }
        Producto producto = obtenerPorId(id)
                .orElseThrow(() -> new Exception("Producto no encontrado"));
        return producto.getStock() >= cantidad;
    }

    private void validarProducto(Producto producto, boolean esActualizacion) throws Exception {
        if (producto == null) {
            throw new Exception("El producto no puede ser nulo");
        }
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del producto es obligatorio");
        }
        if (producto.getPrecio() == null || producto.getPrecio() < 0) {
            throw new Exception("El precio del producto debe ser mayor o igual a cero");
        }
        if (producto.getStock() < 0) {
            throw new Exception("El stock no puede ser negativo");
        }
        if (!esActualizacion && producto.getId() != null) {
            if (obtenerPorId(producto.getId()).isPresent()) {
                throw new Exception("Ya existe un producto con ese id");
            }
        }
    }
}
