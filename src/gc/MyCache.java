package gc;


import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

public abstract class MyCache<K,V> implements Cache<K,V>{

    public static void main(String[] args) {
        MyCache demoCache = new MyCache() {
            @Override
            protected Object getValueFromOut() {
                return new byte[1024*1024*100];
            }

        };

        for (int i = 0; i < 50; i++) {
            demoCache.get(String.valueOf(i));
        }


    }

    private ConcurrentHashMap<K, MySoftRef<V>> cache = new ConcurrentHashMap<>();
    private ReferenceQueue<V> referenceQueue=new ReferenceQueue<>();

    private static int count=0;
    @Override
    public V get(K k) {

        V value = null;
        //从cache获取
        if (cache.containsKey(k)) {
            value = cache.get(k).get();
        }

        if (value == null) {
            //清除cache中无效引用
            Reference<? extends V> reference = referenceQueue.poll();
            if (reference != null) {
                MySoftRef mySoftRef = (MySoftRef) reference;
                K key = (K) mySoftRef.getInfo();
                cache.remove(key);
                System.out.println("清除无效引用 key : "+key);
                System.out.println("count : "+ ++count);
            }
            //从外部获取数据
            value= getValueFromOut();
            cache.put(k, new MySoftRef<V>(k, value, referenceQueue)); //在软引用中存入key便于清除cache无效引用
        }

        return value;

    }

    /**
     * 从外部获取数据
     * @return
     */
    protected abstract V getValueFromOut();

    @Override
    public boolean set(K k, V v) {
        cache.put(k, new MySoftRef<V>(k, v, referenceQueue));

        return true;
    }
}


interface Cache<K,V>{
    V get(K k);

    boolean set(K k, V v);
}


class MySoftRef<T> extends SoftReference<T> {

    private Object info;

    public MySoftRef(T referent) {
        super(referent);
    }

    public MySoftRef(Object info, T referent, ReferenceQueue<? super T> q) {
        super(referent, q);
        this.info = info;
    }

    Object getInfo() {
        return this.info;
    }
}

