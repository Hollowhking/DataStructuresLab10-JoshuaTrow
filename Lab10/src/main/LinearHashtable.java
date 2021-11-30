package main;

public class LinearHashtable<T> extends Hashtable<T> {
    public LinearHashtable(int capacity) {
        super(capacity);
    }

    public int rehash(int previousHash) {
        // YOUR CODE GOES HERE
    	int newhash = previousHash + 1;

        return newhash;
    }
}