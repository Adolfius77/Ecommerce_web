<%-- Historial de pedidos del cliente --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mis pedidos</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="./styles/estiloCarrito.css">
    <link rel="stylesheet" href="./styles/estiloMisPedidos.css">
</head>
<body>
    <div class="layout-container">
        <aside class="sidebar">
            <nav>
                <ul>
                   <li><a href="index.jsp" class="active"><i class="fa-solid fa-house"></i> Inicio</a></li>
                        <li><a href="catalogoView.jsp"><i class="fa-solid fa-box-open"></i> Catálogo de productos</a></li>
                        <li><a href="carritoView.jsp"><i class="fa-solid fa-shopping-cart"></i> Carrito de compras</a></li>
                        <li><a href="misPedidosView.jsp"><i class="fa-solid fa-clock-rotate-left"></i> Mis pedidos</a></li>
                        <li><a href="gestionProductosView.jsp"><i class="fa-solid fa-screwdriver-wrench"></i> Administración</a></li>
                        <li><a href="${pageContext.request.contextPath}/Perfil"><i class="fa-solid fa-user"></i> Mi perfil</a></li>
                        <li><a href="loginView.jsp"><i class="fa-solid fa-right-to-bracket"></i> Iniciar sesión</a></li>
                </ul>
            </nav>
        </aside>
        <div class="main-panel">
            <header class="topbar">
                <div class="topbar-links">
                    <a href="perfilUsuarioView.jsp"><i class="fas fa-user"></i> Perfil</a>
                    <a href="loginView.jsp"><i class="fas fa-sign-out-alt"></i> Cerrar sesión</a>
                </div>
            </header>
            <main class="content">
                <div class="pedidos-cliente-header">
                    <h2>Mis pedidos</h2>
                    <p>Consulta el estado de tus compras anteriores. Datos de ejemplo hasta conectar con el backend.</p>
                </div>

                <div class="pedidos-lista">
                    <article class="pedido-historial-card">
                        <div class="pedido-historial-top">
                            <div>
                                <h3>Pedido #PED-2048</h3>
                                <p class="pedido-meta">Realizado el 10 de mayo de 2026</p>
                                <span class="badge-estado badge-enviado">Enviado</span>
                            </div>
                            <div class="pedido-total">$238.00</div>
                        </div>
                        <ul class="detalle-pedido-lista">
                            <li>Smartwatch Fit × 1 — $89.00</li>
                            <li>Audífonos inalámbricos × 1 — $149.00</li>
                        </ul>
                        <div class="pedido-acciones">
                            <button type="button" class="btn-primario">Ver detalle</button>
                            <a class="btn-secundario" href="catalogoView.jsp">Volver a comprar</a>
                        </div>
                    </article>

                    <article class="pedido-historial-card">
                        <div class="pedido-historial-top">
                            <div>
                                <h3>Pedido #PED-1988</h3>
                                <p class="pedido-meta">Realizado el 2 de mayo de 2026</p>
                                <span class="badge-estado badge-entregado">Entregado</span>
                            </div>
                            <div class="pedido-total">$45.50</div>
                        </div>
                        <ul class="detalle-pedido-lista">
                            <li>Lámpara de escritorio × 1 — $45.50</li>
                        </ul>
                        <div class="pedido-acciones">
                            <button type="button" class="btn-primario">Ver detalle</button>
                            <a class="btn-secundario" href="catalogoView.jsp">Volver a comprar</a>
                        </div>
                    </article>

                    <article class="pedido-historial-card">
                        <div class="pedido-historial-top">
                            <div>
                                <h3>Pedido #PED-1920</h3>
                                <p class="pedido-meta">Realizado el 28 de abril de 2026</p>
                                <span class="badge-estado badge-pendiente">Pendiente</span>
                            </div>
                            <div class="pedido-total">$120.00</div>
                        </div>
                        <ul class="detalle-pedido-lista">
                            <li>Teclado mecánico × 1 — $120.00</li>
                        </ul>
                        <div class="pedido-acciones">
                            <button type="button" class="btn-primario">Ver detalle</button>
                            <a class="btn-secundario" href="catalogoView.jsp">Volver a comprar</a>
                        </div>
                    </article>
                </div>
            </main>
            <footer class="footer">
                <p>Aplicaciones Web – Unidad 4</p>
            </footer>
        </div>
    </div>
</body>
</html>
