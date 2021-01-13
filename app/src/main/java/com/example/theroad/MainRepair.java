package com.example.theroad;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;


public class MainRepair extends AppCompatActivity {
    GridView gv;
    RepairCenter rc;
    AdapterRepair Adapter;
    GetRepair g=new GetRepair();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_repair);

        gv=(GridView)findViewById(R.id.gvrepair);



        final ArrayList<RepairCenter> r=new ArrayList<>(g.getdata(MainRepair.this));
        Adapter=new AdapterRepair(MainRepair.this,r);
        gv.setAdapter(Adapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                rc = r.get(position);

                Intent intent = new Intent(MainRepair.this, RepairDetails.class);
                Bundle bundle = new Bundle();
                bundle.putString("Id", rc.getRapiarid());
                bundle.putString("Name", rc.getRepairname());
                bundle.putString("Specialty",rc.getRepairspecialty());
                bundle.putString("Phone", rc.getRapiarphone());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }}