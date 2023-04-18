package com.eynav.hackathonr2r;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.iwgang.countdownview.CountdownView;

public class MainActivity extends AppCompatActivity {
    CardView cv_list_view,cv_qa,cv_importance,cv_medicines,cv_apple,cv_bottle_of_water;
    TextView textViewContent;
    CountdownView mCvCountdownView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cv_list_view = findViewById(R.id.cv_list_view);
        cv_qa = findViewById(R.id.cv_qa);
        cv_importance = findViewById(R.id.cv_importance);
        cv_medicines = findViewById(R.id.cv_medicines);
        cv_apple = findViewById(R.id.cv_apple);
        cv_bottle_of_water = findViewById(R.id.cv_bottle_of_water);
        textViewContent = findViewById(R.id.textViewContent);
        mCvCountdownView = findViewById(R.id.mycountdown);
        setDateIn("17-04-2023 10:00:00");
        replaceFragment(new ImportantPoint());
        cv_list_view.setCardBackgroundColor(ContextCompat.getColor(this, R.color.teal_700));
        cv_qa.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        cv_importance.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        cv_medicines.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        cv_apple.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        cv_bottle_of_water.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));

        cv_list_view.setOnClickListener(l ->{
            replaceFragment(new ImportantPoint());
            cv_list_view.setCardBackgroundColor(ContextCompat.getColor(this, R.color.teal_700));
            cv_qa.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_importance.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_medicines.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_apple.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_bottle_of_water.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        });

        cv_qa.setOnClickListener(l ->{
            replaceFragment(new qestAns());
            cv_qa.setCardBackgroundColor(ContextCompat.getColor(this, R.color.teal_700));
            cv_list_view.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_importance.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_medicines.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_apple.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_bottle_of_water.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        });

        cv_importance.setOnClickListener(l ->{
            replaceFragment(new BlankFragment());
            cv_importance.setCardBackgroundColor(ContextCompat.getColor(this, R.color.teal_700));
            cv_qa.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_list_view.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_medicines.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_apple.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_bottle_of_water.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        });

        cv_medicines.setOnClickListener(l ->{
            replaceFragment(new medicines());
            cv_medicines.setCardBackgroundColor(ContextCompat.getColor(this, R.color.teal_700));
            cv_qa.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_importance.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_list_view.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_apple.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_bottle_of_water.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        });

        cv_apple.setOnClickListener(l ->{
            replaceFragment(new food());
            cv_apple.setCardBackgroundColor(ContextCompat.getColor(this, R.color.teal_700));
            cv_qa.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_importance.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_medicines.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_list_view.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_bottle_of_water.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        });

        cv_bottle_of_water.setOnClickListener(l ->{
            replaceFragment(new drinkDetails());
            cv_bottle_of_water.setCardBackgroundColor(ContextCompat.getColor(this, R.color.teal_700));
            cv_qa.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_importance.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_medicines.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_apple.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            cv_list_view.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        });

    }
    private void setDateIn(String date_e) {
        StringBuilder date11 = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String date1 = date_e;
        String[] parts = date1.split("/");
        for (int i = 0; i < parts.length; i++) {
            if (i == 0 || i==1){
                if (parts[i].length() == 1){
                    date11.append("0").append(parts[i]).append("-");
                }else {
                    date11.append(parts[i]).append("-");
                }
            }else {
                date11.append(parts[i]);
            }
        }
        date11.append(" 00:00:00");
        for(String part: parts) {

            System.out.println(part);
        }
        String countDate = date11.toString();

//        String countDate = "01-01-2024 00:00:00";
        Date now = new Date();
        textViewContent.setText(date_e);

        try {
            //Formatting from String to Date
            Date date = sdf.parse(countDate);
            long currentTime = now.getTime();
            long newYearDate = date.getTime();
            long countDownToNewYear = newYearDate - currentTime;
            mCvCountdownView.start(countDownToNewYear);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }


}