package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(1000000, 53212.5),
    SALTA(1500000, 59123.7),
    TUCUMAN(2000000, 67890.0),
    CATAMARCA(800000, 45678.9),
    LA_RIOJA(600000, 34567.8),
    SANTIAGO_DEL_ESTERO(1800000, 78901.2);
	
	private int cantidadPoblacion;
	private double superficie;
	
	private Provincia(int cantidadPoblacion, double superficie) {
        this.cantidadPoblacion = cantidadPoblacion;
        this.superficie = superficie;
    }
	public int getCantidadPoblacion() {
		return cantidadPoblacion;
	}
	public void setCantidadPoblacion(int cantidadPoblacion) {
		this.cantidadPoblacion = cantidadPoblacion;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	
	public double calcularDensidadPoblacional() {
		return (double) cantidadPoblacion/superficie;
	}
}