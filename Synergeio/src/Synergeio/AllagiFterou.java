
package Synergeio;

//kathgoria Ergasias
public class AllagiFterou extends Ergasia{
    
    //kataskevasths
    public AllagiFterou(int etos, int mhnas, int mera, int wra, int lepta){
        super(etos, mhnas, mera, wra, lepta);
    }
    
    @Override
    public String toString(){
        return "Προγραμματίστηκε εργασία αλλαγής φτερού για :\n" + super.toString();
    }

}
