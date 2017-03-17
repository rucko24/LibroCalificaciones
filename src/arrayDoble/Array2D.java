package arrayDoble;
/*
 * libro de calificaciones de Array 2D
 */
import java.text.DecimalFormat;
public class Array2D {
	
	private String descripcion;
	private int calificaciones[][];
	private DecimalFormat dosDigi = new DecimalFormat("0.00");
	
	public Array2D( String descripcion, int calificaciones[][]) {
	
		this.descripcion = descripcion;
		this.calificaciones = calificaciones;
		
		init();
	}
	
	
	public void init() {
	
		print(this.descripcion+"\n");
		mostrarNotas();
		print("\n\nNotas");
		print("\nMINIMA: "+calificacionMinima()+" - MAXIMA: "+calificacionMaxima()+"\n");
		distribucionDeCalificaciones();
	}
	
	/*
	/	Calificación Minima
	*/
	public int calificacionMinima() {
	
		int min = calificaciones[0][0];
		for( int tmpCalif[] : calificaciones) {
			for( int tmpCalif2 : tmpCalif) {
				if( tmpCalif2 < min) {
					min = tmpCalif2;
				}
			}
		}
		return min;
	
	}
	/*
	/	Calificación  Maxima
	*/
	public int calificacionMaxima() {
		
		int max = calificaciones[0][0];
		for( int tmpCalif[] : calificaciones) {
			for( int tmpCalif2 : tmpCalif ) {
				if( tmpCalif2 > max) {
					max = tmpCalif2;
				}
			}
		}
		
		return max;
	}
	
	/*
	/	Obtener Promedio
	*/
	public double getPromedio( int calificaciones[]) {
		
		int suma = 0;
		
		for( int tmp : calificaciones) 
			suma += tmp;
		
		return (double) suma / calificaciones.length;
	}
	
	/*
	/	Mostrar Notas
	*/
	public void mostrarNotas() {
		
		print("\nLas Calificaciones son----\n");
		print("\t\t"); //Alinear las columnas 
		
		for( int f=0; f<calificaciones[0].length; f++ ) {
			print("Prueba "+(f+1)+" ");
		}
		
		print("\tPromedio ");
		
		for( int f=0; f<calificaciones.length; f++ ) {
			print("\nEstudiante "+(f+1)+":");
			/* for( int c=0; c<calificaciones[f].length; c++ ) {
			   	print("\t"+calificaciones[f][c]);
			   }
			*/
			for( int c : calificaciones[f]) {
				print("\t  "+c);
			}
				
			double promedio = getPromedio(calificaciones[f]);
			print("\t\t "+dosDigi.format(promedio));
		}	
	}
	/*
	/	Distribucion de Calificaciones
	*/
	public void distribucionDeCalificaciones() {
		
		print("\nDistribucion de notas\n");
		
		int fre[] = new int[11];
		
		/*	Con for-anidado
		for( int f=0; f<calificaciones.length; f++ ) {
			for( int c=0; c<calificaciones[f].length; c++ ) {
				++fre[calificaciones[f][c] / 10];
			}
		}	
		/
		*/
	
		//con doble for extendido
		for( int f[] : calificaciones ) {
			for( int c : f) {
				++fre[ c / 10 ];	
			}
		}
		
		for( int f=0; f<fre.length; f++) {
			
			if( f == 10)
				print("\n  100: ");
			else 
				print("\n"+f*10+"-"+((f*10)+9)+": ");
			
			for( int c=0; c<fre[f]; c++ ) {
				print(" *");
			}
		}
		print("\n");
		
	}
	
	public static void print( String s ) { System.out.print(s); }
	public static void main(String[] args) {
		
		int arrayNotas[][] = {{87,96,70},
				     {68,87,90},
				     {94,100,90},
				     {100,81,82},
				     {83,65,85},
				     {78,87,65},
				     {85,75,83},
				     {91,94,100},
				     {76,72,84},
				     {87,93,73}};
		
		new Array2D("Libro de Calificaciones", arrayNotas);
		
		 print("hola testeando brach");
	}
}
