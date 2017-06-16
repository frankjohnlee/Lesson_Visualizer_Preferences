package com.example.android.frankhaolunlipopularmovies;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.android.frankhaolunlipopularmovies.utilities.JsonParser;
import com.example.android.frankhaolunlipopularmovies.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private TextView tempView;
    boolean debugMode = true;
    String queryString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tempView = (TextView) findViewById(R.id.tempView);
        this.makeSearchQuery();
    }

    private void makeSearchQuery() {
        /**
         * This method retrieves the search text from the EditText, constructs
         * the URL (using {@link NetworkUtils}) for the sort order you'd like to find, displays
         * that URL in a TextView, and finally fires off an AsyncTask to perform the GET request using
         * our (not yet created) {@link GithubQueryTask}
         */
        URL searchUrl = NetworkUtils.buildPopularUrl();
        Log.d("searchUrl", searchUrl.toString());
        new QueryTask().execute(searchUrl);
    }

    public class QueryTask extends AsyncTask<URL, Void, String> {
        @Override
        protected String doInBackground(URL... params) {
            URL searchUrl = params[0];
            String searchResults = null;
            try {
                searchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("searchResults", searchResults);
            return searchResults;
        }

        @Override
        protected void onPostExecute(String searchResults) {
            if (searchResults != null && !searchResults.equals("")) {
                String removedExtra = new JsonParser().removeExtra(searchResults);
                this.print("removedExtra", removedExtra);
                String[] StringArray = new JsonParser().ParseMovieData(removedExtra);
                tempView.setText(StringArray[0]);
            }


        }

        public void print(String name, String input) {
            if (debugMode) {
                Log.d(name, input);
            }
        }

        public void printStringArray(String name, String[] input) {
            if (debugMode) {
                Log.d(name, input[0]);
            }
        }
    }
}
