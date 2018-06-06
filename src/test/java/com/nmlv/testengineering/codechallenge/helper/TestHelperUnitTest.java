package com.nmlv.testengineering.codechallenge.helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

import com.nmlv.testengineering.codechallenge.model.cards.Rank;
import com.nmlv.testengineering.codechallenge.model.cards.Suit;

import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import static org.junit.Assert.*;

public class TestHelperUnitTest {

    /**
     * {@link TestHelper} is a utility class and as such it should only contains static methods.
     * This test verifies that the {@link TestHelper} object only contains a private constructor
     * so that all of its methods will be provided statically.
     */
    @Test
    public void verifyConstructorIsPrivate() throws Exception {
        Constructor<TestHelper> constructor = TestHelper.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    /**
     * {@link TestHelper} is a utility class and as such it should only contains static methods.
     * This test verifies that the {@link TestHelper} object does not contain any public constructors
     * so that all of its methods will be provided statically.
     */
    @Test
    public void verifyOnlyPrivateConstructors() {
        assertEquals(0, TestHelper.class.getConstructors().length);
    }

    /**
     * Verify that {@link TestHelper#randomAlphabetic} creates a random {@link String} of alpha characters.
     */
    @Test
    public void randomAlphabetic() {
        assertNotNull(TestHelper.randomAlphabetic(100));
        assertTrue(StringUtils.isAlpha(TestHelper.randomAlphabetic(100)));
    }

    /**
     * Verify that {@link TestHelper#randomAlphanumeric} creates a random {@link String} of alphanumeric characters.
     */
    @Test
    public void randomAlphanumeric() {
        assertNotNull(TestHelper.randomAlphanumeric(100));
        assertTrue(StringUtils.isAlphanumeric(TestHelper.randomAlphanumeric(100)));
    }

    /**
     * Verify that {@link TestHelper#randomNumeric} creates a random {@link String} of numeric characters.
     */
    @Test
    public void randomNumeric() {
        assertNotNull(TestHelper.randomNumeric(100));
        assertTrue(StringUtils.isNumeric(TestHelper.randomNumeric(100)));
    }

    /**
     * Verify that {@link TestHelper#randomRank} creates a random {@link Rank}.
     */
    @Test
    public void randomRank() {
        assertNotNull(TestHelper.randomRank());
    }

    /**
     * Verify that {@link TestHelper#randomSuit} creates a random {@link Suit}.
     */
    @Test
    public void randomSuit() {
        assertNotNull(TestHelper.randomSuit());
    }

}
