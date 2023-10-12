import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Provides an implementation of the WordLadderGame interface.
 *
 * @author Chase Hopkins (ceh0136@auburn.edu)
 */
public class Doublets implements WordLadderGame {

    // The word list used to validate words.
    // Must be instantiated and populated in the constructor.
    /////////////////////////////////////////////////////////////////////////////
    // DECLARE A FIELD NAMED lexicon HERE. THIS FIELD IS USED TO STORE ALL THE //
    // WORDS IN THE WORD LIST. YOU CAN CREATE YOUR OWN COLLECTION FOR THIS     //
    // PURPOSE OF YOU CAN USE ONE OF THE JCF COLLECTIONS. SUGGESTED CHOICES    //
    // ARE TreeSet (a red-black tree) OR HashSet (a closed addressed hash      //
    // table with chaining).
    /////////////////////////////////////////////////////////////////////////////

    List<String> emptyLadder = new ArrayList();
    TreeSet <String> lexicon;

    /*
     * Instantiates a new instance of Doublets with the lexicon populated with
     * the strings in the provided InputStream. The InputStream can be formatted
     * in different ways as long as the first string on each line is a word to be
     * stored in the lexicon.
     */
    public Doublets(InputStream in) {
        try {

            lexicon = new TreeSet<String>();

            Scanner s =
                    new Scanner(new BufferedReader(new InputStreamReader(in)));
            while (s.hasNext()) {
                String str = s.next();
                lexicon.add(str.toLowerCase());
                s.nextLine();
            }
            in.close();
        }
        catch (java.io.IOException e) {
            System.err.println("Error reading from InputStream.");
            System.exit(1);
        }
    }

    //////////////////////////////////////////////////////////////
    // ADD IMPLEMENTATIONS FOR ALL WordLadderGame METHODS HERE  //
    //////////////////////////////////////////////////////////////


    /**
     * Returns the Hamming distance between two strings, str1 and str2. The
     * Hamming distance between two strings of equal length is defined as the
     * number of positions at which the corresponding symbols are different. The
     * Hamming distance is undefined if the strings have different length, and
     * this method returns -1 in that case. See the following link for
     * reference: https://en.wikipedia.org/wiki/Hamming_distance
     *
     * @param  str1 the first string
     * @param  str2 the second string
     * @return      the Hamming distance between str1 and str2 if they are the
     *                  same length, -1 otherwise
     */
    @Override
    public int getHammingDistance(String str1, String str2) {
        int temp = 0;

        if(str1.length() != str2.length()){
            return -1;
        }

        char[] firstString = str1.toCharArray();
        char[] secondString = str2.toCharArray();

        for(int i = 0; i < str1.length(); i++) {
            if(firstString[i] != secondString[i]) {
                temp++;
            }
        }

        return temp;
    }

    /**
     * Returns a min-length word ladder from start to end. If multiple
     * min-length word ladders exist, no guarantee is made regarding which
     * one is returned. If no word ladder exists, this method returns an empty
     * list.
     *
     * Breadth-first search must be used in all implementing classes.
     *
     * @param  start  the starting word
     * @param  end    the ending word
     * @return        a min length word ladder from start to end
     */
    @Override
    public List<String> getMinLadder(String start, String end) {
        start = start.toLowerCase();
        end = end.toLowerCase();
        ArrayList<String> reverse = new ArrayList<String>();
        List<String> min = new ArrayList<String>();

        if (start.equals(end)) { // if start equals end, return
            min.add(start);
            return min;
        }
        if (getHammingDistance(start,end) == -1) { // if not the same length, return empty
            return emptyLadder;
        }

        if (isWord(start) && isWord(end)) { // if both start and end are words, start a search
            reverse = bfSearch(start, end);
        }

        for (int i = reverse.size() - 1; i >= 0; i--) { // makes reversed ladder forwards
            min.add(reverse.get(i));
        }
        return min;
    }

    /**
     * Bfs search method using memory. Positions are added to
     * the queue wrapped in a node, which is linked to a node
     * containing the position's immediately proceeding neighbor.
     */
    private ArrayList<String> bfSearch(String start, String end){
        Deque<Node> queue = new ArrayDeque<Node>();
        HashSet<String> taken = new HashSet<String>();
        ArrayList<String> reverse = new ArrayList<String>();

        taken.add(start);
        queue.addLast(new Node(start,null));

        Node lastNode = new Node(end, null);

        outerloop:  
        while(!queue.isEmpty()) { // search while queue is empty 

            Node temp = queue.removeFirst();
            String word = temp.word;
            List<String> neighbors = getNeighbors(word);
            for (String neighbor : neighbors){

                if (!taken.contains(neighbor)) {
                    taken.add(neighbor);
                    queue.addLast(new Node(neighbor, temp));

                    // if neighbor == end, make that node predecessor to last node
                    if (neighbor.equals(end)) {
                        lastNode.previous = temp;
                        break outerloop;
                    }
                }
            }
        }
        if (lastNode.previous == null) { // creates list based on Node chain (reversed ladder)
            return reverse;
        }
        Node temp = lastNode;
        while (temp != null) {
            reverse.add(temp.word);
            temp = temp.previous;
        }
        return reverse;
    }

    /**
     * Returns all the words that have a Hamming distance of one relative to the
     * given word.
     *
     * @param  word the given word
     * @return      the neighbors of the given word
     */
    @Override
    public List<String> getNeighbors(String word) {
        List<String> neighbors = new ArrayList<String>();
        char[] generateNeighbors = word.toCharArray();


        for (int i = 0; i < word.length(); i++) {

            for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {

                if (generateNeighbors[i] != alphabet) {

                    generateNeighbors[i] = alphabet;
                    String temp = new String(generateNeighbors);

                    if (lexicon.contains(temp) && (temp.compareTo(word) != 0)) {
                        neighbors.add(temp);
                    }
                }
            }
            generateNeighbors = word.toCharArray();
        }
        return neighbors;
    }

    /**
     * Returns the total number of words in the current lexicon.
     *
     * @return number of words in the lexicon
     */
    @Override
    public int getWordCount() {
        return lexicon.size();
    }

    /**
     * Checks to see if the given string is a word.
     *
     * @param  str the string to check
     * @return     true if str is a word, false otherwise
     */
    @Override
    public boolean isWord(String str) {
        return lexicon.contains(str);
    }

    /**
     * Checks to see if the given sequence of strings is a valid word ladder.
     *
     * @param  sequence the given sequence of strings
     * @return          true if the given sequence is a valid word ladder,
     *                       false otherwise
     */
    @Override
    public boolean isWordLadder(List<String> sequence) {
        if (sequence.isEmpty()) {
            return false;
        }

        for (int i = 0; i < sequence.size() - 1; i++) {
            if (getHammingDistance(sequence.get(i), sequence.get(i + 1)) != 1) {
                return false;
            }
        }
        for (String s : sequence) {
            if (!lexicon.contains(s)) {
                return false;
            }

        }
        return true;
    }

    /**
     * Node to link positions together.
     */
    private class Node{
        String word;
        Node previous;

        public Node(String word, Node previous) {
            this.word = word;
            this.previous = previous;
        }
    }
}