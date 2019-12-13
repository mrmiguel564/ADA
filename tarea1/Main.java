import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;



public class Main{
	public static void main(String[] args) {
		Lector l= new Lector(); //leera el archivo y obtendra la aridad, costos, restricciones, numero de restricciones y numero de variables
		if(l.readFile()){ //si todo salio bien
			
			Comparador comp = new Comparador(l.getAridad(),l.getCosto(),l.getRestricciones(),l.getNRestri(),l.getNMatriz());

			long tInicio, tFin, tiempo; //Variables para determinar el tiempo de ejecución

			tInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
			
			Thread hilo1 = new Backtacking(comp,new ArrayList<Boolean>(Arrays.asList(false, false,true)));
			Thread hilo2 = new Backtacking(comp,new ArrayList<Boolean>(Arrays.asList(false, true,true)));
			Thread hilo3 = new Backtacking(comp,new ArrayList<Boolean>(Arrays.asList(true, false,true)));
			Thread hilo4 = new Backtacking(comp,new ArrayList<Boolean>(Arrays.asList(true, true,true)));
			Thread hilo5 = new Backtacking(comp,new ArrayList<Boolean>(Arrays.asList(false, false,false)));
			Thread hilo6 = new Backtacking(comp,new ArrayList<Boolean>(Arrays.asList(false, true,false)));
			Thread hilo7 = new Backtacking(comp,new ArrayList<Boolean>(Arrays.asList(true, false,false)));
			Thread hilo8 = new Backtacking(comp,new ArrayList<Boolean>(Arrays.asList(true, true,false)));

			hilo1.start();
			hilo2.start();
			hilo3.start();
			hilo4.start();
			hilo5.start();
			hilo6.start();
			hilo7.start();
			hilo8.start();

		try{
  			hilo1.join();
  			hilo2.join();
  			hilo3.join();
  			hilo4.join();	
			hilo5.join();
  			hilo6.join();
  			hilo7.join();
  			hilo8.join();	

		}catch(InterruptedException ie){}


			tFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
			tiempo = tFin - tInicio; //Calculamos los milisegundos de diferencia
			System.out.println("Tiempo de ejecucion en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
			

			System.out.println("Costo minimo :\t"+ comp.getBestCandidato());
			System.out.println("Best vector :\t"+ comp.getBestVector());
			 

			
		}else{  
			System.out.println("Hubo un problema");
		}
	}
}
