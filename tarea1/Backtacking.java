import java.util.List;
import java.util.ArrayList;

public class Backtacking{
    int nMatriz;
    Comparador comp;
    ArrayList<Boolean> solucion;
    int etapa;
    boolean solucionFinal[]; 
    ArrayList<Boolean> temp;
    int mejor_costo;

    public Backtacking(int nMatriz ,Comparador comp, ArrayList<Boolean> solucion, int etapa, boolean solucionFinal[],int mejor_costo ){
        this.nMatriz=nMatriz;;
        this.comp=comp;
        this.etapa=etapa;
        this.solucionFinal=solucionFinal;
        this.mejor_costo=mejor_costo;
        temp = new ArrayList<Boolean>();
        for(int i=0;i<nMatriz;i++){

            temp.add(true);

        }
        this.solucion = new ArrayList<Boolean>(temp);
}

public void start(int etapa){
    if (etapa<nMatriz){        
        solucion.set(etapa,false);
        if(comp.esFactible(solucion)){
            if(solucion.size()==nMatriz){ // NODO FINAL FACTIBLE
                comp.comparar(solucion);
                //idear como guardar la wea 
            }else{
                                           // NODO POSIBLE FACTIBLE
           // Backtacking back = new Backtacking(nMatriz, comp ,solucion, etapa+1, solucionFinal, mejor_costo); 
            start(etapa+1);
            //

            }
        }
    
          solucion.set(etapa,true);
        if(comp.esFactible(solucion)){
            if(solucion.size()==nMatriz){ 
                comp.comparar(solucion);
            }else{
                                           // NODO POSIBLE FACTIBLE
           // Backtacking back = new Backtacking(nMatriz, comp ,solucion, etapa+1, solucionFinal,mejor_costo); 
            start(etapa+1);
            //

            }
        }
    }
}




  public static void imprimirArray (ArrayList lista){
   
        for(int i=0;i<lista.size();i++){
            System.out.print("\t"+lista.get(i));
        }
        System.out.println();
    }


}