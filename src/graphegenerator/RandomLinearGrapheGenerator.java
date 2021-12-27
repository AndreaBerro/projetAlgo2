package graphegenerator;

import grapheelement.Color;
import grapheelement.Edge;
import grapheelement.Graphe;
import grapheelement.Node;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Integer;

public class RandomLinearGrapheGenerator implements GrapheGenerator {

    public int nbNodes;
    public float probSomRouge;
    public float probAreteRouge;
    public float probAreteVersGauche;

    public RandomLinearGrapheGenerator(float p,float q) {
        this.nbNodes = 100;
        this.probSomRouge = p;
        this.probAreteRouge = q;
        this.probAreteVersGauche = 0.5f;
    }

    public RandomLinearGrapheGenerator(float p, float q, float r) {
        this.nbNodes = 100;
        this.probSomRouge = p;
        this.probAreteRouge = q;
        this.probAreteVersGauche = r;
    }

    public RandomLinearGrapheGenerator(float p,float q, float r, int s) {
        this.nbNodes = s;
        this.probSomRouge = p;
        this.probAreteRouge = q;
        this.probAreteVersGauche = r;
    }

    @Override
    public Graphe generateGraphe() {
        //Création du graphe vide
        Graphe resultGraphe = new Graphe(new ArrayList<Node>(), new ArrayList<Edge>());

        //Création des sommets
        for (int i = 0; i < this.nbNodes; i++) {
            String n = Integer.toString(i);
            Color c =  new Random().nextInt(100)<this.probSomRouge*100 ? Color.ROUGE : Color.BLEU;
            Node nodeToAdd = new Node(n, c);
            resultGraphe.nodes.add(nodeToAdd);
        }

        //Création des arretes
        for (int i = 0; i <this.nbNodes-1; i++) {
            Edge edgeToAdd;
            Color c =  new Random().nextInt(100)<this.probAreteRouge*100 ? Color.ROUGE : Color.BLEU;

            if (new Random().nextInt(100)<this.probAreteVersGauche*100)
                edgeToAdd = new Edge(resultGraphe.nodes.get(i+1), resultGraphe.nodes.get(i), c);
            else
                edgeToAdd = new Edge(resultGraphe.nodes.get(i), resultGraphe.nodes.get(i+1), c);

            resultGraphe.edges.add(edgeToAdd);
        }

        return resultGraphe;
    }

}
