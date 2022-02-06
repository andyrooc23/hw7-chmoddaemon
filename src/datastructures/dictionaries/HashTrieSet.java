package datastructures.dictionaries;

import egr221a.interfaces.trie.BString;
import egr221a.interfaces.trie.TrieSet;

public class HashTrieSet<A extends Comparable<A>, E extends BString<A>> extends TrieSet<A, E> {

    /**
     * This constructor makes a basic HashTrieSet utilizing the code from HashTrieMap.
     * This forsakes a bit of storage space but makes the code much simpler on our end.
     *
     * @param Type
     */
    public HashTrieSet(Class<E> Type) {
        super(new HashTrieMap<>(Type));
    }
}