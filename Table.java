
import java.util.ArrayList;

public class Table {
	static  final int MAXPLAYER=4;
	public Deck deck;
	public Dealer dealer;
	private int[] pos_Array = new int[MAXPLAYER];
	private Player[] player = new Player[MAXPLAYER];
	
	ArrayList<Card> Player1Card = new ArrayList<>();
	ArrayList<Card> Player2Card = new ArrayList<>();
	ArrayList<Card> Player3Card = new ArrayList<>();
	ArrayList<Card> Player4Card = new ArrayList<>();
	ArrayList<Card> DealerCard  = new ArrayList<>();
	
	private Card dealer_open_cared;

	public Table(int nDeck) {
		
		Deck deck= new Deck(nDeck);
		deck.shuffle();
		this.deck=deck;
		
	}
	
	public void set_player(int pos,Player p){
		
		player[pos]=p;

	}
	
	public Player[] get_player() {
		
		return player;
		
	}

	
	public void set_dealer(Dealer d) {
		
		dealer=d;
		
	}
	/**
	 * By using this method, dealer's opened card can be known.
	 */
	public Card get_face_up_card_of_dealer(ArrayList<Card> card) {
		
		dealer_open_cared = new Card(DealerCard.get(1).getSuit(), DealerCard.get(1).getRank());
		return dealer_open_cared;
		
	}
	
	/**
	 * Asking each player's bets, then preserve them in the array.
	 */
	private void ask_each_player_about_bets(Player p) {
		p.sayHello();
		for(int index=0;index<MAXPLAYER;index++) {
			pos_Array[index]=p.makeBet();
		}
		
	}
	
	/**
	 * This method will give each person two cards at first. 
	 * All players' cards are opened, while dealer's first card is closed.
	 * If hit, player will get another card in the deck and the card will be added in player's one round card, then print them.
	 * While passing hit, player's final cards will be printed on the scream.
	 */
	private void distribute_cards_to_dealer_and_players() {
		
			boolean openclose;
			for(int index=0;index<2;index++) {
				if(index==0) {
					openclose=false;
				}
				else {
					openclose=true;
				}
	
				Player1Card.add(deck.getOneCard(true));
				Player2Card.add(deck.getOneCard(true));
				Player3Card.add(deck.getOneCard(true));
				Player4Card.add(deck.getOneCard(true));
				DealerCard.add(deck.getOneCard(openclose));
				
			}
			
			player[0].setOneRoundCard(Player1Card);
			player[1].setOneRoundCard(Player2Card);
			player[2].setOneRoundCard(Player3Card);
			player[3].setOneRoundCard(Player4Card);
			dealer.setOneRoundCard(DealerCard);
	}
	
	/**
	 * This method will ask each player whether to bet by using hit_me method in Player Class.
	 * If hit, player will get another card in the deck and the card will be added in player's one round card, then print them.
	 * While passing hit, player's final cards will be printed on the scream.
	 *  @param tbl
	 */
	private void ask_each_player_about_hits(Table tbl) {
		
		boolean hit=false;
		do{
			hit=player[0].hit_me(tbl); 
			if(hit){
				Player1Card.add(deck.getOneCard(true));
				player[0].setOneRoundCard(Player1Card);
				System.out.print("Hit! ");
				System.out.println(player[0].getName()+"'s Cards now:");
				for(Card c : Player1Card){
					c.printCard(c.getSuit(),c.getRank());
				}
			}
			else{
				
				System.out.println(player[0].getName()+", Pass hit!");
				System.out.println(player[0].getName()+"'s hit is over:");

			}
		}while(hit);
		
		hit=false;
		do{
			hit=player[1].hit_me(tbl); //this
			if(hit){
				Player2Card.add(deck.getOneCard(true));
				player[1].setOneRoundCard(Player2Card);
				System.out.print("Hit! ");
				System.out.println(player[1].getName()+"'s Cards now:");
				for(Card c : Player2Card){
					c.printCard(c.getSuit(),c.getRank());
				}
			}
			else{
				
				System.out.println(player[1].getName()+", Pass hit!");
				System.out.println(player[1].getName()+"'s hit is over:");
				
			}
		}while(hit);
		
		hit=false;
		do{
			hit=player[2].hit_me(tbl); //this
			if(hit){
				Player3Card.add(deck.getOneCard(true));
				player[2].setOneRoundCard(Player3Card);
				System.out.print("Hit! ");
				System.out.println(player[2].getName()+"'s Cards now:");
				for(Card c : Player3Card){
					c.printCard(c.getSuit(),c.getRank());
				}
			}
			else{
				
				System.out.println(player[2].getName()+", Pass hit!");
				System.out.println(player[2].getName()+"'s hit is over:");
				
			}
		}while(hit);
		
		hit=false;
		do{
			hit=player[3].hit_me(tbl); //this
			if(hit){
				Player4Card.add(deck.getOneCard(true));
				player[3].setOneRoundCard(Player4Card);
				System.out.print("Hit! ");
				System.out.println(player[3].getName()+"'s Cards now:");
				for(Card c : Player4Card){
					c.printCard(c.getSuit(),c.getRank());
				}
			}
			else{
				
				System.out.println(player[3].getName()+", Pass hit!");
				System.out.println(player[3].getName()+"'s hit is over:");
				
			}
		}while(hit);
		}
	
