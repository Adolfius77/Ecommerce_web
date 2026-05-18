/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Config.MongoClientProvider;
import java.util.List;
import java.util.Optional;
import model.Usuario;
import negocio.interfaces.IUsuarioBO;
import org.bson.types.ObjectId;
import persistencia.IUsuarioDAO;
import persistencia.impl.UsuarioDAO;
import util.JWTProvider;

/**
 *
 * @author USER
 */
public class UsuarioBO implements IUsuarioBO {

    private IUsuarioDAO usuarioDAO;

    public UsuarioBO() {
        this.usuarioDAO = new UsuarioDAO(MongoClientProvider.INSTANCE.getcCollection("usuario", Usuario.class));
    }

    @Override
    public String autentificarGenerarToken(String correo, String contrasena) {
        Usuario usuarioValido = usuarioDAO.autentificar(correo, contrasena, "CLIENTE");

        if (usuarioValido != null) {
            return JWTProvider.generarTokem(usuarioValido.getCorreo(), usuarioValido.getRol());

        }
        return null;
    }

    @Override
    public void registrarUsuario(Usuario usuario) throws Exception {
        usuario.setRol("CLIENTE");
        usuarioDAO.registrarUsuario(usuario, "CLIENTE");
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws Exception {
        boolean exito = usuarioDAO.actualizar(usuario);
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            throw new Exception("el nombre es obligatorio");
        }
        if (usuario.getTelefono() == null || usuario.getTelefono().isEmpty()) {
            throw new Exception("el telefono es obligatorio");
        }
        if (usuario.getContrasena() == null || usuario.getContrasena().isEmpty()) {
            throw new Exception("la contrasena es obligatorio");

        }

        if (!exito) {
            throw new Exception("No se puede actualizar el perfil carnal");
        }
        return usuario;
    }

}
