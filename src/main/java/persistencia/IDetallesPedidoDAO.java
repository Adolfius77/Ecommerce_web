/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import model.detallePedido;
import org.bson.types.ObjectId;

/**
 *
 * @author USER
 */
public interface IDetallesPedidoDAO {
    void agregarDetalles(List<detallePedido> detallesPedido);
    List<detallePedido> obtenerPorPedido(ObjectId _pedidoId);
}
