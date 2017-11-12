
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author maitr
 */
public class Node {

    public int ordre;
    public Node parent;

    private int valeur;
    private ArrayList<Node> enfants;

    public Node(int valeur) {
        this.valeur = valeur;
        ordre = 0;
        this.parent = null;
        enfants = new ArrayList<Node>();
    }

    public Node(int valeur, Node parent) {
        ordre = 0;
        this.valeur = valeur;
        this.parent = parent;
        enfants = new ArrayList<Node>();
    }

    public int getVal() {
        return valeur;
    }

    public ArrayList<Node> getEnfants() {
        return enfants;
    }

    public void addEnfant(Node enfant) {
        enfants.add(enfant);
    }

    public boolean removeEnfant(Node enfant) {
        if (enfants.contains(enfant)) {
            enfants.remove(enfant);
            return true;
        }
        return false;
    }

    public void removeEnfants(ArrayList<Node> enfants) {
        this.enfants.removeAll(enfants);
    }

    public Node fusion(Node autre) throws DifferentOrderTrees {

        if (autre != null && ordre == autre.ordre )
        {
        	if (valeur < autre.valeur)
        	{
        		autre.parent = this;
        		ordre++;
        		enfants.add(autre);
        		return this;
        	}
        	else 
        	{	
            	parent = autre;
            	autre.ordre++;
            	autre.enfants.add(this);
        		return parent;
        	}
        	
        }
        else  throw new DifferentOrderTrees();
    }

    private void moveUp() 
    {
    	ArrayList<Node> temp ;
    	Node node = parent;
      while (node != null)
      {
    	  parent = node.parent;
    	  node.parent = this;
    	  temp = node.enfants ;
    	  for (int i = 0; i < temp.size(); i++)
    	  {
    		  if (temp.get(i).valeur == valeur)
    		  {
    			 temp.remove(i);
    		     temp.add(i, node);
    		  }
    	  }
    	  node.enfants = enfants;
    	  enfants = temp ;
    	  node.ordre--;
    	  ordre++ ;
    	  
    	  node = parent;
      }
    }

    public ArrayList<Node> delete() {
       
    	ArrayList<Node> array= new ArrayList();
    	array.add(this);
    	Node temp;
       moveUp();
       for (int i= 1 ;i < enfants.size();i++)
       {
    	   temp = enfants.get(i);
    	   temp.parent.enfants.remove(temp);
    	   temp.parent = null;
    	   array.add(temp); 
       }
       return array;
    }	

    public void print(String tabulation) {
        // à compléter
    }
    
    public Node findValue(int valeur) {
    	
    	Node node1 ;
    	Node node2 ;
    	
    	for (int i= 0 ;i < enfants.size();i++)
    	{
    		node1 = enfants.get(i);
    		if (node1.valeur == valeur)
    		{
    			return node1;
    		}
    		else if (node1.valeur < valeur)
    		{
    			node2 = node1.findValue(valeur);
    			if (node2 != null )
    				return node2;
    		}
    	}
        return null;
    }
    
    public ArrayList<Integer> getElementsSorted() {
    	ArrayList<Integer> array = new ArrayList<Integer>();
    	array.add(this.valeur);
    	if (enfants.size() > 0) 
    	{
    	remplirTableau(array);
    	Collections.sort(array);
    	return array;
    	}
    	return null;
    }
    
    public ArrayList<Integer> remplirTableau(ArrayList<Integer> array)
    {
    	for (int i =0 ; i < enfants.size() ; i++)
    	{
    		array.add(enfants.get(i).valeur);
    		enfants.get(i).remplirTableau(array);
    	}
    	return array;
    }
}
