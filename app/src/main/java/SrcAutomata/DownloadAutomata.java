/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SrcAutomata;
import java.io.File;
import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import Extension.FilePath;
import Extension.UI;
import android.content.Context;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;

/**
 *
 * @author ASUS
 */
public class DownloadAutomata {
    private String[][] DFA_Table;
    private String[] Final_States;
    private int Rows;
    private int Columns;
    private Sheet sheet;
    private Scanner scanner;
    private String path_file;
    private Workbook workbook;
    private Cell cell;
    private File file;
    private UI mListener;
    public DownloadAutomata(Context context) throws IOException, BiffException {
        mListener=(UI)context ;
        file =new File(FilePath.path);
        workbook=Workbook.getWorkbook(file);
        sheet=workbook.getSheet(0);
        Rows=sheet.getRows();
        Columns=sheet.getColumns();
        DFA_Table=new String[Rows][Columns];
        Final_States=new String[11];
        for (int i=0;i<Rows;i++)
        {
            for(int j=0;j<Columns;j++)
            {
                cell=sheet.getCell(j, i);
                DFA_Table[i][j]=cell.getContents();
            }
        }
    }
    public void  Show_DFA_Table()
    {
        for (int i=0;i<Rows;i++)
        {
            for (int j=0;j<Columns;j++)
            {
                //cell=sheet.getCell(j, i);
                System.out.printf("|%-15s",DFA_Table[i][j]);
            }
           // System.out.print("|");
            System.out.println("|");
            
        }
    }

    public String getDFA_Table(int i,int j) {
        return DFA_Table[i][j];
    }

    public int getRows() {
        return Rows;
    }

    public int getColumns() {
        return Columns;
    }
    public String InitializeState()
    {
        //cell=sheet.getCell(0,1);
        
       // return cell.getContents();
       // System.out.println(this.obb.getDFA_Table(1, 0));
        return DFA_Table[1][0];
        
    }
      public String NextState(String curenntstate,char curenntchar)
    {
        for (int i=0;i<Rows;i++)
        {
            //cell=sheet.getCell(0, i);
            if (curenntstate.compareTo(getDFA_Table(i, 0))==0)
         
            {
                 for (int j=0;j<Columns;j++)
                 {
                   // cell=sheet.getCell(j, 0);
                    if (Character.isDigit(curenntchar))
                     {
                        if (getDFA_Table(0, j).compareTo("NUMBER")==0)
                        {
                            return getDFA_Table(i, j);
                        }
                     }// states char number
                    else if(curenntchar=='+')
                    {
                        //if (cell.getContents().compareTo("PLUS")==0)
                        if(getDFA_Table(0, j).compareTo("PLUS")==0)
                        {
                          return getDFA_Table(i, j);
                        }
                         
                    }
                    else if(curenntchar=='-')
                    {
                        if (getDFA_Table(0, j).compareTo("MINUS")==0)
                        {
                         
                           return getDFA_Table(i, j);
                        }
                         
                    }
                    else if(Character.isWhitespace(curenntchar))
                    {
                        if (getDFA_Table(0, j).compareTo("SPACE")==0)
                        {


                           return getDFA_Table(i, j);
                        }
                         
                    }
                    else if (curenntchar=='.')
                    {
                        if (getDFA_Table(0, j).compareTo("POINT")==0)
                        {
                            return getDFA_Table(i, j);
                        }
                         
                    }
                    else if (curenntchar=='/')
                    {
                        if (getDFA_Table(0, j).compareTo("SLASH")==0)
                        {
                            return getDFA_Table(i, j);
                        }
                         
                    }
                    else if (curenntchar=='*')
                    {
                        if (getDFA_Table(0, j).compareTo("STAR")==0)
                        {

                            return getDFA_Table(i, j);
                        }
                         
                    }
                    else if (curenntchar=='=')
                    {
                        if (getDFA_Table(0, j).compareTo("EQUAL")==0)
                        {
                           return getDFA_Table(i, j);
                        }
                         
                    }
                    else if (curenntchar==';')
                    {
                        if (getDFA_Table(0, j).compareTo("S.C")==0)
                        {

                          return getDFA_Table(i, j);
                        }
                         
                    }
                    else if (Character.isUpperCase(curenntchar))
                    {
                        if (getDFA_Table(0, j).compareTo("CAPITAL")==0)
                        {

                         return getDFA_Table(i, j);
                        }
                         
                         
                    }
                    else
                    {
                        if (getDFA_Table(0, j).compareTo(Character.toString(curenntchar))==0)
                        {
                            return getDFA_Table(i, j);
                        }
                    }// end else
                 }//end for2
             }//end if
               
        }//end for1
        return getDFA_Table(Rows-1,Columns-1);
        
    }//end methode NextState
    public boolean FinalState(String curenntstate)
    {
        //final_states = {"Q17","Qdo"}
        String fs="Q17 Qdo Qdouble Qfloat Qint Qfinal Qthrow Qs.c Qnumber Qdslash Qnumber2";
        Final_States=fs.split(" ");
      
        //for(String str:final_states)
        //    System.out.println(str);
        for (String sttr:Final_States)
        {
            if (sttr.compareTo(curenntstate)==0)
            {  
                System.out.println("The State IS Final States ....");
                mListener.ShowToast("The State IS Final States !");
                //Chech_Type(curenntstate);

                return true;
            }
        }

         System.out.println("The State IS NOT Final States ....");
        mListener.ShowToast("The State IS NOT Final States !");
        mListener.showText(" ");
        return false;
    }
    
    
    
    
}// END class
