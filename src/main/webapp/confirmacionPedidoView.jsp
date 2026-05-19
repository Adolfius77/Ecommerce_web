<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmación de Pedido</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/styles.css">
</head>
<body>
    <div class="container">
        <h1>¡Pedido Confirmado!</h1>
        
        <c:if test="${mensaje != null}">
            <div class="alert alert-success">${mensaje}</div>
        </c:if>
        
        <c:if test="${error != null}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        <c:if test="${avisoEmail != null}">
            <div class="alert alert-warning">${avisoEmail}</div>
        </c:if>
        <c:if test="${emailEnviado}">
            <div class="alert alert-success">Se envió un correo de confirmación a su bandeja de entrada.</div>
        </c:if>
        
        <div class="confirmacion-pedido">
            <c:if test="${numeroPedido != null}">
                <div class="numero-pedido">
                    <h2>Número de Pedido: <strong>${numeroPedido}</strong></h2>
                </div>
            </c:if>
            
            <div class="detalles-pedido">
                <h3>Detalles del Pedido</h3>
                <table class="tabla-pedido">
                    <thead>
                        <tr>
                            <th>Producto</th>
                            <th>Cantidad</th>
                            <th>Precio Unitario</th>
                            <th>Subtotal</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producto" items="${pedido.productos}">
                            <tr>
                                <td>${producto.nombreProducto}</td>
                                <td>${producto.cantidad}</td>
                                <td>$<fmt:formatNumber value="${producto.precioUnitario}" type="number" minFractionDigits="2"/></td>
                                <td>$<fmt:formatNumber value="${producto.subtotal}" type="number" minFractionDigits="2"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
            <div class="resumen-pedido">
                <h3>Resumen</h3>
                <p><strong>Total:</strong> $<fmt:formatNumber value="${pedido.total}" type="number" minFractionDigits="2"/></p>
                <p><strong>Fecha:</strong> <fmt:formatDate value="${pedido.fecha}" pattern="dd/MM/yyyy HH:mm"/></p>
                <p><strong>Método de Pago:</strong> ${metodoPago}</p>
                <p><strong>Dirección de Envío:</strong> ${direccionEnvio}</p>
                <p><strong>Estado:</strong> ${pedido.estado}</p>
            </div>
            
            <div class="acciones">
                <a href="${pageContext.request.contextPath}/misPedidos" class="btn btn-primary">Ver Mis Pedidos</a>
                <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary">Volver al Inicio</a>
            </div>
        </div>
    </div>
</body>
</html>
