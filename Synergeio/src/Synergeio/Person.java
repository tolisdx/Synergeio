
package Synergeio;

//H abstract klash Person
public abstract class Person {
    
    private String onoma;     //onoma 
    private String epitheto;  //epitheto
    private String dieythinsi;  //dieyhtinsi
    private String thl;    //thlefwno
    private String at;       //arithmos tautothtas // NOPMD by Tolis on 20/1/2013 1:42 ��
    
    //kataskevasths
    public Person(String onoma, String epitheto, String dieythinsi, String thl, String AT){ // NOPMD by Tolis on 20/1/2013 1:40 ��
        this.onoma = onoma;
        this.epitheto = epitheto;
        this.dieythinsi = dieythinsi;
        this.thl = thl;
        this.at = AT;
    }
    
    //set onoma   
    public void setOnoma(String onoma){
        this.onoma = onoma;
    }
    
    //get onoma
    public String getOnoma(){
        return this.onoma;
    }
    
    //set Epitheto
    public void setEpitheto(String epitheto){
        this.epitheto = epitheto;
    }
    
    //get Epitheto
    public String getEpitheto(){
        return this.epitheto;
    }
    
    //set Dieythinsi
    public void setDieythinsi(String dieythinsi){
        this.dieythinsi = dieythinsi;
    }
    
    //get Dieythinsi
    public String getDieythinsi(){
        return this.dieythinsi;
    }
    
    //set thlefwno
    public void setThl(String thl){
        this.thl = thl;
    }
    
    //get thlefwno
    public String getThl(){
        return this.thl;
    }
    
    //set arithmo tautotitas
    public void setAT(String AT){
        this.at = AT;
    }
    
    //get arithmo tautotitas
    public String getAT(){
        return this.at;
    }
    
    //Ektypwsh tou person
    @Override
    public String toString(){
        return "Όνομα: " + this.onoma + ", Επίθετο: " + this.epitheto + ", Διεύθυνση: " + this.dieythinsi + ", Τηλέφωνο: " + this.thl + ", Αριθμός ταυτότητας: " + this.at;
    }
    
  

}

