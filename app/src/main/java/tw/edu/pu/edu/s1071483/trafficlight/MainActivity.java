package tw.edu.pu.edu.s1071483.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText tst1;
    EditText tst2;
    EditText tst3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //設定全螢幕顯示
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //設定螢幕為橫式
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_main);

         tst1 = findViewById(R.id.editText1);
         tst2 = findViewById(R.id.editText2);
         tst3 = findViewById(R.id.editText3);
    }

    public void StartGame(View v) {

        if (tst1.getText().toString().equals("") || tst2.getText().toString().equals("") || tst3.getText().toString().equals("")) {
            Toast.makeText(this, "燈號的秒數不能為空白", Toast.LENGTH_LONG).show();
        } else if (tst1.getText().toString().equals("0") || tst2.getText().equals("0") || tst3.getText().toString().equals("0")) {
            Toast.makeText(this, "燈號的秒數不能為0", Toast.LENGTH_LONG).show();
        } else {
            Intent it = new Intent();
            it.setClass(this, GameActivity.class);
            it.putExtra("green", Integer.parseInt(tst1.getText().toString()));
            it.putExtra("yellow", Integer.parseInt(tst2.getText().toString()));
            it.putExtra("red", Integer.parseInt(tst3.getText().toString()));
            startActivity(it);
            finish();
        }
    }

    public void EndApp(View v) {
        finish();
    }
}
