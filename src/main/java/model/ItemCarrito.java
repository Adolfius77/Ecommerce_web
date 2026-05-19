package model;

import org.bson.types.ObjectId;

/**
 * Representa un item en el carrito de compras
 */
public class ItemCarrito {
    
    private ObjectId productoId;
    private String nombre;
    private Double precioUnitario;
    private int cantidad;
    private String imagenProducto;
    
    public ItemCarrito() {
    }
    
    public ItemCarrito(ObjectId productoId, String nombre, Double precioUnitario, int cantidad, String imagenProducto) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.imagenProducto = imagenProducto;
    }
    
    public ObjectId getProductoId() {
        return productoId;
    }
    
    public void setProductoId(ObjectId productoId) {
        this.productoId = productoId;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Double getPrecioUnitario() {
        return precioUnitario;
    }
    
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getImagenProducto() {
        return imagenProducto;
    }
    
    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }
    
    public Double getSubtotal() {
        return precioUnitario * cantidad;
    }
}
