package com.example.emad.splashscreen;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class AI_calculate extends AppCompatActivity {
    squad_calculation SC = new squad_calculation();
    Player p = new Player();

    Handler handler = new Handler();

    AI_team AI = new AI_team();

    ArrayList<Player> squad_team1 = new ArrayList<>();
    ArrayList<Player> squad_team2 = new ArrayList<>();


    ArrayList<ArrayList<Player>> Initialized_array = new ArrayList<>();
    ArrayList<Player> AI_TEAM = new ArrayList<>();

    String MatchName;
    String Id;
    String UserName;

    private TransparentProgressDialog pd;
    private Handler h;
    private Runnable r;

    private RecyclerView recyclerView;
    private playerAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_calculate);

        Toast.makeText(this, "YAYYYYY I AM IN AI TEAM!! ", Toast.LENGTH_LONG);

        Intent intent = getIntent();
        MatchName = intent.getStringExtra("Teams");
        Id = intent.getStringExtra("Tid");

        UserName = intent.getStringExtra("User");
        mLayoutManager = new LinearLayoutManager(this);


        JSONTASK b = new JSONTASK();  //CHANGE THAT I EXECUTED ##CHHHHHH
        b.execute("http://cricapi.com/api/fantasySummary?unique_id=" + Id + "&apikey=O0E8leAg52MRpniJgY8RNfAuGtI3");
        final ProgressDialog d4 = new ProgressDialog(this);
        timerDelayRemoveDialog(d4);

    }

    public void timerDelayRemoveDialog(final ProgressDialog d) {
        d.setTitle("Connecting");
        d.setMessage("Please wait while we connect to devices...");
        d.show();
        handler.postDelayed(new Runnable() {
            public void run() {
                d.dismiss();
            }
        }, 60000);//for 6 seconds
    }


    public class JSONTASK extends AsyncTask<String, ArrayList<String>, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            //          doneSignal.countDown();
            try {

                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            String response_ = s;
            try {
                System.out.println(response_ + "      888888888888888888888888888888888888888888888888888888888888888888888888888888888888");
                Initialized_array = SC.parsingNames_AI(response_, p);

                final JSONObject obj1 = new JSONObject(response_);
                // System.out.println(obj1);
                // System.out.println("ss");
                final JSONObject test = obj1.getJSONObject("data");

                final JSONArray geodata1 = test.getJSONArray("team"); // getting squad
                System.out.println(geodata1 + "\n\n\n");
                final JSONObject team1 = geodata1.getJSONObject(0);
                final JSONObject team2 = geodata1.getJSONObject(1);


                TextView team1_ = (TextView) findViewById(R.id.title_team);
                team1_.setText(team1.getString("name") + "\n vs \n" + team2.getString("name"));


            } catch (JSONException e) {
                e.printStackTrace();
            }


            squad_team1 = Initialized_array.get(0);
            squad_team2 = Initialized_array.get(1);

            //CHECK HERE FOR THE AI-TEAM!!!

            AI_TEAM = AI.createAiOdiTeam(squad_team1, squad_team2);


            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

            adapter = new playerAdapter(this, AI_TEAM);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);


        }


    }

}



