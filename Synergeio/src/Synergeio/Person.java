
package Synergeio;

//H abstract klash Person
public abstract class Person {
    
    private String onoma;     //onoma 
    private String epitheto;  //epitheto
    private String dieythinsi;  //dieyhtinsi
    private String thl;    //thlefwno
    private String AT;       //arithmos tautothtas
    
    //kataskevasths
    public Person(String onoma, String epitheto, String dieythinsi, String thl, String AT){
        this.onoma = onoma;
        this.epitheto = epitheto;
        this.dieythinsi = dieythinsi;
        this.thl = thl;
        this.AT = AT;
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
        this.AT = AT;
    }
    
    //get arithmo tautotitas
    public String getAT(){
        return this.AT;
    }
    
    
    @Override
    public String toString(){
        return "Ονομα: " + this.onoma + ", Επίθετο: " + this.epitheto + ", Διε�?θυνση: " + this.dieythinsi + ", Τηλέφωνο: " + this.thl + ", Α�?ιθμ�?ς ταυτ�?τητας: " + this.AT;
    }
    
    //για εκτ�?πωση των ιδιοτήτων
    public void print(){
        System.out.println(this.toString());
    }

}

