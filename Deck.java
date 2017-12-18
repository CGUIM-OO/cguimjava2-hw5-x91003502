import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck{
	private ArrayList<Card> cards;
	private ArrayList<Card> usedCard;
	private ArrayList<Card> openCard;
	public int nUsed=0;//not sure
	public Deck(int nDeck){
		openCard= new ArrayList<Card>();
		usedCard= new ArrayList<Card>();//have some ....
		cards=new ArrayList<Card>();
		for(int i=1;i<=nDeck;i++) {
			for(int k=1;k<=13;k++) {
				for(Card.Suit suit:Card.Suit.values()) {
					Card card=new Card(suit,k);
					cards.add(card);
				
				}
			}	
		}			
	}	

	public void printDeck(){
		for(int index=0;index<cards.size();index++) {
		Card CardDetail= cards.get(index);
		Card c=new Card(CardDetail.getSuit(),CardDetail.getRank());
		c.printCard(CardDetail.getSuit(),CardDetail.getRank());
		}
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)

	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
	
	public void shuffle() {
		
		nUsed=0;
		cards.addAll(usedCard);
		usedCard.removeAll(usedCard);
		openCard.removeAll(openCard);
		Random rnd=new Random();
		Collections.shuffle(cards, rnd);
		
	}
	
	public Card getOneCard(boolean isOpened) {
		Card usedcard=cards.get(0);
		usedCard.add(usedcard);
		
		if(isOpened=true) {
			openCard.add(usedcard);
		}
		
		cards.remove(usedcard);
		nUsed++;
		if(nUsed>51)
		{
		shuffle();	
		}
		return usedcard;
		
	}
	
	public ArrayList<Card> getOpenedCard() {
		return openCard;
	}
}