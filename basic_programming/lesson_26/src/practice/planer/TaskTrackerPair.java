package practice.planer;

import java.util.Arrays;

public class TaskTrackerPair <K, V> {
    private K[] keys;
    private V[] values;

    public TaskTrackerPair() {
        this.keys = (K[]) new Object[0];
        this.values = (V[]) new Object[0];
    }

    public void setPair(K k, V v) throws TaskException {
        if (containsKey(k)) {
            throw new TaskException("Key has already exist!");
        }

        keys = Arrays.copyOf(keys, keys.length + 1);
        keys[keys.length - 1] = k;

        values = Arrays.copyOf(values, values.length + 1);
        values[values.length - 1] = v;
    }

    public V getValue(K k) throws TaskException {
        int index = getKeyIndex(k);
        if(index != -1) {
            return values[index];
        } else {
            throw new TaskException("Incorrect key!");
        }
    }

    public boolean containsKey(K k) {
        return getKeyIndex(k) != -1;
    }

    public int getKeyIndex(K k) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].equals(k)) {
                return i;
            }
        }

        return -1;
    }
}
