package PolyNet;

import java.util.HashSet;
import java.util.PriorityQueue;

public class PolyNet {
    private PolyNetNode[] nodes;

    public PolyNet(PolyNetNode[] nodes) {
        this.nodes = nodes;
    }

    // MST (using Prim's algorithm).
    public int computeTotalCableLength() {

        int totalCableLength = 0;
        PriorityQueue<PolyNetConnection> knownConnections = new PriorityQueue<>();
        HashSet<PolyNetNode> visitedNodes = new HashSet<>();

        visitedNodes.add(nodes[0]);
        remplirQueue(nodes[0], knownConnections);

        while(!knownConnections.isEmpty()) {
            /** Connection avec la plus petite distance est retiree de la file de priorite */
            PolyNetConnection connectionCourante = knownConnections.poll();

            /** Node de la connection devient la node courante */
            PolyNetNode nodeCourant = connectionCourante.getConnectedNode();
            int distanceANodeCourant = connectionCourante.getDistance();

            if(!visitedNodes.contains(nodeCourant)) {
                visitedNodes.add(nodeCourant);

                /** On remplis ajoute les connections du node courant a la file de priorite */
                remplirQueue(nodeCourant, knownConnections);
                totalCableLength+=distanceANodeCourant;
            }
        }
        return totalCableLength;
    }


    public void remplirQueue(PolyNetNode node, PriorityQueue<PolyNetConnection> queue) {
        for (PolyNetConnection co : node.getConnections())
            queue.add(co);
    }
}


