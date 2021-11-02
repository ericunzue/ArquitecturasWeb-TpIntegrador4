package arq.integrador.despensa.entities;

import java.io.Serializable;

public class DetalleCompraId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int compra;
	private int producto;
	
	public DetalleCompraId() {
		// TODO Auto-generated constructor stub
	}

	public DetalleCompraId(int compra, int producto) {
		super();
		this.compra = compra;
		this.producto = producto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + compra;
		result = prime * result + producto;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleCompraId other = (DetalleCompraId) obj;
		if (compra != other.compra)
			return false;
		if (producto != other.producto)
			return false;
		return true;
	}
	
	
	
	

}