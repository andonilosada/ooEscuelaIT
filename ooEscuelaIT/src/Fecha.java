import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;


public class Fecha {
	
///////////////////////////////////////////////////////////// ATRIBUTOS
	
	private int dia;
	
	private int mes;
	
	private int a�o;
	
	private final static int[] DIAS_MESES = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
///////////////////////////////////////////////////////////// CONSTRUCTORES
	
	public Fecha(int dia, int mes, int a�o) {
		this.set(dia, mes, a�o);
	}
	
	public Fecha(Fecha fecha) {
		this(fecha.dia, fecha.mes, fecha.a�o);
	}
	
	public Fecha() {
		this(1,1,1);
	}
	
	public Fecha(String fecha) {
		StringTokenizer analizador = new StringTokenizer(fecha, "/");
		dia = Integer.parseInt(analizador.nextToken());
		mes = Integer.parseInt(analizador.nextToken());
		a�o = Integer.parseInt(analizador.nextToken());
	}
	
/////////////////////////////////////////////////////////////// M�TODOS 
	
	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getA�o() {
		return a�o;
	}
	
	private void set(int dia, int mes, int a�o) {
		this.dia = dia;
		this.mes = mes;
		this.a�o = a�o;
	}

	public void set(Fecha fecha) {
		this.set(fecha.dia, fecha.mes, fecha.a�o);
	}
	
	public char diaSemana() {
		
		return ' ';
	}
	
	public boolean equal (Fecha fecha) {
		
		return false;
	}
	
	public boolean festivo() {
		
		return false;
	}
	
	public void mostrar() {
		System.out.println(dia + "/" + mes + "/" + a�o);
		
	}
	
	public int numeroSemana() {
		
		return 0;
	}
	
	public void incrementar(int dias) {
		
	}
		
	public Fecha clone() {
		return new Fecha(this);
	}
	
	public boolean igual(Fecha fecha) {
		return dia == fecha.dia && mes == fecha.mes && a�o == fecha.a�o;  
	}
	
	public boolean anterior(Fecha fecha) {
		return this.diasOrigen() < fecha.diasOrigen();
	}
	
	public boolean posterior(Fecha fecha) {
		return this.diasOrigen() > fecha.diasOrigen();
	}
	
	public int diferencia(Fecha fecha) {
		
		return this.diasOrigen() - fecha.diasOrigen();
	}
	
	public int diasOrigen() {
		int resultado = dia;
		for (int i = 0; i < mes - 1; i++) {
			resultado += DIAS_MESES[i];
		}
		resultado += 365 * (a�o - 1);
		return resultado;
	}
	
	public static boolean isLeapYear(int year) {
		  Calendar cal = Calendar.getInstance();
		  cal.set(Calendar.YEAR, year);
		  return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
	}
	
	public static int getDayOfTheWeek(Date d){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(d);
		return cal.get(Calendar.DAY_OF_WEEK);		
	}

	
/////////////////////////////////////////////////////////////// M�TODO MAIN
	
	public static void main(String[] args) {
		
		//Fecha fecha = new Fecha(25,06,1962);
		System.out.println(Fecha.isLeapYear(2020));
	}
}






