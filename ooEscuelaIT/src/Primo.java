
public class Primo {

	public static void main(String[] args) {
		
	    int totalSuma = 0;
	    int totalPrimos = 0;
	    
		do {

			for(int i=1; i<=307;i++) {
				int contador = 0;
				for(int j =1; j<=i; j++) {
					if(i%j == 0) {
						contador++;
					}
				}
				if(contador==2) {
					totalSuma += i;
					totalPrimos++;
					System.out.print(i + " ");
				}
			}
		} while (totalPrimos <= 50);
		System.out.print("Total "+ totalPrimos + " primos: " + totalSuma );
	}
}
