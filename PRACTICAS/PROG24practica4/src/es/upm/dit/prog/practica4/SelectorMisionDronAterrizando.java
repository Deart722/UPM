package es.upm.dit.prog.practica4;

public class SelectorMisionDronAterrizando implements SelectorMision{

	@Override
	public boolean seleccionar(Mision m) {
		if(m==null) return false;
		
		boolean mVelX = m.getDron().getVel().getX() < 0.2;
		boolean mVelY = m.getDron().getVel().getY() < 0.2;
		boolean mVelZ = m.getDron().getVel().getZ() < 0;
		
		return (m!=null) && mVelX && mVelY && mVelZ;
	}
	
	
}
