import java.util.Vector;

public class Display extends DisplayUtilities{
     static void displayBoard(Vector<Tableau> tableau, Vector<Foundation> foundation, Deck deck) {
        displayTableau(tableau);
        displayFoundation(foundation);
        displayDeck(deck);
    }

    public static void displayInstructions(){
        System.out.println("=== This is Solitaire ===");
        System.out.println("INTRO TO GAME");
    }

    public static void displayTableau(Vector<Tableau> tableau) {
        final int tableauWidth = 7; // width is number of tableau piles (standard is 7)
        final int tableauHeight = computeTableauHeight(tableau);

        // Print column headers A through G
        space(5);
        for (int i = 0; i < tableauWidth; ++i) {
            System.out.print((char)('A' + i)); // column header
            space(cardLength * 2 - 3);
        }
        System.out.println();

        // Print tableau with row headers
        for (int i = 0; i < tableauHeight; ++i) {
            System.out.print(i + 1); // row header
            space(i + 1 > 9 ? 3 : 4); // if row header is two digits, less space
            for (int j = 0; j < tableauWidth; ++j) {
                Tableau toDisplay = tableau.get(j);

                // Print vacant tableau space -or-
                if(toDisplay.cards.isEmpty() && i == 0){
                    repeatCharacter(OPEN, cardLength);
                // print a card in a pile -or-
                } else if (toDisplay.size() - 1 >= i) {
                    System.out.print(toDisplay.printCertainCard(i));
                // print empty space
                } else {
                    space(cardLength);
                }
                space(3); // space between columns
            }
            System.out.println();
        }
    }

    public static void displayFoundation(Vector<Foundation> foundation){
        System.out.println();
        System.out.print("Foundation: ");
        for(Foundation pile : foundation){
            if(pile.size() == 0)
                repeatCharacter(OPEN, cardLength - 2);
            else
                System.out.print(pile.printTopCard());
            space(2);
        }
    }

    public static void displayDeck(Deck deck){
        System.out.println();
        System.out.println("Stock: " + deck.stock.size());
        System.out.print("Next: ");
        for (String card : deck.getTalonStrings()) {
            System.out.print(card + "   ");
        }
    }
}