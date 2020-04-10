package com.example.myapplication15;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;
import android.widget.ViewFlipper;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_main, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int curId = item.getItemId();
        switch (curId){
            case R.id.menu_user:
                Toast.makeText(this, "user 메뉴 선택됨.", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_menu:
                Intent intent = new Intent(getApplicationContext(),);
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }*/
    ViewFlipper flipper;
//자동 Flipping 선택 ToggleButton 참조변수

    ToggleButton toggle_Flipping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar abar = getSupportActionBar();
        abar.setDisplayShowTitleEnabled(false);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_menu, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


//ViewFlipper 객체 참조

        flipper= (ViewFlipper)findViewById(R.id.flipper);


        Animation showIn= AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

    //ViewFlipper에게 등장 애니메이션 적용

        flipper.setInAnimation(showIn);



    //ViewFlipper의 View가 교체될 때 퇴장하는 View의 애니메이션

    //오른쪽으로 슬라이딩 되면 퇴장하는 애니메이션 리소스 파일 적용.

    //위와 다른 방법으로 애니메이션을 적용해봅니다.

    //첫번째 파라미터 : Context

    //두번재 파라미터 : 트윈(Tween) Animation 리소스 파일(오른쪽으로 슬라이딩되며 퇴장)

        flipper.setOutAnimation(this, android.R.anim.slide_out_right);

        toggle_Flipping= (ToggleButton)findViewById(R.id.toggle_auto);



        //ToggleButton에 Toggle상태 변경 리스너 세팅(OnCheckedChangedListener)
        toggle_Flipping.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {



            //ToggleButton의 선택 상태가 변경되면 자동으로 호출되는 메소드

            //첫번재 파라미터 : 선택의 변화가 생긴 CompoundButton(여기서는 toggle_Flipping)

            //두번째 파라미터 : Compoundbutton(toggle_Flipping)의 ON(true),OFF(false) 상태

            @Override

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                // TODO Auto-generated method stub

                if(isChecked){//On 으로 바뀌었으므로 ..자동 Flipping 시작..



                    //1초의 간격으로 ViewFlipper의 View 자동 교체

                    flipper.setFlipInterval(3000);//플리핑 간격(1000ms)

                    flipper.startFlipping();//자동 Flipping 시작



                }else{//OFF로 변경되었으므로  Flipping 정지



                    flipper.stopFlipping();;//Flipping 정지



                }

            }

        });

    }
}




