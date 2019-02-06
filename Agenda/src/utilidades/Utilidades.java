package utilidades;

public class Utilidades {
	
	//CONSTANTES TABLA USUARIOS
	public static final String TABLA_USUARIO = "usuarios";
	public static final String CAMPO_ID = "id";
	public static final String CAMPO_NOMBRE = "nombre";
	public static final String CAMPO_EMAIL = "email";


	public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " + TABLA_USUARIO+" ("+ CAMPO_ID +" INTEGER, "+ CAMPO_NOMBRE + " TEXT, "+CAMPO_EMAIL+" TEXT)"; 

	
}
