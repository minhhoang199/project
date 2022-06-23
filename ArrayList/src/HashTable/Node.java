package HashTable;

public class Node<K, V> {
    private K key;
    private V value;
    private int hashCode;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.hashCode = key.hashCode();
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public int getHashCode() {
        return hashCode;
    }

    public boolean equals(Node<K, V> otherNode) {
        if (!(this.hashCode == otherNode.hashCode))
            return false;
        else {
            return this.key.equals(otherNode.key);
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }


}
