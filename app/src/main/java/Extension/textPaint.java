package Extension;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class textPaint {
    android.text.TextPaint Cpaint;
    textPaint() {
        Cpaint = new android.text.TextPaint();
        Cpaint.setColor(Color.argb(255, 255, 255,255));
        Cpaint.setStyle(Paint.Style.FILL);
        Cpaint.setTextSize(17);
        Cpaint.setTypeface(Typeface.MONOSPACE);
    }
    Paint get_Paint()
    {
        return  Cpaint;
    }
}
