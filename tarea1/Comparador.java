import java.util.List;
import java.util.ArrayList;
public class Comparador{
	
	//ATRIBUTOS
	//vectores y matrices
	private boolean restriciones[][];
	private int costo[],arradidad[];


	//largos
	private int nRestri, nMatriz, nArbol ; 
	public int bestcandidato ; //nRes seria filas , nMat seria columnas
	public ArrayList<Boolean> bestvector;
	//test de arbol
	private Comparador[] hijo[];
	//contructor
	public Comparador(int arradidad[],int costo[], boolean restriciones[][], int nRestri, int nMatriz){
		this.costo=costo; //vector de costos
		this.restriciones=restriciones;  //matriz de restricciones
		this.nRestri=nRestri;
		this.nMatriz=nMatriz;
		this.nArbol=nMatriz-1;
		this.arradidad=arradidad;
		this.bestcandidato=2147483647;
	}


	public boolean esFactible(ArrayList<Boolean> vectorFactible){ //veremos si la solucion es factible
		int i=0;// para la matriz son: i filas (restricciones) , j columnas (variables)
		if(vectorFactible.size()>nMatriz){
			System.out.println("es demaciado largo no es factible");
			return false;
		}
		boolean factible=true;			//para el vector: j es variable (verificando si esta activa o no)
		while(i<nRestri ){
			int count=0;
			int j=0;
			 //se utilizara para saber si es factible con la restriccion actual
			
			while(j<vectorFactible.size()){

				if(restriciones[i][j]){//si contiene 1 (true)
					if(!(boolean)vectorFactible.get(j)){   //se verifica si es que vectorFactible tenga true
						count++;

						if(count==arradidad[i]){ // si se encuentran todas las resticiones no satifacidas, no es solucion

						factible=false;
						System.out.println("NO-factible");
						return factible;
						}
					}
				}

				j++;
			} //antes nMatriz
			
			i++; 
		}

		if(vectorFactible.size()==nMatriz){
		//	System.out.print("ES SOLUCION");
		//imprimirArray(vectorFactible);
	}
		return factible; //si termine el ciclo, significa que fue factible para todas las restricciones

	}

	public int minimizar(ArrayList<Boolean> vectorFactible){ // retornaremos la solucion minima del vector dado
		int min=0,boleano;
		for (int i=0;i<nMatriz;i++){
			if(vectorFactible.get(i)){ //si el valor es true (1) seria costo*1 osea costo
				min=min+costo[i]; //voy obteniendo el valor
			}
		}
		return min;
	}
	  public static void imprimirArray (ArrayList lista){
   
        for(int i=0;i<lista.size();i++){
            System.out.print("\t"+lista.get(i));
        }
        System.out.println();
    }

  

}
