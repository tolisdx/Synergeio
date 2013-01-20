
package Synergeio;


import java.util.Vector;

//afhrhmenh klash texnikos apo thn opoia klhronomoun ta eidh twn texnikwn
public abstract class Texnikos extends Employee{
    
    private Vector<Diathesimotita> a = new Vector<Diathesimotita>();  //Vector diathesimwn hmeromhniwn
    private Vector<Ergasia> ergasies = new Vector<Ergasia>();  //Vector progrmmatismenwn ergasiwn
    private Vector<IstorikoErgasiwn> istoriko = new Vector<IstorikoErgasiwn>(); //Vector istorikou ergasiwn
    
    //kataskevasths
    public Texnikos(String onoma, String epitheto, String dieythinsi, String thl, String AT){
        super(onoma, epitheto, dieythinsi, thl, AT);       
    }
    
    //prostiki programmatismenhs ergasias
    public void addErgasia(Ergasia e){
        ergasies.add(e);
    }
    
    //diagrafi programmatismenhs ergasias
    public void removeErgasia(Ergasia e){
        ergasies.remove(e);
    }
    
    //get sygkekrimenh ergasia 
    public Ergasia getErgasia(int i){
        return ergasies.get(i);
    }
    
    //get oles tis ergasies 
    public Vector<Ergasia> getErgasies(){
        return ergasies;
    }
    
    //prosthiki oloklhrwmwnhs ergasias
    public void addIstorikoErgasiwn(IstorikoErgasiwn h){
        istoriko.add(h);
    }
    
    //diagrafi oloklhrwmwnhs ergasias
    public void removeIstorikoErgasiwn(IstorikoErgasiwn h){
        istoriko.remove(h);
    }
    
    //get syskekrimenh oloklhrwmenh ergasia
    public IstorikoErgasiwn getIstorikoErgasiwn(int i){
        return istoriko.get(i);
    }
    
    //prosthiki diathesimotitas
    public void addToDiathesimotita(Diathesimotita av){
        a.add(av);
    }
    
    //diagrafi apo thn diathesimotita
    public void removeFromDiathesimotita(int i){
        a.remove(i);
    }
    
    //get diathesimotita
    public Vector<Diathesimotita> getDiathesimotita(){
        return a;
    }

}
