package deepstack;

/**
 *
 * @author lucie dvorakova
 */

public class PDSymbol {
    public enum Type {TERMINAL, NONTERMINAL, BOTTOM}
    
    private Type type = null;
    private String name = null;
    
    public PDSymbol(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }
    
    public String toString() {
        return "{" + name + ":" + type.toString() + "}";
    }
    
}
