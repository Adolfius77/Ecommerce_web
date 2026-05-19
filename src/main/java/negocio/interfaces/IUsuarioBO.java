/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.interfaces;

import java.util.Optional;
import model.Usuario;

/**
 *
 * @author USER
 */
public interface IUsuarioBO {
    String autentificarGenerarToken(String correo, String contrasena);
    void registrarUsuario(Usuario usuario )throws Exception; 
    Usuario actualizarUsuario(Usuario usuario)throws Exception;
    Optional<Usuario> obtenerUsuarioPorCorreo(String correo);
    java.util.List<Usuario> listarTodosUsuarios() throws Exception;
    Optional<Usuario> obtenerUsuarioPorId(org.bson.types.ObjectId id) throws Exception;
}
