package es.upm.dit.prog.practica5;

public class SelectorMisionActiva implements SelectorMision{

	@Override
	public boolean seleccionar(Mision m) {	
		if(m==null) return false;
		return m!=null && m.activa();
	}

	
}
