package my.automat;

import Extension.UI;
import Extension.mCanvas;
import SrcAutomata.DownloadAutomata;
import SrcAutomata.ProjectAutomata;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import jxl.read.biff.BiffException;

import java.io.IOException;

public class SecondActivity extends AppCompatActivity implements UI {
EditText mText;
Context context=this;
InputMethodManager Imm;
mCanvas canvas;
RelativeLayout Second_Layout;
String inString;
TextView typeTxt;
ProjectAutomata ob= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mText=findViewById(R.id.InputText);
        typeTxt=findViewById(R.id.stateText);
        Second_Layout=findViewById(R.id.second_layout);

        try {
            DownloadAutomata D=new DownloadAutomata(context);
            ob = new ProjectAutomata(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        canvas=new mCanvas(this);
        Second_Layout.addView(canvas);
              mText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                inString=mText.getText().toString();
                ob.setLineStringArray(inString);
                ob.Algorithm();
                canvas.Invalidate();

            Imm=(InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            Imm.hideSoftInputFromWindow(mText.getWindowToken(),0);
                return true;
            }
        });
    }

    @Override
    public void showText(String S) {
     typeTxt.setText(S);
    }

    @Override
    public void ShowToast(String S) {
        Toast.makeText(context,S,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showFinalState(boolean isFinal) {
        canvas.setFinal(isFinal);
    }
}
