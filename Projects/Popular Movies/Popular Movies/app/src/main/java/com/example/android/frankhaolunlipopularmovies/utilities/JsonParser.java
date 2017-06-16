package com.example.android.frankhaolunlipopularmovies.utilities;

import android.util.Log;

/**
 * Created by Frank2 on 6/16/2017.
 */

public class JsonParser {
    boolean debugMode = true;
    public String[] ParseMovieData(String inputString){
        inputString = this.removeExtra(inputString);
        String[] stringArrayResults = this.stringArrayResults(inputString);
        return stringArrayResults;
    }
    public String removeExtra (String inputString){
        int beginningExtra = inputString.indexOf("[");
        int endExtra = inputString.length() - 2;
        String removedExtra = inputString.substring(beginningExtra + 1, endExtra);
        Log.d("removedExtra", removedExtra);
        return removedExtra;
    };
    public String[] stringArrayResults (String inputString){
        String[] stringArrayResults = inputString.split(", ");
        Log.d("stringArrayResults", stringArrayResults[0]);
        return stringArrayResults;
    }
    public void print (String name, String input){
        if (debugMode) {
            Log.d(name, input);
        }
    }
    public void printStringArray (String name, String[] input){
        if (debugMode) {
            Log.d(name, input[0]);
            }
        }

    }



