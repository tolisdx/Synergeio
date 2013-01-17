
package Synergeio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


//Diathesimotita
public class Diathesimotita {
    
    private Calendar  gc1;  //apo poia wra einai diathesimos o texnikos
    private Calendar gc2;   //mexri poia wra einai diathesimos o texnikos
    private DateFormat df1;		//Gia format ths hmeromhnias	
    
    //kataskevasths
    public Diathesimotita(int etos, int mhnas, int mera, int wrastart, int leptastart, int wraend, int leptaend){
        gc1=new GregorianCalendar (etos, mhnas, mera, wrastart, leptastart);
        gc2=new GregorianCalendar (etos, mhnas, mera, wraend, leptaend);
       
    }
    
    //get hmerologio1
    public Calendar getGC1(){
        return this.gc1;
    }
    
    //get hmerologio2
    public Calendar getGC2(){
        return this.gc2;
    }
    
    public String toString(){
    	df1=new SimpleDateFormat("dd/MM/yyyy 'στις' HH:mm");
    	Date formgc1=gc1.getTime();
    	Date formgc2=gc2.getTime();
        return "Ημερομηνία Από :" + df1.format(formgc1)+ " έως :"+df1.format(formgc2);
   }
   
}
