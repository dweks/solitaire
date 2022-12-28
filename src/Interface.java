import java.util.Arrays;
import java.util.Vector;

public class Interface extends Display{
	protected static Input input = new Input();
	protected final static int tableauHeight = 7;
	private final static Vector options = new Vector<>(Arrays.asList(
		'q', 'h', 'u', 'r'
	));

	protected static int validateInput(int [] toValidate) throws InvalidInput, IllegalMove, InvalidOption {
		System.out.println("toValidate = " + toValidate.length);
			switch (toValidate.length) {
				case 1:
					if(isValidOption(toValidate))
						return 0;
				case 3:
					if(isLegalTableauMove(toValidate))
						return 1;
				case 4:
					if(isLegalFoundationMove(toValidate))
						return 2;
				default:
					throw new InvalidInput("Unknown command");
			}
	}

	protected static boolean isValidOption(int [] toValidate) throws InvalidOption {
		return options.contains((char)toValidate[0]);
	}

	protected static boolean isLegalTableauMove(int [] toValidate) throws IllegalMove {
		return false;
	}

	protected static boolean isLegalFoundationMove(int [] toValidate) throws IllegalMove {
		return false;
	}
}