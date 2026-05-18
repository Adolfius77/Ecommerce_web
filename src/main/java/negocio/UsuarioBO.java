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

    private final IUsuarioDAO usuarioDAO;

    public UsuarioBO(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = new UsuarioDAO(MongoClientProvider.INSTANCE.getcCollection("usuario", Usuario.class));
    }

    @Override
    public String autentificarGenerarToken(String correo, String contrasena) {
        Usuario usuarioValido = usuarioDAO.autentificar(correo, contrasena, "CLIENTE");

        if (usuarioValido != null && usuarioValido.isActivo()) {
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
    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listarTodos();
    }

    @Override
    public boolean cambiarEstadoActivo(ObjectId id, boolean activo) throws Exception {
        if (id == null) {
            throw new IllegalArgumentException("El id de usuario es obligatorio");
        }
        return usuarioDAO.actualizarActivo(id, activo);
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(ObjectId id) {
        if (id == null) {
            return Optional.empty();
        }
        return usuarioDAO.encontrarPorId(id);
    }

    @Override
    public boolean actualizarPerfil(Usuario usuario) throws Exception {
        if (usuario == null || usuario.getId() == null) {
            throw new IllegalArgumentException("El usuario debe tener id para actualizar el perfil");
        }
        Usuario existente = usuarioDAO.encontrarPorId(usuario.getId())
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        existente.setNombre(usuario.getNombre());
        existente.setApellido(usuario.getApellido());
        existente.setTelefono(usuario.getTelefono());
        existente.setDireccion(usuario.getDireccion());

        return usuarioDAO.actualizar(existente);
    }

    @Override
    public boolean cambiarContrasena(ObjectId id, String contrasenaActual, String contrasenaNueva) throws Exception {
        if (id == null) {
            throw new IllegalArgumentException("El id de usuario es obligatorio");
        }
        if (contrasenaNueva == null || contrasenaNueva.trim().isEmpty()) {
            throw new Exception("La nueva contraseña es obligatoria");
        }

        Usuario existente = usuarioDAO.encontrarPorId(id)
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        Usuario validado = usuarioDAO.autentificar(
                existente.getCorreo(),
                contrasenaActual,
                existente.getRol()
        );
        if (validado == null) {
            throw new Exception("La contraseña actual no es correcta");
        }

        existente.setContrasena(contrasenaNueva);
        return usuarioDAO.actualizar(existente);
    }
}
