package modelo;

public class Menu {
	
	public final static int SALIR = 0;
	
	public final static int CABALLEROS = 1;
	public final static int ARMAS = 2;
	public final static int ESCUDOS = 3;
	public final static int LUCHAS = 4;
	public final static int CABALLOS = 5;
	public final static int ESCUDEROS = 6;
	public static final int JUEGO = 7;
	
	public final static int VER_CABALLEROS = 1;
	public final static int INSERTAR_CABALLEROS = 2;
	public final static int ELIMINAR_CABALLEROS = 3;
	public final static int MODIFICAR_CABALLEROS = 4;
	
	public final static int VER_ESCUDOS = 1;
	public final static int INSERTAR_ESCUDOS = 2;
	public final static int ELIMINAR_ESCUDOS = 3;
	public final static int MODIFICAR_ESCUDOS = 4;
	
	public final static int VER_ARMAS = 1;
	public final static int INSERTAR_ARMAS = 2;
	public final static int ELIMINAR_ARMA = 3;
	public final static int MODIFICAR_ARMA = 4;
	
	public final static int VER_LUCHAS = 1;
	public final static int INSERTAR_LUCHA = 2;
	public final static int ELIMINAR_LUCHA = 3;
	public final static int MODIFICAR_LUCHA = 4;
	
	public final static int VER_CABALLOS = 1;
	public final static int INSERTAR_CABALLOS = 2;
	public final static int ELIMINAR_CABALLOS = 3;
	public final static int MODIFICAR_CABALLOS = 4;
	
	public final static int VER_ESCUDEROS = 1;
	public final static int INSERTAR_ESCUDEROS = 2;
	public final static int ELIMINAR_ESCUDEROS = 3;
	public final static int MODIFICAR_ESCUDEROS = 4;


	
	
	public static void menuPrincipal() {
		
		System.out.println("\n--MENU--");
		System.out.println(SALIR + "- Salir del programa");
		System.out.println(CABALLEROS + "- Entrar al menu de caballeros");
		System.out.println(ARMAS + "- Entrar al menu de armas");
		System.out.println(ESCUDOS + "- Entrar al menu de escudos");
		System.out.println(LUCHAS + "- Entrar al menu de lucha");
		System.out.println(CABALLOS + "- Entrar al menu de caballos");
		System.out.println(ESCUDEROS + "- Entrar al menu de escuderos");
		System.out.println(JUEGO + "- Entrar a la interfaz de peleas");
	}
	
	public static void menuCaballeros() {
		System.out.println("\n--MENU--");
		System.out.println(SALIR + "- Salir");
		System.out.println(VER_CABALLEROS + "- Visualizar todos los caballeros");
		System.out.println(INSERTAR_CABALLEROS + "- Crear caballeros nuevos");
		System.out.println(ELIMINAR_CABALLEROS + "- Elimina caballeros");
		System.out.println(MODIFICAR_CABALLEROS + "- Modifica los caballeros ya creados");
	}
	
	public static void menuEscudos(){
		
		System.out.println("\n--MENU--");
		System.out.println(SALIR + "- Salir");
		System.out.println(VER_ESCUDOS + "- Visualizar todos los escudos");
		System.out.println(INSERTAR_ESCUDOS + "- Crear escudos nuevos");
		System.out.println(ELIMINAR_ESCUDOS + "- Elimina escudos");
		System.out.println(MODIFICAR_ESCUDOS + "- Modifica los escudos ya creados");
	}
  
	public static void menuArmas(){
		
		System.out.println("\n--MENU--");
		System.out.println(SALIR + "- Salir");
		System.out.println(VER_ARMAS + "- Visualizar todas las armas");
		System.out.println(INSERTAR_ARMAS + "- Crear armas nuevas");
		System.out.println(ELIMINAR_ARMA + "- Elimina armas");
		System.out.println(MODIFICAR_ARMA + "- Modifica las armas ya creadas");
	}
	
	public static void menuLucha() {
		System.out.println("\n--MENU--");
		System.out.println(SALIR + "- Salir");
		System.out.println(VER_LUCHAS + "- Visualizar todas las luchas");
		System.out.println(INSERTAR_LUCHA + "- Comenzar enfrentamientos nuevos");
		System.out.println(ELIMINAR_LUCHA +"- Elimina luchas del historial");
		System.out.println(MODIFICAR_LUCHA +"- Modifica las luchas ya finalizadas");
	}
	
	public static void menuCaballos() {
		System.out.println("\n--MENU--");
		System.out.println(SALIR + "- Salir");
		System.out.println(VER_CABALLOS + "- Visualizar todos los caballos");
		System.out.println(INSERTAR_CABALLOS + "- Crear un nuevo caballo");
		System.out.println(ELIMINAR_CABALLOS +"- Elimina los caballos existentes");
		System.out.println(MODIFICAR_CABALLOS +"- Modifica los caballos existentes");
	
	}
	
	public static void menuEscuderos() {
		System.out.println("\n--MENU--");
		System.out.println(SALIR + "- Salir");
		System.out.println(VER_ESCUDEROS + "- Visualizar todos los escuderos");
		System.out.println(INSERTAR_ESCUDEROS + "- Crear un nuevo escudero");
		System.out.println(ELIMINAR_ESCUDEROS +"- Elimina los escuderos existentes");
		System.out.println(MODIFICAR_ESCUDEROS +"- Modifica los escuderos existentes");
	}
	
}
