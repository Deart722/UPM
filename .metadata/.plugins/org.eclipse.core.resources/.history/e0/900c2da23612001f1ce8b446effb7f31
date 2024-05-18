package es.upm.dit.prog.practica4;
import java.util.Objects;

public class Posicion {

	// Apartado 1
	private double x;
	private double y;
	private double z;

	// Apartado 2
	public Posicion(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// Apartado3
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	// Apartado 4
	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y)
				&& Double.doubleToLongBits(z) == Double.doubleToLongBits(other.z);
	}

	@Override
	public String toString() {
		return "Posicion [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	// Apartado 5
	public double modulo() {
		return Math.sqrt((x * x + y * y + z * z));
	}

	// Apartado 6
	public double distancia(Posicion pos) {

		double x = pos.getX() - this.getX();
		double y = pos.getY() - this.getY();
		double z = pos.getZ() - this.getZ();
		return (Math.sqrt((x * x + y * y + z * z)));

	}

}
