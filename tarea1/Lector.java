import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Lector{
	//ATRIBUTOS
	private File f;
	private int[] aridad;
	private int[] costo;
	private boolean[][] restricciones;
	private int nRestri, nMatriz;

	public Lector(){
		this.f=new File("scp41.txt");
	}
	
	public boolean readFile(){
		boolean ayuda=false; //estado para los printf, para mostrar lo que devuelve cada cosa

		try(Scanner entrada = new Scanner(this.f)) {
			this.nRestri = entrada.nextInt(); //retricciones 5
			if(ayuda){System.out.println("Cantidad de restriciones: "+nRestri);}
			this.nMatriz = entrada.nextInt(); //variables 6
			if(ayuda){System.out.println("Numero de variables: "+nMatriz);} 

			//se hará una matriz de 5 filas y 6 restricc
			this.restricciones= new boolean[this.nRestri][this.nMatriz]; //matriz booleana

			this.costo= new int [this.nMatriz]; //almacena los costos 65 55 60 45 40 50

			for(int i=0;i<this.nMatriz;i++) { //relleno los costos
				this.costo[i] = entrada.nextInt();
				//System.out.println(costo[i]);
			}

			this.aridad= new int[nRestri];
			for(int i=0;i<nRestri;i++) {  //ultima para tomar las restricciones
				aridad[i]=entrada.nextInt(); // sirve para detenernos en cada restriccion
				if(ayuda)System.out.println("Aridad: "+aridad[i]);
				for(int j=0;j<aridad[i];j++) {
					int varActiva = entrada.nextInt(); //guarda las variables activas en las restricciones
					if(ayuda)System.out.print(" "+varActiva);
					this.restricciones[i][varActiva-1]=true; // nuestras restriciones con 1
				}
				if(ayuda)System.out.println();
			}
			return true; //logro hacer todas la operaciones
		}catch (FileNotFoundException e) {
			System.out.println(e.toString());
			return false;  //hubo un problema
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;  //hubo un problema
		}
	}

	//GETTERS
	public int[] getCosto(){
		return this.costo;
	}
	public boolean[][] getRestricciones(){
		return this.restricciones;
	}
	public int getNRestri(){
		return this.nRestri;
	}
	public int getNMatriz(){
		return this.nMatriz;
	}
	public int[] getAridad(){
		return this.aridad;
	}

	public void mostrarRestricciones(){
		for (int i=0;i<this.nRestri;i++) {
			for (int j=0;j<this.nMatriz;j++) {
				System.out.print(this.restricciones[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}