/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SrcAutomata;

import java.io.IOException;
import java.util.ArrayList;

import Extension.Component;
import Extension.Screen_Size;
import Extension.UI;
import android.content.Context;
import jxl.read.biff.BiffException;

/**
 *
 * @author ASUS
 */
public class ProjectAutomata {
    private char curenntTerminal;
    private String curenntState;
    private int LineStringArrayCount=0;
    private char[] LineStringArray;
    private DownloadAutomata dfa;
    public static ArrayList<Component> List_Moves;
    private Component current;
    private int X,Y;
    private Context mcontext;
    private UI mListener;
    boolean FinalState=false;
    public ProjectAutomata(Context context)
            throws IOException, BiffException {
        mcontext=context;
        mListener=(UI)context;
        dfa=new DownloadAutomata(mcontext);
        List_Moves=new ArrayList<Component>();
        current=new Component();
        LineStringArray=new char[100];
    }
        
    public void Algorithm() 
   {
        curenntState=dfa.InitializeState();
        List_Moves.clear();
        FinalState=false;
        X=130;Y=100;
        current=new Component();
        current.setXY(X,Y);
        current.setState(curenntState);
        curenntTerminal=NextChar();
        current.setTerminal(curenntTerminal);
        List_Moves.add(current);

        while (curenntTerminal!='$')
        {
            System.out.println("CurrentState :"+curenntState);
            System.out.println("CurrentTerminal :"+curenntTerminal);
            current=new Component();
            Calculate_XY();
            curenntState=Move(curenntState,curenntTerminal);
            current.setState(curenntState);
            curenntTerminal=NextChar();
            current.setTerminal(curenntTerminal);
            List_Moves.add(current);
        }
        //
        if (curenntTerminal == '$')
        {
            System.out.println("CurrentState :"+curenntState);

        }

           if(FinalStateChecker())
           {
               FinalState=true;
               System.out.println("List Of States : "+List_Moves);
               if (List_Moves.get(List_Moves.size()-1).getCurrent_state().compareTo("Qnumber2")==0)
               {
                   System.out.println("The Type IS : Define Number With Point");
                   mListener.showText("Type : Define Number With Point");
                   mListener.showFinalState(FinalState);
                   return;
                   
               }
               else if(List_Moves.get(List_Moves.size()-1).getCurrent_state().compareTo("Qnumber")==0)
               {
                   System.out.println("The Type IS : Define Number Without Point");
                   mListener.showText("Type : Define Number Without Point");
                   mListener.showFinalState(FinalState);
                   return;
               }
               else if(List_Moves.get(List_Moves.size()-1).getCurrent_state().compareTo("Qfinal")==0 ||
                       List_Moves.get(List_Moves.size()-1).getCurrent_state().compareTo("Qdouble")==0||
                       List_Moves.get(List_Moves.size()-1).getCurrent_state().compareTo("Qdo")==0||
                       List_Moves.get(List_Moves.size()-1).getCurrent_state().compareTo("Qfinal")==0||
                       List_Moves.get(List_Moves.size()-1).getCurrent_state().compareTo("Qint")==0||
                       List_Moves.get(List_Moves.size()-1).getCurrent_state().compareTo("Qthrow")==0)
               {
                   System.out.println("The Type IS : Define Keyword ");
                   mListener.showText("Type : Define Keyword ");
               }
               else if (List_Moves.get(1).getCurrent_state().compareTo("Qslash")==0 && List_Moves.get(2).getCurrent_state().compareTo("Qdslash")==0)
               {
                   System.out.println("The Type IS : Define Comment IN One Line ");
                   mListener.showText("Type : Define Comment IN One Line ");
                   mListener.showFinalState(FinalState);
                   return;
               }
               else if(List_Moves.get(1).getCurrent_state().compareTo("Qslash")==0 && List_Moves.get(2).getCurrent_state().compareTo("Qslashstar")==0)
               {
                   System.out.println("The Type IS : Define Comment IN More Of Line ");
                   mListener.showText("Type : Define Comment IN More Of Line ");
                   mListener.showFinalState(FinalState);
                   return;
               }
//               else if(List_Moves.get(List_Moves.size()-2).compareTo("Qnumberdecl")==0 &&List_Moves.get(List_Moves.size()-1).compareTo("Qs.c")==0)
//               {
//                    System.out.println("The Type IS : Define Variable Integer/ Long ");
//               }
               try{
                    if (List_Moves.get(3).getCurrent_state().compareTo("Qint")==0 && List_Moves.get(4).getCurrent_state().compareTo("Qspace")==0 && List_Moves.get(List_Moves.size()-1).getCurrent_state().compareTo("Qdslash")==0 )
                   {
                       System.out.println("The Type IS : Define Variable (Int) With Comment In One Line ");
                       mListener.showText("Type : Define Variable (Int) With Comment In One Line ");
                   }
                   else if(List_Moves.get(3).getCurrent_state().compareTo("Qint")==0 && List_Moves.get(4).getCurrent_state().compareTo("Qspace")==0 && List_Moves.get(List_Moves.size()-1).getCurrent_state().compareTo("Q17")==0)
                   {
                     System.out.println("The Type IS : Define Variable (Int) With Comment In More Line ");
                     mListener.showText("Type : Define Variable (Int) With Comment In More Line ");
                   }
                    else if (List_Moves.get(4).getCurrent_state().compareTo("Qlong")==0 && List_Moves.get(5).getCurrent_state().compareTo("Qspace")==0 && List_Moves.get(List_Moves.size()-1).getCurrent_state().compareTo("Qdslash")==0 )
                    {
                         System.out.println("The Type IS : Define Variable (Long) With Comment One Line");
                        mListener.showText("Type: Define Variable (Int) With Comment In More Line ");
                    }
                    else if (List_Moves.get(4).getCurrent_state().compareTo("Qlong")==0 && List_Moves.get(5).getCurrent_state().compareTo("Qspace")==0 &&List_Moves.get(List_Moves.size()-1).getCurrent_state().compareTo("Q17")==0)
                    {
                        System.out.println("The Type IS : Define Variable (Long) With Comment More Line");
                        mListener.showText("Type : Define Variable (Long) With Comment More Line");
                    }
                    
                    else if(List_Moves.get(5).getCurrent_state().compareTo("Qfloat")==0 && List_Moves.get(6).getCurrent_state().compareTo("Qspace2")==0 && List_Moves.get(List_Moves.size()-1).getCurrent_state().compareTo("Qdslash")==0)
                    {
                        System.out.println("The Type IS : Define Variable (Float) With Comment One Line");
                        mListener.showText("Type : Define Variable (Float) With Comment One Line");
                    }
                    else if(List_Moves.get(5).getCurrent_state().compareTo("Qfloat")==0 && List_Moves.get(6).getCurrent_state().compareTo("Qspace2")==0 && List_Moves.get(List_Moves.size()-1).getCurrent_state().compareTo("Q17")==0)
                    {
                         System.out.println("The Type IS : Define Variable (Float) With Comment More Line");
                         mListener.showText("Type : Define Variable (Float) With Comment More Line");
                    }
                     else if(List_Moves.get(6).getCurrent_state().compareTo("Qdouble")==0 && List_Moves.get(7).getCurrent_state().compareTo("Qspace2")==0 &&  List_Moves.get(List_Moves.size()-1).getCurrent_state().compareTo("Qdslash")==0 )
                    {
                         System.out.println("The Type IS : Define Variable (Double) With Comment One Line");
                         mListener.showText("Type : Define Variable (Double) With Comment One Line");
                    }
                    else if (List_Moves.get(6).getCurrent_state().compareTo("Qdouble")==0 && List_Moves.get(7).getCurrent_state().compareTo("Qspace2")==0 && List_Moves.get(List_Moves.size()-1).getCurrent_state().compareTo("Q17")==0)
                    {
                         System.out.println("The Type IS : Define Variable (Double) With Comment More Line");
                         mListener.showText("Type : Define Variable (Double) With Comment More Line");
                    }
         
                    else if(List_Moves.get(3).getCurrent_state().compareTo("Qint")==0 && List_Moves.get(4).getCurrent_state().compareTo("Qspace")==0 )
                    {
                         System.out.println("The Type IS : Define Variable Int ");
                         mListener.showText("Type : Define Variable Int ");
                    }
                    else if (List_Moves.get(4).getCurrent_state().compareTo("Qlong")==0 && List_Moves.get(5).getCurrent_state().compareTo("Qspace")==0 )
                    {
                          System.out.println("The Type IS : Define Variable Long ");
                          mListener.showText("Type : Define Variable Long ");
                    }
                    else if(List_Moves.get(5).getCurrent_state().compareTo("Qfloat")==0 && List_Moves.get(6).getCurrent_state().compareTo("Qspace2")==0 )
                    {
                           System.out.println("The Type IS : Define Variable Float ");
                           mListener.showText("Type : Define Variable Float ");
                    }
                    else if (List_Moves.get(6).getCurrent_state().compareTo("Qdouble")==0 && List_Moves.get(7).getCurrent_state().compareTo("Qspace2")==0 )
                    {
                          System.out.println("The Type IS : Define Variable Double ");
                          mListener.showText("Type : Define Variable Double ");
                    }
                    else
                    {
                              System.out.println("The Type IS : Define Keyword ");
                              mListener.showText("Type : Define Keyword ");
                    }
                    //throw new Exception();

                 //throw new ArrayIndexOutOfBoundsException();
               }
               catch(Exception e)
               {
                   
                   //System.out.println("The Type IS : Define Keyword ");
                  // System.out.println(e.toString());
               }
                     
           }// if final state
       mListener.showFinalState(FinalState);
        //System.out.println(FinalStateChecker());
    }// end methode Algorithm
        public  char NextChar()
    {
        if (LineStringArray==null || LineStringArrayCount==LineStringArray.length)
        {
            LineStringArrayCount=0;
            return '$';
        }
        return LineStringArray[LineStringArrayCount++];
            
    }
    public  String Move(String currentstring,char currentterminal)
    {
       //return dfa.NextState(currentstring, currentterminal);
        //return dfa.NextState(curenntState, curenntTerminal);
        return this.dfa.NextState(curenntState, curenntTerminal);
    }
    public  boolean FinalStateChecker()
    {
        if (dfa.FinalState(curenntState))
            return true;
        return false;
    }
    private void Calculate_XY()
    {
      X+=150;
      if(X>= Screen_Size.Width-70)
      {
          Y+=200;
          X=130;
      }
      current.setXY(X,Y);
    }

    public void setLineStringArray(String str) {
        this.LineStringArray = str.toCharArray();
    }
    
    
    
}
