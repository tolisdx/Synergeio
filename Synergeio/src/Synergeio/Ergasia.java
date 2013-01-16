
package Synergeio;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//Afhrhmenh klash Ergasia apo thn opoia klhronomoun ta eidh twn ergasiwn
public abstract class Ergasia {
    
    
    private Calendar date; 		//hmeromhnia pou tha ginei h ergasia
    private DateFormat df1;		//Gia format ths hmeromhnias	
    
    //kataskevasths
    public Ergasia(int etos, int mhnas, int mera, int wra, int lepta){
        date = new GregorianCalendar(etos, mhnas, mera, wra, lepta);
    }
    
    //epistrofi hmeromhnia ergasias
    public Calendar getDate(){
        return this.date;
    }
    
    //Ektypwsh me format dd/MM/yyyy 'στις' HH:mm ths hmeromhnias
    @Override
    public String toString(){
    	df1=new SimpleDateFormat("dd/MM/yyyy 'στις' HH:mm");
    	Date formdate=date.getTime();
        return df1.format(formdate);//"Ημερομηνία: " + this.date;
    }
    
}
