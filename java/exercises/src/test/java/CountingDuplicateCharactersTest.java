import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingDuplicateCharactersTest {

    @Test
    void countDuplicateChars() {
        int result = CountingDuplicateCharacters.countDuplicateChars("abccd");
        assertSame(1, result, "Should be same");

        result = CountingDuplicateCharacters.countDuplicateChars("abccdd");
        assertSame(2, result, "Should be same");

        result = CountingDuplicateCharacters.countDuplicateChars("abcd");
        assertSame(0, result, "Should be same");

        result = CountingDuplicateCharacters.countDuplicateChars("aabcd");
        assertSame(1, result, "Should be same");

        result = CountingDuplicateCharacters.countDuplicateChars("abbbbcd");
        assertSame(1, result, "Should be same");

        result = CountingDuplicateCharacters.countDuplicateCharsRecursive("aaaaaabbbbcccccccddddd");
        assertSame(4, result, "Should be same");
    }

    @Test
    void countDuplicateCharsRecursive() {
        int result = CountingDuplicateCharacters.countDuplicateCharsRecursive("abccd");
        assertSame(1, result, "Should be same");

        result = CountingDuplicateCharacters.countDuplicateCharsRecursive("abccdd");
        assertSame(2, result, "Should be same");

        result = CountingDuplicateCharacters.countDuplicateCharsRecursive("abcd");
        assertSame(0, result, "Should be same");

        result = CountingDuplicateCharacters.countDuplicateCharsRecursive("aabcd");
        assertSame(1, result, "Should be same");

        result = CountingDuplicateCharacters.countDuplicateCharsRecursive("abbbbcd");
        assertSame(1, result, "Should be same");

        result = CountingDuplicateCharacters.countDuplicateCharsRecursive("aaaaaabbbbcccccccddddd");
        assertSame(4, result, "Should be same");
    }
}