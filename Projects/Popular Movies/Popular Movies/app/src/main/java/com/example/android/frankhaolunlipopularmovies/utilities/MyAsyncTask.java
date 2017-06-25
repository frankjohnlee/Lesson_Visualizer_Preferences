import android.os.AsyncTask;

public class MyAsyncTask extends AsyncTask<Object,Object,Object> { //change Object to required type
    private OnTaskCompleted listener;

    public YourTask(OnTaskCompleted listener){
        this.listener=listener;
    }

    // required methods

    protected void onPostExecute(Object o){
        // your stuff
        listener.onTaskCompleted();
    }
}
