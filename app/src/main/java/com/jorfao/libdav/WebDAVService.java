package com.jorfao.libdav;


import com.jorfao.libdav.Model.PropList;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Streaming;
import retrofit2.http.Url;


interface WebDAVService {

    //Lists the properties of a collection or resource
    @HTTP(method = Constants.Methods.PROPFIND, hasBody = true, path = ".") @Headers(Constants.Headers.CONTENT_TYPE_XML)
    Call<PropList> propfind(@Body RequestBody body, @Header(Constants.Headers.DEPTH) String depth);

    //Updates a resource or collection
    @HTTP(method = Constants.Methods.PROPPATCH, hasBody = true, path = ".")
    Call<PropList> proppatch(@Body RequestBody body, @Header(Constants.Headers.CONTENT_TYPE) String contentType);

    //Creates a collection
    @HTTP(method = Constants.Methods.MKCOL, path = ".")
    Call<ResponseBody> mkcol();

    //Copies a resource or collection
    @HTTP(method = Constants.Methods.COPY, path = ".")
    Call<ResponseBody> copy(@Header(Constants.Headers.DESTINATION) String destination);

    //Moves a resource or collection
    @HTTP(method = Constants.Methods.MOVE, path = ".")
    Call<ResponseBody> move(@Header(Constants.Headers.DESTINATION) String destination);

    //Not implemented
    @HTTP(method = Constants.Methods.LOCK, hasBody = true, path = ".")
    Call<PropList> lock(@Body RequestBody body, @Header(Constants.Headers.DEPTH) String depth, @Header("Content-Type") String contentType);

    //Not implemented
    @HTTP(method = Constants.Methods.UNLOCK, hasBody = true, path = ".")
    Call<PropList> unlock(@Body RequestBody body, @Header("Depth") String depth, @Header("Content-Type") String contentType);

    //Gets a resource from the server
    @GET @Streaming
    Call<ResponseBody> get(@Url String fileUrl);

    //Deletes a resource from the server
    @DELETE
    Call<ResponseBody> delete(@Url String fileUrl);

    //Puts a resource in the server
    @PUT
    Call<ResponseBody> put(@Url String fileUrl, @Body RequestBody body);

}
