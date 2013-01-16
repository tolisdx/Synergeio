
package Synergeio;

//kathgoria texnikou
public class Hlektrologos extends Texnikos{
    
    //kataskevasths
    public Hlektrologos(String onoma, String epitheto, String dieythinsi, String thl, String AT){
        super(onoma, epitheto, dieythinsi, thl, AT);       
    }
    
    @Override
    public String toString(){
        return "Ηλεκτρολόγος: " + super.toString();
    }

}
