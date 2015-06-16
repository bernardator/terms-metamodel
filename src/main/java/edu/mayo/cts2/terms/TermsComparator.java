package edu.mayo.cts2.terms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TermsComparator implements Comparator<String> {

    protected static Map<String,List<String>> dependencies = new HashMap<String, List<String>>();

    static {
        dependencies.put( "terms.owl", Arrays.asList( "lmm_l1.owl", "skos.owl", "cts2.owl" ) );
    }

    protected static TermsComparator instance = new TermsComparator();

    public static TermsComparator getInstance() {
        return  instance;
    }

    protected TermsComparator() {}

    @Override
    public int compare( String x, String y ) {
        String s = x.substring( x.lastIndexOf( "/" ) + 1 );
        String t = y.substring( y.lastIndexOf( "/" ) + 1 );

        if ( dependencies.containsKey( s ) && dependencies.get( s ).contains( t ) ) {
            return 1;
        } else if ( dependencies.containsKey( t ) && dependencies.get( t ).contains( s ) ) {
            return -1;
        } else {
            return 0;
        }
    }
}

