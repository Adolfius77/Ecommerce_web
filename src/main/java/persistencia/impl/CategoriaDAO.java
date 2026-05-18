/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.impl;

import Config.MongoClientProvider;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Categoria;
import org.bson.types.ObjectId;
import persistencia.ICategoriaDAO;

/**
 *
 * @author USER
 */
public class CategoriaDAO implements ICategoriaDAO {

    private final MongoCollection<Categoria> col;

    public CategoriaDAO(MongoCollection<Categoria> col) {
        this.col = MongoClientProvider.INSTANCE.getcCollection("categoria", Categoria.class);
    }

    @Override
    public ObjectId crear(Categoria categoria) {
        try {
            if (categoria.getId() == null) {
                categoria.setId(new ObjectId());
            }
            col.insertOne(categoria);
            return categoria.getId();
        } catch (MongoException e) {
            throw new MongoException("error al crear categoría: " + e.getMessage());
        }
    }

    @Override
    public List<Categoria> listarTodos() {
        try {
            return col.find().into(new ArrayList<>());
        } catch (MongoException e) {
            throw new MongoException("error al listar categorías: " + e.getMessage());
        }
    }

    @Override
    public Optional<Categoria> obtenerPorId(ObjectId id) {
        try {
            return Optional.ofNullable(col.find(eq("_id", id)).first());
        } catch (MongoException e) {
            throw new MongoException("error al obtener categoría: " + e.getMessage());
        }
    }

    @Override
    public boolean actualizar(Categoria categoria) {
        try {
            UpdateResult resultado = col.replaceOne(eq("_id", categoria.getId()), categoria);
            return resultado.getModifiedCount() > 0;
        } catch (MongoException e) {
            throw new MongoException("error al actualizar categoría: " + e.getMessage());
        }
    }

    @Override
    public boolean eliminar(ObjectId id) {
        try {
            DeleteResult resultado = col.deleteOne(eq("_id", id));
            return resultado.getDeletedCount() > 0;
        } catch (MongoException e) {
            throw new MongoException("error al eliminar categoría: " + e.getMessage());
        }
    }
}
