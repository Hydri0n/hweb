package xyz.hplus.web.support;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author xiehongsong
 * @Date 2022/8/15
 */
public class AppContext {
    /** 存储字符串键值对的ThreadLocal */
    private static final ThreadLocal<Map<String, String>> STRING_THREAD_LOCAL = new ThreadLocal<>();

    public static synchronized void set(String key, String value) {
        if (STRING_THREAD_LOCAL.get() == null) {
            STRING_THREAD_LOCAL.set(new HashMap<>());
        }
        STRING_THREAD_LOCAL.get().put(key, value);
    }

    public static synchronized String getString(String key) {
        if (STRING_THREAD_LOCAL.get() == null) {
            return null;
        }
        return STRING_THREAD_LOCAL.get().get(key);
    }

    public static synchronized void remove(String key) {
        if (STRING_THREAD_LOCAL.get() == null) {
            return;
        }
        STRING_THREAD_LOCAL.get().remove(key);
    }

    public static synchronized void clear() {
        STRING_THREAD_LOCAL.remove();
    }
}
