package com.nmlv.testengineering.codechallenge.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.util.Assert;

import com.nmlv.testengineering.codechallenge.model.cards.*;

public class CardDealer {
	 private CardDealer() {
	    }

	    /**
	     * TODO: Test Engineering Open Code Challenge
	     * Deal as many cards as possible to the players provided.
	     * @param players List of {@link Player}s to be dealt cards
	     * @param deck The {@link Deck} of {@link Card}s to be used
	     * @return {@link Game} comprised of the {@link Player}s and their individual {@link Card}s
	     * along with any undealt {@link Card}s that would remain
	     */
	    public static Game deal(List<Player> players, Deck deck) {
	        Assert.notNull(players, "Players cannot be null");
	        Assert.notNull(deck, "Deck cannot be null");

	        // TODO: this is where the work goes
	        // TODO: this is NOT the correct solution, it is simply returning the input values

			//no player
	    	if(players.size()==0) {
	    		return new Game(players, deck.getCards());
	    	}

	    	int totalCards = deck.getCardsNum();
	    	int playerNum=players.size();
	    	//each player has this number of cards
	    	int numberOfCardsPerPlayer=totalCards/playerNum;
	    	
	    	//if players are more than total cards
	    	if(numberOfCardsPerPlayer==0) {
	    		return new Game(players, deck.getCards());
	    	}
	    	
	    	//temporary list of cards for a player 
	    	List<Card> temp= new ArrayList<>();
	    	
	    	//add cards to the list based on how many cards a player can have
	    	for(int i=0;i<players.size();i++) {
	    		for(int j=i;j<totalCards-(totalCards%playerNum);j=j+playerNum) {
	    			temp.add(deck.getCards().get(j));
	    		}	    		
	    		players.get(i).setCards(new ArrayList<>(temp));
	    		temp.clear();
	    	}
	    	
	    	//list of remaining cards
	    	List<Card> undealtCards= new ArrayList<>();
	    	
	    	for(int i=numberOfCardsPerPlayer*playerNum;i<totalCards;i++){
	    		undealtCards.add(deck.getCards().get(i));
	    	}
	    	
	    	
	        return new Game(players, undealtCards);
	    }

	    /**
	     * TODO: Test Engineering Open Code Challenge
	     * Deal the specified number of cards to the players provided.
	     * @param players List of {@link Player}s to be dealt cards
	     * @param deck The {@link Deck} of {@link Card}s to be used
	     * @param numberOfCardsPerPlayer The number of cards to deal to each player.
	     * @return {@link Game} comprised of the {@link Player}s and their individual {@link Card}s
	     * along with any undealt {@link Card}s that would remain
	     */
	    public static Game deal(List<Player> players, Deck deck, int numberOfCardsPerPlayer) {
	        Assert.notNull(players, "Players cannot be null");
	        Assert.notNull(deck, "Deck cannot be null");

	        // TODO: this is where the work goes
	        // TODO: this is NOT the correct solution, it is simply returning the input values
	    	int playerNum=players.size();
	    	int totalCards = deck.getCardsNum();
	    	
	    	//card to player=0 or not enough cards to play, return with original status
	    	if(players.size()==0||numberOfCardsPerPlayer<=0||numberOfCardsPerPlayer*playerNum>totalCards) {
	    		return new Game(players, deck.getCards());
	    	}
	    	
	    	//add cards to the list based on how many cards a player can have
	    	List<Card> temp= new ArrayList<>();
	    	for(int i=0;i<playerNum;i++) {
	    		for(int j=i;j<numberOfCardsPerPlayer*playerNum;j=j+playerNum) {
	    			temp.add(deck.getCards().get(j));
	    		}
	    		players.get(i).setCards(new ArrayList<>(temp));
	    		temp.clear();	
	    	}
	    	
	    	//list of remaining cards
	    	List<Card> undealtCards= new ArrayList<>();
	    	
	    	for(int i=numberOfCardsPerPlayer*playerNum;i<totalCards;i++){
	    		undealtCards.add(deck.getCards().get(i));
	    	}
	    	
	        return new Game(players, undealtCards);
	    }

