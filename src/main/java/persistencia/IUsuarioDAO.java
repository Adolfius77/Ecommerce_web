/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import java.util.Optional;
import model.Usuario;
import org.bson.types.ObjectId;

/**
 *
 * @author USER
 */
public interface IUsuarioDAO {
    ObjectId registrarUsuario(Usuario entidad, String rol);
    Usuario autentificar(String correo, String password, String rol);
    Optional<Usuario> encontrarPorId(ObjectId _id);
    List<Usuario> encontrarTodos(Usuario entidad);
    boolean actualizar(Usuario entidad);
    boolean eliminarPorId(ObjectId _id);
    Optional<Usuario> encontrarPorNombre(String nombre);
}

