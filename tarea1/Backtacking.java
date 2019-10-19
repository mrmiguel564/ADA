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
           System.out.println(solucion);

            comp.comparar(solucion);                               
        }else{
            ArrayList<Boolean> solucion1=new ArrayList<Boolean>(solucion);
            ArrayList<Boolean> solucion2=new ArrayList<Boolean>(solucion);
            start(etapa+1,false,solucion1);
            start(etapa+1,true,solucion2);
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