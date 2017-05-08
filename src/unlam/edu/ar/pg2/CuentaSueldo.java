package unlam.edu.ar.pg2;

public class CuentaSueldo {

private Double saldo;
private Boolean pudoRealizarExtraccion;
	
	public CuentaSueldo(Double saldoActual)
	{
		pudoRealizarExtraccion=false;
		this.saldo= saldoActual;
		
	}
	
	public Double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public void realizarExtraccion(Double extraccionDeDinero){
		
		if(this.saldo>=extraccionDeDinero)
		{
			pudoRealizarExtraccion=true;
			this.saldo-=extraccionDeDinero;

		}
		/*else{
			throw new RuntimeException("Saldo Insuficiente");
		}*/
	}
	
	public Boolean getPudoRealizarExtraccion() {
		return pudoRealizarExtraccion;
	}

	public void setPudoRealizarExtraccion(Boolean pudoRealizarExtraccion) {
		this.pudoRealizarExtraccion = pudoRealizarExtraccion;
	}
	
}
