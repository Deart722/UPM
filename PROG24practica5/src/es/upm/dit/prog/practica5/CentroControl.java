package es.upm.dit.prog.practica5;

import java.util.*;

public class CentroControl {

	private List<Dron> drones;
	private List<Mision> misiones;

	public CentroControl() {
		drones = new ArrayList<Dron>();
		misiones = new ArrayList<Mision>();
	}

	@Override
	public String toString() {
		return "CentroControl [drones=" + drones + ", misiones=" + misiones + "]";
	}

	public void addMision(Mision m) {
		if (m != null) {
			this.misiones.add(m);
		}
	}

	public void addDron(Dron d) {
		if (d != null) {
			this.drones.add(d);
		}
	}

	public List<Mision> getMisiones(SelectorMision sm) {

		List<Mision> aux = new ArrayList<Mision>();

		if (sm == null) {

			SelectorMisionTrue smt = new SelectorMisionTrue();

			for (Mision m : this.misiones) {

				if (smt.seleccionar(m)) {

					aux.add(m);
				}

			}

		}

		for (Mision m : this.misiones) {

			if (sm.seleccionar(m)) {

				aux.add(m);
			}

		}

		return aux;
	}

	public List<Dron> getDrones() {
		return new ArrayList<Dron>(this.drones);
	}

	public void update(long t) {

		for (Mision m : this.misiones) {

			m.update(t);

		}
		
		for (int i = 0; i < this.misiones.size(); i++) {
			
			this.misiones.get(i).update(t);
			
		}
		for (Dron d : this.drones) {

			d.mover(t);

		}

	}
}
