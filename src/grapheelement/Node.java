package grapheelement;

public class Node {
    public Color color;
    public String name;
    public Edge leftEdge;
    public Edge rightEdge;


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
        this.leftEdge = e;
    }
    public void setRight(Edge e) {
        this.rightEdge = e;
    }



    @Override
    public String toString() {
        return "("+this.name+":"+this.color+")";
    }

//    public int importanceB(){
//        if(color == Color.BLEU){
//            return 0;
//        }
//        int i=3;
//        i = getI(i, leftEdge);
//        i = getI(i, rightEdge);
//        return i;
//    }
//
//    private int getI(int i, Edge edge) {
//        if(edge != null){
//            if(edge.isOutEdge(this)){
//                if(edge.color == Color.ROUGE){
//                    i+=10;
//                    if(edge.endingNode.color == Color.BLEU){
//                         i+=4;
//                    }
//                }
//            }else {
//                if(edge.color == Color.BLEU){
//                    i+=3;
//                    if( edge.startingNode.color == Color.ROUGE){
//                       i+=2;
//                    }
//                }
//            }
//        }
//        return i;
//    }
}
