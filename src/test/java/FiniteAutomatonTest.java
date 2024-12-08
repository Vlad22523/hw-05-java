
import  com.example.FiniteAutomaton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FiniteAutomatonTest {


    private final FiniteAutomaton automaton = new FiniteAutomaton();


    @ParameterizedTest
    @CsvSource({
            "'abcTESTabc', 4",
            "'abcTES', 3",
            "'T', 1",
            "'TEST', 4",
            "'TESTabc', 4"
    })
    void testFiniteAutomaton(String input, int expectedState) {
        int result = automaton.processString(input);

        Assertions.assertEquals(expectedState, result);
    }

    @Test
    void testAutomatonStateOnEmptyString() {
        int result = automaton.processString("");

        Assertions.assertEquals(FiniteAutomaton.STATE_INITIAL, result);
    }
}