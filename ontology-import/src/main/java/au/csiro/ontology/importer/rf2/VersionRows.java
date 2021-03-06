/**
 * Copyright CSIRO Australian e-Health Research Centre (http://aehrc.com).
 * All rights reserved. Use is subject to license terms and conditions.
 */
package au.csiro.ontology.importer.rf2;

import java.util.ArrayList;
import java.util.Collection;

import au.csiro.ontology.snomed.refset.rf2.RefsetRow;

/**
 * This class represents a collection of rows from the RF2 concepts,
 * descriptions, and relationships tables that correspond to a logical version.
 * 
 * @author Alejandro Metke
 * 
 */
public class VersionRows {

    /**
     * The concept rows in this version.
     */
    protected final Collection<ConceptRow> conceptRows;

    /**
     * The relationship rows in this version.
     */
    protected final Collection<RelationshipRow> relationshipRows;
    
    /**
     * The concrete domains reference set rows in this version.
     */
    protected final Collection<RefsetRow> concreteDomainRows;

    /**
     * Builds a new VersionRows.
     */
    public VersionRows() {
        this(new ArrayList<ConceptRow>(), new ArrayList<RelationshipRow>(), new ArrayList<RefsetRow>());
    }
    
    public VersionRows(Collection<ConceptRow> conceptRows, Collection<RelationshipRow> relationshipRows, 
            Collection<RefsetRow> concreteDomainRows) {
        this.conceptRows = conceptRows;
        this.relationshipRows = relationshipRows;
        this.concreteDomainRows = concreteDomainRows;
    }

    /**
     * @return the conceptRows
     */
    public Collection<ConceptRow> getConceptRows() {
        return conceptRows;
    }

    /**
     * @return the relationshipRows
     */
    public Collection<RelationshipRow> getRelationshipRows() {
        return relationshipRows;
    }
    
    /**
     * Merges another {@link VersionRows} into this.
     * 
     * @param other
     */
    public void merge(VersionRows other) {
        conceptRows.addAll(other.conceptRows);
        relationshipRows.addAll(other.relationshipRows);
        concreteDomainRows.addAll(other.getConcreteDomainRows());
    }
    
    /**
    *
    * @return the refsetRows (includes current inactive rows)
    */
   public Collection<RefsetRow> getConcreteDomainRows() {
       return concreteDomainRows;
   }

}
