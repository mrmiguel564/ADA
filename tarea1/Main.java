import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
		
    public static void main(String[] args) {
        int numeroEntero, sumaInt = 0;
        double numeroDouble, sumaDouble = 0;

        File f = new File("scp1.txt");

        try  (Scanner entrada = new Scanner(f)) {
        	int nRestri = entrada.nextInt();
          System.out.println(nRestri); //retricciones 5
        	int nMatriz = entrada.nextInt();
          System.out.println(nMatriz);  //variables

          //se hará una matriz de 5 filas y 6 restricc
        	boolean restriciones[][]= new boolean[nRestri][nMatriz]; //matriz booleana

        	int costo[]= new int [nMatriz]; //almacena los costos 65 55 60 45 40 50                   

            for(int i=0;i<nMatriz;i++) { //relleno los costos
  
               	costo[i] = entrada.nextInt(); 
                //System.out.println(costo[i]);
  			    }


  			for(int i=0;i<nRestri;i++) {  //ultima para tomar las restricciones
               int arradidad = entrada.nextInt(); // sirve para detenernos en cada restriccion
               System.out.println("aridad: "+arradidad);
              for(int j=0;j<arradidad;j++) {
                int wea = entrada.nextInt(); //guarda las variables activas en las restricciones
                System.out.println("wea: "+wea);
                restriciones[i][wea-1]=true; // nuestras restriciones
  				    }
  			}

        mostrarRestricciones(restriciones,nRestri,nMatriz);

        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void mostrarRestricciones(boolean restriciones[][],int nRestri,int nMatriz){
      for (int i=0;i<nRestri;i++) {
        for (int j=0;j<nMatriz;j++) {
          System.out.print(restriciones[i][j]);
          System.out.print(" ");
        }
        System.out.println();
      }
    }
}