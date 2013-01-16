
package Synergeio;

//kathgoria texnikou
public class Fanopoios extends Texnikos{
    
    //kataskevasths
    public Fanopoios(String onoma, String epitheto, String dieythinsi, String thl, String AT){
        super(onoma, epitheto, dieythinsi, thl, AT);       
    }
    
    @Override
    public String toString(){
        return "Φανοποιός: " + super.toString();
    }

}
