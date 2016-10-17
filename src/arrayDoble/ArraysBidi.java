package arrayDoble;
/*
 * libro de calificaciones de array
 */
import java.text.DecimalFormat;
public class ArraysBidi {
	
	private String nombre;
	private int calificaciones[][];
	private DecimalFormat dosDigi = new DecimalFormat("0.00");
	
	public ArraysBidi( String nombre, int calificaciones[][]) {
	
		this.nombre = nombre;
		this.calificaciones = calificaciones;
	
	}
	
	public void setNombre( String nombre ) { this.nombre = nombre; }
	public String getNombre() { return nombre; }
	
	public void mostrar() {
	
		print("\nBienvenido al libro de calificaciones "+getNombre());
		mostrarNotas();
		print("\n\nNotas");
		print("\nMINIMA: "+notaMinima()+"- MAXIMA: "+notaMaxima()+"\n");
		distribucionDeNotas();
	}
	
	public int notaMinima() {
	
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
	
	public int notaMaxima() {
		
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
	
	public double getPromedio( int calificaciones[]) {
		
		int suma = 0;
		
		for( int tmp : calificaciones) 
			suma += tmp;
		
		return (double) suma / calificaciones.length;
	}
	
	public void mostrarNotas() {
		
		print("\nLas Calificaciones son----\n");
		print("\t\t"); //alinea las columnas 
		
		for( int f=0; f<calificaciones[0].length; f++ ) {
			print("Prueba "+(f+1)+" ");
		}
		
		print("\tPromedio ");
		
		for( int f=0; f<calificaciones.length; f++ ) {
			print("\nEstudiante "+(f+1)+":");
			
			for( int c : calificaciones[f]) {
				print("\t  "+c);
			}
				
			double promedio = getPromedio(calificaciones[f]);
			print("\t\t "+dosDigi.format(promedio));
		}	
	}
	
	public void distribucionDeNotas() {
		
		print("\nDistribucion de notas\n");
		
		int fre[] = new int[11];
		
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
		
		
	}
	
	public static void println( String s) { System.out.println(s);}
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
		
		ArraysBidi o = new ArraysBidi(" Escuela de lacras", arrayNotas);
		o.mostrar();
		 
	}
}
