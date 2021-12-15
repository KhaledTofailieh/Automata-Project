package Extension;

import android.graphics.Paint;

public class final_paint {
    private Paint fPaint;

    public final_paint()
    {
        fPaint=new Paint();
        fPaint.setARGB(255,235,9,6);
        fPaint.setStyle(Paint.Style.STROKE);
        fPaint.setStrokeWidth(3f);
        fPaint.setStrokeCap(Paint.Cap.SQUARE);
        fPaint.setStrokeJoin(Paint.Join.ROUND);

        //fPaint.setDither(true);
    }
    public Paint getPaint()
    {
        return fPaint;
    }
}
