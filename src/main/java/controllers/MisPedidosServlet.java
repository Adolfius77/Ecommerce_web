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
import model.Pedido;
import negocio.UsuarioBO;
import negocio.PedidoBO;
import negocio.interfaces.IUsuarioBO;
import negocio.interfaces.IPedidoBO;

/**
 * Servlet para mostrar el historial de pedidos del usuario
 */
@WebServlet(name = "MisPedidosServlet", urlPatterns = {"/misPedidos"})
public class MisPedidosServlet extends HttpServlet {
    
    private IUsuarioBO usuarioBO;
    private IPedidoBO pedidoBO;
    
    public MisPedidosServlet() {
        this.usuarioBO = new UsuarioBO();
        this.pedidoBO = new PedidoBO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(false);
        
        if (sesion == null || sesion.getAttribute("usuario") == null) {
            response.sendRedirect(request.getContextPath() + "/loginView.jsp");
            return;
        }
        
        String correo = (String) sesion.getAttribute("usuario");
        Optional<Usuario> usuarioOpt = usuarioBO.obtenerUsuarioPorCorreo(correo);
        
        if (!usuarioOpt.isPresent()) {
            request.setAttribute("error", "Usuario no encontrado");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        
        try {
            Usuario usuario = usuarioOpt.get();
            List<Pedido> pedidos = pedidoBO.obtenerPedidosPorUsuario(usuario.getId());
            
            request.setAttribute("usuario", usuario);
            request.setAttribute("pedidos", pedidos);
            request.getRequestDispatcher("/misPedidosView.jsp").forward(request, response);
            
        } catch (Exception e) {
            request.setAttribute("error", "Error al obtener pedidos: " + e.getMessage());
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
