/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Config.MongoClientProvider;
import java.util.List;
import java.util.Optional;
import model.Categoria;
import negocio.interfaces.ICategoriaBO;
import org.bson.types.ObjectId;
import persistencia.ICategoriaDAO;
import persistencia.impl.CategoriaDAO;

/**
 *
 * @author USER
 */
public class CategoriaBO implements ICategoriaBO {

    private final ICategoriaDAO categoriaDAO;

    public CategoriaBO() {
        this.categoriaDAO = new CategoriaDAO(MongoClientProvider.INSTANCE.getcCollection("categoria", Categoria.class));
    }

    public CategoriaBO(ICategoriaDAO categoriaDAO) {
        this.categoriaDAO = new CategoriaDAO(MongoClientProvider.INSTANCE.getcCollection("categoria", Categoria.class));
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaDAO.listarTodos();
    }

    @Override
    public Optional<Categoria> obtenerPorId(ObjectId id) {
        if (id == null) {
            return Optional.empty();
        }
        return categoriaDAO.obtenerPorId(id);
    }

    @Override
    public ObjectId registrarCategoria(Categoria categoria) throws Exception {
        validarNombre(categoria);
        return categoriaDAO.crear(categoria);
    }

    @Override
    public boolean actualizarCategoria(Categoria categoria) throws Exception {
        if (categoria == null || categoria.getId() == null) {
            throw new IllegalArgumentException("La categoría debe tener id para actualizar");
        }
        validarNombre(categoria);
        return categoriaDAO.actualizar(categoria);
    }

    @Override
    public boolean eliminarCategoria(ObjectId id) throws Exception {
        if (id == null) {
            throw new IllegalArgumentException("El id de categoría es obligatorio");
        }
        return categoriaDAO.eliminar(id);
    }

    private void validarNombre(Categoria categoria) throws Exception {
        if (categoria == null || categoria.getNombre() == null || categoria.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre de la categoría es obligatorio");
        }
    }
    
    @Override
    public boolean crearCategoria(Categoria categoria) throws Exception {
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula");
        }
        validarNombre(categoria);
        if (categoria.getId() == null) {
            categoria.setId(new ObjectId());
        }
        categoriaDAO.crear(categoria);
        return true;
    }
}
