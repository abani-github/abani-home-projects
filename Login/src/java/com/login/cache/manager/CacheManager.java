/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.cache.manager;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author CHIKI
 */
@Singleton
@Startup
public class CacheManager {
    private Map<String, Object> cache = new HashMap<String, Object>();
    
    @Lock(LockType.WRITE)
    public void addToCache (String key, Object obj) {
        if ( !cache.containsKey(key) ){
            cache.put(key, obj);
        }
    }
    
    @Lock(LockType.READ)
    public Object getFromCache (String key) {
        return cache.get(key);
    }
    
    @Lock(LockType.WRITE)
    public void removeFromCache (String key){
        cache.remove(key);
    }
    
    @Lock(LockType.READ)
    public Map<String, Object> getAllCache () {
        return cache;
    }
    @PostConstruct
    public void loadCache () {
        cache.put("name", "abani");
        cache.put("email", "abani@in.com");
        cache.put("mobile", "8892496877");
        cache.put("id", "2121471");
        cache.put("gender", "male");
    }
}
