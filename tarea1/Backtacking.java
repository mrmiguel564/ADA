import java.util.List;
import java.util.ArrayList;

public class Backtacking{
    int nMatriz;
    Comparador comp;

    public Backtacking(int nMatriz ,Comparador comp){
        this.nMatriz=nMatriz;
        this.comp=comp;
}

public void start(int etapa, boolean combinacion, ArrayList<Boolean> solucion){
    solucion.add(etapa,combinacion);
    if(comp.esFactible(solucion)){
        if(comp.estaraTodos(solucion)){             
            comp.comparar(solucion);                               
        }else{
            start(etapa+1,false,solucion);
            start(etapa+1,true,solucion);
        }
    }
}

public void imprimirArray (ArrayList lista){
   
        for(int i=0;i<lista.size();i++){
            System.out.print("\t"+lista.get(i));
        }
        System.out.println();
    }


}