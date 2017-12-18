import java.util.ArrayList;

public class Player extends Person {
	
	private String name;
	private int chips;
	private int bet;
	
	public Player(String name, int chips) {
		
		this.name=name;
		this.chips=chips;
		
	}
	

	public String getName() {
		
		return name;
	}
	
	public int makeBet() {
		
		bet=1;
		return bet;
	}
	
	public int getCurrentChips() {
		
		return chips;
		
	}
	
	public void increaseChips(int diff) {
		this.chips=this.chips+diff;
		
	}
	
	public void sayHello() {
		
		System.out.println("Hello, I am "+name);
		System.out.println("I have "+chips+"chips");
	}
	
	/**
	 * This method override hit_me abstract method in Person Class, which is used to determine to get another card or not.
	 * @param table
	 * @return boolean
	 */
	public boolean hit_me(Table table) {
	
		int sum=0;
		for(int i=0;i<getOneRoundCard().size();i++) {
			Card card=new Card(getOneRoundCard().get(i).getSuit(),getOneRoundCard().get(i).getRank());
			if(card.getRank()==13||card.getRank()==12||card.getRank()==11){
				sum=sum+10;
			}
			else {
				sum=sum+card.getRank();
			}
		}
		
		if(sum<=16) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This method override setOneRoundCard abstract method in Person Class, used to set each palyer's one round card.
	 * @param cards
	 */
	public void setOneRoundCard(ArrayList<Card> cards) {
		
		oneRoundCard = new ArrayList<Card>();
		oneRoundCard.addAll(cards);
		
	}
}


