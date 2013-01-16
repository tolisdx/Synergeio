
package Synergeio;

import java.util.Vector;

//o pelatis klhronomei apo thn Person
public class Customer extends Person{
    
    private String asfalistikhEtairia; //exei mia epipleon idiothta gia asfalistikh etairia
    //Vector progrmmatismenw ergasiwn
    private Vector<Ergasia> ergasies = new Vector<Ergasia>();
    //Vector oloklhromenwn ergasiwn
    private Vector<IstorikoErgasiwn> istoriko = new Vector<IstorikoErgasiwn>();
    
    //kataskevasths
    public Customer(String onoma, String epitheto, String dieythinsi, String thl, String AT, String asfalisikh){
        super(onoma, epitheto, dieythinsi, thl, AT);       
        this.asfalistikhEtairia = asfalisikh;
    }
    
    //prosthiki progrmmatismenhs ergasias
    public void addErgasia(Ergasia e){
        ergasies.add(e);
    }
    
    //diagrafi programmatismenhs ergasias
    public void removeErgasia(Ergasia e){
        ergasies.remove(e);
    }
    
    //get progamm ergasias
    public Ergasia getErgasia(int i){
        return ergasies.get(i);
    }
    
    //get oles tis ergasies
    public Vector<Ergasia> getErgasies(){
        return this.ergasies;
    }
    
    //prosthiki oloklhrwmenhs ergasias sto istoriko 
    public void addIstorikoErgasiwn(IstorikoErgasiwn h){
        istoriko.add(h);
    }
    
    //diagrafi ergasias 
    public void removeIstorikoErgasiwn(IstorikoErgasiwn h){
        istoriko.remove(h);
    }
    
    //get oloklhrwmenh ergasia
    public IstorikoErgasiwn getIstorikoErgasiwn(int i){
        return istoriko.get(i);
    }
    
    //set asfalistikh
    public void setAsfalistikhEtairia(String asfalistiki){
        this.asfalistikhEtairia = asfalistiki;
    }
    
    //get asfalistikh
    public String getAsfalistikhEtairia(){
        return this.asfalistikhEtairia;
    }

}