	    /**
	     * TODO: Test Engineering Open Code Challenge
	     * Shuffle/randomize the provided {@link Deck}.
	     * @param deck {@link Deck}
	     * @return {@link Deck}
	     */
	    protected static Deck shuffle(Deck deck) {
	        Assert.notNull(deck, "Deck cannot be null");

	        // TODO: this is where the work goes
	        // TODO: this is NOT the correct solution, it is simply returning the input deck without being shuffled
	    	int totalCards = deck.getCardsNum();
	    	int remainCards = deck.getCardsNum();
	    	List<Card> shuffledCards = new ArrayList<>();// initialize a temporary list to store shuffled cards. 
	    	List<Card> deckCards= deck.getCards();
	    	Random rand = new Random();
	    	
	    	//default null in temporary cards list
	    	for(int i=0;i<totalCards;i++) {	    		
	    		shuffledCards.add(null);
	    	}
	    		    	
	    	//Pick a random number to be the new location of a card from original deck
	    	//The first random number is from 0 to 51. Indicating the index of the new location  	    	
	    	//Random number range is reduced every time a card is assigned to new location, 
	    	//which means random number range will be no more than empty slots, guarantee a card has its own location.
	    	
	    	//If the location is assigned a card, move to the next location
	    	//For example, if location 0,1,3,5 is assigned, the random number will be between 0~47(51-4)
	    	//If random number is 5, it's new location will be 9.(empty slot is 2,4,6,7,8,9)
	    	
	    	while(remainCards>0) {
	    		int  n = rand.nextInt(remainCards);	
	    		int index=0; 
	    		
	    		// go through the list and skip any slot with card already
	    		while(n>0||shuffledCards.get(index)!=null) {
	    			if(shuffledCards.get(index)==null) {
	    				n--;
	    			}
	    			index++;
	    		}
	    		
	    		//reduce remaining cards and add the card from desk to the temporary list    		
	    		remainCards--;
	    		shuffledCards.set(index,deckCards.get(remainCards));
	    		
	    	}
	    	
	    	//assign shuffled cards back to deck
	    	for(int i=0;i<totalCards;i++) {	    		
	    		deckCards.set(i, shuffledCards.get(i));
	    	}
	    	
	        return deck;
	    }

	    /**
	     * TODO: Test Engineering Open Code Challenge
	     * Shuffle/randomize the provided list of {@link Card}s.
	     * @param cards List of {@link Card}s
	     * @return {@link Deck}
	     */
	    protected static List<Card> shuffle(List<Card> cards) {
	        Assert.notNull(cards, "List<Card> cannot be null");

	        // TODO: this is where the work goes
	        // TODO: this is NOT the correct solution, it is simply returning the input deck without being shuffled
	    	int totalCards = cards.size();
	    	int remainCards = cards.size();
	    	List<Card> shuffledCards = new ArrayList<>(); 
	    	Random rand = new Random();
	    	
	    	//Same idea with shuffle the deck, only small difference
	    	//Instead of initialize the new list = null, I pick a card from a random place in original cards
	    	//Add it to the end of temporary list. Then set original card = null;
	    	//When finished, assign the shuffled cards back to original card list
	    	for(int i=0;i<totalCards;i++) {
	    		int  n = rand.nextInt(remainCards);	
	    		int index=0;
	    		//find the random card
	    		while(n>0||cards.get(index)==null) {
	    			if(cards.get(index)!=null) {
	    				n--;
	    			}
	    			index++;
	    		}
	    		//add the card to temporary list
	    		shuffledCards.add(new Card(cards.get(index).getRank(),cards.get(index).getSuit()));
	    		//set this card to null means it's been used
	    		cards.set(index, null);
	    		remainCards--;
	    	}
	    	
	    	//assign shuffledcards back to cards
	    	for(int i=0;i<shuffledCards.size();i++) {
	    		cards.set(i, shuffledCards.get(i));
			}
	    	
	    	
	        return cards;
	    }
}
