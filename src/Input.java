import java.util.Scanner;
import java.util.regex.*;
public class Input {
	private static Scanner prompt = new Scanner(System.in);
	protected final static Pattern optionPattern = Pattern.compile("^:[a-z]$");
	protected final static Pattern moveTableauPattern = Pattern.compile(
	"^[A-G]([1-9]|1[0-4]) to [A-G]([1-9]|1[0-4])$"
	);

	public Input(){

	}

	public int[] get() throws InvalidInput {
		String input = prompt.nextLine();
		Matcher matchOption = optionPattern.matcher(input);
		Matcher matchMove = moveTableauPattern.matcher(input);

		if(matchOption.find()){
			return new int[] { (int)input.charAt(1) };
		} else if(matchMove.find()) {
			return parseCoordinates(input);
		}
		else
			throw new InvalidInput(input);
	}

	private int[] parseCoordinates(String input){
		String [] splitInput = input.split(" to ");
		String fromX = splitInput[0].substring(0,1);
		String fromY = splitInput[0].substring(1);
		String toX = splitInput[1].substring(0,1);
		String toY = splitInput[1].substring(1);

		int[] coordinates = {
				(int) fromX.charAt(0) - 64,
				Integer.parseInt(fromY),
				(int) toX.charAt(0) - 64,
				Integer.parseInt(toY),
		};
		return coordinates;
	}

}