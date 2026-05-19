/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Config.MongoClientProvider;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import model.Producto;
import model.Usuario;
import model.reseña;
import negocio.interfaces.IResenaBO;
import negocio.interfaces.IProductoBO;
import negocio.interfaces.IUsuarioBO;
import org.bson.types.ObjectId;
import persistencia.IResenaDAO;
import persistencia.impl.ResenaDAO;

/**
 *
 * @author USER
 */
public class ResenaBO implements IResenaBO {

    private final IResenaDAO resenaDAO;
    private final IProductoBO productoBO;
    private final IUsuarioBO usuarioBO;

    public ResenaBO() {
        this.resenaDAO = new ResenaDAO(MongoClientProvider.INSTANCE.getcCollection("resena", reseña.class));
        this.productoBO = new ProductoBO();
        this.usuarioBO = new UsuarioBO();
    }

    public ResenaBO(IResenaDAO resenaDAO) {
        this.resenaDAO = resenaDAO;
        this.productoBO = new ProductoBO();
        this.usuarioBO = new UsuarioBO();
    }

    @Override
    public List<reseña> listarTodasResenas() {
        return resenaDAO.listarTodas();
    }

    @Override
    public List<reseña> listarPorProducto(ObjectId productoId) {
        if (productoId == null) {
            return Collections.emptyList();
        }
        return resenaDAO.listarPorProducto(productoId);
    }

    @Override
    public boolean eliminarResena(ObjectId id) throws Exception {
        if (id == null) {
            throw new IllegalArgumentException("El id de la reseña es obligatorio");
        }
        return resenaDAO.eliminarPorId(id);
    }
    
    @Override
    public java.util.Optional<reseña> obtenerResena(ObjectId id) throws Exception {
        if (id == null) {
            throw new IllegalArgumentException("El id de la reseña es obligatorio");
        }
        return resenaDAO.obtenerPorId(id);
    }
    
    @Override
    public boolean actualizarResena(reseña resena) throws Exception {
        if (resena == null || resena.getId() == null) {
            throw new IllegalArgumentException("La reseña debe tener id para actualizar");
        }
        return resenaDAO.actualizar(resena);
    }

    @Override
    public void registrarResena(ObjectId productoId, String correoUsuario, double calificacion, String comentario) throws Exception {
        if (productoId == null) {
            throw new IllegalArgumentException("El producto es obligatorio");
        }
        if (correoUsuario == null || correoUsuario.trim().isEmpty()) {
            throw new IllegalArgumentException("Debe iniciar sesión para dejar una reseña");
        }
        if (calificacion < 1 || calificacion > 5) {
            throw new IllegalArgumentException("La calificación debe estar entre 1 y 5");
        }
        if (comentario == null || comentario.trim().length() < 5) {
            throw new IllegalArgumentException("El comentario debe tener al menos 5 caracteres");
        }
        if (comentario.trim().length() > 500) {
            throw new IllegalArgumentException("El comentario no puede exceder 500 caracteres");
        }

        Optional<Producto> productoOpt = productoBO.obtenerPorId(productoId);
        if (!productoOpt.isPresent()) {
            throw new IllegalArgumentException("Producto no encontrado");
        }

        Optional<Usuario> usuarioOpt = usuarioBO.obtenerUsuarioPorCorreo(correoUsuario.trim());
        if (!usuarioOpt.isPresent()) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        Usuario usuario = usuarioOpt.get();
        reseña r = new reseña();
        r.setId(new ObjectId());
        r.setProductoId(productoId);
        r.setNombreUsuario(usuario.getNombre());
        r.setCalificacion(calificacion);
        r.setComentario(comentario.trim());
        r.setFecha(new Date());
        r.setAprobada(false);
        resenaDAO.crear(r);
    }
}
