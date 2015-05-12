package metamodel;

import org.junit.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class OntologyTest {

    @Test
    public void testLoadOntologies() {
        OWLOntologyManager mgr = OWLManager.createOWLOntologyManager();
        try {
            mgr.loadOntologyFromOntologyDocument( OntologyTest.class.getResourceAsStream( "/lmm_l1.owl" ) );
            mgr.loadOntologyFromOntologyDocument( OntologyTest.class.getResourceAsStream( "/skos.rdf" ) );
            mgr.loadOntologyFromOntologyDocument( OntologyTest.class.getResourceAsStream( "/cts2.owl" ) );
            mgr.loadOntologyFromOntologyDocument( OntologyTest.class.getResourceAsStream( "/terms.owl" ) );
        } catch ( OWLOntologyCreationException e ) {
            e.printStackTrace();
            fail( e.getMessage() );
        }
        assertEquals( 4, mgr.getOntologies().size() );
    }

}
