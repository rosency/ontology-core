package au.csiro.ontology;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import au.csiro.ontology.axioms.IAxiom;

/**
 * Defines the methods of an ontology.
 * 
 * @author Alejandro Metke
 *
 */
public interface IOntology {
    
    /**
     * Returns the identifier of the ontology.
     * @return
     */
    public String getId();
    
    /**
     * Returns the version of the ontology.
     * 
     * @return
     */
    public String getVersion();
    
    /**
     * Returns the {@link Collection} of axioms in the ontology.
     * 
     * @return The axioms.
     */
    public Collection<IAxiom> getStatedAxioms();
    
    /**
     * Returns the {@link Collection} of inferred axioms in the ontology.
     * 
     * @return
     */
    public Collection<IAxiom> getInferredAxioms();
    
    /**
     * Returns the {@link Node} in the taxonomy that contains a specified 
     * concept or null if such {@link Node} does not exist.
     * 
     * @param id The concept's id.
     * @return The node.
     */
    public Node getNode(String id);
    
    /**
     * Returns the {@link Node} in the taxonomy that corresponds to top.
     * 
     * @return The top node.
     */
    public Node getTopNode();
    
    /**
     * Returns the {@link Node} in the taxonomy that correspond to bottom.
     * 
     * @return The bottom node.
     */
    public Node getBottomNode();
    
    /**
     * Returns an {@link Iterator} for all the nodes in the taxonomy or null if
     * the ontology has not been classified.
     * 
     * @return The iterator.
     */
    public Iterator<Node> nodeIterator();
    
    /**
     * Returns the taxonomy represented by a {@link Map} of keys to 
     * {@link Node}s.
     * 
     * @return The taxonomy.
     */
    public Map<String, Node> getNodeMap();
    
    /**
     * Sets the taxonomy represented by a {@link Map} of keys to 
     * {@link Node}s.
     * 
     * @param nodeMap The taxonomy.
     */
    public void setNodeMap(Map<String, Node> nodeMap);
    
    /**
     * Returns a {@link Set} with a subset of nodes in the taxonomy that have 
     * been possibly affected after an incremental classification. If no 
     * incremental classification has been done then it returns an empty 
     * {@link Set}.
     * 
     * @return The subset of the taxonomy that has potentially changed.
     */
    public Set<Node> getAffectedNodes();
    
    /**
     * Sets the {@link Set} of nodes in the taxonomy that might have been 
     * affected in an incremental classification.
     * 
     * @param cids The set of nodes to set.
     */
    public void setAffectedNodes(Set<Node> nodes);

}
