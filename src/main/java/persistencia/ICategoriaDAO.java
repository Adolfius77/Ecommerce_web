/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import java.util.Optional;
import model.Categoria;
import org.bson.types.ObjectId;

/**
 *
 * @author USER
 */
public interface ICategoriaDAO {

    ObjectId crear(Categoria categoria);

    List<Categoria> listarTodos();

    Optional<Categoria> obtenerPorId(ObjectId id);

    boolean actualizar(Categoria categoria);

    boolean eliminar(ObjectId id);
}
