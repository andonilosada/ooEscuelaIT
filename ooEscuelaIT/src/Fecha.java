import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.time.*;
import java.time.DayOfWeek;



public class Fecha {
	
///////////////////////////////////////////////////////////// ATRIBUTOS
	
	private int a�o;
	
	private int mes;
	
	private int dia;
	
	private final static int[] DIAS_MESES = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
///////////////////////////////////////////////////////////// CONSTRUCTORES
	
	public Fecha(int a�o, int mes, int dia) {
		this.a�o = a�o;
		this.mes = mes;
		this.dia = dia;
		
		
	}
	
	public Fecha(Fecha fecha) {
		this(fecha.a�o, fecha.mes, fecha.dia);
	}
	
	public Fecha() {
		this(1,1,1);
	}
/////////////////////////////////////////////////////////////// M�TODOS 
	
	public Fecha(String fecha) {
		StringTokenizer analizador = new StringTokenizer(fecha, "/");
		a�o = Integer.parseInt(analizador.nextToken());
		mes = Integer.parseInt(analizador.nextToken());
		dia = Integer.parseInt(analizador.nextToken());	
	}
	
	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getA�o() {
		return a�o;
	}
	
	private void set(int a�o, int mes, int dia) {
		this.a�o = a�o;
		this.mes = mes;
		this.dia = dia;
	}

	public void set(Fecha fecha) {
		this.set(fecha.a�o, fecha.mes, fecha.dia);
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
	
	public int dameMaximoDiasEnMes(int a�o, int mes) {
	    GregorianCalendar gc = new GregorianCalendar();
	    gc.set(Calendar.YEAR,a�o);
	    gc.set(Calendar.MONTH,mes-1); 
	    return gc.getActualMaximum(Calendar.DATE);
	}
		
/////////////////////////////////////////////////////////////// M�TODO MAIN
	
	public static void main(String[] args) {
		System.out.println("D�a de la semana actual: " + LocalDate.now().getDayOfWeek());
		System.out.println("Dia de la semana: " + LocalDate.of(1964,12,30).getDayOfWeek());
		
		Fecha fecha = new Fecha(2021,3,9);
		
		LocalDate localDate = LocalDate.of(fecha.a�o, fecha.mes, fecha.dia);
		DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
		int val = dayOfWeek.getValue();
		System.out.println("N� d�a de la semana: " + val);
		
		
		
	
		System.out.println(fecha.dameMaximoDiasEnMes(fecha.a�o, fecha.mes));
		System.out.println(fecha.a�o + "/" + fecha.mes);
	}
}






