package arq.integrador.despensa.dto;

import java.time.LocalDateTime;

public class ComprasDiariasDTO {

	private LocalDateTime fecha;
	private double total_compra;
	public ComprasDiariasDTO(LocalDateTime fecha, double total_compra) {
		super();
		this.fecha = fecha;
		this.total_compra = total_compra;
	}
	public ComprasDiariasDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public double getTotal_compra() {
		return total_compra;
	}
	public void setTotal_compra(double total_compra) {
		this.total_compra = total_compra;
	}
	
	
}
