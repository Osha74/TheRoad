package com.example.theroad;

import android.content.Intent;
import android.os.Bundle;

import com.codemybrainsout.onboarder.AhoyOnboarderActivity;
import com.codemybrainsout.onboarder.AhoyOnboarderCard;

import java.util.ArrayList;
import java.util.List;

public class onBoard  extends AhoyOnboarderActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard
                ("زحام مروري", "معرفة اماكن الزحام المروري ", R.drawable.st);
        ahoyOnboarderCard1.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard1.setTitleColor(R.color.white);
        ahoyOnboarderCard1.setDescriptionColor(R.color.grey_200);
        ahoyOnboarderCard1.setTitleTextSize(dpToPixels(18, this));
        ahoyOnboarderCard1.setDescriptionTextSize(dpToPixels(12, this));
        ahoyOnboarderCard1.setIconLayoutParams
                (600, 600, 20, 20, 8, 8);



        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard
                ("ونش", "طلب اقرب ونش فى حاله الاعطال", R.drawable.winch);
        ahoyOnboarderCard2.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard2.setTitleColor(R.color.white);
        ahoyOnboarderCard2.setDescriptionColor(R.color.grey_200);
        ahoyOnboarderCard2.setTitleTextSize(dpToPixels(18, this));
        ahoyOnboarderCard2.setDescriptionTextSize(dpToPixels(12, this));
        ahoyOnboarderCard2.setIconLayoutParams
                (600, 600, 20, 20, 8, 8);

        AhoyOnboarderCard ahoyOnboarderCard3 = new AhoyOnboarderCard
                ("بنزينه", "معرفة اقرب بنزينه عن طريق الخريطة", R.drawable.gaspump);
        ahoyOnboarderCard3.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard3.setTitleColor(R.color.white);
        ahoyOnboarderCard3.setDescriptionColor(R.color.grey_200);
        ahoyOnboarderCard3.setTitleTextSize(dpToPixels(18, this));
        ahoyOnboarderCard3.setDescriptionTextSize(dpToPixels(12, this));
        ahoyOnboarderCard3.setIconLayoutParams
                (600, 600, 20, 20, 8, 8);


        List<AhoyOnboarderCard> pages = new ArrayList<>();
        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard2);
        pages.add(ahoyOnboarderCard3);


        setOnboardPages(pages);


        setGradientBackground();

        //Set finish button text
        setFinishButtonTitle("Next");

    }




        @Override
        public void onFinishButtonPressed () {

        startActivity(new Intent(onBoard.this,RegisterActivity.class));
        
        }
}
