package main;

public class QuadraticHashtable<T> extends Hashtable<T> {
    public QuadraticHashtable(int capacity) {
        super(capacity);
    }

    public int rehash(int previousHash) {
        // YOUR CODE GOES HERE
        int newhash = (previousHash*previousHash)%this.capacity;

        return newhash;
    }
}