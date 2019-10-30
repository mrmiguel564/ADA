import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{
	public static void main(String[] args) {
		Lector l= new Lector(); //leera el archivo y obtendra la aridad, costos, restricciones, numero de restricciones y numero de variables
		if(l.readFile()){ //si todo salio bien
			Comparador comp = new Comparador(l.getAridad(),l.getCosto(),l.getRestricciones(),l.getNRestri(),l.getNMatriz());
			///
			long tInicio, tFin, tiempo; //Variables para determinar el tiempo de ejecución
			tInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
			///
			Backtacking back = new Backtacking(comp);
			back.start(0,false,new ArrayList<Boolean>());
			back.start(0,true,new ArrayList<Boolean>());
			///
			tFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
			tiempo = tFin - tInicio; //Calculamos los milisegundos de diferencia
			System.out.println("Tiempo de ejecucion en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
			///
			System.out.println("Costo minimo :\t"+comp.getBestCandidato());
			System.out.println("Best vector :\t"+comp.getBestVector());
		}else{  
			System.out.println("Hubo un problema");
		}
	}
}