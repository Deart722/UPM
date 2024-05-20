package ex2010_11;

import java.util.Scanner;

public class Examen2010_11_EXA2 {

	private static Scanner sc = new Scanner(System.in);

	/*
	 * Pregunta 1. (2 puntos) Escriba un método para calcular el factorial de un
	 * número entero mayor o igual que 0 (lanza Exception si es menor que 0). Use un
	 * bucle while para calcularlo.
	 */

	public static void factorial(int numero) throws Exception {

		int nParametro = numero;

		if (numero < 0) {
			throw new Exception("El numero es menor de 0");
		}

		int resultado = numero;
		while (numero > 1) {

			numero--;
			resultado *= numero;

		}

		System.out.println("El factorial de " + nParametro + " es: " + resultado);

	}

	/*
	 * Pregunta 2. (2 puntos) Escriba un método imprimeMes que toma un parámetro int
	 * mes (que va de 1 a 12) y mediante una sentencia switch imprime el número de
	 * días que tiene el mes, agrupando los meses según el número de días. Imprime
	 * “ERROR” si el valor de mes no es correcto. No considere años bisiestos.
	 */

	public static void imprimeMes(int mes) {

		switch (mes) {

		case 1, 3, 5, 7, 8, 10, 12:

			System.out.println("Tiene 31 dias");
			break;
		case 2, 4, 6, 9, 11:
			System.out.println("Tiene 30 dias");

			break;

		default:
			System.out.println("ERROR");

			break;
		}
	}

	/*
	 * Pregunta 3. (2 puntos). Complete la clase Bombilla, que representa una
	 * bombilla de un edificio con su identificador y la potencia que consume. Debe
	 * completar el constructor, el método consumoTotal, que devuelve la potencia
	 * consumida por todas las bombillas, añadir atributos si fuera necesario.
	 * 
	 */

	class Bombilla {

		private int identificador;
		private double potencia;
		private static double consumoTotal; // Completar

		Bombilla(int id, double potencia, double consumoTotal) { // Completar
			this.identificador = id;
			this.potencia = potencia;
			this.consumoTotal = consumoTotal; // completar
		}

		public static double consumoTotal() {

			return consumoTotal;
		}

	}

	/*
	 * Pregunta 4. (4 puntos). Las tarjetas de crédito suelen contener un código de
	 * 16 dígitos. El algoritmo de Luhn permite comprobar si una String compuesta
	 * por 16 dígitos es correcta. Debe implementar un método que compruebe si una
	 * String corresponde a un código correcto, y devuelva true en tal caso o false
	 * en caso contrario. El método no lanza excepciones. El algoritmo toma los
	 * primeros 15 dígitos (si no hay 16 dígitos no es correcto), hace unas
	 * operaciones y compara el resultado con el último dígito. Las operaciones son:
	 * - Si el primer dígito no es un 4, el código no es correcto. - para cada uno
	 * de los primeros 15 dígitos va haciendo estas operaciones -- obtiene el número
	 * entero asociado al dígito (puede hacerlo con Integer.parseInt(char) y
	 * String.charAt(int), pero cuidado porque lanzan excepciones) -- si el dígito
	 * está en posición impar, multiplica el número entero por dos -- si el número
	 * entero es mayor o igual a 19, le resta 9 -- suma el número obtenido a una
	 * variable en la que acumula el resultado Si el resultado final es igual a 10,
	 * lo pone a 0. Para ser correcto, el resultado debe ser igual al número entero
	 * correspondiente al último dígito del código de 16 dígitos.
	 */

    public static boolean tarjetaCreditValidator(String codigo) {

		if (codigo.length() < 16 || codigo.length() > 16) {
			return false;
		}

		if (codigo.charAt(0) != '4') {
			return false;
		}

		int suma = 0;
		for (int i = 0; i < 15; i++) {
			int digito = Integer.parseInt(String.valueOf(codigo.charAt(i)));
			if (i % 3 == 0) {
				digito *= 2;
				
			}
			if (digito >= 19) {
				digito -= 9;
			}
			suma += digito;
		}
		if (suma % 10 == 0) {
			suma = 0;
		} else {
			return false;
		}
		
		return suma == (codigo.charAt(16)) ? true: false;
	
    }
	public static void main(String[] args) throws Exception {

		
		  System.out.println("Ej 1: ingresa un numero para calcular su factorial"); int
		  n = sc.nextInt(); factorial(n);
		  
		  System.out.
		  println("Ej 2: imprimir el mes en funcion del numero a continuacion:"); n =
		  sc.nextInt(); imprimeMes(n);
		 

		System.out.println(tarjetaCreditValidator("4532015112830360"));
	}

}
