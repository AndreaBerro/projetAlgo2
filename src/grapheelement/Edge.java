package grapheelement;

public class Edge {
    public Color color;
    public Node startingNode;
    public Node endingNode;

    public Edge(Node startingNode, Node endingNode, Color color) {
        this.startingNode = startingNode;
        this.endingNode = endingNode;
        this.color = color;
    }

}
