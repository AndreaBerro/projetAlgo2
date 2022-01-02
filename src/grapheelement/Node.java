package grapheelement;

public class Node {
    public Color color;
    public String name;
    public Edge left;
    public Edge right;
    public Node(String n, Color c) {
        this.color = c;
        this.name = n;

    }
    public void setLeft(Edge e) {
        this.left = e;
    }
    public void setRight(Edge e) {
        this.right = e;
    }
    @Override
    public String toString() {
        return "("+this.name+")";
    }
    
}
