/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.interfaces;

import java.util.List;
import model.reseña;
import org.bson.types.ObjectId;

/**
 *
 * @author USER
 */
public interface IResenaBO {

    List<reseña> listarTodasResenas();

    List<reseña> listarPorProducto(ObjectId productoId);

    boolean eliminarResena(ObjectId id) throws Exception;
    
    java.util.Optional<reseña> obtenerResena(ObjectId id) throws Exception;
    
    boolean actualizarResena(reseña resena) throws Exception;
}
