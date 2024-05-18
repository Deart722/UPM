package es.upm.dit.prog.practica2;

import java.util.Objects;

public class Dron {

	// Apartado 7
	private String id;
	private Posicion pos;
	private long t;
	private Posicion vel;
	private static final long SAFETY_DISTANCE = 2;

	// Apartado 8
	public Dron(String id, Posicion pos, long t, Posicion vel) {
		this.id = id;
		this.pos = pos;
		this.t = t;
		this.vel = vel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Posicion getPos() {
		return pos;
	}

	public void setPos(Posicion pos) {
		this.pos = pos;
	}

	public long getT() {
		return t;
	}

	public void setT(long t) {
		this.t = t;
	}

	public Posicion getVel() {
		return vel;
	}

	public void setVel(Posicion vel) {
		this.vel = vel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	// Apartado 9
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dron other = (Dron) obj;
		return Objects.equals(id, other.id);
	}

	@Override 
	public String toString() {
		return "Dron [id=" + id + ", pos=" + pos + ", t=" + t + ", vel=" + vel + "]";
	}

	// Apartado 10
	public void mover(long t) {

		if (t > this.t) {

			double newPosX = this.pos.getX() + this.vel.getX() * (t - this.t);
			double newPosY = this.pos.getY() + this.vel.getY() * (t - this.t);
			double newPosZ = this.pos.getZ() + this.vel.getZ() * (t - this.t);

			this.pos.setX(newPosX);
			this.pos.setY(newPosY);
			this.pos.setZ(newPosZ);

			this.t = t;
		}

	}

	// Apartado 11
	public boolean peligro(Dron otro) {

		return (otro != null) && (!this.equals(otro)) ? this.getPos().distancia(otro.getPos()) < SAFETY_DISTANCE
				: false;
	}

}
