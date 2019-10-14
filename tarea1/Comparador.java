import java.util.List;
import java.util.ArrayList;
public  class Comparador{
	//ATRIBUTOS
	//vectores y matrices
	private boolean restriciones[][];
	private int costo[],arradidad[];
	private int nRestri, nMatriz, nArbol, test; 
	public int bestcandidato ; //nRes seria filas , nMat seria columnas
	public ArrayList<Boolean> bestvector;


	public Comparador(int arradidad[],int costo[], boolean restriciones[][], int nRestri, int nMatriz){
		this.costo=costo; //vector de costos
		this.restriciones=restriciones;  //matriz de restricciones
		this.nRestri=nRestri;
		this.nMatriz=nMatriz;		
		this.arradidad=arradidad;
		this.bestcandidato=2147483647; //numero maximo que puede ser tomado
		this.bestvector = new ArrayList<Boolean>();
	}
public boolean estaraTodos(ArrayList<Boolean> vectorFactible){
	if(nMatriz==vectorFactible.size()){
		return true;
	}else{
		return false;
	}
}

public boolean esFactible(ArrayList<Boolean> vectorFactible){ //veremos si la solucion es factible
	boolean factible=true;												// para la matriz son: i filas (restricciones) , j columnas (variables)
	if(vectorFactible.size()>nMatriz){
		return false;

	}
	for(int i=0;i<nRestri;i++){
		int count=0;
			for(int j=0;j<vectorFactible.size();j++){
				if(restriciones[i][j]&& !(boolean)vectorFactible.get(j))count=count+1;
			}	
			if(count==arradidad[i])factible=false; 	// si se encuentra una restricion no satifecha, no es solucion y no lo sera nunca							
		}
	if(factible)System.out.println("F :"+ vectorFactible);
	if(!factible)System.out.println("N :"+ vectorFactible);
	return factible; //si termine el ciclo, significa que fue factible para todas las restricciones
}

	public void comparar(ArrayList<Boolean> vectorFactible){ // retornaremos la solucion minima del vector dado
		int total=0;

		for (int i=0;i<vectorFactible.size();i++){
			if(vectorFactible.get(i)){ 			//si el valor es true (1) seria costo*1 osea costo
				total=total+costo[i]; //voy obteniendo el valor
			}
		} 
		System.out.println(total+"<"+bestcandidato);
		if(total<bestcandidato){
			bestcandidato=total;
			for(int i=0;i<nMatriz;i++){
				bestvector = new ArrayList<Boolean>(vectorFactible); //vectorFactible.get(i)
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
