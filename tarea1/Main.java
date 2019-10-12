import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
		
    public static void main(String[] args) {
        boolean ayuda=true; //estado para los printf

        int numeroEntero, sumaInt = 0;
        double numeroDouble, sumaDouble = 0;

        File f = new File("scp1.txt");

        try  (Scanner entrada = new Scanner(f)) {
        	int nRestri = entrada.nextInt();
          if(ayuda){System.out.println("cantidad de restriciones: "+nRestri);} //retricciones 5
        	int nMatriz = entrada.nextInt();
          if(ayuda){System.out.println("largo del vector: "+nMatriz);}  //variables

          //se hará una matriz de 5 filas y 6 restricc
        	boolean restriciones[][]= new boolean[nRestri][nMatriz]; //matriz booleana

        	int costo[]= new int [nMatriz]; //almacena los costos 65 55 60 45 40 50                   
              if(ayuda)System.out.print("el vector costo es: [");
            for(int i=0;i<nMatriz;i++) { //relleno los costos
                
               	costo[i] = entrada.nextInt(); 
                if(ayuda){System.out.print(costo[i]+" ");}
  			    }
            if(ayuda)System.out.println("]");

  			for(int i=0;i<nRestri;i++) {  //ultima para tomar las restricciones
               int arradidad = entrada.nextInt(); // sirve para detenernos en cada restriccion
               if(ayuda)System.out.println("aridad: "+arradidad);
              for(int j=0;j<arradidad;j++) {
                int wea = entrada.nextInt(); //guarda las variables activas en las restricciones
                if(ayuda)System.out.print(" "+wea);
                restriciones[i][wea-1]=true; // nuestras restriciones
  				    }
              if(ayuda)System.out.println();
  			}

        //mostrarRestricciones(restriciones,nRestri,nMatriz);
        //----------ESTA ES UNA DEMOSTRACION PARA QUE VEAS COMO FUNCIONA---------------
        Comparador comp=new Comparador(costo,restriciones,nRestri,nMatriz);  //CLASE COMPARADOR
        boolean solucion[]= new boolean[nMatriz];
        boolean solucionFinal[]= new boolean[nMatriz];
        Backtacking(nMatriz, comp ,solucion ,0, solucionFinal);
        boolean vectorDePrueba[]={false,true,false,true,false,true};  // VECTOR QUE CONTIENE UNA POSIBLE SOLUCION

        if(comp.esFactible(vectorDePrueba)){ // si es factible dame la funcion minimizada de esta solucion
          System.out.println("Es factible este vector?: "+true);
          System.out.println("El valor minimo para esta solucion es: "+comp.minimizar(vectorDePrueba));
        }

        //-------------------------------------------------------------------------------

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
    
    public static void Backtacking(int nMatriz ,Comparador comp,boolean solucion[], int etapa,boolean solucionFinal[] ){
    boolean i=false;
    int condition=0;
    if (etapa>nMatriz) return;
    do{
      solucion[etapa]=i;
      if(comp.esFactible(solucion)){
        if(etapa==nMatriz-1){
          //actualizarSolucion
        }else{
          Backtacking(nMatriz, comp ,solucion, etapa+1, solucionFinal);
    
        }

      }
      condition++;
      i=true;
      for (int j=0;j<etapa;j++) {
          System.out.print("asdasd"+solucion[j]);
        }
         System.out.println();
      }while(condition!=1);

  }


}