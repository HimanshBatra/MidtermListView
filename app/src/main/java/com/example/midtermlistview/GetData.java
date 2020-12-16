package com.example.midtermlistview;
import android.app.Activity;
        import android.app.ProgressDialog;
        import android.content.Context;
        import android.os.AsyncTask;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.IOException;
        import java.util.ArrayList;

        import static android.content.ContentValues.TAG;


class GetData extends AsyncTask<String,Integer,String> implements AdapterView.OnItemClickListener {
    ArrayList RepositoryName,Ownername;
    ListView details;
    Context context;
    Activity activity;




    public GetData(MainActivity mainActivity) {
        activity=mainActivity;
        context=mainActivity;
        details = (ListView) mainActivity.findViewById(R.id.list);
        details.setOnItemClickListener(this);
    }
    @Override
    protected void onPostExecute(String s) {

        RepositoryName = new ArrayList();
        Ownername = new ArrayList();
        try {
            JSONArray jsonArray = new JSONArray(s);
            for(int i =0; i<jsonArray.length();i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");

                JSONObject ownerObject = jsonObject.getJSONObject("owner");
                String full_name = ownerObject.getString("login");

                RepositoryName.add(name);
                Ownername.add(full_name);
            }

            mylist adapter=new mylist(activity, RepositoryName, Ownername);
            details.setAdapter(adapter);

        } catch (JSONException exception) {

            exception.printStackTrace();

        }

        super.onPostExecute(s);
    }


    @Override
    protected void onPreExecute() {
        Log.d("premethod","onPreExecute: hellotest");
        super.onPreExecute();

    }



    @Override
    protected String doInBackground(String... strings)
    {
        String string = strings[0];
        String emptystring = "";

        GetUrl du = new GetUrl();
        try {
            emptystring = du.downloadurl(string);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return emptystring;
    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

    }
}
