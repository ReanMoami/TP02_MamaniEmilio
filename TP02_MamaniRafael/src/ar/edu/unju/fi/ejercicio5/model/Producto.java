package ar.edu.unju.fi.ejercicio5.model;


public class Producto {
	private int codigo;
    private String descripcion;
    private double precioUnitario;
    private OrigenDeFabricacion origenFabricacion;
    private Categoria categoria;
    private boolean estado;
	
    public Producto(int codigo, String descripcion, double precioUnitario, OrigenDeFabricacion origenFabricacion,
			Categoria categoria, boolean estado) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
		this.estado = estado;
	}
    
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public OrigenDeFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}
	public void setOrigenFabricacion(OrigenDeFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	


}