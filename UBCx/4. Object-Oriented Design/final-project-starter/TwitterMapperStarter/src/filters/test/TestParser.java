package filters.test;

import filters.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test the parser.
 */
public class TestParser {
    @Test
    public void testBasic() throws SyntaxError {
        Filter f = new Parser("trump").parse();
        assertTrue(f instanceof BasicFilter);
        assertTrue(((BasicFilter)f).getWord().equals("trump"));
    }

    @Test
    public void testHairy() throws SyntaxError {
        Filter x = new Parser("trump and (evil or blue) and red or green and not not purple").parse();
        assertTrue(x.toString().equals("(((trump and (evil or blue)) and red) or (green and not not purple))"));
    }

    @Test
    public void testOrs() throws SyntaxError {
        Filter x = new Parser("blue or red or (green or purple) or (trump or evil)").parse();
        assertTrue(x.toString().equals("(((blue or red) or (green or purple)) or (trump or evil))"));
    }

    @Test
    public void testAnds() throws SyntaxError {
        Filter x = new Parser("blue and red and (green and purple) and (trump and evil)").parse();
        assertTrue(x.toString().equals("(((blue and red) and (green and purple)) and (trump and evil))"));
    }

    @Test
    public void testMashUp() throws SyntaxError {
        Filter x = new Parser("trump and right or biden and left").parse();
        System.out.println(x.toString());
        assertTrue(x.toString().equals("((trump and right) or (biden and left))"));
    }
}
