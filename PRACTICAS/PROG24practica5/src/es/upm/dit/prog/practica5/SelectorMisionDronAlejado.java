package es.upm.dit.prog.practica5;

public class SelectorMisionDronAlejado implements SelectorMision{
	
	private Posicion p;
	private double d;

	public SelectorMisionDronAlejado(Posicion p, double d) {
		this.p = p;
		this.d = d;
	}

	@Override
	public boolean seleccionar(Mision m) {
		if(m==null) return false;

		boolean mPos = m.getDron().getPos().distancia(p) > d;

		return (m!=null) && mPos;
	}
	
	

	
	
}
