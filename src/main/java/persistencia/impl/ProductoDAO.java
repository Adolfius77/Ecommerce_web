/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.impl;

import Config.MongoClientProvider;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.or;
import java.util.ArrayList;
import java.util.List;
import model.Producto;
import org.bson.types.ObjectId;
import persistencia.IProductoDAO;

/**
 *
 * @author USER
 */
public class ProductoDAO implements IProductoDAO {

    private final MongoCollection<Producto> col;

    public ProductoDAO(MongoCollection<Producto> col) {
        this.col = MongoClientProvider.INSTANCE.getcCollection("producto", Producto.class);
    }

    @Override
    public List<Producto> obtenerProductos() {
        try {
            return col.find().into(new ArrayList<>());
        } catch (MongoException e) {
            throw new MongoException("error al obtener productos" + e.getMessage());
        }
    }

    @Override
    public Producto obtenerProductoPorId(ObjectId _id) {
        try {
            return col.find(eq("_id", _id)).first();
        } catch (Exception e) {
            throw new MongoException("error al obtener producto por id: " + _id + e.getMessage());
        }

    }

    @Override
    public void crearProducto(Producto producto) {
        try {
            col.insertOne(producto);
        } catch (Exception e) {
            throw new MongoException("error al crear producto" + e.getMessage());
        }
    }

    @Override
    public void actualizarProducto(Producto producto) {
        try {
            col.replaceOne(eq("_id", producto.getId()),producto);
        } catch (Exception e) {
            throw new MongoException("error al actualizar el producto" + e.getMessage());
        }
    }

    @Override
    public void eliminar(ObjectId _id) {
        try {
            col.deleteOne(eq("_id", _id));
        } catch (Exception e) {
            throw new MongoException("error al borrar producto" + e.getMessage());
        }
    }

    public List<Producto> buscarPorNombre(String nombre) {
        try {
            return col.find(regex("nombre", nombre, "i")).into(new ArrayList<>());
        } catch (Exception e) {
            throw new MongoException("error al buscar productos por nombre: " + e.getMessage());
        }
    }

    public List<Producto> buscarPorCategoria(String categoria) {
        try {
            return col.find(eq("categoria", categoria)).into(new ArrayList<>());
        } catch (Exception e) {
            throw new MongoException("error al buscar productos por categoría: " + e.getMessage());
        }
    }

    public List<Producto> buscarPorRangoPrecio(Double precioMin, Double precioMax) {
        try {
            return col.find(and(gte("precio", precioMin), lte("precio", precioMax))).into(new ArrayList<>());
        } catch (Exception e) {
            throw new MongoException("error al buscar productos por rango de precio: " + e.getMessage());
        }
    }

    public List<Producto> filtrar(String nombre, String categoria, Double precioMin, Double precioMax) {
        try {
            List<org.bson.conversions.Bson> filters = new ArrayList<>();
            
            if (nombre != null && !nombre.trim().isEmpty()) {
                filters.add(regex("nombre", nombre.trim(), "i"));
            }
            
            if (categoria != null && !categoria.trim().isEmpty()) {
                filters.add(eq("categoria", categoria.trim()));
            }
            
            if (precioMin != null && precioMin >= 0) {
                filters.add(gte("precio", precioMin));
            }
            
            if (precioMax != null && precioMax >= 0) {
                filters.add(lte("precio", precioMax));
            }
            
            if (filters.isEmpty()) {
                return obtenerProductos();
            }
            
            return col.find(and(filters)).into(new ArrayList<>());
        } catch (Exception e) {
            throw new MongoException("error al filtrar productos: " + e.getMessage());
        }
    }

}
