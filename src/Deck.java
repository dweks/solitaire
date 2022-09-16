
public class Deck extends Stack{
    public Deck() throws Exception {
        generateDeck();
    }
    public void generateDeck() throws Exception {
        for(Suit suit : Suit.values()){
            for(int i = 1; i < 14; ++i) {
                allCards.add(new Card(new Value(i), suit));
            }
        }
    }

    public void printDeck() {
        for(Card card : this.allCards) {
            card.printCard();
            System.out.println();
        }
    }
}
