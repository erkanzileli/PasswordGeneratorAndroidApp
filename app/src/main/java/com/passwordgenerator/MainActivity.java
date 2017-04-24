package com.passwordgenerator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tw;
    CheckBox c1;
    CheckBox c2;
    CheckBox c3;
    EditText et;
    String password = "";
    String text = "";
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tw = (TextView) findViewById(R.id.textview);

        tw.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!tw.getText().toString().equals("")) {
                    ClipboardManager manager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData data = ClipData.newPlainText("password", tw.getText().toString());
                    manager.setPrimaryClip(data);
                    text = tw.getText().toString();
                    Toast.makeText(MainActivity.this, "Coppied", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        c1 = (CheckBox) findViewById(R.id.checkbox1);
        c2 = (CheckBox) findViewById(R.id.checkbox2);
        c3 = (CheckBox) findViewById(R.id.checkbox3);
        et = (EditText) findViewById(R.id.edittext1);
    }

    public void getPassword(View view) {
        Random rand = new Random();
        boolean b1;
        boolean b2;
        boolean b3;
        int length;
        try {
            b1 = c1.isChecked();
            b2 = c2.isChecked();
            b3 = c3.isChecked();
            length = Integer.parseInt(et.getText().toString());
            if (length <= 24) {
                if (b1 && b2 && b3) {
                    while (password.length() < length) {
                        switch (rand.nextInt((3 - 1) + 1) + 1) {
                            case 1:
                                password += (char) ('A' + rand.nextInt((25 - 0) + 1) + 0);
                                break;
                            case 2:
                                password += (char) ('a' + rand.nextInt((25 - 0) + 1) + 0);
                                break;
                            case 3:
                                password += rand.nextInt((9 - 0) + 1) + 0;
                                break;
                        }
                    }
                    tw.setText(password);
                    password = "";
                } else if (b1 && b2 && !b3) {
                    while (password.length() < length) {
                        switch (rand.nextInt((2 - 1) + 1) + 1) {
                            case 1:
                                password += (char) ('A' + rand.nextInt((25 - 0) + 1) + 0);
                                break;
                            case 2:
                                password += (char) ('a' + rand.nextInt((25 - 0) + 1) + 0);
                                break;
                        }
                    }
                    tw.setText(password);
                    password = "";
                } else if (b1 && !b2 && b3) {
                    while (password.length() < length) {
                        switch (rand.nextInt((2 - 1) + 1) + 1) {
                            case 1:
                                password += (char) ('A' + rand.nextInt((25 - 0) + 1) + 0);
                                break;
                            case 2:
                                password += rand.nextInt((9 - 0) + 1) + 0;
                                break;
                        }
                    }
                    tw.setText(password);
                    password = "";
                } else if (b1 && !b2 && !b3) {
                    while (password.length() < length) {
                        password += (char) ('A' + rand.nextInt((25 - 0) + 1) + 0);
                    }
                    tw.setText(password);
                    password = "";
                } else if (!b1 && b2 && b3) {
                    while (password.length() < length) {
                        switch (rand.nextInt((2 - 1) + 1) + 1) {
                            case 1:
                                password += (char) ('a' + rand.nextInt((25 - 0) + 1) + 0);
                                break;
                            case 2:
                                password += rand.nextInt((9 - 0) + 1) + 0;
                                break;
                        }
                    }
                    tw.setText(password);
                    password = "";
                } else if (!b1 && b2 && !b3) {
                    while (password.length() < length) {
                        password += (char) ('a' + rand.nextInt((25 - 0) + 1) + 0);
                    }
                    tw.setText(password);
                    password = "";
                } else if (!b1 && !b2 && b3) {
                    while (password.length() < length) {
                        password += rand.nextInt((9 - 0) + 1) + 0;
                    }
                    tw.setText(password);
                    password = "";
                } else {
                    Toast.makeText(this, "Please check anyone", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "MAXIMUM 24 CHARACTER", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            new AlertDialog.Builder(this).setTitle("Error").setMessage("Don't do that!").create().show();
        }
    }
}
