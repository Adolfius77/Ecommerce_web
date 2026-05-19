<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Proyecto ECommerce - Mis Pedidos</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link rel="stylesheet" href="./styles/estiloCarrito.css">
        <link rel="stylesheet" href="./styles/estiloMisPedidos.css">
    </head>
    <body>

        <div class="layout-container">
            <aside class="sidebar">
                <nav>
                    <ul>
                        <li><a href="index.jsp"><i class="fa-solid fa-house"></i> Inicio</a></li>
                        <li><a href="${pageContext.request.contextPath}/catalogo"><i class="fa-solid fa-box-open"></i> Catálogo de productos</a></li>
                        <li><a href="${pageContext.request.contextPath}/carrito"><i class="fa-solid fa-shopping-cart"></i> Carrito de compras</a></li>
                        <li><a href="${pageContext.request.contextPath}/misPedidos" class="active"><i class="fa-solid fa-clock-rotate-left"></i> Mis pedidos</a></li>
                        <li><a href="${pageContext.request.contextPath}/Perfil"><i class="fa-solid fa-user"></i> Mi perfil</a></li>
                        <li><a href="loginView.jsp"><i class="fa-solid fa-right-to-bracket"></i> Iniciar sesión</a></li>
                    </ul>
                </nav>
            </aside>

            <div class="main-panel">

                <header class="topbar">
                    <div class="topbar-links">
                        <a href="${pageContext.request.contextPath}/Perfil"><i class="fas fa-user"></i> Perfil</a>
                        <a href="${pageContext.request.contextPath}/Logout"><i class="fas fa-sign-out-alt"></i> Cerrar sesión</a>
                    </div>
                </header>

                <main class="content">
                    <div class="pedidos-header">
                        <h2>Mis Pedidos</h2>
                        <p>Historial y estado de tus pedidos.</p>
                        <c:if test="${not empty error}">
                            <p style="color: red;">${error}</p>
                        </c:if>
                    </div>

                    <c:if test="${empty pedidos}">
                        <div style="text-align: center; padding: 40px;">
                            <p style="margin-bottom: 30px ; font-size: 18px">No tienes pedidos aún</p>
                            <a class="btn-primario" href="${pageContext.request.contextPath}/catalogo">Ir al catálogo</a>
                        </div>
                    </c:if>

                    <c:if test="${not empty pedidos}">
                        <div class="pedidos-lista">
                            <c:forEach var="pedido" items="${pedidos}">
                                <article class="pedido-card">
                                    <div class="pedido-header">
                                        <div>
                                            <h4>Pedido #${pedido.numeroPedido}</h4>
                                            <p class="pedido-fecha">Fecha: <fmt:formatDate value="${pedido.fechaPedido}" pattern="dd/MM/yyyy" /></p>
                                        </div>
                                        <div class="pedido-estado">
                                            <span class="estado ${pedido.estado}">${pedido.estado}</span>
                                            <p class="pedido-total">Total: $${pedido.total}</p>
                                        </div>
                                    </div>

                                    <div class="pedido-items">
                                        <c:forEach var="detalle" items="${pedido.detalles}">
                                            <div class="item-resumen">
                                                <span>${detalle.nombre} x ${detalle.cantidad}</span>
                                                <span>$${detalle.precioUnitario * detalle.cantidad}</span>
                                            </div>
                                        </c:forEach>
                                    </div>

                                    <div class="pedido-acciones">
                                        <button class="btn-secundario">Ver detalles</button>
                                        <button class="btn-secundario">Descargar recibo</button>
                                    </div>
                                </article>
                            </c:forEach>
                        </div>
                    </c:if>
                </main>

                <footer class="footer">
                    <p>Aplicaciones Web – Unidad 4</p>
                </footer>

            </div>
        </div>

    </body>
</html>
