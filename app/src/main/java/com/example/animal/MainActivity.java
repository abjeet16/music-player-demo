package com.example.animal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements itemClickLisner {
    ArrayList<sportItem> sportItemArrayList = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView= findViewById(R.id.sportrecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sportItemArrayList.add(new sportItem("Arjan Vailly",R.drawable.arjanvaily,1));
        sportItemArrayList.add(new sportItem("Haiwaan",R.drawable.haiwaan,2));
        sportItemArrayList.add(new sportItem("Papa meri jaan",R.drawable.papamarejaan,3));
        sportItemArrayList.add(new sportItem("Saari duniya jalaa denge",R.drawable.saariduniyajalaadenge,8));
        sportItemArrayList.add(new sportItem("Dolby walya",R.drawable.dolbywalya,10));
        sportItemArrayList.add(new sportItem("Hua main",R.drawable.huamain,4));
        sportItemArrayList.add(new sportItem("Satranga",R.drawable.satranga,5));
        sportItemArrayList.add(new sportItem("Abrars Entry Jamal Kudu",R.drawable.abrarentryy,9));
        sportItemArrayList.add(new sportItem("Kashmir",R.drawable.kasmirr,6));
        sportItemArrayList.add(new sportItem("Pehle bhi main",R.drawable.pehlebhi,7));
        sportItemArrayList.add(new sportItem("ABJEET YADAV\nNIE FGC BCA 3rd Sem",R.drawable.nie,100));

        recycalListAdapter adapter = new recycalListAdapter(this,sportItemArrayList,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(sportItem sportItem) {
        if (sportItem.num!=100) {
            Intent intent = new Intent(getApplicationContext(), playSound.class);
            if (sportItem.num == 1) {
                intent.putExtra("link", "https://pagalfree.com/musics/128-Arjan%20Vailly%20-%20Animal%20128%20Kbps.mp3");
            } else if (sportItem.num == 2) {
                intent.putExtra("link", "https://pagalfree.com/musics/128-Haiwaan%20-%20Animal%20128%20Kbps.mp3");
            } else if (sportItem.num == 3) {
                intent.putExtra("link", "https://pagalfree.com/musics/128-Papa%20Meri%20Jaan%20-%20Animal%20128%20Kbps.mp3");
            } else if (sportItem.num == 4) {
                intent.putExtra("link", "https://pagalfree.com/musics/128-Hua%20Main%20-%20Animal%20128%20Kbps.mp3");
            } else if (sportItem.num == 5) {
                intent.putExtra("link", "https://pagalfree.com/musics/128-Satranga%20-%20Animal%20128%20Kbps.mp3");
            } else if (sportItem.num == 6) {
                intent.putExtra("link", "https://pagalfree.com/musics/128-Kashmir%20-%20Animal%20128%20Kbps.mp3");
            } else if (sportItem.num == 7) {
                intent.putExtra("link", "https://pagalfree.com/musics/128-Pehle%20Bhi%20Main%20-%20Animal%20128%20Kbps.mp3");
            } else if (sportItem.num == 8) {
                intent.putExtra("link", "https://pagalfree.com/musics/128-Saari%20Duniya%20Jalaa%20Denge%20-%20Animal%20128%20Kbps.mp3");
            } else if (sportItem.num == 9) {
                intent.putExtra("link", "https://pagalfree.com/musics/128-Abrars%20Entry%20Jamal%20Kudu%20-%20Animal%20128%20Kbps.mp3");
            } else if (sportItem.num == 10) {
                intent.putExtra("link", "android.resource://" + getPackageName() + "/raw/dolbywalya");
            }
            String numINString = String.valueOf(sportItem.num);
            intent.putExtra("songname", sportItem.name);
            intent.putExtra("pos",numINString);
            startActivity(intent);
        }
    }
}