package Extension;

import android.graphics.Paint;

public class LinePaint {
   private Paint lPaint;

   public LinePaint()
    {
        lPaint=new Paint();
        lPaint.setARGB(255,23,80,76);
        lPaint.setStyle(Paint.Style.FILL);
        lPaint.setStrokeWidth(2f);
        lPaint.setDither(true);
    }
    public Paint getPaint()
    {
       return this.lPaint;
    }
}
