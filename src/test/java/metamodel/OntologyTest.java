package metamodel;

import edu.mayo.cts2.terms.TermsNames;
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
        String root = TermsNames.TERMS_METAMODEL_PACKAGE.replaceAll( "\\.", "/" );
        try {
            mgr.loadOntologyFromOntologyDocument( OntologyTest.class.getResourceAsStream( "/" + root + "/lmm_l1.owl" ) );
            mgr.loadOntologyFromOntologyDocument( OntologyTest.class.getResourceAsStream( "/" + root + "/skos.owl" ) );
            mgr.loadOntologyFromOntologyDocument( OntologyTest.class.getResourceAsStream( "/" + root + "/cts2.owl" ) );
            mgr.loadOntologyFromOntologyDocument( OntologyTest.class.getResourceAsStream( "/" + root + "/terms.owl" ) );
        } catch ( OWLOntologyCreationException e ) {
            e.printStackTrace();
            fail( e.getMessage() );
        }
        assertEquals( 4, mgr.getOntologies().size() );
    }

}
