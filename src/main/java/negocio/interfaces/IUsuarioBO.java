/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.interfaces;

import java.util.List;
import java.util.Optional;
import model.Usuario;
import org.bson.types.ObjectId;

/**
 *
 * @author USER
 */
public interface IUsuarioBO {
    String autentificarGenerarToken(String correo, String contrasena);
    void registrarUsuario(Usuario usuario) throws Exception;

    List<Usuario> listarUsuarios();

    boolean cambiarEstadoActivo(ObjectId id, boolean activo) throws Exception;

    Optional<Usuario> obtenerUsuarioPorId(ObjectId id);

    boolean actualizarPerfil(Usuario usuario) throws Exception;

    boolean cambiarContrasena(ObjectId id, String contrasenaActual, String contrasenaNueva) throws Exception;
}
