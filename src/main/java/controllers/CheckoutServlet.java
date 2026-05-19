package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.ItemCarrito;
import model.Usuario;
import negocio.UsuarioBO;
import negocio.interfaces.IUsuarioBO;
import java.util.Optional;

/**
 * Servlet para preparar el checkout (revisar carrito, validar stock, etc)
 */
@WebServlet(name = "CheckoutServlet", urlPatterns = {"/checkout"})
public class CheckoutServlet extends HttpServlet {
    
    private IUsuarioBO usuarioBO;
    private static final String CARRITO_SESION = "carrito";
    
    public CheckoutServlet() {
        this.usuarioBO = new UsuarioBO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(false);
        
        if (sesion == null || sesion.getAttribute("usuario") == null) {
            response.sendRedirect(request.getContextPath() + "/loginView.jsp?redirigir=checkout");
            return;
        }
        
        List<ItemCarrito> carrito = (List<ItemCarrito>) sesion.getAttribute(CARRITO_SESION);
        
        if (carrito == null || carrito.isEmpty()) {
            request.setAttribute("error", "El carrito está vacío");
            request.getRequestDispatcher("/carritoView.jsp").forward(request, response);
            return;
        }
        
        String correo = (String) sesion.getAttribute("usuario");
        Optional<Usuario> usuarioOpt = usuarioBO.obtenerUsuarioPorCorreo(correo);
        
        if (!usuarioOpt.isPresent()) {
            request.setAttribute("error", "Usuario no encontrado");
            request.getRequestDispatcher("/carritoView.jsp").forward(request, response);
            return;
        }
        
        Usuario usuario = usuarioOpt.get();
        double total = carrito.stream()
                .mapToDouble(ItemCarrito::getSubtotal)
                .sum();
        
        request.setAttribute("usuario", usuario);
        request.setAttribute("carrito", carrito);
        request.setAttribute("total", total);
        request.setAttribute("subtotal", total);
        request.setAttribute("cantidadItems", carrito.size());
        request.getRequestDispatcher("/checkoutView.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
