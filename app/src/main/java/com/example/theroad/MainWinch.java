package com.example.theroad;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;


public class MainWinch extends AppCompatActivity {
    GridView gvv;
    Winch W;
    AdapterWinch Adapter1;
    GetWinch b=new GetWinch();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_winch);

        gvv=(GridView)findViewById(R.id.gvwinch);
        final ArrayList<Winch> m=new ArrayList<>(b.getdata(MainWinch.this));
        Adapter1=new AdapterWinch(MainWinch.this,m);
        gvv.setAdapter(Adapter1);


        gvv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                W = m.get(position);

                Intent intent = new Intent(MainWinch.this,WinchDetails.class);
                Bundle bundle = new Bundle();
                bundle.putString("Id",W.getWinchid());
                bundle.putString("Name",W.getWinchname());
                bundle.putString("Phone",W.getWinchPhone());
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

    }
}
