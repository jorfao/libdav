package com.jorfao.libdav;

import android.support.annotation.NonNull;

import com.burgstaller.okhttp.AuthenticationCacheInterceptor;
import com.burgstaller.okhttp.CachingAuthenticatorDecorator;
import com.jorfao.libdav.Model.PropList;
import com.jorfao.libdav.Model.Server;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


public class WebDAVClient {

    private OkHttpClient mClient;
    private List<Server> mServers;
    private Server mSelectedServer;
    private Call mCall;

    public WebDAVClient(){
        mServers = new ArrayList<>();
    }

    public void addServer(Server server){
        if(mServers == null)
            mServers = new ArrayList<>();

        mServers.add(server);
    }

    public void setSelectedServer(@NonNull Server server){
        setOKHTTPClient(server);
        mSelectedServer = server;
    }

    public void setSelectedServer(String path){
        if (mServers != null) {
            for (Server item : mServers) {
                if (path.contains(item.getPath())) {
                    setSelectedServer(item);
                }
            }
        }
    }

    public void cancelRequest(){
        if(mCall != null){
            mCall.cancel();
        }
    }

    //region propfind
    public void propfind(String path, @NonNull Callback<PropList> callback){
        propfind(path, Constants.Default.PROPFIND_DEFAUT_BODY, Constants.Depth.ONE, callback);
    }

    public void propfind(String path, String body, @NonNull Callback<PropList> callback){
        propfind(path, body, Constants.Depth.ONE, callback);
    }

    public void propfind(String path, String body, String depth, @NonNull Callback<PropList> callback){

        mCall = new Retrofit.Builder()
                .baseUrl(path)
                .client(mClient)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
                .create(WebDAVService.class)
                .propfind(RequestBody.create(MediaType.parse(body), body), depth);

        mCall.enqueue(callback);
    }
    //endregion

    //region delete
    public void delete(String path, @NonNull Callback<ResponseBody> callback){

        mCall = new Retrofit.Builder()
                .baseUrl(path + "/")
                .client(mClient)
                .build()
                .create(WebDAVService.class)
                .delete(path);
        mCall.enqueue(callback);
    }
    //endregion

    //region get
    public void get(String path, @NonNull Callback<ResponseBody> callback){

        mCall = new Retrofit.Builder()
                .baseUrl(mSelectedServer.getPath())
                .client(mClient)
                .build()
                .create(WebDAVService.class)
                .get(path);
        mCall.enqueue(callback);
    }
    //endregion

    //region mkol
    public void mkol(String path, Callback<ResponseBody> callback){
        mCall  = new Retrofit.Builder()
                        .baseUrl(path)
                        .client(mClient)
                        .build()
                        .create(WebDAVService.class)
                        .mkcol();
        mCall.enqueue(callback);
    }
    //endregion

    //region move
    public void move(String path, String destination, @NonNull Callback<ResponseBody> callback){
        mCall = new Retrofit.Builder()
                .baseUrl(path)
                .client(mClient)
                .build()
                .create(WebDAVService.class)
                .move(destination);
        mCall.enqueue(callback);
    }
    //endregion

    //region put
    public void put(String path, File file, @NonNull Callback<ResponseBody> callback){
        /*
        if(TextUtils.isEmpty(contentType)){
            contentType = "text/plain";
        }
        */

        mCall = new Retrofit.Builder()
                .baseUrl(mSelectedServer.getPath())
                .client(mClient)
                .build()
                .create(WebDAVService.class)
                .put(path, RequestBody.create(MediaType.parse(file.getAbsolutePath()), file));
        mCall.enqueue(callback);
    }
    //endregion

    //region lock
    public void lock(){

    }
    //endregion

    //region lock
    public void unlock(){

    }
    //endregion

    private void setOKHTTPClient(@NonNull Server server) {
        mClient = new OkHttpClient.Builder()
                .authenticator(new CachingAuthenticatorDecorator(server.getAuthenticator(), server.getAuthCache()))
                .addInterceptor(new AuthenticationCacheInterceptor(server.getAuthCache()))
                .build();
    }


}
