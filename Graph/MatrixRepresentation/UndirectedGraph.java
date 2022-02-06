/* representation of undirected graph using matrix */

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph implements Graph{
    private List<List<Integer>> list = new ArrayList<List<Integer>>();
    private int size;

    // constractor
    public UndirectedGraph(){
        super();
    }
    public UndirectedGraph(List<List<Integer>> list, int size){
        this.size = size;
        for(int i=0; i<this.size; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            for(int k=0; k<this.size; k++) temp.add(0);
            this.list.add(temp);
        }
        for(List<Integer> a: list){
            addEdge(a.get(0), a.get(1));
            addEdge(a.get(1), a.get(0));
        }
    }

    public void addEdge(int from, int to){
        try{
            this.list.get(from-1).set(to-1, 1);
            this.list.get(to-1).set(from-1, 1);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Edge "+from+" to "+to+" is not possible.");
        }
    }

    public void addVertex(List<Integer> adjacent){
        this.size++;
        List<Integer> temp = new ArrayList<Integer>();
        for(int i=0; i<this.size; i++) temp.add(0);
        this.list.add(temp);
        for(int i=0; i<this.size-1; i++) this.list.get(i).add(0);
        for(int a: adjacent){
            addEdge(a, this.size);
            addEdge(this.size, a);
        }
    }
    public void deleteEdge(){

    }
    
    public void deleteVertex(){

    }

    public void displayMatrix(){
        for(List<Integer> a: this.list){
            for(int b: a) System.out.print(b+" ");
            System.out.println();
        }
    }

    // get matrix
    public List<List<Integer>> getMatrix(){
        return this.list;
    }
}
