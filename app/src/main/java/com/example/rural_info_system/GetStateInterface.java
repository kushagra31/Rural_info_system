package com.example.rural_info_system;

import java.util.ArrayList;

public interface GetStateInterface {

    void onCarsCompleted(ArrayList<String> arrayList);

    void onCarsError(String error);

}
