import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.example.calculator.model.ExpressionEvaluator;



public class ExpressionEvaluatorTest {
    
    @ParameterizedTest
    @CsvSource({
        "+, true", 
        "-, true",
        "*, true",
        "/, true",
        "a, false",
    })
    public void testIsOperator(char c, boolean expected) {
        boolean res = ExpressionEvaluator.isOperator(c);
        assertEquals(res, expected);
    }

    @ParameterizedTest
    @CsvSource({
        "(a+b)*(c-d), ab+cd-*",
        "a+b*(c^d-e)^(f+g*h)-i, abcd^e-fgh*+^*+i-",
    })
    public void testInfixToPostfix(String infix, String expected) {
        String res = ExpressionEvaluator.infixToPostfix(infix);
        assertEquals(res, expected);
    }
}
