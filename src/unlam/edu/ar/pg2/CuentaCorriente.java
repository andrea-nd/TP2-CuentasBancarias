package unlam.edu.ar.pg2;

public class CuentaCorriente extends CuentaSueldo{

	Double dineroQueVaAPrestarElBanco;
	Double deudaAlBanco;
	
	public CuentaCorriente(Double saldo,Double dineroDescubierto){
		
		super(saldo);
		this.dineroQueVaAPrestarElBanco=dineroDescubierto;
		deudaAlBanco=0.00;
	}
	
	public void realizarExtraccion(Double dineroAExtraer)
	{	
		Double dineroQueQuiereExtraer=dineroAExtraer;

		if(super.getSaldo()>=dineroQueQuiereExtraer)
		{
			super.realizarExtraccion(dineroQueQuiereExtraer);
		}
		else{
			dineroQueQuiereExtraer-=super.getSaldo();
			
				if(this.dineroQueVaAPrestarElBanco>=dineroQueQuiereExtraer){
					deudaAlBanco=((5*dineroQueQuiereExtraer)/100)+dineroQueQuiereExtraer;
					this.dineroQueVaAPrestarElBanco-=dineroQueQuiereExtraer;
					super.setSaldo(0.00);
				}
				/*else{
					throw new RuntimeException("Saldo Descubierto Insuficiente");
				}*/
			}
		
		
	}

	public Double getDineroQueVaAPrestarElBanco() {
		return dineroQueVaAPrestarElBanco;
	}

	public void setDineroQueVaAPrestarElBanco(Double dineroQueVaAPrestarElBanco) {
		this.dineroQueVaAPrestarElBanco = dineroQueVaAPrestarElBanco;
	}

	public Double getDeudaAlBanco() {
		return deudaAlBanco;
	}

	public void setDeudaAlBanco(Double deudaAlBanco) {
		this.deudaAlBanco = deudaAlBanco;
	}
	
	
}
