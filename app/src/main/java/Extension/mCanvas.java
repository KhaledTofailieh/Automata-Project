package Extension;

import SrcAutomata.ProjectAutomata;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.view.View;

public class mCanvas extends View {
    textPaint tPaint=new textPaint();
    LinePaint lPaint=new LinePaint();
    textPaint t1=new textPaint();
    final_paint fpaint=new final_paint();
    int tX=0, tY=0;
    boolean isfinal=false;
    public mCanvas(Context context) {
        super(context);
        t1.Cpaint.setARGB(255,219,9,9);
        t1.Cpaint.setTextSize(25);
        t1.Cpaint.setTypeface(Typeface.MONOSPACE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i=0;
        for(Component current : ProjectAutomata.List_Moves)
        {
            i++;
            if(i<ProjectAutomata.List_Moves.size())
            {

                canvas.drawLine(current.getX(),current.getY(),ProjectAutomata.List_Moves.get(i).getX(),ProjectAutomata.List_Moves.get(i).getY(),lPaint.getPaint());
                tX=((current.getX()+ProjectAutomata.List_Moves.get(i).getX())/2) -2;
                tY=((current.getY()+ProjectAutomata.List_Moves.get(i).getY())/2) -2;
                canvas.drawText(String.valueOf(current.getCurrent_terminal()),tX,tY,t1.get_Paint());
            }
            canvas.drawCircle(current.getX(),current.getY(),current.getRaduis(),current.cPaint);
            canvas.drawText(current.current_state,current.getX()-(current.current_state.length()*4 +10),current.getY()+5,tPaint.get_Paint());
            canvas.drawText("->",40,110,t1.get_Paint());

            if(i==ProjectAutomata.List_Moves.size() && isfinal)
            {
                canvas.drawCircle(current.getX(),current.getY(),current.getRaduis()+1,fpaint.getPaint());
            }
        }



    }
    public void setFinal(boolean f)
    {
        isfinal=f;
        invalidate();
    }
  public void Invalidate()
  {
      invalidate();
  }
}
