package datastructures.dictionaries;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import egr221a.exceptions.NotYetImplementedException;
import egr221a.interfaces.trie.BString;
import egr221a.interfaces.trie.TrieMap;

/**
 * See egr221a/interfaces/trie/TrieMap.java
 * and egr221a/interfaces/misc/Dictionary.java
 * for method specifications.
 */
public class HashTrieMap<A extends Comparable<A>, K extends BString<A>, V> extends TrieMap<A, K, V> {
    public class HashTrieNode extends TrieNode<Map<A, HashTrieNode>, HashTrieNode> {
        public HashTrieNode() {
            this(null);
        }

        public HashTrieNode(V value) {
            this.pointers = new HashMap<A, HashTrieNode>();
            this.value = value;
        }

        @Override
        public Iterator<Entry<A, HashTrieNode>> iterator() {
            return pointers.entrySet().iterator();
        }
    }

    public HashTrieMap(Class<K> KClass) {
        super(KClass);
        this.root = new HashTrieNode();
    }

    /**
     * This method takes a key and a value, and returns the root with the key/value pair attached to
     * the trie.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the trie
     */
    @Override
    public V insert(K key, V value) {

        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }

        HashTrieNode current = (HashTrieNode) this.root;

        for (A letter : key) {// traversing the trie if the node exists

            if (!current.pointers.containsKey(letter)) { // if the letter doesn't have a node yet
                current.pointers.put(letter, new HashTrieNode()); // make one
            }
            current = current.pointers.get(letter); // on to the next node
        }

        V prevVal = current.value;


        current.value = value;

        if (prevVal == null) { // only increment size if the trie is actually gaining a new word
            size++;
        }

        return prevVal;
    }

    /**
     * This method searches through the trie and returns the value of the key that is input
     * if it exists.
     * @param key the key whose associated value is to be returned
     * @return the value that exists at the node of the final letter of the key
     */
    @Override
    public V find(K key) {
        if (key == null) {
            throw new IllegalArgumentException("That's not a valid argument. Try again... (the key is null)");
        }

        HashTrieNode current = (HashTrieNode) this.root;
        for (A letter : key) {// traversing the trie if the node exists

            if (!current.pointers.containsKey(letter)) { // if the next letter in the key doesn't have a node
                return null;
            }
            current = current.pointers.get(letter); // on to the next node
        }
        return current.value;
    }

    /**
     * This method searches through the trie and returns true or false based on whether
     *  the key exists in the trie.
     * @param key the key that is being searched for in the trie be returned
     * @return true or false based on if the key is found or not
     */
    @Override
    public boolean findPrefix(K key) {
        if (key == null) {
            throw new IllegalArgumentException("You can't find something that doesn't exist... (the key is null)");
        }

        HashTrieNode current = (HashTrieNode) this.root;

        for (A letter : key) {// traversing the trie if the node exists

            if (!current.pointers.containsKey(letter)) {  // if the letter isn't a node in the trie
                return false;
            }
            current = current.pointers.get(letter); // on to the next node
        }
        return true;
    }

    /**
     * This method calls a recursive helper method that searches through the trie and
     * deletes the nodes corresponding to the key as long as they are not being depended
     * on to fulfill another value.
     * @param key the key whose mapping is to be removed from the map
     */
    @Override
    public void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException("The key is null.");
        }

        if (key.iterator().hasNext()) { // if the key has a next letter (making sure it's not an empty string -> "")
            HashTrieNode current = (HashTrieNode) this.root;
            removeRecursion(current, key.iterator()); // this is the recursive method
        }

    }

    /**
     * This is the recursive helper method that is going to go through and delete the
     * key's letters' nodes in the trie. It doesn't delete in a few specific
     * circumstances. First, if another word is dependent on some of the letters that
     * make up the key than it will leave the letters that are required to form the
     * other word.
     *
     * @param current
     * @param itr
     * @return
     */
    public HashTrieNode removeRecursion(HashTrieNode current, Iterator<A> itr) {
        if (!itr.hasNext()) { // base case, stop the recursion. it's time to start deleting
            if (current.value != null) {  // if this node has a value it is the last node therefore
                size--; // decrement size so that the trie has the proper size
            }

            if (current.pointers.isEmpty()) { // if this node has no other nodes after it
                return null; // delete it
            }

            current.value = null; // each node should have a null value

            return current; // return the modified node
        } else {
            A character = itr.next();

            if (!current.pointers.containsKey(character)) { // if the character is not a part of the key
                return current; // the key given is not valid
            }

            HashTrieNode next = current.pointers.get(character); // this the node that contains the letter

            next = removeRecursion(next, itr); // the node = the return value of the recursion

            if (next == null) { // if the node has been deleted
                current.pointers.remove(character); // remove the pointers for that node
            }
        }
        if (current.pointers.isEmpty() && current.value == null) { // if the node has no pointers and it's value = null
            return null;
        }
        return current;
    }

    //There's another comment right here now
    @Override
    public void clear() {
        this.root = new HashTrieNode();
        size = 0;
    }
}
