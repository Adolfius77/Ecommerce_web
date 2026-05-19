<%-- Moderación de reseñas (vista administrador) --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Administración - Moderación de reseñas</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link rel="stylesheet" href="./styles/estiloGestionPanel.css">
    </head>
    <body>
        <div class="layout-container">
            <aside class="sidebar">
                <nav>
                    <ul>
                        <li><a href="index.jsp"><i class="fa-solid fa-house"></i> Inicio</a></li>
                        <li><a href="catalogoView.jsp"><i class="fa-solid fa-box-open"></i> Catálogo</a></li>
                        <li><a href="gestionProductosView.jsp"><i class="fa-solid fa-warehouse"></i> Inventario</a></li>
                        <li><a href="gestionCategoriasView.jsp"><i class="fa-solid fa-tags"></i> Categorías</a></li>
                        <li><a href="gestionUsuariosView.jsp"><i class="fa-solid fa-users"></i> Usuarios</a></li>
                        <li><a href="gestionPedidosPagosView.jsp"><i class="fa-solid fa-receipt"></i> Pedidos y pagos</a></li>
                        <li><a href="moderacionResenasView.jsp" class="active"><i class="fa-solid fa-star-half-stroke"></i> Moderación reseñas</a></li>
                        <li><a href="perfilUsuarioView.jsp"><i class="fa-solid fa-user"></i> Mi perfil (cliente)</a></li>
                        <li><a href="misPedidosView.jsp"><i class="fa-solid fa-clock-rotate-left"></i> Mis pedidos</a></li>
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
                    <div class="page-header">
                        <div>
                            <h2>Moderación de reseñas</h2>
                            <p>Elimina comentarios inapropiados. Datos de ejemplo alineados con el modelo reseña (producto, usuario, calificación, comentario, fecha).</p>
                        </div>
                    </div>

                    <div class="table-wrap">
                        <table class="data-table">
                            <thead>
                                <tr>
                                    <th>Producto</th>
                                    <th>Usuario</th>
                                    <th>Calificación</th>
                                    <th>Comentario</th>
                                    <th>Fecha</th>
                                    <th>Acción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Smartwatch Fit</td>
                                    <td>cliente.demo</td>
                                    <td>4.5 / 5</td>
                                    <td class="comentario-celda" title="Buena relación calidad-precio.">Buena relación calidad-precio.</td>
                                    <td>2026-05-11</td>
                                    <td class="acciones-celda">
                                        <button type="button" class="btn-peligro" title="Eliminar reseña"><i class="fa-solid fa-trash"></i> Eliminar</button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Audífonos inalámbricos</td>
                                    <td>usuario_prueba</td>
                                    <td>2 / 5</td>
                                    <td class="comentario-celda" title="Comentario inapropiado (ejemplo).">Comentario inapropiado (ejemplo).</td>
                                    <td>2026-05-10</td>
                                    <td class="acciones-celda">
                                        <button type="button" class="btn-peligro" title="Eliminar reseña"><i class="fa-solid fa-trash"></i> Eliminar</button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Lámpara de escritorio</td>
                                    <td>Ana Ruiz</td>
                                    <td>5 / 5</td>
                                    <td class="comentario-celda" title="Llegó rápido y bien empaquetado.">Llegó rápido y bien empaquetado.</td>
                                    <td>2026-05-07</td>
                                    <td class="acciones-celda">
                                        <button type="button" class="btn-peligro" title="Eliminar reseña"><i class="fa-solid fa-trash"></i> Eliminar</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </main>
                <footer class="footer">
                    <p>Aplicaciones Web – Unidad 4</p>
                </footer>
            </div>
        </div>
    </body>
</html>
