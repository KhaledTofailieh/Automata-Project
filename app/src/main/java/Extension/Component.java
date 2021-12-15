package Extension;

import android.graphics.Paint;
public class Component {
    char current_terminal;
    String current_state;
    int X , Y , Raduis;
    Paint cPaint;
    public Component(){
        current_state="null";
        current_terminal=' ';
        X=130;
        Y=70;
        Raduis=60;
        cPaint=new Paint();
       // cPaint.setColor(Color.argb(255, 0, 0,255));
        cPaint.setARGB(255,17,87,69);
        cPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        cPaint.setDither(true);
    }
    public void setState(String s)
    {
        this.current_state=s;
    }
    public void setTerminal(char c)
    {
        this.current_terminal=c;
    }
    public String getCurrent_state()
    {
        return this.current_state;
    }
    public char getCurrent_terminal()
    {
        return this.current_terminal;
    }
    public void setXY(int x , int y)
    {
        this.X=x;
        this.Y=y;
    }
    public  void setRaduis(int r)
    {
     this.Raduis=r;
    }
    int getX()
    {
        return  X;
    }
    int getY()
    {
        return Y;
    }
    int getRaduis()
    {
        return Raduis;
    }
    Paint getcPaint()
    {
        return cPaint;
    }
}
