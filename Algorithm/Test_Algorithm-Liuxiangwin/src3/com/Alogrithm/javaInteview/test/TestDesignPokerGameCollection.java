package com.Alogrithm.javaInteview.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestDesignPokerGameCollection {

	public static void main(String[] args) {
//		if (args.length < 2) {
//			System.out.println("Usage: ListCollectionDemo hands cards");
//			return;
//		}
		int numHands = 2;//Integer.parseInt(args[0]);
		int cardsPerHand =2; 
		//Integer.parseInt(args[1]);

		// Make a normal 52-card deck.
		String[] suit = new String[] { "Spades", "Hearts", "Diamonds", "Clubs" };
		String[] rank = new String[] { "Ace", "2", "3", "4", "5", "6", "7",	"8", "9", "10", "Jack", "Queen", "King" };

		List<String> deck = new ArrayList<String>();

		// Create deck
		for (int i = 0; i < suit.length; i++)
			for (int j = 0; j < rank.length; j++)
				deck.add(rank[j] + " of " + suit[i]);

		System.out.println("The Deck:" + deck);

		// Shuffle the deck.
		Collections.shuffle(deck);

		System.out.println("Shuffled Deck:" + deck);

		if (numHands * cardsPerHand > deck.size()) {
			System.out.println("Not enough cards.");
			return;
		}

		for (int i = 0; i < numHands; i++)
			System.out.println(ListCollectionDemoHand(deck, cardsPerHand));
		System.out.println("Flop" + ListCollectionDemoHand(deck, 3));
		System.out.println("Turn" + ListCollectionDemoHand(deck, 1));
		System.out.println("River" + ListCollectionDemoHand(deck, 1));

	}

	public static <E> List<E> ListCollectionDemoHand(List<E> deck, int n) {
		int deckSize = deck.size();
		List<E> handView = deck.subList(deckSize - n, deckSize);
		List<E> hand = new ArrayList<E>(handView);
		handView.clear();
		return hand;
	}

}
