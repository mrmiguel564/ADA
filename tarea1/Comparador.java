import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
public  class Comparador{
	//ATRIBUTOS
	private boolean restriciones[][];
	private int costo[],arradidad[];
	private int nRestri, nMatriz; //nRes seria filas , nMat seria columnas
	private int bestCandidato ; 
	private ArrayList<Boolean> bestVector;

	//CONSTRUCTOR
	public Comparador(int arradidad[],int costo[], boolean restriciones[][], int nRestri, int nMatriz){
		this.costo=costo; //vector de costos
		this.restriciones=restriciones;  //matriz de restricciones
		this.nRestri=nRestri;
		this.nMatriz=nMatriz;		
		this.arradidad=arradidad;
		this.bestCandidato=2147483647; //numero maximo que puede ser tomado
		this.bestVector = new ArrayList<Boolean>();
	}

	//GETTERS
	public int getBestCandidato(){
		return this.bestCandidato;
	}
	public ArrayList<Boolean> getBestVector(){
		return this.bestVector;
	}

	//METODOS
	public boolean estaraTodos(ArrayList<Boolean> vectorFactible){ //verifica que el vector este completo
		if(nMatriz==vectorFactible.size()){
			return true;
		}else{
			return false;
		}
	}

	public boolean esFactible(ArrayList<Boolean> vectorFactible){ //veremos si la solucion es factible
		if(vectorFactible.size()>nMatriz){
			return false;
		}
		for(int i=0;i<nRestri;i++){  //toma el indice de restricciones
			int count=0; //sirve para contar las variables que no cumple
			for(int j=0;j<vectorFactible.size();j++){  //toma el indice de variables
				//si la variable esta activa en restriccion y la del vectorFactible es falsa
				if(restriciones[i][j]&& !(boolean)vectorFactible.get(j))count=count+1; //aumento el contador de variables no activas
			}	
			if(count==arradidad[i])return false; 	// si se encuentra una restricion no satifecha, no es solucion y no lo sera nunca							
		}
		return true; //se retorna el estado de factibilidad
	}

	public synchronized void comparar(ArrayList<Boolean> vectorFactible){ // retornaremos la solucion minima del vector dado
		int total=0;
		for (int i=0;i<vectorFactible.size();i++){
			if(vectorFactible.get(i)){ 		//si el valor es true (1) seria costo*1 osea costo
				total=total+costo[i]; //voy obteniendo el valor
			}
		} 
		
		if(total<this.bestCandidato){ //comparo el total con mi candidato actual
			imprimirArray(vectorFactible);	
			System.out.println("\t"+total+"\t");
					
			this.bestCandidato=total;
			this.bestVector = new ArrayList<Boolean>(vectorFactible); //vectorFactible.get(i)

			FileWriter fichero = null;
		try {

			fichero = new FileWriter("fichero_escritura.txt");

			// Escribimos linea a linea en el fichero
			
				fichero.write(total + "\t" +vectorFactible);
			

			fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}


		}
	}

	public static void imprimirArray (ArrayList lista){ //se usa en caso de que sea necesario
        for(int i=0;i<lista.size();i++){
        	if(lista.get(i).equals(true)){
        		System.out.print("1");
        	}else{
        		System.out.print("0");
        	}
           
        }
        System.out.println();
    }
}
