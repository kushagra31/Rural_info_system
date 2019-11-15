package com.example.rural_info_system;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.GridView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();
    public static Boolean networkStatus(Context context){
        ConnectivityManager manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){
            return true;
        }
        return false;
    }

    public static String gettoken() throws IOException {

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
        RequestBody body = RequestBody.create(mediaType, "------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"username\"\r\n\r\n1412\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"password\"\r\n\r\n142487\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--");
        Request request = new Request.Builder()
                .url("https://hrtaskapi.dhwaniris.in/index.php/api/user/login")
                .post(body)
                .addHeader("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "fd396d85-6f2c-c8cc-3aa8-25592833f3ba")
                .build();

        Response response = client.newCall(request).execute();
        String authtoken = parseJson(response.body().string());

return authtoken;
    }
    public static ArrayList<String> getstate(String authtoken) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request1 = new Request.Builder()
                .url("https://hrtaskapi.dhwaniris.in/index.php/api/master/get-state")
                .get()
                .addHeader("token", authtoken)
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "d59b8bc7-dfbd-d1b3-6730-26aef34d0d3a")
                .build();

        Response response1 = client.newCall(request1).execute();

      ArrayList<String> stateArrayList= parseJsonState(response1.body().string());


   return stateArrayList;
    }


    public static ArrayList<String> getdistrict(String authtoken) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://hrtaskapi.dhwaniris.in/index.php/api/master/get-district?state_id=1")
                .get()
                .addHeader("token", authtoken)
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "78c2759d-96a5-5138-8122-f4f9b93ae04b")
                .build();

        Response response2 = client.newCall(request).execute();

        ArrayList<String> districtArrayList= parseJsonDistrict(response2.body().string());


        return districtArrayList;
    }

    public static void postdistrict(String authtoken) throws IOException {

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
        RequestBody body = RequestBody.create(mediaType, "------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"state_id\"\r\n\r\n1\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent-Disposition: form-data; name=\"district_name\"\r\n\r\nPune\n\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW--");
        Request request = new Request.Builder()
                .url("https://hrtaskapi.dhwaniris.in/index.php/api/district/create")
                .post(body)
                .addHeader("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
                .addHeader("token", authtoken)
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "0202868b-59b6-0c45-185f-84fba5407279")
                .build();

        Response response = client.newCall(request).execute();



    }


    public static String parseJson(String data){
        String authtoken=null;
        try {
            JSONObject mainObject = new JSONObject(data);
            authtoken= mainObject.getString("token");

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "Erro occurred during JSON Parsing", e);
        }
return authtoken;
    }
    public static ArrayList<String> parseJsonState(String datastate){
        ArrayList<String> ArrayList = new ArrayList<>();

        try {
            JSONObject mainObject = new JSONObject(datastate);

JSONArray jsonArray= mainObject.getJSONArray("state");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
String statename= jsonObject.getString("state_name");

                ArrayList.add(statename);

            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "Erro occurred during JSON Parsing", e);
        }
return ArrayList;
    }


    public static ArrayList<String> parseJsonDistrict(String datadistrict){
        ArrayList<String> ArrayList2 = new ArrayList<>();

        try {
            JSONObject mainObject = new JSONObject(datadistrict);

            JSONArray jsonArray= mainObject.getJSONArray("district");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String districtname= jsonObject.getString("district_name");

                ArrayList2.add(districtname);

            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "Erro occurred during JSON Parsing", e);
        }
        return ArrayList2;
    }

}

