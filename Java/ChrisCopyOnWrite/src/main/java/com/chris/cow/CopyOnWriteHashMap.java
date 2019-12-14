package com.chris.cow;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class CopyOnWriteHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
    private volatile Map<K, V> map;

    public CopyOnWriteHashMap() {
        this.map = new HashMap<>();
    }


    public CopyOnWriteHashMap(HashMap<K, V> map) {

    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return map.entrySet();
    }

    @Override
    public V get(Object key) {
        return map.get(key);
    }

    @Override
    public V put(K key, V value) {
        synchronized (this) {
            Map<K, V> newMap = new HashMap<>(map);
            newMap.put(key, value);
            map = newMap;
            return value;
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        synchronized (this) {
            Map<K, V> newMap = new HashMap<>(map);
            newMap.putAll(m);
            map = newMap;
        }
    }

    @Override
    public V remove(Object key) {
        synchronized (this) {
            Map<K, V> newMap = new HashMap<>(map);
            V value = newMap.remove(key);
            map = newMap;
            return value;
        }
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return map.replace(key, oldValue, newValue);
    }
}
