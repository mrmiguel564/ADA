import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
		
    public static void main(String[] args) {
        boolean ayuda=false; //estado para los printf

        int numeroEntero, sumaInt = 0;
        double numeroDouble, sumaDouble = 0;

        File f = new File("scp41.txt");

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
        int arradidad[]= new int[nRestri];
  			for(int i=0;i<nRestri;i++) {  //ultima para tomar las restricciones
          arradidad[i]=entrada.nextInt(); // sirve para detenernos en cada restriccion
          if(ayuda)System.out.println("aridad: "+arradidad[i]);
               
          for(int j=0;j<arradidad[i];j++) {
            int wea = entrada.nextInt(); //guarda las variables activas en las restricciones
            if(ayuda)System.out.print(" "+wea);
              restriciones[i][wea-1]=true; // nuestras restriciones
  				  }
            if(ayuda)System.out.println();
  			}

        Comparador comp = new Comparador(arradidad,costo,restriciones,nRestri,nMatriz);
     //   if(comp.esFactible(temp))System.out.println("pichulita");
        Backtacking back = new Backtacking(nMatriz, comp);
        back.start(0,false,new ArrayList<Boolean>());
        back.start(0,true,new ArrayList<Boolean>());

        System.out.println("costo minimo :\t"+comp.bestcandidato);
        System.out.println("best vector :\t"+comp.bestvector);
        //-------------------------------------------------------------------------------
        // mostrarRestricciones(restriciones,nRestri,nMatriz);

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
    

  public static void imprimirArray (ArrayList lista){
   
        for(int i=0;i<lista.size();i++){
            System.out.print("\t"+lista.get(i));
        }
        System.out.println();
    }

}
