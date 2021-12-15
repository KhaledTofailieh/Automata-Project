package my.automat;

import Extension.FilePath;
import Extension.Screen_Size;
import SrcAutomata.DownloadAutomata;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import jxl.read.biff.BiffException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button Go;
    ImageView back;
    Context context=this;
    View mView ;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DisplayMetrics metrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Screen_Size.Height=metrics.heightPixels;
        Screen_Size.Width=metrics.widthPixels;

         Go=findViewById(R.id.Go_button);
         back=findViewById(R.id.back_image);
         mToolbar=findViewById(R.id.mtool_bar);

         mToolbar.setTitle("Automat");
         mToolbar.setSubtitle("by : MAKQ");

         YoYo.with(Techniques.BounceIn).duration(2000).playOn(Go);
         YoYo.with(Techniques.BounceIn).duration(2000).pivot(Go.getPivotX(),Go.getPivotY()).playOn(back);


         Go.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent intent=new Intent(context,SecondActivity.class);
                 startActivity(intent);
             }
         });

    }

}
