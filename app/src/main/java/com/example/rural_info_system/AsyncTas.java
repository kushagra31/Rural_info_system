package com.example.rural_info_system;


import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;


public class AsyncTas extends AsyncTask<Void,Void,Void> {

    private final GetStateInterface listener ;
    Context context;

    ArrayList<String> districtslist;
ArrayList<String> stateslist;
    public AsyncTas(GetStateInterface listener,Context context){
this.listener=listener;

        this.context=context;

    }
    public AsyncTas(Context context){

this.listener=null;
        this.context=context;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }


    @Override
    protected Void doInBackground(Void... voids) {
      districtslist = new ArrayList<>();
       stateslist =new ArrayList<>();
        try {
            if(NetworkUtils.networkStatus(context)){

                String authtoken= NetworkUtils.gettoken();


                if(this.context instanceof State){

                    stateslist=NetworkUtils.getstate(authtoken);

                }


                else if(this.context instanceof DistrictActivity){

                    districtslist=NetworkUtils.getdistrict(authtoken);

                }

            }else{
                Toast.makeText(context,"No Internet Connection",Toast.LENGTH_LONG).show();
            }
          } catch (IOException e){
            e.printStackTrace();
        }

        return null;

    }

    @Override
    protected void onPostExecute(Void  s) {
        super.onPostExecute(s);


        if(this.context instanceof State){
            if (listener!=null){
                listener.onCarsCompleted(stateslist);
            }
        }

        if(this.context instanceof DistrictActivity){
            if (listener!=null){
                listener.onCarsCompleted(districtslist);
            }
        }




    }
}
