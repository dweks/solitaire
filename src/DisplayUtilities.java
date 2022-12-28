import java.util.Vector;

public class DisplayUtilities {
	static final int cardLength = 5;
	static final char OPEN = '_';
	static final char HIDDEN = '_';

	static void space(int length) {
		for(int i = 0; i < length; ++i) {
			System.out.print(" ");
		}
	}

	static void repeatCharacter(char toPrint, int numTimes) {
		for (int i = 0; i < numTimes; i++) {
			System.out.print(toPrint);
		}
	}

	public static int computeTableauHeight(Vector<Tableau> tableau) {
		int largest = 0;
		for(Tableau pile : tableau){
			if(largest < pile.size())
				largest = pile.size();
		}
		return largest;
	}
}