	private void ask_dealer_about_hits(Table tbl) {
		boolean hit=false;
		
		do{
			hit=dealer.hit_me(tbl); 
			if(hit){
				DealerCard.add(deck.getOneCard(true));
				dealer.setOneRoundCard(DealerCard);
				System.out.print("Hit! ");
				System.out.println("dealer'sCards now:");
				for(Card c : DealerCard){
					c.printCard(c.getSuit(),c.getRank());
				}
			}
			else{
				System.out.println("dealer Pass hit!");
				System.out.println("dealer's hit is over");
				
			}
		}while(hit);
	}
	
	/**
	 * This method is used to calculate each player's and dealer's card values at first.
	 * Then, comparing each player's card value to dealer's card value to determine who wins the game.
	 * Finally, decide whether players get money or lose money.
	 */
	private void calculate_chips() {
				
		System.out.println("........................................");
		System.out.println("Dealer's card value is "+dealer.getTotalValue());
		dealer.printAllCard();
		System.out.println("........................................");
		

		
		for(int index=0;index<MAXPLAYER;index++) {
					
				if(index==0) {
					
					System.out.println("Player1's Card:");
					player[index].printAllCard();
					System.out.print("Player1 card value is "+player[index].getTotalValue()+", ");
					
				}
				else if (index==1) {
					
					System.out.println("Player2's Card:");
					player[index].printAllCard();
					System.out.print("Player2 card value is "+player[index].getTotalValue()+", ");
					
				}
				else if (index==2) {
					
					System.out.println("Player3's Card:");
					player[index].printAllCard();
					System.out.print("Player3 card value is "+player[index].getTotalValue()+", ");
					
				}
				else if (index==3) {
					
					System.out.println("Player4's Card:");
					player[index].printAllCard();
					System.out.print("Player4 card value is "+player[index].getTotalValue()+", ");
					
				}
				if(dealer.getTotalValue()>21&&player[index].getTotalValue()>21) {
					
					System.out.print("chips have no change!, ");
					System.out.println("the Chips now is: "+player[index].getCurrentChips());
					
				}
				else if(dealer.getTotalValue()>21&&player[index].getTotalValue()<=21) {
					
					System.out.print("Get "+pos_Array[index]+" Chips, ");
					player[index].increaseChips(pos_Array[index]);
					System.out.println("the Chips now is: "+player[index].getCurrentChips());
					
				}
				else if(dealer.getTotalValue()<=21&&player[index].getTotalValue()>21) {
					
					System.out.print("Lose "+pos_Array[index]+" Chips, ");
					player[index].increaseChips(-pos_Array[index]);
					System.out.println("the Chips now is: "+player[index].getCurrentChips());
					
				}
				else if(dealer.getTotalValue()<=21&&player[index].getTotalValue()<=21) {
					if(dealer.getTotalValue()<player[index].getTotalValue()) {
						
						System.out.print("Get "+pos_Array[index]+" Chips, ");
						player[index].increaseChips(pos_Array[index]);
						System.out.println("the Chips now is: "+player[index].getCurrentChips());
						
					}
					else if(dealer.getTotalValue()>player[index].getTotalValue()){

						System.out.print("Lose "+pos_Array[index]+" Chips, ");
						player[index].increaseChips(-pos_Array[index]);
						System.out.println("the Chips now is: "+player[index].getCurrentChips());
						
					}
					else if(dealer.getTotalValue()==player[index].getTotalValue()) {

						System.out.print("chips have no change!, ");
						System.out.println("the Chips now is: "+player[index].getCurrentChips());
						
					}
				
				}
		
		System.out.println("........................................");
		}
	}
	
	/**
	 * To get each player's bet 
	 */
	public int[] get_palyers_bet() {
		
		return pos_Array;
	}	
	
	public void play(Table tbl) {
		
		for(int index=0; index<player.length;index++) {
		ask_each_player_about_bets(player[index]);
		
		}
		distribute_cards_to_dealer_and_players();
		
		System.out.println("........................................");
		System.out.print("Dealer's face up card is ");
		get_face_up_card_of_dealer(DealerCard);
		dealer_open_cared.printCard(dealer_open_cared.getSuit(), dealer_open_cared.getRank());
		System.out.println("........................................");
		ask_each_player_about_hits(tbl);
		ask_dealer_about_hits(tbl);
		calculate_chips();
		
	}

	
}
