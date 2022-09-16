public class Card {
    protected Value value;
    protected Suit suit;
    protected String color;

    public Card(Value value, Suit suit){
        this.value = value;
        this.suit = suit;
        if(this.suit == Suit.DIAMOND || this.suit == Suit.HEART)
            this.color = "/";
        else
            this.color = "\\";
    }

    public void printCard() {
        String maybeSpace = "";
        if(this.value.valueString().length() == 1)
            maybeSpace = " ";
        System.out.print(maybeSpace + this.value.valueString() + this.color + this.getSuitString());
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

    public Suit getSuitEnum(){
        return this.suit;
    }

    public int getValueNumber() {
        return this.value.valueNumber();
    }

    public String getValueString() {
        return this.value.valueString();
    }

    public boolean isAbove(int otherValue){
        if(value.valueNumber() == otherValue + 1)
            return true;
        return false;
    }

    public boolean isBelow(int otherValue){
        if(value.valueNumber() == otherValue - 1)
            return true;
        return false;
    }

    public boolean isSameSuit(Suit otherSuit) {
        if(otherSuit == this.suit)
            return true;
        return false;
    }
}