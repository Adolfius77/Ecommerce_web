/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import java.util.Optional;
import model.Pedido;
import model.estadoPedido;
import org.bson.types.ObjectId;

/**
 *
 * @author USER
 */
public interface IPedidoDAO {

    void crear(Pedido pedido);

    List<Pedido> listarTodos();

    Optional<Pedido> obtenerPorId(ObjectId id);

    List<Pedido> listarPorUsuario(ObjectId idUsuario);

    boolean actualizarEstado(ObjectId id, estadoPedido estado);

    boolean actualizar(Pedido pedido);
}
