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
import java.util.stream.Collectors;
import model.Producto;
import model.reseña;
import negocio.ProductoBO;
import negocio.ResenaBO;
import negocio.interfaces.IProductoBO;
import negocio.interfaces.IResenaBO;
import org.bson.types.ObjectId;

/**
 * Servlet para la ficha detallada de un producto (RF 2.3).
 */
@WebServlet(name = "DetalleProductoServlet", urlPatterns = {"/DetalleProducto"})
public class DetalleProductoServlet extends HttpServlet {

    private IProductoBO productoBO;
    private IResenaBO resenaBO;

    public DetalleProductoServlet() {
        this.productoBO = new ProductoBO();
        this.resenaBO = new ResenaBO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr == null || idStr.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/catalogo");
            return;
        }

        try {
            ObjectId productoId = new ObjectId(idStr);
            Optional<Producto> productoOpt = productoBO.obtenerPorId(productoId);

            if (!productoOpt.isPresent()) {
                response.sendRedirect(request.getContextPath() + "/catalogo?error=producto_no_encontrado");
                return;
            }

            Producto producto = productoOpt.get();
            List<reseña> resenas = resenaBO.listarPorProducto(productoId).stream()
                    .filter(reseña::isAprobada)
                    .collect(Collectors.toList());

            double promedio = 0;
            if (!resenas.isEmpty()) {
                promedio = resenas.stream()
                        .mapToDouble(reseña::getCalificacion)
                        .average()
                        .orElse(0);
            }

            HttpSession sesion = request.getSession(false);
            String usuarioLogueado = null;
            if (sesion != null) {
                usuarioLogueado = (String) sesion.getAttribute("usuario");
            }

            String mensaje = request.getParameter("mensaje");
            if (mensaje != null && !mensaje.isEmpty()) {
                request.setAttribute("mensaje", mensaje);
            }
            String error = request.getParameter("error");
            if (error != null && !error.isEmpty()) {
                request.setAttribute("error", error);
            }

            request.setAttribute("producto", producto);
            request.setAttribute("resenas", resenas);
            request.setAttribute("promedioCalificacion", promedio);
            request.setAttribute("totalResenas", resenas.size());
            request.setAttribute("usuarioLogueado", usuarioLogueado);
            request.getRequestDispatcher("/productoDetalleView.jsp").forward(request, response);

        } catch (IllegalArgumentException e) {
            response.sendRedirect(request.getContextPath() + "/catalogo?error=id_invalido");
        } catch (Exception e) {
            request.setAttribute("error", "Error al cargar el producto: " + e.getMessage());
            request.getRequestDispatcher("/catalogoView.jsp").forward(request, response);
        }
    }
}
