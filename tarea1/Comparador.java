public class Comparador{
	
	//ATRIBUTOS
	//vectores y matrices
	private boolean restriciones[][];
	private int costo[];


	//largos
	private int nRestri, nMatriz, nArbol; //nRes seria filas , nMat seria columnas

	//test de arbol
	private Comparador[] hijo[];
	//contructor
	public Comparador(int costo[], boolean restriciones[][], int nRestri, int nMatriz){
		this.costo=costo; //vector de costos
		this.restriciones=restriciones;  //matriz de restricciones
		this.nRestri=nRestri;
		this.nMatriz=nMatriz;
		this.nArbol=nMatriz-1;
	}
	


	public boolean esFactible(boolean vectorFactible[]){ //veremos si la solucion es factible
		int i=0,j=0;  // para la matriz son: i filas (restricciones) , j columnas (variables)
		//para el vector: j es variable (verificando si esta activa o no)

		do{
			j=0; //se reinicia el contador de j
			boolean factible=false; //se utilizara para saber si es factible con la restriccion actual
			do{
				if(restriciones[i][j]==true){   //si contiene 1 (true) 
					if(restriciones[i][j]==vectorFactible[j]){   //se verifica si es que vectorFactible tenga true
						factible=true; //si cumple la restriccion, ya que la sumatoria es >=1
						break;
					}
				}
				j++;
			}while(j<nMatriz);

			if(factible==false){ //aqui pregunto: ¿mi solucion vectorFactible fue satisfacio la restriccion?
				return false; //en caso de que no retorno false
			}

			i++; 
		}while(i<nRestri);
		
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