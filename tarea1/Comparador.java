import java.util.List;
import java.util.ArrayList;
public class Comparador{
	
	//ATRIBUTOS
	//vectores y matrices
	private boolean restriciones[][];
	private int costo[],arradidad[];


	//largos
	private int nRestri, nMatriz, nArbol; //nRes seria filas , nMat seria columnas

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
	}


	public boolean esFactible(ArrayList<Boolean> vectorFactible){ //veremos si la solucion es factible
		int i=0;// para la matriz son: i filas (restricciones) , j columnas (variables)
					//para el vector: j es variable (verificando si esta activa o no)
		while(i<nRestri ){
			int count=0;
			int j=0;
			boolean factible=true; //se utilizara para saber si es factible con la restriccion actual
			
			while(j<vectorFactible.size()){

				if(restriciones[i][j]==true){//si contiene 1 (true)
					if(!(boolean)vectorFactible.get(j)){   //se verifica si es que vectorFactible tenga true
						count++;
						if(count==arradidad[i]){ // si se encuentran todas las resticiones no satifacidas, no es solucion

						return false;
						}
					}
				}

				j++;
			} //antes nMatriz
			
			i++; 
		}
		
		return true; //si termine el ciclo, significa que fue factible para todas las restricciones
	}

	public int minimizar(boolean vectorFactible[]){ // retornaremos la solucion minima del vector dado
		int min=0,boleano;
		for (int i=0;i<nMatriz;i++){
			if(vectorFactible[i]==true){ //si el valor es true (1) seria costo*1 osea costo
				min=min+costo[i]; //voy obteniendo el valor
			}
		}
		return min;
	}

}
