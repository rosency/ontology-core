/**
 * Copyright CSIRO Australian e-Health Research Centre (http://aehrc.com).
 * All rights reserved. Use is subject to license terms and conditions.
 */
package au.csiro.ontology;

import java.util.Iterator;
import java.util.Map;

/**
 * Represents a taxonomy generated after classifying an {@link Ontology}.
 * 
 * @author Alejandro Metke
 * @deprecated Use {@link IOntology} instead.
 *
 */
public class Taxonomy {
    
    /**
     * A map that contains references to all the nodes in the taxonomy indexed
     * by id.
     */
    protected final Map<String, Node> nodeMap;
    
    /**
     * Creates a new Taxonomy.
     */
    public Taxonomy(Map<String, Node> nodeMap) {
        this.nodeMap = nodeMap;
    }
    
    /**
     * Returns the {@link Node} in the taxonomy that contains a specified 
     * concept or null if such {@link Node} does not exist.
     * 
     * @param id The concept's id.
     * @return the node.
     */
    public Node getNode(String id) {
        return nodeMap.get(id);
    }
    
    /**
     * Returns an {@link Iterator} for all the nodes in the {@link Taxonomy}.
     * 
     * @return the iterator.
     */
    public Iterator<Node> iterator() {
        return nodeMap.values().iterator();
    }
    
}
