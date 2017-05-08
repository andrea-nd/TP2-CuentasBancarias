package unlam.edu.ar.pg2;

public class CajaDeAhorro extends CuentaSueldo{

	Double costoAdicionalPorExtraccion;
	Integer cantidadDeExtraccion;
	
	public CajaDeAhorro(Double saldo){
		
		super(saldo);
		costoAdicionalPorExtraccion=6.00;
		cantidadDeExtraccion=0;
		
	}
	
	public void realizarExtraccion(Double dineroAExtraer){
		
		cantidadDeExtraccion++;
		Double extraccion=dineroAExtraer;
		
		if(cantidadDeExtraccion>5)
		{	
			
			Double extraccionTotal=costoAdicionalPorExtraccion+extraccion;
			super.realizarExtraccion(extraccionTotal);
		}
		else
		{	
			super.realizarExtraccion(extraccion);
		}
		if(super.getPudoRealizarExtraccion()==false)
		{	
			cantidadDeExtraccion--;
		}
	}
	
	
	
}
