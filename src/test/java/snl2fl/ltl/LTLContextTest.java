package snl2fl.ltl;

import org.junit.jupiter.api.Test;
import snl2fl.fl.elements.Atom;
import snl2fl.fl.patterns.Pattern;
import snl2fl.req.expressions.VariableExpression;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LTLContextTest {

    @Test
    public void testGetPattern() {

        Map<String, VariableExpression> symbolTable = new HashMap<>();
        Map<String, TreeMap<Float, Atom[]>> rangeMap = new HashMap<>();
        Map<String, Pattern> patterns = null;

        try {
            patterns = Pattern.loadPatterns(Pattern.PATTERNS_FILE);
        }
        catch(Exception e) { e.printStackTrace(); }

        assertNotNull(patterns);

        LTLContext context = new LTLContext(symbolTable, rangeMap, patterns);

        for(String s: patterns.keySet())
            assertEquals(context.getPattern(s), patterns.get(s));

    }
}
