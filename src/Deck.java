import java.util.Collections;
import java.util.Vector;

public class Deck {
	Vector<Card> stock = new Vector<>();
	Vector<Card> talon = new Vector<>();

	public Deck() {
		for(Suit suit : Suit.values()){
			for(int i = 1; i < 14; ++i) {
				stock.add(new Card(new Value(i), suit));
			}
		}
		Collections.shuffle(stock);
	}

	public Vector<Card> extractTableau(int size) {
		Vector<Card> hold = new Vector<>();
		hold.addAll(stock.subList(stock.size() - size, stock.size()));
		stock.subList(stock.size() - size, stock.size()).clear();
		return hold;
	}

	public void refillStock() {
		for(Card card : talon){
			stock.add(card);
		}
		talon.clear();
	}

	public boolean next(){
		if(stock.isEmpty())
			return false;
		Card hold = stock.get(stock.size() - 1);
		hold.revealCard();
		stock.remove(stock.size() - 1);
		return talon.add(hold);
	}

	public Vector<String> getTalonStrings(){
		Vector<String> talonCardNames = new Vector<>();
		if (talon.size() == 0)
			return talonCardNames;
		else if(talon.size() == 1)
			talonCardNames.add(talon.get(0).getCardString());
		else if(talon.size() == 2) {
			talonCardNames.add(talon.get(1).getCardString());
			talonCardNames.add(talon.get(0).getCardString());
		}
		else {
			int top = talon.size() - 1;
			for (int i = top; i > top - 3; i--) {
				talonCardNames.add(talon.get(i).getCardString());
			}
		}
		return talonCardNames;
	}

}