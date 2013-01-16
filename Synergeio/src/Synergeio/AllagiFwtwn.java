
package Synergeio;

//kathgoria ergasias
public class AllagiFwtwn extends Ergasia{
    
    //kataskevasths
    public AllagiFwtwn(int etos, int mhnas, int mera, int wra, int lepta){
        super(etos, mhnas, mera, wra, lepta);
    }
    
    @Override
    public String toString(){
        return "Προγραμματίστηκε εργασία αλλαγής φώτων για :\n" + super.toString();
    }

}
