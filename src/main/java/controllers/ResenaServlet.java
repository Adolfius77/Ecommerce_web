package controllers;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import negocio.ResenaBO;
import negocio.interfaces.IResenaBO;
import org.bson.types.ObjectId;

/**
 * Servlet para crear reseñas de productos (RF 7.1).
 */
@WebServlet(name = "ResenaServlet", urlPatterns = {"/resena"})
public class ResenaServlet extends HttpServlet {

    private IResenaBO resenaBO;

    public ResenaServlet() {
        this.resenaBO = new ResenaBO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession sesion = request.getSession(false);
        String productoIdStr = request.getParameter("productoId");
        String contextPath = request.getContextPath();

        if (sesion == null || sesion.getAttribute("usuario") == null) {
            String redir = productoIdStr != null
                    ? contextPath + "/loginView.jsp?redirigir=DetalleProducto&id=" + productoIdStr
                    : contextPath + "/loginView.jsp";
            response.sendRedirect(redir);
            return;
        }

        if (productoIdStr == null || productoIdStr.trim().isEmpty()) {
            response.sendRedirect(contextPath + "/catalogo");
            return;
        }

        String correo = (String) sesion.getAttribute("usuario");
        String calificacionStr = request.getParameter("calificacion");
        String comentario = request.getParameter("comentario");

        try {
            ObjectId productoId = new ObjectId(productoIdStr);
            double calificacion = Double.parseDouble(calificacionStr);
            resenaBO.registrarResena(productoId, correo, calificacion, comentario);

            String mensaje = URLEncoder.encode(
                    "Reseña enviada; pendiente de aprobación del administrador",
                    StandardCharsets.UTF_8);
            response.sendRedirect(contextPath + "/DetalleProducto?id=" + productoIdStr + "&mensaje=" + mensaje);

        } catch (IllegalArgumentException e) {
            String error = URLEncoder.encode(e.getMessage(), StandardCharsets.UTF_8);
            response.sendRedirect(contextPath + "/DetalleProducto?id=" + productoIdStr + "&error=" + error);
        } catch (Exception e) {
            String error = URLEncoder.encode("Error al guardar la reseña: " + e.getMessage(), StandardCharsets.UTF_8);
            response.sendRedirect(contextPath + "/DetalleProducto?id=" + productoIdStr + "&error=" + error);
        }
    }
}
