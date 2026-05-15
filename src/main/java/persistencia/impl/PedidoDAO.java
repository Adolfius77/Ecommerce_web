/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.impl;

import Config.MongoClientProvider;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Pedido;
import model.estadoPedido;
import org.bson.types.ObjectId;
import persistencia.IPedidoDAO;

/**
 *
 * @author USER
 */
public class PedidoDAO implements IPedidoDAO {

    private final MongoCollection<Pedido> col;

    public PedidoDAO(MongoCollection<Pedido> col) {
        this.col = MongoClientProvider.INSTANCE.getcCollection("pedido", Pedido.class);
    }

    @Override
    public void crear(Pedido pedido) {
        try {
            if (pedido.getId() == null) {
                pedido.setId(new ObjectId());
            }
            col.insertOne(pedido);
        } catch (Exception e) {
            throw new MongoException("error al crear pedido: " + e.getMessage());
        }
    }

    @Override
    public List<Pedido> listarTodos() {
        try {
            return col.find().into(new ArrayList<>());
        } catch (MongoException e) {
            throw new MongoException("error al listar pedidos: " + e.getMessage());
        }
    }

    @Override
    public Optional<Pedido> obtenerPorId(ObjectId id) {
        try {
            return Optional.ofNullable(col.find(eq("_id", id)).first());
        } catch (MongoException e) {
            throw new MongoException("error al obtener pedido por id: " + e.getMessage());
        }
    }

    @Override
    public List<Pedido> listarPorUsuario(ObjectId idUsuario) {
        try {
            return col.find(eq("idUsuario", idUsuario)).into(new ArrayList<>());
        } catch (MongoException e) {
            throw new MongoException("error al listar pedidos por usuario: " + e.getMessage());
        }
    }

    @Override
    public boolean actualizarEstado(ObjectId id, estadoPedido estado) {
        try {
            UpdateResult r = col.updateOne(eq("_id", id), Updates.set("estado", estado));
            return r.getModifiedCount() > 0;
        } catch (MongoException e) {
            throw new MongoException("error al actualizar estado del pedido: " + e.getMessage());
        }
    }

    @Override
    public boolean actualizar(Pedido pedido) {
        try {
            UpdateResult resultado = col.replaceOne(eq("_id", pedido.getId()), pedido);
            return resultado.getModifiedCount() > 0;
        } catch (MongoException e) {
            throw new MongoException("error al actualizar pedido: " + e.getMessage());
        }
    }
}
