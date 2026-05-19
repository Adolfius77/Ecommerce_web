/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.interfaces;

import java.util.List;
import java.util.Optional;
import model.Categoria;
import org.bson.types.ObjectId;

/**
 *
 * @author USER
 */
public interface ICategoriaBO {

    List<Categoria> listarCategorias();

    Optional<Categoria> obtenerPorId(ObjectId id);

    ObjectId registrarCategoria(Categoria categoria) throws Exception;

    boolean actualizarCategoria(Categoria categoria) throws Exception;

    boolean eliminarCategoria(ObjectId id) throws Exception;
    
    boolean crearCategoria(Categoria categoria) throws Exception;
}
