package graphesolver;

import grapheelement.Color;
import grapheelement.Edge;
import grapheelement.Graphe;
import grapheelement.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GrapheSolverAlgo1 implements GrapheSolver {
    ArrayList<Node> nodesRouges = new ArrayList<>();
    HashMap<Node,Integer> flechesEntrantesBleues = new HashMap<>();
    Graphe graphe;

    //generates the ArrayList nodesRouges and the HashMap flechesEntrantesBleues
    public void generateHashMap(){
        nodesRouges.clear();
        flechesEntrantesBleues.clear();
        for(Node no : graphe.nodes){
            if(no.color.equals(Color.ROUGE)){
                nodesRouges.add(no);
                flechesEntrantesBleues.put(no,0);
            }
        }
        for(Edge e : graphe.edges){
            if(e.color.equals(Color.BLEU) && e.endingNode.color.equals(Color.ROUGE)){
                flechesEntrantesBleues.put(e.endingNode,flechesEntrantesBleues.get(e.endingNode)+1);
            }
        }
    }
    //returns the highest value of the HashMap
    public int getMaxValue(){
        int max = 0;
        for(Node n : nodesRouges) {
            if(flechesEntrantesBleues.get(n)>max){
                max = flechesEntrantesBleues.get(n);
            }
        }
        return max;
    }

    public int solve(Graphe graphe){
        int total = 0;
        this.graphe = graphe;
        generateHashMap();
        int max = getMaxValue();
        boolean removed = false;

        while(max == 2){
            for(Node n : nodesRouges) {
                if((flechesEntrantesBleues.get(n) == 2) && (removed == false)){
                    graphe.removeNode(n);
                    total++;
                    removed = true;
                }
            }
            generateHashMap();
            max = getMaxValue();
            removed = false;
        }

        while(max == 1){
            for(Node n : nodesRouges) {
                if((flechesEntrantesBleues.get(n) == 1) && (removed == false)){
                    graphe.removeNode(n);
                    total++;
                    removed = true;
                }
            }
            generateHashMap();
            max = getMaxValue();
            removed = false;
        }

        while(nodesRouges.size()!=0){
            for(Node n : nodesRouges) {
                if(removed == false){
                    graphe.removeNode(n);
                    total++;
                    removed = true;
                }
            }
            generateHashMap();
            removed = false;
        }

        return total;
    }
}
