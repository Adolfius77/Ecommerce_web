///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
// */
//package Filtros;
//
//import java.io.IOException;
//import java.io.PrintStream;
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.FilterConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
///**
// *
// * @author USER
// */
//@WebFilter(filterName = "autentificacionFilter", urlPatterns = {"/*"})
//public class autentificacionFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response,
//            FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpRespose = (HttpServletResponse) response;
//        HttpSession sesion = httpRequest.getSession(false);
//
//        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
//
//        boolean esPaginaPublica = path.equals("aqui iran las paginas que deban iniciar sesion");
//
//        boolean estaLogueado = (sesion != null && sesion.getAttribute("usuario") != null);
//
//        if (estaLogueado || esPaginaPublica) {
//            chain.doFilter(request, response);
//        } else {
//            httpRespose.sendRedirect(httpRequest.getContextPath() + "/loginView.jsp?error=sesion_requerida");
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//    }
//
//    /**
//     * Init method for this filter
//     */
//    @Override
//    public void init(FilterConfig filterConfig) {
//
//    }
//
//}
