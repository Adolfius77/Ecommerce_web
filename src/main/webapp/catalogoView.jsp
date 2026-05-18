<%-- 
    Document   : newjsp
    Created on : May 12, 2026, 7:34:43 PM
    Author     : adolfo
--%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Proyecto ECommerce - Catalogo</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="./styles/estiloCatalogo.css">
</head>
<body>

    <div class="layout-container">
        <aside class="sidebar">
            <nav>
                <ul>
                    <li><a href="index.jsp"><i class="fa-solid fa-house"></i> Inicio</a></li>
                    <li><a href="${pageContext.request.contextPath}/catalogo" class="active"><i class="fa-solid fa-box-open"></i> Catálogo de productos</a></li>
                    <li><a href="carritoView.jsp"><i class="fa-solid fa-shopping-cart"></i> Carrito de compras</a></li>
                    <li><a href="misPedidosView.jsp"><i class="fa-solid fa-clock-rotate-left"></i> Mis pedidos</a></li>
                    <li><a href="gestionProductosView.jsp"><i class="fa-solid fa-screwdriver-wrench"></i> Administración</a></li>
                    <li><a href="${pageContext.request.contextPath}/ActualizarPerfil"><i class="fa-solid fa-user"></i> Mi perfil</a></li>
                    <li><a href="loginView.jsp"><i class="fa-solid fa-right-to-bracket"></i> Iniciar sesión</a></li>
                </ul>
            </nav>
        </aside>

        <div class="main-panel">
            
            <header class="topbar">
                <div class="topbar-links">
                    <a href="${pageContext.request.contextPath}/ActualizarPerfil"><i class="fas fa-user"></i> Perfil</a>
                    <a href="loginView.jsp"><i class="fas fa-sign-out-alt"></i> Cerrar sesión</a>
                </div>
            </header>

            <main class="content">
                <div class="catalogo-header">
                    <div>
                        <h2>Catálogo de productos</h2>
                        <p>Encuentra productos usando filtros y barra de búsqueda.</p>
                        <c:if test="${not empty error}">
                            <p style="color: red;">${error}</p>
                        </c:if>
                    </div>
                    <div class="search-bar">
                        <input type="text" placeholder="Buscar productos, marcas o categorías">
                        <button class="btn-primario"><i class="fa-solid fa-magnifying-glass"></i> Buscar</button>
                    </div>
                </div>

                <div class="catalogo-grid">
                    <aside class="filtros">
                        <h3>Filtros</h3>
                        <div class="filtro-grupo">
                            <label>Categorías</label>
                            <div class="filtro-opciones">
                                <label><input type="checkbox"> Tecnología</label>
                                <label><input type="checkbox"> Hogar</label>
                                <label><input type="checkbox"> Accesorios</label>
                                <label><input type="checkbox"> Moda</label>
                            </div>
                        </div>
                        <div class="filtro-grupo">
                            <label>Rango de precio</label>
                            <div class="filtro-opciones">
                                <label><input type="checkbox"> $0 - $50</label>
                                <label><input type="checkbox"> $51 - $150</label>
                                <label><input type="checkbox"> $151 - $300</label>
                                <label><input type="checkbox"> $300+</label>
                            </div>
                        </div>
                        <div class="filtro-grupo">
                            <label>Valoración</label>
                            <div class="filtro-opciones">
                                <label><input type="checkbox"> 5 estrellas</label>
                                <label><input type="checkbox"> 4 estrellas o más</label>
                                <label><input type="checkbox"> 3 estrellas o más</label>
                            </div>
                        </div>
                        <div class="filtro-grupo">
                            <label>Disponibilidad</label>
                            <div class="filtro-opciones">
                                <label><input type="checkbox"> En stock</label>
                                <label><input type="checkbox"> En oferta</label>
                            </div>
                        </div>
                        <button class="btn-secundario">Limpiar filtros</button>
                    </aside>

                    <section class="productos-grid">
                        <c:if test="${empty productos}">
                            <div style="grid-column: 1 / -1; text-align: center; padding: 20px;">
                                <p>No hay productos disponibles en este momento.</p>
                            </div>
                        </c:if>

                        <c:forEach var="producto" items="${productos}">
                            <article class="producto-card">
                                <div class="producto-img" style="display: flex; justify-content: center; align-items: center; height: 150px; overflow: hidden; background: #f8f9fa;">
                                    <img src="${producto.imagenProducto}" alt="${producto.nombre}" style="max-height: 100%; max-width: 100%; object-fit: contain;" onerror="this.src='styles/img/placeholder.png'">
                                </div>
                                
                                <h4 style="margin: 10px 0 5px 0; font-size: 1.1em;">${producto.nombre}</h4>
                                <p class="producto-marca" style="color: #666; font-size: 0.9em; margin: 0;">${producto.categoria}</p>
                                <p class="producto-precio" style="font-weight: bold; font-size: 1.2em; color: #2c3e50; margin: 10px 0;">$${producto.precio}</p>
                                
                                <div style="font-size: 12px; margin-bottom: 15px;">
                                    <c:choose>
                                        <c:when test="${producto.stock > 10}">
                                            <span style="color: #137333; background: #e6f4ea; padding: 2px 6px; border-radius: 4px;">En stock</span>
                                        </c:when>
                                        <c:when test="${producto.stock > 0 && producto.stock <= 10}">
                                            <span style="color: #b06000; background: #feefe3; padding: 2px 6px; border-radius: 4px;">Últimos ${producto.stock}</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span style="color: #d93025; background: #fce8e6; padding: 2px 6px; border-radius: 4px;">Agotado</span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                                <div class="producto-acciones">
                                    <a class="btn-secundario" href="${pageContext.request.contextPath}/DetalleProducto?id=${producto.id}">Ver detalle</a>
                                    <button class="btn-primario" ${producto.stock == 0 ? 'disabled' : ''}>Agregar</button>
                                </div>
                            </article>
                        </c:forEach>
                    </section>
                </div>
            </main>

            <footer class="footer">
               <p>Aplicaciones Web – Unidad 4</p>
            </footer>

        </div>
    </div>

</body>
</html>