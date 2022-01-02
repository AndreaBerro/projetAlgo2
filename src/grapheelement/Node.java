package grapheelement;

public class Node {
    public Color color;
    public String name;
    public Edge left;
    public Edge right;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Edge getLeft() {
        return left;
    }

    public Edge getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "("+this.name+")";
    }
    
}
