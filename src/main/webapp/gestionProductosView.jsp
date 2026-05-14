<%-- Gestión de inventario de productos (vista administrador) --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administración - Inventario de productos</title>
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
                    <li><a href="gestionProductosView.jsp" class="active"><i class="fa-solid fa-warehouse"></i> Inventario</a></li>
                    <li><a href="gestionCategoriasView.jsp"><i class="fa-solid fa-tags"></i> Categorías</a></li>
                    <li><a href="gestionUsuariosView.jsp"><i class="fa-solid fa-users"></i> Usuarios</a></li>
                    <li><a href="gestionPedidosPagosView.jsp"><i class="fa-solid fa-receipt"></i> Pedidos y pagos</a></li>
                    <li><a href="moderacionResenasView.jsp"><i class="fa-solid fa-star-half-stroke"></i> Moderación reseñas</a></li>
                    <li><a href="perfilUsuarioView.jsp"><i class="fa-solid fa-user"></i> Mi perfil (cliente)</a></li>
                    <li><a href="misPedidosView.jsp"><i class="fa-solid fa-clock-rotate-left"></i> Mis pedidos</a></li>
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
                <div class="page-header">
                    <div>
                        <h2>Inventario de productos</h2>
                        <p>Crear, editar y eliminar productos. </p>
                    </div>
                    <div class="toolbar">
                        <button type="button" class="btn-primario"><i class="fa-solid fa-plus"></i> Nuevo producto</button>
                    </div>
                </div>

                <div class="panel-card">
                    <h3>Alta o edición de producto</h3>
                    <p style="color:#5f6368;font-size:14px;margin-bottom:16px;">Campos alineados con el modelo Producto</p>
                    <div class="form-grid-panel">
                        <div class="campo-form-panel">
                            <label for="prodNombre">Nombre</label>
                            <input type="text" id="prodNombre" name="prodNombre" placeholder="Nombre del producto">
                        </div>
                        <div class="campo-form-panel">
                            <label for="prodPrecio">Precio</label>
                            <input type="number" id="prodPrecio" name="prodPrecio" step="0.01" placeholder="0.00">
                        </div>
                        <div class="campo-form-panel">
                            <label for="prodStock">Stock</label>
                            <input type="number" id="prodStock" name="prodStock" min="0" placeholder="0">
                        </div>
                        <div class="campo-form-panel">
                            <label for="prodCategoria">Categoría</label>
                            <input type="text" id="prodCategoria" name="prodCategoria" placeholder="Ej. Tecnología">
                        </div>
                        <div class="campo-form-panel campo-form-panel-full">
                            <label for="prodImagen">URL de imagen</label>
                            <input type="url" id="prodImagen" name="prodImagen" placeholder="https://...">
                        </div>
                        <div class="campo-form-panel campo-form-panel-full">
                            <label for="prodDesc">Descripción</label>
                            <textarea id="prodDesc" name="prodDesc" placeholder="Descripción del producto"></textarea>
                        </div>
                    </div>
                    <div class="toolbar" style="margin-top:18px;">
                        <button type="button" class="btn-primario">Guardar</button>
                        <button type="button" class="btn-secundario">Limpiar formulario</button>
                    </div>
                </div>

                <div class="table-wrap">
                    <table class="data-table">
                        <thead>
                            <tr>
                                <th>Imagen</th>
                                <th>Nombre</th>
                                <th>Categoría</th>
                                <th>Precio</th>
                                <th>Stock</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><div class="thumb-placeholder">IMG</div></td>
                                <td>Smartwatch Fit</td>
                                <td>Tecnología</td>
                                <td>$89.00</td>
                                <td>24</td>
                                <td class="acciones-celda">
                                    <button type="button" class="btn-icono" title="Editar"><i class="fa-solid fa-pen"></i></button>
                                    <button type="button" class="btn-peligro" title="Eliminar"><i class="fa-solid fa-trash"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td><div class="thumb-placeholder">IMG</div></td>
                                <td>Audífonos inalámbricos</td>
                                <td>Audio</td>
                                <td>$149.00</td>
                                <td>10</td>
                                <td class="acciones-celda">
                                    <button type="button" class="btn-icono" title="Editar"><i class="fa-solid fa-pen"></i></button>
                                    <button type="button" class="btn-peligro" title="Eliminar"><i class="fa-solid fa-trash"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td><div class="thumb-placeholder">IMG</div></td>
                                <td>Lámpara de escritorio</td>
                                <td>Hogar</td>
                                <td>$45.50</td>
                                <td>32</td>
                                <td class="acciones-celda">
                                    <button type="button" class="btn-icono" title="Editar"><i class="fa-solid fa-pen"></i></button>
                                    <button type="button" class="btn-peligro" title="Eliminar"><i class="fa-solid fa-trash"></i></button>
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
