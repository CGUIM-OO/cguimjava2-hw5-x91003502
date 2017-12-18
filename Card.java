public class Card{
	private Suit suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	
	public Card(Suit s,int r){
		suit=s;
		rank=r;
	}
	
	public enum Suit {
		Clubs,
	    Diamonds,
	    Hearts,
		Spades;
	}
	
	public void printCard(Suit s,int r){
		switch(r) {
		case 1:
			System.out.println(s+" "+"Ace");
			break;
		case 2:
			System.out.println(s+" "+r);
			break;
		case 3:
			System.out.println(s+" "+r);
			break;
		case 4:
			System.out.println(s+" "+r);
			break;
		case 5:
			System.out.println(s+" "+r);
			break;
		case 6:
			System.out.println(s+" "+r);
			break;
		case 7:
			System.out.println(s+" "+r);
			break;
		case 8:
			System.out.println(s+" "+r);
			break;
		case 9:
			System.out.println(s+" "+r);
			break;
		case 10:
			System.out.println(s+" "+r);
			break;
		case 11:
			System.out.println(s+" "+"Jack");
			break;
		case 12:
			System.out.println(s+" "+"Queen");
			break;
		case 13:
			System.out.println(s+" "+"King");
			break;
		}
		
		
	}
	public Suit getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
