import java.security.SecureRandom;
import javax.swing.JOptionPane;
import java.util.ArrayList;
public class DeckOfCards {
	
	private ArrayList<Card> deck; // array of Card objects
	private int currentCard; // index of next Card to be dealt (0-51)
	private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
	// random number generator
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	// constructor fills deck of Cards
	public DeckOfCards()
	{
		String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
				"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
		deck=new ArrayList<Card>();
		currentCard = 0; // first Card dealt will be deck[0]
		// populate deck with Card objects
		for (int count = 0; count < NUMBER_OF_CARDS; count++)
			deck.add(new Card(faces[count%13], suits[count/13]));
	}
	
	// constructor for empty deck of Cards
	public DeckOfCards(String x)
	{
		String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
				"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
		deck=new ArrayList<Card>();
	}
	
	 // shuffle deck of Cards with one-pass algorithm
	 public void shuffle()
	 {
	 // next call to method dealCard should start at deck[0] again
	 currentCard = 0;
	
     // for each Card, pick another random Card (0-51) and swap them
	 for (int first = 0; first < NUMBER_OF_CARDS; first++)
	 {
		 // select a random number between 0 and 51
		 int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
		 // swap current Card with randomly selected Card
		 Card temp = deck.get(first);
		 deck.add(first, deck.get(second)); 
		 deck.add(second, temp);
		 }
	 }
	 // deal one Card
	 public Card dealCard()
	 {
		 // determine whether Cards remain to be dealt
		 if (currentCard <NUMBER_OF_CARDS )
			 return deck.get(currentCard++); // return current Card in array
		 else
			 return null; // return null to indicate that all Cards were dealt
		 }
	 //add one card to deck
	 public void addCard(int place, DeckOfCards packToDeal)
	 {
		 this.deck.add(place, packToDeal.dealCard());
	 }
	 //print deck 
	 public String print() 
	 {
		    String results = "";
		    for(int i=0; i<this.deck.size(); i++)
		    {
		        results=results+"\n"+ this.deck.get(i).toString(); 
		    }
		    return results;
	 }
	 
	//this method calculate final points for each player
		public int calculatePoints () {
			
			int sum=0;
			for (int i=0; i<this.deck.size(); i++)
			{
				switch (this.deck.get(i).getFace())
				{
				case "Ace":
					break;
				case "Deuce":
					sum=sum+2;
					break;
				case "Three":
					sum=sum+3; 
					break;
				case "Four":
					sum=sum+4; 
					break;
				case "Five":
					sum=sum+5; 
					break;
				case "Six":
					sum=sum+6; 
					break;
				case "Seven":
					sum=sum+7; 
					break;
				case "Eight":
					sum=sum+8; 
					break;
				case "Nine":
					sum=sum+9; 
					break;
				case "Ten":
				case "Jack":
				case "Queen":
				case "King":
					sum=sum+10; 
					break;
				case "default":
					JOptionPane.showMessageDialog(null,  "no such card", "Error", JOptionPane.ERROR_MESSAGE);
					break;
					}//end switch statment
			}//and for loop
			
			return sum;
		}//and of calculatePoints method
		
		//this method check and return for each player/deck number of Aces
		public int checkForAce()
		{
			int count=0; 
			for(int i=0; i<this.deck.size(); i++)
			{
				if (this.deck.get(i).getFace()=="Ace")
					count++;
			}
			return count;
		}//end of method checkForAce
		
	 } // end class DeckOfCards



