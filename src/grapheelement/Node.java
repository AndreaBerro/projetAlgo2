package grapheelement;

public class Node {
    public Color color;
    public String name;

    public Node(String n, Color c) {
        this.color = c;
        this.name = n;
    }

    @Override
    public String toString() {
        return "("+this.name+")";
    }
    
}
