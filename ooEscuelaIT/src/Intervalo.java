
class Intervalo {
	
	private double inferior;
	
	private double superior;
	
	
	
	public Intervalo(double inferior, double superior) {
		assert inferior <= superior;
		this.inferior = inferior;
		this.superior = superior;
	}
	
	public Intervalo(Intervalo intervalo) {
		this(intervalo.inferior, intervalo.superior);
	}	
	
	public Intervalo() {
		this(0, 0);
	}
	
	public Intervalo(double superior) {
		this(0, superior);
	}
	
	public double longitud() {
		return Math.abs(superior - inferior);
	}
	
	public double puntoMedio() {
		return inferior + longitud()/2;
	}
	
	public Intervalo clone() {
		return new Intervalo(this);
	}
	
	public void desplazar(double desplazamiento) {
		inferior += desplazamiento;
		superior += desplazamiento;
	}
	
	public Intervalo desplazado(double desplazamiento) {
		Intervalo intervalo = this.clone();
		intervalo.desplazar(desplazamiento);
		return intervalo;
	}
	
	public boolean isInclude(double punto) {
		return inferior <= punto && punto <= superior;
	}
	
	public boolean isEquals(Intervalo intervalo) {
		assert intervalo != null;
		return inferior == intervalo.inferior &&
			   superior == intervalo.superior;
	}
	
	public Intervalo interseccion(Intervalo intervalo) {
		assert this.isIntersecta(intervalo);
		if(this.isIntersecta(intervalo)) {
			return intervalo.clone();
		}else if(intervalo.isIntersecta(this)) {
			return this.clone();
		}else if(this.incluye(intervalo.inferior)) {
			return new Intervalo(intervalo.inferior, superior);
		}else { 
			return new Intervalo(inferior, intervalo.superior);
		}	
	}
	
	public boolean isIntersecta(Intervalo intervalo) {
		assert intervalo != null;
		return this.incluye(intervalo.inferior) ||
			   this.incluye(intervalo.superior) ||
			   intervalo.incluye(this);
	}
	
	public Intervalo[] trocear(int trozos) {
		return null;
	}
	
	public void mostrar() {
		System.out.println("Intervalo => " + "["+ inferior + "," + superior + "]");
	}
	
	public void doblar() {
		double doblar = longitud()/2;
		inferior -= doblar;
		superior += doblar;			
	}
	
	public boolean incluye(double valor) {
		return (inferior <= valor && valor <= superior); 
	}
	
	public boolean incluye(Intervalo intervalo) {
		assert intervalo != null;
		return this.incluye(intervalo.inferior) &&
		   	   this.incluye(intervalo.superior);
	}
	
	public void oponer() {
		double inferiorInicial = inferior;
		inferior = -superior;
		superior = -inferiorInicial;
	}
	
}
