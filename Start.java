import java.util.Scanner;

public class Start {
	public static void main(String[] args) {
		calculate();
	}

	private static void calculate() {
		char operationType = '\0', otherOperation = '\0';
		double firstValue = 0, secondValue = 0;
		Scanner sc = new Scanner(System.in);
		try {
			do {
				System.out.println(
						"Choisissez votre opération: \n 1) Addition \n 2) Soustraction \n 3) Multiplication \n 4) Division \n 5) Division avec reste \n 6) Exposant");
				operationType = sc.next().charAt(0);
				switch (operationType) {
				case '1':
					firstValue = firstVariable(sc);
					System.out.println("Saisissez la valeur à ajouter à " + firstValue);
					secondValue = sc.nextDouble();
					double resultAddition = firstValue + secondValue;
					System.out.println(
							"L'addition de " + firstValue + " et " + secondValue + " donne: " + resultAddition);
					otherOperation = retry(sc);
					break;
				case '2':
					firstValue = firstVariable(sc);
					System.out.println("Saisissez la valeur à soustraire à " + firstValue);
					secondValue = sc.nextDouble();
					double resultSubtraction = firstValue - secondValue;
					System.out.println(
							"La soustraction de " + firstValue + " et " + secondValue + " donne: " + resultSubtraction);
					otherOperation = retry(sc);
					break;
				case '3':
					firstValue = firstVariable(sc);
					System.out.println("Saisissez la valeur à multiplier par " + firstValue);
					secondValue = sc.nextDouble();
					double resultMultiplicate = firstValue * secondValue;
					System.out.println("La multiplication de " + firstValue + " et " + secondValue + " donne: "
							+ resultMultiplicate);
					otherOperation = retry(sc);
					break;
				case '4':
					firstValue = firstVariable(sc);
					System.out.println("Saisissez la valeur qui divisera " + firstValue);
					secondValue = sc.nextDouble();
					double resultDivision = firstValue / secondValue;
					System.out.println(
							"La division de " + firstValue + " et " + secondValue + " donne: " + resultDivision);
					otherOperation = retry(sc);
					break;
				case '5':
					firstValue = firstVariable(sc);
					System.out.println("Saisissez la valeur qui divisera en gardant le reste " + firstValue);
					secondValue = sc.nextDouble();
					double resultDivisionWithoutWork = firstValue / secondValue,
							restOfDivisionWithoutWork = firstValue % secondValue;
					int resultDivisionWithRest = (int) resultDivisionWithoutWork,
							restOfDivision = (int) restOfDivisionWithoutWork;
					System.out.println("La division de " + firstValue + " et " + secondValue + " donne: "
							+ resultDivisionWithRest + " et il reste: " + restOfDivision);
					otherOperation = retry(sc);
					break;
				case '6':
					System.out.println("Saisissez une valeur");
					firstValue = sc.nextDouble();
					double resultOfExposant = firstValue * firstValue;
					System.out.println("L'exposant de " + firstValue + " est égale à: " + resultOfExposant);
					otherOperation = retry(sc);
					break;
				default:
					System.out.println(
							"Choisissez votre opération: \n 1) Addition \n 2) Soustraction \n 3) Multiplication \n 4) Division \n 5) Division avec reste \n 6) Exposant");
					break;
				}

			} while (otherOperation == '\0' || otherOperation == 'o');
		} catch (NumberFormatException e) {
			System.out.println(
					"Choisissez votre opération: \n 1) Addition \n 2) Soustraction \n 3) Multiplication \n 4) Division \n 5) Division avec reste \n 6) Exposant");
		}
		while (otherOperation == 'n') {
			System.out.println("Au revoir");
			sc.close();
		}
	}

	private static char retry(Scanner sc) {
		char otherOperation;
		System.out.println("Voulez-vous ré-essayer ? (O/N)");
		String retry = sc.next();
		otherOperation = retry.charAt(0);
		Character.toLowerCase(otherOperation);
		return otherOperation;
	}

	private static double firstVariable(Scanner sc) {
		System.out.println("Saisissez la première valeur");
		double firstValue = sc.nextDouble();
		return firstValue;
	}
}
