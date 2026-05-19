/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.impl;

import Config.MongoClientProvider;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Usuario;
import org.bson.types.ObjectId;
import persistencia.IUsuarioDAO;
import util.PasswordUtil;

/**
 *
 * @author USER
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final MongoCollection<Usuario> col;

    public UsuarioDAO(MongoCollection<Usuario> col) {
        this.col = MongoClientProvider.INSTANCE.getcCollection("usuario", Usuario.class);
    }

    @Override
    public ObjectId registrarUsuario(Usuario entidad, String rol) {
        try {
            if (entidad.getId() == null) {
                entidad.setId(new ObjectId());
            }
            entidad.setRol(rol);
            entidad.setActivo(true);
            col.insertOne(entidad);
            return entidad.getId();
        } catch (MongoException e) {
            throw new MongoException("error al registrar al " + entidad + e.getMessage());
        }
    }

    @Override
    public Usuario autentificar(String correo, String password, String rol) {
        try {
            Usuario usuario = col.find(Filters.and(
                    Filters.eq("correo", correo),
                    Filters.eq("rol", rol)
            )).first();
            
            if (usuario != null && usuario.isActivo() && PasswordUtil.verifyPassword(password, usuario.getContrasena())) {
                return usuario;
            }
            return null;
        } catch (Exception e) {
            throw new MongoException("error al autentificar al: " + rol + e.getMessage());
        }
    }

    @Override
    public Optional<Usuario> encontrarPorId(ObjectId _id) {
        try {
            return Optional.ofNullable(col.find(Filters.eq("_id", _id)).first());
        } catch (MongoException e) {
            throw new MongoException("error al encontrar al usuario" + e);
        }
    }

    @Override
    public List<Usuario> encontrarTodos(Usuario entidad) {
        try {
            return col.find().into(new ArrayList<>());
        } catch (MongoException e) {
            throw new MongoException("error al encontrar a todos los usuarios");
        }
    }

    @Override
    public boolean actualizar(Usuario entidad) {
        try {
            UpdateResult resultado = col.replaceOne(
                    Filters.eq("_id", entidad.getId()),
                    entidad
            );
            return resultado.getModifiedCount() > 0;
        } catch (MongoException e) {
            throw new MongoException("error al actualizar al usuario" + e);
        }
    }

    @Override
    public boolean eliminarPorId(ObjectId _id) {
        try {
            var resultado = col.deleteOne(Filters.eq("_id", _id));
            if (resultado.getDeletedCount() == 0) {
                throw new MongoException("usuario no existe" + _id);
            }
            return true;
        } catch (Exception e) {
            throw new MongoException("error al eliminar al usuario");
        }
    }

    @Override
    public Optional<Usuario> encontrarPorNombre(String nombre) {
        try {
            return Optional.ofNullable(col.find(Filters.eq("nombre", nombre)).first());

        } catch (MongoException e) {
            throw new MongoException("error al buscar por nombre" + e);
        }
    }

    @Override
    public List<Usuario> listarTodos() {
        try {
            return col.find().into(new ArrayList<>());
        } catch (MongoException e) {
            throw new MongoException("error al listar usuarios: " + e.getMessage());
        }
    }

    @Override
    public Optional<Usuario> buscarPorCorreo(String correo) {
        try {
            return Optional.ofNullable(col.find(Filters.eq("correo", correo)).first());
        } catch (MongoException e) {
            throw new MongoException("error al buscar usuario por correo: " + e.getMessage());
        }
    }

    @Override
    public boolean actualizarActivo(ObjectId id, boolean activo) {
        try {
            UpdateResult r = col.updateOne(Filters.eq("_id", id), Updates.set("activo", activo));
            return r.getModifiedCount() > 0;
        } catch (MongoException e) {
            throw new MongoException("error al actualizar estado activo del usuario: " + e.getMessage());
        }
    }
}
