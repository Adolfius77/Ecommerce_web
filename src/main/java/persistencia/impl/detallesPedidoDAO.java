/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.impl;

import Config.MongoClientProvider;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;

import model.detallePedido;
import org.bson.types.ObjectId;
import persistencia.IDetallesPedidoDAO;

/**
 *
 * @author USER
 */
public class detallesPedidoDAO implements IDetallesPedidoDAO {

    private final MongoCollection<detallePedido> col;

     public detallesPedidoDAO(MongoCollection<detallePedido> col) {
        this.col = MongoClientProvider.INSTANCE.getcCollection("detalle_pedido",detallePedido.class);
    }

    @Override
    public void agregarDetalles(List<detallePedido> detallesPedido) {
        try {
            col.insertMany(detallesPedido);
        } catch (Exception e) {
            throw new MongoException("error al agregar detalles" + e.getMessage());
        }
    }

    @Override
    public List<detallePedido> obtenerPorPedido(ObjectId _pedidoId) {
        try {
            return col.find(eq("_pedidoId", _pedidoId)).into(new ArrayList<>());
        } catch (Exception e) {
            throw new MongoException("error al obtener la resena: " + e.getMessage());
        }
    }

}
