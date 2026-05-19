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
import model.reseña;
import negocio.ResenaBO;
import negocio.interfaces.IResenaBO;
import org.bson.types.ObjectId;

/**
 * Servlet para moderación de reseñas por admin
 */
@WebServlet(name = "ModeraciónResenasServlet", urlPatterns = {"/admin/moderacionResenas"})
public class ModeraciónResenasServlet extends HttpServlet {
    
    private IResenaBO resenaBO;
    
    public ModeraciónResenasServlet() {
        this.resenaBO = new ResenaBO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!esAdmin(request)) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
        
        String filtro = request.getParameter("filtro");
        
        try {
            List<reseña> resenas = resenaBO.listarTodasResenas();
            
            if ("pendientes".equals(filtro)) {
                resenas.removeIf(r -> r.isAprobada());
                request.setAttribute("tituloFiltro", "Reseñas Pendientes");
            } else if ("aprobadas".equals(filtro)) {
                resenas.removeIf(r -> !r.isAprobada());
                request.setAttribute("tituloFiltro", "Reseñas Aprobadas");
            } else {
                request.setAttribute("tituloFiltro", "Todas las Reseñas");
            }
            
            request.setAttribute("resenas", resenas);
            request.getRequestDispatcher("/moderacionResenasView.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error al listar reseñas: " + e.getMessage());
            request.getRequestDispatcher("/moderacionResenasView.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!esAdmin(request)) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
        
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        String resenaIdStr = request.getParameter("resenaId");
        
        if ("aprobar".equals(accion)) {
            aprobarResena(request, response, resenaIdStr);
        } else if ("rechazar".equals(accion)) {
            rechazarResena(request, response, resenaIdStr);
        } else {
            doGet(request, response);
        }
    }
    
    private void aprobarResena(HttpServletRequest request, HttpServletResponse response, String resenaIdStr)
            throws ServletException, IOException {
        if (resenaIdStr == null || resenaIdStr.trim().isEmpty()) {
            request.setAttribute("error", "ID de reseña inválido");
            doGet(request, response);
            return;
        }
        
        try {
            ObjectId resenaId = new ObjectId(resenaIdStr);
            Optional<reseña> resenaOpt = resenaBO.obtenerResena(resenaId);
            
            if (resenaOpt.isPresent()) {
                reseña resena = resenaOpt.get();
                resena.setAprobada(true);
                resenaBO.actualizarResena(resena);
                request.setAttribute("mensaje", "Reseña aprobada correctamente");
            } else {
                request.setAttribute("error", "Reseña no encontrada");
            }
        } catch (Exception e) {
            request.setAttribute("error", "Error al aprobar reseña: " + e.getMessage());
        }
        
        doGet(request, response);
    }
    
    private void rechazarResena(HttpServletRequest request, HttpServletResponse response, String resenaIdStr)
            throws ServletException, IOException {
        if (resenaIdStr == null || resenaIdStr.trim().isEmpty()) {
            request.setAttribute("error", "ID de reseña inválido");
            doGet(request, response);
            return;
        }
        
        try {
            ObjectId resenaId = new ObjectId(resenaIdStr);
            resenaBO.eliminarResena(resenaId);
            request.setAttribute("mensaje", "Reseña rechazada y eliminada");
        } catch (Exception e) {
            request.setAttribute("error", "Error al rechazar reseña: " + e.getMessage());
        }
        
        doGet(request, response);
    }
    
    private boolean esAdmin(HttpServletRequest request) {
        HttpSession sesion = request.getSession(false);
        return sesion != null && sesion.getAttribute("usuario") != null;
    }
}
