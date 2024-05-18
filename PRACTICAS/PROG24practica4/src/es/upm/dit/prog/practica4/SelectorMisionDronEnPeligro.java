package es.upm.dit.prog.practica4;

public class SelectorMisionDronEnPeligro implements SelectorMision {

	private Dron[] drones;

	public SelectorMisionDronEnPeligro(Dron[] drones) {
		this.drones = drones;
	}

	public boolean seleccionar(Mision m) {

		boolean res = false;
		if (m == null) {
			return false;
		}

		for (int i = 0; i < this.drones.length; i++) {
			if (drones[i] != null && drones[i].peligro(m.getDron())) {
				res = true;
			}
		}
		return res;
	}

}
