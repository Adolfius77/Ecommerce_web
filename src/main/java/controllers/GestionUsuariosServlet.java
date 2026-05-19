package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import model.Usuario;
import negocio.UsuarioBO;
import negocio.interfaces.IUsuarioBO;
import org.bson.types.ObjectId;

/**
 * Servlet para gestión de usuarios por admin
 */
@WebServlet(name = "GestionUsuariosServlet", urlPatterns = {"/admin/gestionUsuarios"})
public class GestionUsuariosServlet extends HttpServlet {
    
    private IUsuarioBO usuarioBO;
    
    public GestionUsuariosServlet() {
        this.usuarioBO = new UsuarioBO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!esAdmin(request)) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
        
        try {
            List<Usuario> usuarios = usuarioBO.listarTodosUsuarios();
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("/gestionUsuariosView.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error al listar usuarios: " + e.getMessage());
            request.getRequestDispatcher("/gestionUsuariosView.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!esAdmin(request)) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
        
        String accion = request.getParameter("accion");
        
        if ("activar".equals(accion)) {
            activarDesactivarUsuario(request, response, true);
        } else if ("desactivar".equals(accion)) {
            activarDesactivarUsuario(request, response, false);
        } else if ("cambiarRol".equals(accion)) {
            cambiarRolUsuario(request, response);
        } else {
            doGet(request, response);
        }
    }
    
    private void activarDesactivarUsuario(HttpServletRequest request, HttpServletResponse response, boolean activo)
            throws ServletException, IOException {
        String usuarioIdStr = request.getParameter("usuarioId");
        
        if (usuarioIdStr == null || usuarioIdStr.trim().isEmpty()) {
            request.setAttribute("error", "ID de usuario inválido");
            doGet(request, response);
            return;
        }
        
        try {
            ObjectId usuarioId = new ObjectId(usuarioIdStr);
            Optional<Usuario> usuarioOpt = usuarioBO.obtenerUsuarioPorId(usuarioId);
            
            if (!usuarioOpt.isPresent()) {
                request.setAttribute("error", "Usuario no encontrado");
                doGet(request, response);
                return;
            }
            
            Usuario usuario = usuarioOpt.get();
            usuario.setActivo(activo);
            usuarioBO.actualizarUsuario(usuario);
            
            request.setAttribute("mensaje", "Usuario " + (activo ? "activado" : "desactivado") + " correctamente");
        } catch (Exception e) {
            request.setAttribute("error", "Error al actualizar usuario: " + e.getMessage());
        }
        
        doGet(request, response);
    }
    
    private void cambiarRolUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuarioIdStr = request.getParameter("usuarioId");
        String nuevoRol = request.getParameter("rol");
        
        if (usuarioIdStr == null || usuarioIdStr.trim().isEmpty() || nuevoRol == null) {
            request.setAttribute("error", "Datos inválidos");
            doGet(request, response);
            return;
        }
        
        try {
            ObjectId usuarioId = new ObjectId(usuarioIdStr);
            Optional<Usuario> usuarioOpt = usuarioBO.obtenerUsuarioPorId(usuarioId);
            
            if (!usuarioOpt.isPresent()) {
                request.setAttribute("error", "Usuario no encontrado");
                doGet(request, response);
                return;
            }
            
            Usuario usuario = usuarioOpt.get();
            usuario.setRol(nuevoRol);
            usuarioBO.actualizarUsuario(usuario);
            
            request.setAttribute("mensaje", "Rol del usuario cambió a " + nuevoRol);
        } catch (Exception e) {
            request.setAttribute("error", "Error al cambiar rol: " + e.getMessage());
        }
        
        doGet(request, response);
    }
    
    private boolean esAdmin(HttpServletRequest request) {
        HttpSession sesion = request.getSession(false);
        if (sesion == null) {
            return false;
        }
        
        return sesion.getAttribute("usuario") != null;
    }
}
