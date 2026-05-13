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
    <title>Proyecto ECommerce - Catalogo</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="./styles/estiloCatalogo.css">
</head>
<body>

    <div class="layout-container">
        <!-- Menu Lateral -->
        <aside class="sidebar">
            <nav>
                <ul>
                    <li><a href="index.jsp"><i class="fa-solid fa-house"></i> Inicio</a></li>
                    <li><a href="catalogoView.jsp" class="active"><i class="fa-solid fa-box-open"></i> Catálogo de productos</a></li>
                    <li><a href="carritoView.jsp"><i class="fa-solid fa-shopping-cart"></i> Carrito de compras</a></li>
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
                <div class="catalogo-header">
                    <div>
                        <h2>Catálogo de productos</h2>
                        <p>Encuentra productos usando filtros y barra de búsqueda.</p>
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
                        <article class="producto-card">
                            <div class="producto-img">Imagen</div>
                            <h4>Audífonos inalámbricos</h4>
                            <p class="producto-marca">AudioPro</p>
                            <p class="producto-precio">$149.99</p>
                            <div class="producto-acciones">
                                <a class="btn-secundario" href="productoDetalleView.jsp">Ver detalle</a>
                                <button class="btn-primario">Agregar</button>
                            </div>
                        </article>
                        <article class="producto-card">
                            <div class="producto-img">Imagen</div>
                            <h4>Smartwatch Fit</h4>
                            <p class="producto-marca">Active</p>
                            <p class="producto-precio">$89.00</p>
                            <div class="producto-acciones">
                                <a class="btn-secundario" href="productoDetalleView.jsp">Ver detalle</a>
                                <button class="btn-primario">Agregar</button>
                            </div>
                        </article>
                        <article class="producto-card">
                            <div class="producto-img">Imagen</div>
                            <h4>Teclado mecánico RGB</h4>
                            <p class="producto-marca">NovaKeys</p>
                            <p class="producto-precio">$129.50</p>
                            <div class="producto-acciones">
                                <a class="btn-secundario" href="productoDetalleView.jsp">Ver detalle</a>
                                <button class="btn-primario">Agregar</button>
                            </div>
                        </article>
                        <article class="producto-card">
                            <div class="producto-img">Imagen</div>
                            <h4>Mochila urbana</h4>
                            <p class="producto-marca">CityLine</p>
                            <p class="producto-precio">$54.90</p>
                            <div class="producto-acciones">
                                <a class="btn-secundario" href="productoDetalleView.jsp">Ver detalle</a>
                                <button class="btn-primario">Agregar</button>
                            </div>
                        </article>
                        <article class="producto-card">
                            <div class="producto-img">Imagen</div>
                            <h4>Kit de organización</h4>
                            <p class="producto-marca">HomePlus</p>
                            <p class="producto-precio">$32.00</p>
                            <div class="producto-acciones">
                                <a class="btn-secundario" href="productoDetalleView.jsp">Ver detalle</a>
                                <button class="btn-primario">Agregar</button>
                            </div>
                        </article>
                        <article class="producto-card">
                            <div class="producto-img">Imagen</div>
                            <h4>Tenis running</h4>
                            <p class="producto-marca">Sprint</p>
                            <p class="producto-precio">$110.00</p>
                            <div class="producto-acciones">
                                <a class="btn-secundario" href="productoDetalleView.jsp">Ver detalle</a>
                                <button class="btn-primario">Agregar</button>
                            </div>
                        </article>
                    </section>
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
