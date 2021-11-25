package arq.integrador.despensa.dto;

public class ComprasPorClienteDTO {
	
	
	private String nombre;
	private String direccion;
	private double total_compras;
	
	
	public ComprasPorClienteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ComprasPorClienteDTO(String nombre, String direccion, double total_compras) {
		
		this.nombre = nombre;
		this.direccion = direccion;
		this.total_compras = total_compras;
	}



	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	


	public double getTotal_compras() {
		return total_compras;
	}

	public void setTotal_compras(double total_compras) {
		this.total_compras = total_compras;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "ComprasPorClienteDTO [nombre=" + nombre + ", direccion=" + direccion + ", total_compras="
				+ total_compras + "]";
	}
	
	
	


	
}
