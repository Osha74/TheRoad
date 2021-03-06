package com.example.theroad;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WinchDetails extends AppCompatActivity {

    TextView txtName;
    TextView txtPhone;
    ImageView call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winch_details);
        call = findViewById(R.id.imgcallw);

        txtName = findViewById(R.id.txtwinchDname);
        txtPhone = findViewById(R.id.txtwinchDphone);
        //Bundle
        Bundle bundle = getIntent().getExtras();
        txtName.setText(bundle.getString("Name"));
        txtPhone.setText(bundle.getString("Phone"));


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(WinchDetails.this);
                builder.setMessage("Do You Want To Call ?");
                builder.setTitle("Alert !");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        {
                            {
                                Intent callIntent = new Intent(Intent.ACTION_CALL);
                                callIntent.setData(Uri.parse("tel:" + txtPhone.getText().toString()));

                                if (ActivityCompat.checkSelfPermission
                                        (WinchDetails.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                                {
                                    return;
                                }
                                startActivity(callIntent);
                            }
                        }
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }
        });


    }
}
