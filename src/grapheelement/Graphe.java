package grapheelement;

import java.util.ArrayList;

public class Graphe {
    public ArrayList<Node> nodes;
    public ArrayList<Edge> edges;

    public Graphe(ArrayList<Node> nodes,ArrayList<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    @Override
    public String toString() {
        String result = "";
        result += nodes.get(0);
        for (int i = 0; i < nodes.size()-1; i++) {
            result += this.edges.get(i).endingNode==nodes.get(i) ? " <-- " : " --> ";
            result += nodes.get(i+1);
        }
        return result;
    }

}
