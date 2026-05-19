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
import model.Pedido;
import model.estadoPedido;
import negocio.PedidoBO;
import negocio.interfaces.IPedidoBO;
import org.bson.types.ObjectId;

/**
 * Servlet para gestión de pedidos y pagos por admin
 */
@WebServlet(name = "GestionPedidosServlet", urlPatterns = {"/admin/gestionPedidos"})
public class GestionPedidosServlet extends HttpServlet {
    
    private IPedidoBO pedidoBO;
    
    public GestionPedidosServlet() {
        this.pedidoBO = new PedidoBO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!esAdmin(request)) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
        
        try {
            List<Pedido> pedidos = pedidoBO.listarTodosPedidos();
            request.setAttribute("pedidos", pedidos);
            request.getRequestDispatcher("/gestionPedidosPagosView.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error al listar pedidos: " + e.getMessage());
            request.getRequestDispatcher("/gestionPedidosPagosView.jsp").forward(request, response);
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
        String pedidoIdStr = request.getParameter("pedidoId");
        
        if ("cambiarEstado".equals(accion)) {
            cambiarEstadoPedido(request, response, pedidoIdStr);
        } else if ("cambiarEstadoPago".equals(accion)) {
            cambiarEstadoPago(request, response, pedidoIdStr);
        } else {
            doGet(request, response);
        }
    }
    
    private void cambiarEstadoPedido(HttpServletRequest request, HttpServletResponse response, String pedidoIdStr)
            throws ServletException, IOException {
        if (pedidoIdStr == null || pedidoIdStr.trim().isEmpty()) {
            request.setAttribute("error", "ID de pedido inválido");
            doGet(request, response);
            return;
        }
        
        String nuevoEstadoStr = request.getParameter("nuevoEstado");
        
        try {
            ObjectId pedidoId = new ObjectId(pedidoIdStr);
            estadoPedido nuevoEstado = estadoPedido.valueOf(nuevoEstadoStr);
            
            pedidoBO.cambiarEstadoPedido(pedidoId, nuevoEstado);
            request.setAttribute("mensaje", "Estado del pedido actualizado a: " + nuevoEstado);
        } catch (Exception e) {
            request.setAttribute("error", "Error al cambiar estado: " + e.getMessage());
        }
        
        doGet(request, response);
    }
    
    private void cambiarEstadoPago(HttpServletRequest request, HttpServletResponse response, String pedidoIdStr)
            throws ServletException, IOException {
        if (pedidoIdStr == null || pedidoIdStr.trim().isEmpty()) {
            request.setAttribute("error", "ID de pedido inválido");
            doGet(request, response);
            return;
        }
        
        String nuevoEstadoPago = request.getParameter("nuevoEstadoPago");
        
        try {
            ObjectId pedidoId = new ObjectId(pedidoIdStr);
            List<Pedido> pedidos = pedidoBO.listarTodosPedidos();
            Optional<Pedido> pedidoOpt = pedidos.stream()
                    .filter(p -> p.getId().equals(pedidoId))
                    .findFirst();
            
            if (pedidoOpt.isPresent()) {
                Pedido pedido = pedidoOpt.get();
                pedido.setEstadoPago(nuevoEstadoPago);
                pedidoBO.actualizarPedido(pedido);
                request.setAttribute("mensaje", "Estado de pago actualizado a: " + nuevoEstadoPago);
            } else {
                request.setAttribute("error", "Pedido no encontrado");
            }
        } catch (Exception e) {
            request.setAttribute("error", "Error al cambiar estado de pago: " + e.getMessage());
        }
        
        doGet(request, response);
    }
    
    private boolean esAdmin(HttpServletRequest request) {
        HttpSession sesion = request.getSession(false);
        return sesion != null && sesion.getAttribute("usuario") != null;
    }
}
