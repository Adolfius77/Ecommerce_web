/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Config.MongoClientProvider;
import java.util.Collections;
import java.util.List;
import model.reseña;
import negocio.interfaces.IResenaBO;
import org.bson.types.ObjectId;
import persistencia.IResenaDAO;
import persistencia.impl.ResenaDAO;

/**
 *
 * @author USER
 */
public class ResenaBO implements IResenaBO {

    private final IResenaDAO resenaDAO;

    public ResenaBO() {
        this.resenaDAO = new ResenaDAO(MongoClientProvider.INSTANCE.getcCollection("resena", reseña.class));
    }

    public ResenaBO(IResenaDAO resenaDAO) {
        this.resenaDAO = new ResenaDAO(MongoClientProvider.INSTANCE.getcCollection("resena", reseña.class));
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
}
