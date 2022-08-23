package Modelo;

public class Detalle {
	private int cantidad;
	private Producto producto;
	private int subtotal;

	public Detalle(int cantidad, Producto producto) {
		this.cantidad = cantidad;
		this.subtotal = cantidad * producto.getValorUnitario();
		this.producto = producto;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public int getSubtotal() {
		return this.subtotal;
	}

	public int getCantidad() {
		return this.cantidad;
	}
}
