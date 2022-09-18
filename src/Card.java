public class Card {
    protected Value value;
    protected Suit suit;
    protected String color;
    protected boolean revealed;

    public Card(Value value, Suit suit){
        this.value = value;
        this.suit = suit;
        if(this.suit == Suit.DIAMOND || this.suit == Suit.HEART)
            this.color = "+";
        else
            this.color = "-";
        this.revealed = false;
    }

    public void revealCard() {
        this.revealed = true;
    }
    public void hideCard() {
        this.revealed = false;
    }

    public void printCard() {
        if(this.revealed) {
            String maybeSpace = "";
            if (this.value.valueString().length() == 1)
                maybeSpace = " ";
            System.out.print(this.color + maybeSpace + this.value.valueString() + this.getSuitString());
        } else {
            System.out.print("____");
        }
    }

    public String getSuitString() {
        switch (this.suit) {
            case DIAMOND -> {return "D";}
            case CLUB -> {return "C";}
            case HEART -> {return "H";}
            case SPADE -> {return "S";}
        }
        return null;
    }

    public Suit getSuitEnum(){ return this.suit; }
    public int getValueNumber() { return this.value.valueNumber(); }
    public String getValueString() { return this.value.valueString(); }
    public String getColorString() { return this.color; }

    // This card's value is above the destination card's value
    public boolean isAbove(int destinationValue){
        return this.value.valueNumber() == destinationValue - 1;
    }

    // This card's color is opposite the destination card's color
    public boolean isAlternateColor(String destinationColor) {
        return this.color == destinationColor;
    }

    // This card may be placed on top of destination pile
    public boolean compatiblePile(Card card){
        return this.isAbove(card.getValueNumber()) && this.isAlternateColor(card.getColorString());
    }

    // This card's suit matches the destination card's suit
    public boolean isSameSuit(Suit otherSuit) {
        return otherSuit == this.suit;
    }
}