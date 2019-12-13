import java.util.List;
import java.util.ArrayList;


public class Backtacking extends Thread {
    Comparador comp;
    ArrayList<Boolean> estadoInicial;
    public Backtacking(Comparador comp,ArrayList<Boolean> estadoInicial){
        this.comp=comp;
        this.estadoInicial=estadoInicial;
    }
    public void run(){
        Backtacking(2,false,new ArrayList<Boolean>(estadoInicial));
        Backtacking(2,true,new ArrayList<Boolean>(estadoInicial));

    }

    public void Backtacking(int etapa, boolean combinacion, ArrayList<Boolean> solucion){

        solucion.add(etapa,combinacion);
        if(comp.esFactible(solucion)){ // se pregunta si, es factible hasta ahora?
            if(comp.estaraTodos(solucion)){  //esta completo el vector?
                //System.out.println(solucion);
                comp.comparar(solucion); //se vee si es mejor solucion que la actual                     
            }else{
                Backtacking(etapa+1,false,new ArrayList<Boolean>(solucion));
                Backtacking(etapa+1,true,new ArrayList<Boolean>(solucion));
            }
        }
    }
}