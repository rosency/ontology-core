package au.csiro.ontology.classification;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.Set;

import au.csiro.ontology.Taxonomy;

import au.csiro.ontology.IOntology;
import au.csiro.ontology.axioms.IAxiom;

/**
 * This interface represents the functionality of a reasoner. It uses the 
 * internal ontology model. This interface is included in this package because
 * it could have several implementations.
 * 
 * @author Alejandro Metke
 *
 */
@SuppressWarnings("deprecation")
public interface IReasoner<T extends Comparable<T>> {
    
    /**
     * Loads and indexes the supplied axioms.
     * 
     * @param axioms
     */
    public void loadAxioms(Set<IAxiom> axioms);
    
    /**
     * Loads and indexes the supplied axioms.
     * 
     * @param axioms
     */
    public void loadAxioms(Iterator<IAxiom> axioms);
    
    /**
     * Loads and indexes the supplied axioms.
     * 
     * @param axioms
     */
    public void loadAxioms(IOntology<T> ont);
    
    /**
     * Classifies the current axioms.
     * 
     * @return
     */
    public IReasoner<T> classify();
    
    /**
     * Classifies the supplied axioms. The first time this method is called it 
     * will perform a full classification. Subsequent calls will trigger
     * incremental classifications.
     * 
     * @param axioms The axioms in the base ontology.
     * @return IReasoner
     * @deprecated Use {@link IReasoner#loadAxioms(Set)}  and 
     * {@link IReasoner#classify()} instead. 
     */
    public IReasoner<T> classify(Set<IAxiom> axioms);
    
    /**
     * Classifies the supplied axioms. The first time this method is called it 
     * will perform a full classification. Subsequent calls will trigger
     * incremental classifications.
     * 
     * @param axioms An iterator for the axioms. Implementations must be able
     * to handle null values.
     * @return IReasoner
     * @deprecated Use {@link IReasoner#loadAxioms(Iterator)} and 
     * {@link IReasoner#classify()} instead. 
     */
    public IReasoner<T> classify(Iterator<IAxiom> axioms);
    
    /**
     * Classifies the stated axioms in the supplied ontology. The first time 
     * this method is called it will perform a full classification. Subsequent 
     * calls will trigger incremental classifications.
     * 
     * @deprecated Use {@link IReasoner#loadAxioms(IOntology)} and 
     * {@link IReasoner#classify()} instead. 
     * instead.
     * 
     * @param ont An ontology.
     * @return IReasoner
     */
    public IReasoner<T> classify(IOntology<T> ont);
    
    /**
     * Removes all the state in the classifier except the taxonomy generated
     * after classification. If the classification process has not been run then
     * this method has no effect. Once pruned, it is no longer possible to run
     * an incremental classification. Doing so will generate a 
     * {@link RuntimeException}.
     */
    public void prune();
    
    /**
     * Returns an {@link IOntology} that represents the generated taxonomy. 
     * If no axioms have yet been classified it throws a 
     * {@link RuntimeException}.
     * 
     * @return The classified ontology.
     */
    public IOntology<T> getClassifiedOntology();
    
    /**
     * Returns an {@link IOntology} that represents the generated taxonomy. 
     * If no axioms have yet been classified it throws a 
     * {@link RuntimeException}.
     * 
     * @return The classified ontology.
     */
    public IOntology<T> getClassifiedOntology(IOntology<T> ont);
    
    /**
     * Saves this reasoner to the specified {@link OutputStream}.
     * 
     * @param out The {@link OutputStream}.
     */
    public void save(OutputStream out);
    
    /**
     * Determines if the ontology has been classified.
     * 
     * @return boolean True if the ontology has been classified or false if it
     * hasn't.
     */
    public boolean isClassified();
    
    /**
     * Returns the resulting {@link Taxonomy} after classification (or null if
     * the ontology has not been classified yet).
     * 
     * @return The taxonomy.
     * @deprecated Use {@link IReasoner#getClassifiedOntology()} instead.
     */
    public Taxonomy<T> getTaxonomy();

}
