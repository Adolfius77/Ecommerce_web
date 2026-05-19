package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminDashboardServlet", urlPatterns = {"/admin/dashboard"})
public class AdminDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Verificar que el usuario sea admin
        Object esAdminObj = request.getSession().getAttribute("esAdmin");
        Boolean esAdmin = (esAdminObj instanceof Boolean) ? (Boolean) esAdminObj : false;
        
        if (!esAdmin) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
        
        // Redirigir a la vista del dashboard
        request.getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
    }
}
