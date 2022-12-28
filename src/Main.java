import java.util.Vector;

public class Main extends Interface {
    static Deck deck = new Deck();
    static Vector<Tableau> tableau = new Vector<>();
    static Vector<Foundation> foundation = new Vector<>();

    public static void main(String[] args) {
        initialize();
        while(true){
            try{
                int [] action = input.get();
                System.out.println(validateInput(action));
            } catch (InvalidInput e) {
                System.out.println("Invalid input: " + e.getMessage());
            } catch (IllegalMove e) {
                System.out.println("Illegal move: " + e.getMessage());
            } catch (InvalidOption e) {
                System.out.println("Invalid option: " + e.getMessage());
            }
        }
//        Display.displayInstructions();
//        Display.displayBoard(tableau, foundation, deck);
    }

    static void update() {
        computeTableauHeight(tableau);
    }

    static void initialize() {
        for (int i = 0; i < 7; ++i) {
            tableau.add(new Tableau(deck.extractTableau(i + 1)));
            tableau.get(i).revealLast();
            
        }
        for (int i = 0; i < 4; i++) {
            foundation.add(new Foundation(new Vector<Card>()));
        }
    }
    static void TESTS() {
        Card addCard = new Card(new Value(1), Suit.SPADE);
        addCard.revealCard();
        try {
            foundation.get(0).appendCard(addCard);
        } catch (IllegalMove e) {
            System.out.println(e.getMessage());
        }
    }
}