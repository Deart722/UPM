package es.upm.dit.prog.practica2;

import java.util.Arrays;
import java.util.Objects;

public class Mision {

	private String id;
	private Dron dron;
	private Posicion[] posiciones;
	private long[] tiempos;
	private int nPosiciones;
	private int posicion;

	public Mision(String id, Dron dron, int maxPosiciones) {
		this.id = id;
		this.dron = dron;
		this.posiciones = new Posicion[maxPosiciones];
		this.tiempos = new long[maxPosiciones];
		this.nPosiciones = 0;
		this.posicion = 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Dron getDron() {
		return dron;
	}

	public void setDron(Dron dron) {
		this.dron = dron;
	}

	public Posicion[] getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(Posicion[] posiciones) {
		this.posiciones = posiciones;
	}

	public long[] getTiempos() {
		return tiempos;
	}

	public void setTiempos(long[] tiempos) {
		this.tiempos = tiempos;
	}

	public int getnPosiciones() {
		return nPosiciones;
	}

	public void setnPosiciones(int nPosiciones) {
		this.nPosiciones = nPosiciones;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public void addPosT(Posicion pos, long t) {
		if (pos != null && this.nPosiciones < this.posiciones.length) {
			this.posiciones[this.nPosiciones] = pos;
			this.tiempos[this.nPosiciones] = t;
			this.nPosiciones += 1;
		}
	}

	public boolean activa() {

		return (this.posicion < this.nPosiciones) && (this.posiciones[this.posicion] != null)
				&& (this.posicion < this.posiciones.length) ? true : false;
	}

	public void update(long t) {
		if (activa() && t == this.dron.getT() && t == tiempos[posicion]) {
			if (this.posicion < this.nPosiciones - 1) {
				Posicion posicionSig = this.posiciones[this.posicion + 1];
				long diffT = this.tiempos[this.posicion + 1] - t;

				if (diffT > 0) {
					double newX = (posicionSig.getX() - this.dron.getPos().getX()) / diffT;
					double newY = (posicionSig.getY() - this.dron.getPos().getY()) / diffT;
					double newZ = (posicionSig.getZ() - this.dron.getPos().getZ()) / diffT;
					this.dron.setVel(new Posicion(newX, newY, newZ));
				} else {
					this.dron.setVel(new Posicion(0, 0, 0));

				}
			} else {
				this.dron.setVel(new Posicion(0, 0, 0));
			}
			this.posicion++;
		}

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mision other = (Mision) obj;
		return Objects.equals(dron, other.dron) && Objects.equals(id, other.id) && nPosiciones == other.nPosiciones
				&& posicion == other.posicion && Arrays.equals(posiciones, other.posiciones)
				&& Arrays.equals(tiempos, other.tiempos);
	}

	@Override
	public String toString() {
		return "Mision [id=" + id + ", dron=" + dron + ", posiciones=" + Arrays.toString(posiciones) + ", tiempos="
				+ Arrays.toString(tiempos) + ", nPosiciones=" + nPosiciones + ", posicion=" + posicion + "]";
	}

}
