import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.ArrayList;
public class BlackJack
{

	public static void main(String[] args) {

		DeckOfCards comp = new DeckOfCards("empty");//set of player cards
		DeckOfCards player = new DeckOfCards("empty");//set of computer cards - as default only 2
		DeckOfCards pack=new DeckOfCards();//declaring new full pack of cards
		pack.shuffle();
		int i;
		for ( i=0; i<2; i++)//dealing first 2 cards
		{
			comp.addCard(i, pack);
			player.addCard(i, pack);
		}//end for
		//process of dealing cards until player ask to stop
		int answer;
		JOptionPane.showMessageDialog(null,  player.print(), "your cards", JOptionPane.INFORMATION_MESSAGE);
		answer=JOptionPane.showConfirmDialog(null, "would you like to get another card?");
		while(answer!=1 && i<11)
		{
			player.addCard(i, pack);		
			i++;
			JOptionPane.showMessageDialog(null,  player.print(), "your cards", JOptionPane.INFORMATION_MESSAGE);
			answer=JOptionPane.showConfirmDialog(null, "would you like to get another card?");
		}//end while
		//showing final cards of both players
		JOptionPane.showMessageDialog(null,  player.print(), "your cards", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null,  comp.print(), "computer cards", JOptionPane.INFORMATION_MESSAGE);
		int playerP, comP; //variables to save players points
		int playerAce=player.checkForAce();//number of Aces in players pack
		playerP=player.calculatePoints();//calculating points without Aces
		String plAnswer; int ans;
		//if player have aces, this is the process for him to decide their values
		if (playerAce>0)
			for (int k=0; k<playerAce; k++)
			{
				plAnswer=JOptionPane.showInputDialog("Press 1 if you like Ace would be equal to 1 or 11 if you like Ace would be equal to 11:");
				ans=Integer.parseInt(plAnswer);
				if (ans==1)
					playerP=playerP+1;
				else if (ans==11)
					playerP=playerP+11;
				else while (ans!=1 && ans !=11)
				{
					plAnswer=JOptionPane.showInputDialog("Press 1 if you like Ace would be equal to 1 or 11 if you like Ace would be equal to 11:");
					ans=Integer.parseInt(plAnswer);
				}
			}//end for
		
		int compAce=comp.checkForAce();//number of Aces in computer pack
		comP=comp.calculatePoints();//calculating points without Aces
		//if computer have aces, the program will decide for him the values of them
		if (compAce>0)
			for (int j=0; j<compAce; j++)
			{
				if (comP+11<=21)
					comP=comP+11;
				else
					comP=comP+1;
			}//end for
		//converting points to String so they can be printed
		String pP=Integer.toString(playerP);
		String cP=Integer.toString(comP);
		//printing results
		if((playerP>comP && playerP<=21)||(comP>playerP && comP>21))
			JOptionPane.showMessageDialog(null, "The final points are"+"\n"+pP+"\n"+cP , "the winner is:player", JOptionPane.INFORMATION_MESSAGE);
		else if ((comP>playerP && comP<=21)||(comP<playerP && playerP>21))
			JOptionPane.showMessageDialog(null, "The final points are"+"\n"+cP+"\n"+pP , "the winner is:computer", JOptionPane.INFORMATION_MESSAGE);
		else if (comP==playerP && comP<=21)
			JOptionPane.showMessageDialog(null, "equal points there is no winner" , "the winner is:", JOptionPane.INFORMATION_MESSAGE);
		else if (comP>21 && playerP>21)
			JOptionPane.showMessageDialog(null, "Both players lose" , "the winner is:", JOptionPane.INFORMATION_MESSAGE);


	}//end of Main
	}//end of class

	
	
	
	


