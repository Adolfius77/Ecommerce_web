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
            String nombre = request.getParameter("nombre");
            String categoria = request.getParameter("categoria");
            String precioMinStr = request.getParameter("precioMin");
            String precioMaxStr = request.getParameter("precioMax");
            
            List<Producto> listaProductos;
            
            if ((nombre != null && !nombre.trim().isEmpty()) || 
                (categoria != null && !categoria.trim().isEmpty()) ||
                (precioMinStr != null && !precioMinStr.isEmpty()) ||
                (precioMaxStr != null && !precioMaxStr.isEmpty())) {
                
                Double precioMin = null;
                Double precioMax = null;
                
                if (precioMinStr != null && !precioMinStr.isEmpty()) {
                    try {
                        precioMin = Double.parseDouble(precioMinStr);
                    } catch (NumberFormatException e) {
                      
                    }
                }
                
                if (precioMaxStr != null && !precioMaxStr.isEmpty()) {
                    try {
                        precioMax = Double.parseDouble(precioMaxStr);
                    } catch (NumberFormatException e) {
                      
                    }
                }
                
                listaProductos = productoBO.filtrarProductos(nombre, categoria, precioMin, precioMax);
                request.setAttribute("filtroAplicado", true);
            } else {
                listaProductos = productoBO.listarProductos();
            }
            
            request.setAttribute("productos", listaProductos);
            request.setAttribute("nombreBusqueda", nombre != null ? nombre : "");
            request.setAttribute("categoriaBusqueda", categoria != null ? categoria : "");
            request.getRequestDispatcher("/catalogoView.jsp").forward(request, response);
            
        } catch (Exception e) {
            request.setAttribute("error", "error al cargar los productos: " + e.getMessage());
            request.getRequestDispatcher("/catalogoView.jsp").forward(request, response);
        }
    }

}
