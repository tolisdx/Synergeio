
package Synergeio;

//Kathgoria Texnikou
public class Mixanikos extends Texnikos{
    
    //kataskevasths
    public Mixanikos(String onoma, String epitheto, String dieythinsi, String thl, String AT){
        super(onoma, epitheto, dieythinsi, thl, AT);       
    }
    
    
    @Override
    public String toString(){
        return "Μηχανικός: " + super.toString();
    }

}
