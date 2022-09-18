import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        try {
            Deck deck = new Deck();
            deck.shuffleDeck();
            Vector<Pile> allPiles = new Vector<>();
            int numPiles = 7;
            int longestPile = 0;
            int rowHeader = 1;
            char columnHeader = 'A';

            for(int i = 0; i < numPiles; ++i) {
                allPiles.add(deck.extractPile(i + 2));
                allPiles.get(i).revealLast();
                if(allPiles.get(i).size() > longestPile)
                    longestPile = allPiles.get(i).size();
            }

            Display.space(5);
            for(int i = 0; i < numPiles; ++i) {
                System.out.print(columnHeader);
                Display.space(7);
                ++columnHeader;
            }
            System.out.println();

            for(int i = 0; i < longestPile; ++i) {
                System.out.print(rowHeader);
                Display.space(4);
                for(int j = 0; j < numPiles; ++j) {
                    if(allPiles.get(j).size() - 1 >= i) {
                        allPiles.get(j).allCards.get(i).printCard();
                    } else {
                        Display.space(4);
                    }
                    Display.space(4);
                }
                System.out.println();
                ++rowHeader;
            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
