package com.nmlv.testengineering.codechallenge.helper;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import com.nmlv.testengineering.codechallenge.model.cards.Rank;
import com.nmlv.testengineering.codechallenge.model.cards.Suit;

public class TestHelper {

    private TestHelper() {
    }

    /**
     * Create a string containing the specified number of randomized alpha characters.
     * @param characterCount Number of alpha characters to be contained in the randomized string
     * @return {@link String} containing the specified number of randomized alpha characters
     */
    public static String randomAlphabetic(int characterCount) {
        return RandomStringUtils.randomAlphabetic(characterCount);
    }

    /**
     * Create a string containing the specified number of randomized alphanumeric characters.
     * @param characterCount Number of alphanumeric characters to be contained in the randomized string
     * @return {@link String} containing the specified number of randomized alphanumeric characters
     */
    public static String randomAlphanumeric(int characterCount) {
        return RandomStringUtils.randomAlphanumeric(characterCount);
    }

    /**
     * Create a string containing the specified number of randomized numeric characters.
     * @param characterCount Number of numeric characters to be contained in the randomized string
     * @return {@link String} containing the specified number of randomized numeric characters
     */
    public static String randomNumeric(int characterCount) {
        return RandomStringUtils.randomNumeric(characterCount);
    }

    /**
     * Randomly select a {@link Rank} from the supported methods within {@link Rank#values}.
     * @return {@link Rank} that was randomly selected
     */
    public static Rank randomRank() {
        List<Rank> ranks = Arrays.asList(Rank.values());
        int index = new Random().nextInt(ranks.size());
        return ranks.get(index);
    }

    /**
     * Randomly select a {@link Suit} from the supported methods within {@link Suit#values}.
     * @return {@link Suit} that was randomly selected
     */
    public static Suit randomSuit() {
        List<Suit> suits = Arrays.asList(Suit.values());
        int index = new Random().nextInt(suits.size());
        return suits.get(index);
    }

}
