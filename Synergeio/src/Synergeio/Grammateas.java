
package Synergeio;

//h klash grammateas klhronomei thn Employee
public class Grammateas extends Employee{
    
    //kataskevasths
    public Grammateas(String onoma, String epitheto, String dieythinsi, String thl, String AT){
        super(onoma, epitheto, dieythinsi, thl, AT);       
    }
    
    @Override
    public String toString(){
        return "Γραμματέας: " + super.toString();
    }

}
