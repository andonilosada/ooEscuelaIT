
class Intervalo {
	
	private double puntoMedio;
	
	private double longitud;
	
	
	public Intervalo(double inferior, double superior) {
		
		longitud = superior - inferior;
		puntoMedio = inferior + longitud/2;
		
		System.out.println("Longitud= " + longitud);
		System.out.println("Punto Medio = " + puntoMedio);
	}
	
	public Intervalo(Intervalo intervalo) {
		
	}
	
	public Intervalo() {
		
	}
	
	public Intervalo(double superior) {
		
	}
	
	public double longitud() {
	
		return longitud;
	}
	
	public double puntoMedio() {
		
		return puntoMedio;
	}
	
	public Intervalo clone() {
		
		return null;
	}
	
	public void desplazar(double desplazamiento) {
		
		puntoMedio += desplazamiento;
		
	}
	
	public Intervalo desplazado(double desplazamiento) {
		
		return null;
	}
	
	public boolean isInclude(double punto) {
		return true;
		
	}
	
	public boolean isEquals(Intervalo intervalo) {
		return true;
	}
	
	public Intervalo interseccion(Intervalo intervalo) {
		
		return null;
	}
	
	public boolean isIntersecta(Intervalo intervalo) {
		
		return true;
	}
	
	public Intervalo[] trocear(int trozos) {
		
		return null;
	}
	
	public void mostrar() {
		
		System.out.println("Intervalo => " + "["+ (puntoMedio - longitud/2) + "," + (puntoMedio + longitud/2) + "]");
	}
	
	public void doblar() {
		
		longitud *= 2;			
		
	}
	
	public boolean incluye(double valor) {

		return Math.abs(valor - puntoMedio) < longitud / 2; 
	}
	
}
