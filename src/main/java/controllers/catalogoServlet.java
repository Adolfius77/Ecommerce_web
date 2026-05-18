/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Producto;
import negocio.ProductoBO;
import negocio.interfaces.IProductoBO;

/**
 *
 * @author USER
 */
@WebServlet(name = "catalogoServlet", urlPatterns = {"/catalogo"})
public class catalogoServlet extends HttpServlet {
    private IProductoBO productoBO;

    public catalogoServlet() {
        this.productoBO = new ProductoBO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Producto> listaProductos = productoBO.listarProductos();
            request.setAttribute("productos", listaProductos);
            request.getRequestDispatcher("/catalogoView.jsp").forward(request, response);
            
        } catch (Exception e) {
            request.setAttribute("error", "error al cargar los productos: " + e.getMessage());
            request.getRequestDispatcher("/catalogoView.jsp").forward(request, response);
        }
    }

}
