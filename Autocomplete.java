import java.util.Arrays;
import java.util.Comparator;


/**
 * Autocomplete.
 */
public class Autocomplete {

	private Term[] terms;

	/**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
	 */
	public Autocomplete(Term[] terms) {
      if (terms == null){
         throw new NullPointerException();
      }
      
      Term[] duplicate = new Term[terms.length];
      for (int i = 0; i < terms.length; i++){
         duplicate[i] = terms[i];
      }
    }

	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
	 */
	public Term[] allMatches(String prefix) {
	   if (prefix == null) {
         throw new NullPointerException();
         }

      Term p = new Term(prefix, 0);
      Comparator<Term> prefixOrder = Term.byPrefixOrder(prefix.length());
      int a = BinarySearch.firstIndexOf(terms, p, prefixOrder);
      int b = BinarySearch.lastIndexOf(terms, p, prefixOrder);
      int c = a;
      Term[] matches = new Term[b - a];
      for (int i = 0; i < b - a; i++){
         matches[i] = terms[c];
         c++;
      }
       Arrays.sort(matches, Term.byDescendingWeightOrder());
       return matches;
    }
  
}