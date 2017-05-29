package com.example.a15017381.c302_anime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    ArrayList<Anime> animeList = new ArrayList<Anime>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://10.0.2.2/C302_P06SecondExercise/getAnimeEvents.php";

        //TODO 2
        HttpRequest request = new HttpRequest(url);
        request.setMethod("GET");

        //TODO 3
        request.execute();

        try {
            //TODO 4

            String jsonString = request.getResponse();

            System.out.println(">>" + jsonString);
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                Anime a = new Anime();
                a.setName(jsonObj.getString("event_name"));
                a.setDescription(jsonObj.getString("event_description"));
                a.setLink(jsonObj.getString("event_link"));
                a.setImage(jsonObj.getString("event_picture"));
                animeList.add(a);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        AnimeAdapter adapter = new AnimeAdapter(this,
                R.layout.listview, animeList);

        lv = (ListView)findViewById(R.id.lv);

        lv.setAdapter(adapter);
    }
}
