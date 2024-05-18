package es.upm.dit.prog.practica4;

import java.util.Arrays;

public class CentroControl {

	private Dron[] drones;
	private Mision[] misiones;
	private int N = 10;

	public CentroControl() {
		this.drones = new Dron[N];
		this.misiones = new Mision[N];
	}

	@Override
	public String toString() {
		return "CentroControl [drones=" + Arrays.toString(drones) + ", misiones=" + Arrays.toString(misiones) + "]";
	}

	public void addDron(Dron d) {
		if (d == null) {
			return;
		}

		for (int i = 0; i < this.drones.length; i++) {
			if (drones[i] == null) {
				drones[i] = d;
				return;
			}
		}
		for (int i = 1; i < this.drones.length; i++) {
			drones[i - 1] = drones[i];
		}
		drones[this.drones.length - 1] = d;
	}

	public Dron[] getDrones() {

		int contNull = 0;
		Dron[] auxDrones;
		for (int i = 0; i < this.drones.length; i++) {
			if (drones[i] != null) {
				contNull += 1;
			}
		}
		auxDrones = new Dron[contNull];
		for (int i = 0; i < auxDrones.length; i++) {
			if (drones[i] != null) {
				auxDrones[i] = this.drones[i];
			}
		}
		return auxDrones;
	}

	public void addMision(Mision d) {
		if (d == null) {
			return;
		}

		for (int i = 0; i < this.misiones.length; i++) {
			if (misiones[i] == null) {
				misiones[i] = d;
				return;
			}
		}
		for (int i = 1; i < this.misiones.length; i++) {
			misiones[i - 1] = misiones[i];
		}
		misiones[this.misiones.length - 1] = d;
	}

	public Mision[] getMisiones(SelectorMision sm) {

		int contNull = 0;
		int contNull2 = 0;

		if (sm == null) {

			SelectorMisionTrue smt = new SelectorMisionTrue();
			for (int i = 0; i < misiones.length; i++) {

				if (smt.seleccionar(misiones[i])) {
					contNull += 1;
				}

				Mision[] auxMisiones2 = new Mision[contNull2];

				for (int j = 0; j < this.misiones.length; j++) {
					if (smt.seleccionar(misiones[j])) {
						auxMisiones2[i] = misiones[j];
					}
				}

				this.misiones = auxMisiones2;
			}

		} else {
			for (int i = 0; i < this.misiones.length; i++) {
				if (sm.seleccionar(misiones[i])) {
					contNull += 1;
				}
			}

			Mision[] auxMisiones = new Mision[contNull];

			for (int i = 0; i < this.misiones.length; i++) {
				if (sm.seleccionar(misiones[i])) {
					auxMisiones[i] = misiones[i];
				}
			}

			this.misiones = auxMisiones;
			
		}
		
		return this.misiones;
	}

	public void update(long t) {

		for (int i = 0; i < drones.length; i++) {
			if (drones[i] != null) {
				drones[i].mover(t);
			}
		}
		for (int i = 0; i < misiones.length; i++) {
			if (misiones[i] != null) {
				misiones[i].update(t);
			}
		}
	}
}