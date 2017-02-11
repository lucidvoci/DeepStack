
package deepstack;

//import ndpdar.PDSymbol;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucie dvorakova
 */
public class DeepStackTest {

    /**
     * Test of push method, of class DeepStack.
     */
    @Test
    public void testPush_1args_2() {
        System.out.println("\n Push array - test");
        DeepStack<String> ds = new DeepStack<>();
        
        assertTrue (ds.isEmpty());
        
        System.out.println("Push c");
        ds.push("c");
        System.out.println("Push a");
        ds.push("a");
        System.out.println("Current stack:");
        System.out.println(ds.toString());
        
        assertEquals("a", ds.peek());
        assertEquals("c", ds.peek(1));
        
        System.out.println("Push b to depth 1");
        ds.push("b", 1);
        System.out.println("Current stack:");
        System.out.println(ds.toString());
        
        assertEquals("b", ds.peek(1));
        assertEquals("c", ds.peek(2));
        
        System.out.println("Push d to bottom");
        ds.push("d", ds.size());
        System.out.println("Push e to top");
        ds.push("e");
        System.out.println("Current stack:");
        System.out.println(ds.toString());
        
        assertEquals("e", ds.peek());
        assertEquals("d", ds.peek(ds.size() - 1));
        
        System.out.println("Pop at depth 3: " + ds.pop(3));
        System.out.println("Current stack:");
        System.out.println(ds.toString());
        
        assertEquals("d", ds.peek(ds.size() - 1));
        
        System.out.println("Peek at depth 3: " + ds.peek(3));
       
        assertFalse(ds.isEmpty());
    }

    /**
     * Test of push method, of class DeepStack.
     
    @Test
    public void testPush_2args_2() {
        System.out.println("\n Push array deep - test ");
        DeepStack<PDSymbol> ds = new DeepStack();
        
        assertTrue (ds.isEmpty());
        
        PDSymbol[] ar = new PDSymbol[4];
        ar[0] = new PDSymbol(PDSymbol.Type.BOTTOM, "#");
        ar[1] = new PDSymbol(PDSymbol.Type.NONTERMINAL, "B");
        ar[2] = new PDSymbol(PDSymbol.Type.TERMINAL, "a");
        ar[3] = new PDSymbol(PDSymbol.Type.NONTERMINAL, "A");
        System.out.println("Push array:");
        System.out.println(printSymbols(ar, 4));
        ds.push(ar);
        
        assertEquals(ar[3], ds.peek());
        assertEquals(ar[0], ds.peek(ds.size() - 1));
        
        System.out.println("Current stack:");
        System.out.println(ds.toString());
        
        System.out.println("Pop at depth 2: " +  ds.pop(2));
        System.out.println("Current stack:");
        System.out.println(ds.toString());
        
        assertEquals(ar[0], ds.peek(ds.size() - 1));
        
        ar = new PDSymbol[2];
        ar[0] = new PDSymbol(PDSymbol.Type.TERMINAL, "c");
        ar[1] = new PDSymbol(PDSymbol.Type.NONTERMINAL, "C");
        System.out.println("Push array at depth 2:");
        System.out.println(printSymbols(ar, 2));
        ds.push(ar, 2);
        System.out.println("Current stack:");
        System.out.println(ds.toString());
        
        assertSame(ds.peek(3), ds.peek(ds.size() - 2));
        assertSame(ar[1], ds.peek(2));
        
        assertFalse(ds.isEmpty());
    }
    
    private static String printSymbols(PDSymbol[] ar, int size){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            sb.append(ar[i]);
            sb.append("\n");
        }
        return sb.toString();
    }  */
    
}
