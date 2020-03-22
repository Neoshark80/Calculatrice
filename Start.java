import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {
	public static void main(String[] args) {
		calculate();
	}

	public static void calculate() {
		Scanner sc = new Scanner(System.in);
		int operationType = 0, valeurUne = 0, valeurDeux = 0;
		char moreOperation = 'O';

		while (moreOperation == 'O')
			if (operationType <= 0 || operationType >= 6) {
				System.out.println(
						"Choisissez le type d'opération à réaliser en entrant son numéro: \n 1 pour une addition \n 2 pour une soustraction \n 3 pour une multiplication \n 4 pour une division \n 5 pour une division avec reste");
				try {
					operationType = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Veuillez entrer une valeur correspondant à une opération");
					sc.next();
				}
			} else {
				while (valeurUne == 0) {
					System.out.println("Veuillez entrer la 1ere valeur");
					try {
						valeurUne = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Veuillez entrer une valeur numérique");
						sc.next();
					}
				}
				while (valeurDeux == 0) {
					System.out.println("Veuillez entrer la 2eme valeur");
					try {
						valeurDeux = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Veuillez entrer une valeur numérique");
						sc.next();
					}
				}
				switch (operationType) {
				case 1:
					System.out.println("La somme de " + valeurUne + " + " + valeurDeux + " fait "
							+ addition(valeurUne, valeurDeux));
					break;
				case 2:
					System.out.println("Le reste de " + valeurUne + " - " + valeurDeux + " fait "
							+ soustraction(valeurUne, valeurDeux));
					break;
				case 3:
					System.out.println("Le produit de " + valeurUne + " et " + valeurDeux + " fait "
							+ multiplication(valeurUne, valeurDeux));
					break;
				case 4:
					System.out.println("Le quotient de " + valeurUne + " et " + valeurDeux + " fait "
							+ division(valeurUne, valeurDeux));
					break;
				case 5:
					System.out.println("Le quotient de " + valeurUne + " et " + valeurDeux + " fait "
							+ divisionAvecReste(valeurUne, valeurDeux) + " avec un reste de "
							+ reste(valeurUne, valeurDeux));
					break;
				default:
					System.out.println("Veuillez entrer une valeur correspondant à une opération");
				}
				operationType = 0;
				valeurUne = 0;
				valeurDeux = 0;
				moreOperation = retry(sc);

				while (moreOperation != 'O' && moreOperation != 'N')
					moreOperation = retry(sc);
				while (moreOperation == 'N')
					System.out.println("Au revoir");
				break;
			}
	}

	private static char retry(Scanner sc) {
		char otherOperation, otherOperation1;
		String retry = null;
		System.out.println("Voulez-vous ré-essayer ? (O/N)");
		retry = sc.next();
		otherOperation = retry.charAt(0);
		otherOperation1 = Character.toUpperCase(otherOperation);
		return otherOperation1;
	}

	private static int addition(int valeurUne, int valeurDeux) {
		int resultAdd = valeurUne + valeurDeux;
		return resultAdd;
	}

	private static int soustraction(int valeurUne, int valeurDeux) {
		int resultLess = valeurUne - valeurDeux;
		return resultLess;
	}

	private static int multiplication(int valeurUne, int valeurDeux) {
		int resultMultiplicate = valeurUne * valeurDeux;
		return resultMultiplicate;
	}

	private static double division(int valeurUne, int valeurDeux) {
		double resultDivision = valeurUne / (double) valeurDeux;
		return resultDivision;
	}

	private static int divisionAvecReste(int valeurUne, int valeurDeux) {
		int resultDivision = valeurUne / valeurDeux;
		return resultDivision;
	}

	private static int reste(int valeurUne, int valeurDeux) {
		int rest = valeurUne % valeurDeux;
		return rest;
	}
}
