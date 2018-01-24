package com.jorfao.libdav.Model;

import com.burgstaller.okhttp.digest.CachingAuthenticator;
import com.burgstaller.okhttp.digest.Credentials;
import com.burgstaller.okhttp.digest.DigestAuthenticator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Server {

    private String mPath;
    private DigestAuthenticator mAuthenticator;
    private Map<String, CachingAuthenticator> mAuthCache;

    public String getPath() {
        return mPath;
    }

    public DigestAuthenticator getAuthenticator() {
        return mAuthenticator;
    }

    public Map<String, CachingAuthenticator> getAuthCache() {
        return mAuthCache;
    }

    public Server(String url, String username, String password){
        this.mPath = url;
        setAuthenticator(username, password);
    }

    public Server(String url, DigestAuthenticator auth, Map<String, CachingAuthenticator> cache){
        this.mPath = url;
        this.mAuthenticator = auth;
        this.mAuthCache = cache;
    }

    private void setAuthenticator(String username, String password){
        mAuthenticator = new DigestAuthenticator(new Credentials(username, password));
        mAuthCache = new ConcurrentHashMap<>();
    }
}
