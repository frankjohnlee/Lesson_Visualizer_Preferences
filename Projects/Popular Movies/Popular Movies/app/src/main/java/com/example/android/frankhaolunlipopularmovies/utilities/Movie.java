package com.example.android.frankhaolunlipopularmovies.utilities;
import android.util.Log;

/**
 * Created by Frank2 on 6/16/2017.
 */

public class Movie {
    boolean debugMode = true;
    String vote_count;
    String id;
    String video;
    String vote_average;
    String title;
    String popularity;
    String poster_path;
    String original_langauge;
    String original_title;
    String genre_ids;
    String backdrop_path;
    String adult;
    String release_date;

    // {
    // 0 "vote_count":1181,
    // 1"id":297762,
    // 2"video":false,
    // 3"vote_average":7,
    // 4"title":"Wonder Woman",
    // 5"popularity":101.523015,
    // 6"poster_path":"\/gfJGlDaHuWimErCr5Ql0I8x9QSy.jpg",
    // 7"original_language":"en",
    // 8"original_title":"Wonder Woman",
    // 9"genre_ids":[28,12,14,878],
    // 10"backdrop_path":"\/hA5oCgvgCxj5MEWcLpjXXTwEANF.jpg",
    // 11"adult":false,"overview":"An Amazon princess comes to the world of Man to become the greatest of the female superheroes.",
    // 12"release_date":"2017-05-30"
    // }

    public void Movie(String inputString) {
        String[] stringArray = this.divideString(inputString.substring(1, inputString.length() - 1));
        String atZero = this.stringAfterColon(stringArray[0]);
        this.print("atZero", atZero);
    }

    public String[] divideString(String inputString) {
        String[] stringArray = inputString.split(", ");
        return stringArray;
    }
    public String stringAfterColon(String inputString) {
        int index = 0;
        while (index != inputString.length()) {
            if (inputString.charAt(index) + "" == ":") {
                return inputString.substring(index + 1);
            }
            index++;
        }
        return "";
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


