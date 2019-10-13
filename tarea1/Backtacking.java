import java.util.List;
import java.util.ArrayList;

public class Backtacking{
    int nMatriz;
    Comparador comp;
    ArrayList<Boolean> solucion;
    int etapa;
    boolean solucionFinal[]; 
    ArrayList<Boolean> weas;
    int mejor_costo;
    public Backtacking(int nMatriz ,Comparador comp, ArrayList<Boolean> solucion, int etapa, boolean solucionFinal[],int mejor_costo ){
        this.nMatriz=nMatriz;;
        this.comp=comp;
        this.solucion=solucion;
        this.etapa=etapa;
        this.solucionFinal=solucionFinal;
        this.mejor_costo=mejor_costo;
}

public void start(){

    if (etapa<nMatriz){
        
        solucion.add(etapa,false);
        if(comp.esFactible(solucion)){
            if(solucion.size()==nMatriz){ // NODO FINAL FACTIBLE
                if(comp.minimizar(solucion)<comp.bestcandidato){
                    System.out.println("por la chucha");
                    comp.bestcandidato=comp.minimizar(solucion);
                    comp.bestvector=solucion;
                }
                //idear como guardar la wea 
            }else{
                                           // NODO POSIBLE FACTIBLE
            Backtacking back = new Backtacking(nMatriz, comp ,solucion, etapa+1, solucionFinal, mejor_costo); 
            back.start();
            //

            }
        }
    
          solucion.set(etapa,true);
        if(comp.esFactible(solucion)){
            if(solucion.size()==nMatriz){ // NODO FINAL FACTIBLE
                if(comp.minimizar(solucion)<comp.bestcandidato){
                    comp.bestcandidato=comp.minimizar(solucion);
                    comp.bestvector=solucion;
                }
                //idear como guardar la wea 
            }else{
                                           // NODO POSIBLE FACTIBLE
            Backtacking back = new Backtacking(nMatriz, comp ,solucion, etapa+1, solucionFinal,mejor_costo); 
            back.start();
            //

            }
        }
    System.out.println("vector final:\t"+comp.bestvector+"\ncosto minimo :\t"+comp.bestcandidato);
    
    }
}




  public static void imprimirArray (ArrayList lista){
   
        for(int i=0;i<lista.size();i++){
            System.out.print("\t"+lista.get(i));
        }
        System.out.println();
    }


}