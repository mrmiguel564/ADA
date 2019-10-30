import java.util.List;
import java.util.ArrayList;

public class Backtacking{
    Comparador comp;

    public Backtacking(Comparador comp){
        this.comp=comp;
    }

    public void start(int etapa, boolean combinacion, ArrayList<Boolean> solucion){

        solucion.add(etapa,combinacion);
        if(comp.esFactible(solucion)){ // se pregunta si, es factible hasta ahora?
            if(comp.estaraTodos(solucion)){  //esta completo el vector?
               //System.out.println(solucion);
                comp.comparar(solucion); //se vee si es mejor solucion que la actual                     
            }else{
                start(etapa+1,false,new ArrayList<Boolean>(solucion));
                start(etapa+1,true,new ArrayList<Boolean>(solucion));
            }
        }
    }
}