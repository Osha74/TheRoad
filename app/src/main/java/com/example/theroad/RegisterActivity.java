
package com.example.theroad;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class RegisterActivity extends AppCompatActivity {


    EditText temail, tname, tactive, tuser, tpassword, taddress, tphone;
    Button bsend, btncreate;


    final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tuser = findViewById(R.id.txtusername);
        tname = findViewById(R.id.txtname);
        tpassword = findViewById(R.id.txtpassword);
        temail = findViewById(R.id.txtemail);
        bsend = findViewById(R.id.btnsend);
        tactive = findViewById(R.id.txtactivecode);
        tphone = findViewById(R.id.txtphone);
        taddress = findViewById(R.id.txtaddress);
        btncreate = findViewById(R.id.btncreate);
        btncreate.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                if (tname.getText().toString().isEmpty()) {

                    tname.setError("Please enter full name");
                    tname.requestFocus();

                } else if (tuser.getText().toString().isEmpty()) {

                    tuser.setError("Please enter user name");
                    tuser.requestFocus();

                } else if (tpassword.getText().toString().isEmpty()) {

                    tpassword.setError("Please enter password");
                    tpassword.requestFocus();

                } else if (temail.getText().toString().isEmpty()) {

                    temail.setError("Please enter email");
                    temail.requestFocus();

                } else if (tphone.getText().toString().isEmpty()) {

                    tphone.setError("Please enter phone");
                    tphone.requestFocus();

                } else if (tphone.getText().toString().length() < 11) {

                    tphone.setError("invalid phone number");
                    tphone.requestFocus();

                } else if (taddress.getText().toString().isEmpty()) {

                    tphone.setError("please enter your address");
                    tphone.requestFocus();

                } else if (temail.getText().toString().matches(emailPattern)) {

                    // register DB

                    insertInDB();

                } else {

                    temail.setError("invalid email addrress (name@domain)");
                    temail.requestFocus();
                }


            }
        });


        temail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String ss = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (temail.getText().toString().matches(ss)) {
                    ;
                } else
                    temail.setError("Invaild Email Address (user@domain)");
            }
        });

        bsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ss = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (temail.getText().toString().matches(ss)) {

                    Random r = new Random();
                    x = r.nextInt(9999 - 1111 + 1) + 1111;

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                final String username = "yourmobileapp2017@gmail.com";
                                final String password = "okok2017";
                                Properties props = new Properties();
                                props.put("mail.smtp.auth", "true");
                                props.put("mail.smtp.starttls.enable", "true");
                                props.put("mail.smtp.host", "smtp.gmail.com");
                                props.put("mail.smtp.port", "587");

                                Session session = Session.getInstance(props,
                                        new javax.mail.Authenticator() {

                                            protected PasswordAuthentication getPasswordAuthentication() {
                                                return new PasswordAuthentication(username, password);
                                            }
                                        });

                                try {
                                    Message message = new MimeMessage(session);
                                    message.setFrom(new InternetAddress("yourmobileapp2017@gmail.com"));
                                    message.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse(temail.getText().toString()));
                                    message.setSubject("The road - Activation Code");
                                    message.setText("Dear : " + temail.getText().toString() + "\n" + "Your activation code is : " + x + "\n" + "Thank you for registeration :)");
                                    Transport.send(message);


                                } catch (MessagingException e) {
                                    throw new RuntimeException(e);
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }).start();


                    Toast.makeText(RegisterActivity.this, "" + x, Toast.LENGTH_SHORT).show();
                    Toast.makeText(RegisterActivity.this, "Activation code has been sent , Check your email", Toast.LENGTH_SHORT).show();

                } else

                    temail.setError("Invalid Email Address (user@domain)");

            }
        });
    }

    private void insertInDB() {

        Database db = new Database();

        Connection conn = db.ConnectDB();

        if (conn == null) {

            errorMsg("Error", "no internet connection", "try again");

        } else {

            String msg = db.RUNDML("insert into Users values ('" + tuser.getText() + "','" + tpassword.getText() + "','" + tname.getText() + "','" + tphone.getText() + "','" + temail.getText() + "','" + taddress.getText() + "')");

            if (msg.equals("Ok")) {

                errorMsg("The Road", "Your account has been created succeed :) ", "Thanks");

            } else if (msg.contains("PRIMARY KEY")) {


                errorMsg("The Road", "Sorry this user already exist try again", "Thanks");

            } else

                errorMsg("Error", msg, "try again");

        }


    }


    private void errorMsg(String title, String msg, String btnText) {

            AlertDialog.Builder al = new AlertDialog.Builder(this);

        al.setTitle(title)
                .setMessage(msg)
                .setNegativeButton(btnText, null);

        al.create();
        al.show();

    }

}
