package graphesolver;

import grapheelement.Color;
import grapheelement.Edge;
import grapheelement.Graphe;
import grapheelement.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class GrapheSolverAlgo2 implements GrapheSolver {

    ArrayList<Node> nodesRouges = new ArrayList<>();
    HashMap<Node,Integer> flechesEntrantes = new HashMap<>();
    HashMap<Node,Integer> flechesSortante = new HashMap<>();
    Graphe graphe;

    //generates the ArrayList nodesRouges and the HashMap flechesEntrantes
    public void generateHashMap(){
        nodesRouges.clear();
        flechesEntrantes.clear();
        for(Node no : graphe.nodes){
            if(no.color.equals(Color.ROUGE)){
                nodesRouges.add(no);
                flechesEntrantes.put(no,0);
                flechesSortante.put(no,0);
            }
        }
        for(Edge e : graphe.edges){
            if(e.endingNode.color.equals(Color.ROUGE)){
                flechesEntrantes.put(e.endingNode,flechesEntrantes.get(e.endingNode)+1);
            }
        }
        for(Edge e : graphe.edges){
            if(e.startingNode.color.equals(Color.ROUGE)&&e.color.equals(Color.BLEU)){
                flechesSortante.put(e.startingNode,flechesSortante.get(e.startingNode)+1);
            }
        }
    }
    //returns the highest value of the HashMap
    public int getMaxValue(){
        int max = 0;
        for(Node n : nodesRouges) {
            if(flechesEntrantes.get(n)>max){
                max = flechesEntrantes.get(n);
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

                for (Node n : nodesRouges) {
                    if ((flechesSortante.get(n) == 0) && (!removed)) {
                        graphe.removeNode(n);
                        total++;
                        removed = true;
                    }
                }
                for (Node n : nodesRouges) {
                    if ((flechesSortante.get(n) == 1) && (!removed)) {
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
            for (Node n : nodesRouges) {
                if ((flechesSortante.get(n) == 0) && (!removed)) {
                    graphe.removeNode(n);
                    total++;
                    removed = true;
                }
            }
            for(Node n : nodesRouges) {
                if((flechesSortante.get(n) == 1) && (!removed)){
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
                if(!removed){
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
