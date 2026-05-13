<%-- 
    Document   : newjsp
    Created on : May 12, 2026, 7:34:43 PM
    Author     : adolfo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Proyecto ECommerce - Carrito</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="./styles/estiloCarrito.css">
</head>
<body>

    <div class="layout-container">
        <!-- Menu Lateral -->
        <aside class="sidebar">
            <nav>
                <ul>
                   <li><a href="index.jsp"><i class="fa-solid fa-house"></i> Inicio</a></li>
                    <li><a href="catalogoView.jsp"><i class="fa-solid fa-box-open"></i> Catálogo de productos</a></li>
                    <li><a href="carritoView.jsp" class="active"><i class="fa-solid fa-shopping-cart"></i> Carrito de compras</a></li>
                    <li><a href="misPedidosView.jsp"><i class="fa-solid fa-clock-rotate-left"></i> Mis pedidos</a></li>
                    <li><a href="gestionProductosView.jsp"><i class="fa-solid fa-screwdriver-wrench"></i> Administración</a></li>
                    <li><a href="perfilUsuarioView.jsp"><i class="fa-solid fa-user"></i> Mi perfil</a></li>
                    <li><a href="loginView.jsp"><i class="fa-solid fa-right-to-bracket"></i> Iniciar sesión</a></li>
                </ul>
            </nav>
        </aside>

        <!-- Panel principal (Derecha) -->
        <div class="main-panel">
            
            <!-- Barra Superior -->
            <header class="topbar">
                <div class="topbar-links">
                    <a href="perfilUsuarioView.jsp"><i class="fas fa-user"></i> Perfil</a>
                    <a href="loginView.jsp"><i class="fas fa-sign-out-alt"></i> Cerrar sesión</a>
                </div>
            </header>

            <!-- Contenido -->
            <main class="content">
                <div class="carrito-header">
                    <h2>Carrito de compras</h2>
                    <p>Revisa tus artículos, ajusta cantidades o elimina productos.</p>
                </div>

                <div class="carrito-grid">
                    <section class="carrito-lista">
                        <article class="carrito-item">
                            <div class="item-img">Imagen</div>
                            <div class="item-info">
                                <h4>Smartwatch Fit</h4>
                                <p>Color negro · Stock disponible</p>
                                <span class="item-precio">$89.00</span>
                            </div>
                            <div class="item-controles">
                                <button type="button" class="btn-cantidad">-</button>
                                <span>1</span>
                                <button type="button" class="btn-cantidad">+</button>
                                <button type="button" class="btn-eliminar"><i class="fa-solid fa-trash"></i></button>
                            </div>
                        </article>
                        <article class="carrito-item">
                            <div class="item-img">Imagen</div>
                            <div class="item-info">
                                <h4>Audífonos inalámbricos</h4>
                                <p>Color blanco · Stock disponible</p>
                                <span class="item-precio">$149.00</span>
                            </div>
                            <div class="item-controles">
                                <button type="button" class="btn-cantidad">-</button>
                                <span>1</span>
                                <button type="button" class="btn-cantidad">+</button>
                                <button type="button" class="btn-eliminar"><i class="fa-solid fa-trash"></i></button>
                            </div>
                        </article>
                    </section>

                    <aside class="resumen-card">
                        <h3>Resumen</h3>
                        <div class="resumen-linea">
                            <span>Subtotal</span>
                            <span>$238.00</span>
                        </div>
                        <div class="resumen-linea">
                            <span>Envío</span>
                            <span>$12.00</span>
                        </div>
                        <div class="resumen-linea total">
                            <span>Total</span>
                            <span>$250.00</span>
                        </div>
                        <button class="btn-primario">Ir a checkout</button>
                        <a class="btn-secundario" href="catalogoView.jsp">Seguir comprando</a>
                    </aside>
                </div>
            </main>

            <!-- Pie de pagina -->
            <footer class="footer">
                <p>Aplicaciones Web – Unidad 4</p>
            </footer>

        </div>
    </div>

</body>
</html>
