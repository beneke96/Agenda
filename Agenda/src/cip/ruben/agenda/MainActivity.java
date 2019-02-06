package cip.ruben.agenda;

import java.util.ArrayList;

import utilidades.Utilidades;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import entidades.Usuarios;

public class MainActivity extends Activity {

	ListView l_personas;
	ArrayList<String> listaInformacion;
	ArrayList<Usuarios> listaUsuario;
	ConexionSqliteHelper conn;
	ArrayAdapter<String> adaptador;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listar();

	}
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		listar();
		
	}
	 //----------------FUNCION LISTAR------------------
	public void listar(){
	conn = new ConexionSqliteHelper(getApplicationContext(), "BD_personas",null, 1);
	l_personas = (ListView) findViewById(R.id.list);
	consultarListaPersonas();
	// para que se pueda abrir el menu contextual al pulsar un item de la
	// listview
	registerForContextMenu(l_personas);

	adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listaInformacion);
	l_personas.setAdapter(adaptador);
	l_personas.setTextFilterEnabled(true);
	//mostrar textview cuando lista este vacia
	l_personas.setEmptyView(findViewById(R.id.resultado_vacio));
	adaptador.notifyDataSetChanged();
	}
	

	//----------------------OBTENER LISTA PARA VISUALIZAR EN EL LISTVIEW------------------------------

	private void consultarListaPersonas() {
		SQLiteDatabase db = conn.getReadableDatabase();

		Usuarios usuario = null;
		listaUsuario = new ArrayList<Usuarios>();
		// select * from usuarios
		Cursor c = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_USUARIO,
				null);

		while (c.moveToNext()) {
			usuario = new Usuarios();
			usuario.setId(c.getInt(0));
			usuario.setNombre(c.getString(1));
			usuario.setEmail(c.getString(2));

			listaUsuario.add(usuario);

		}
		obtenerLista();

	}

	private void obtenerLista() {
		listaInformacion = new ArrayList<String>();

		for (int i = 0; i < listaUsuario.size(); i++) {
			listaInformacion.add(listaUsuario.get(i).getId() + " - "
					+ listaUsuario.get(i).getNombre() + "\n"
					+ listaUsuario.get(i).getEmail());

		}
	}
	//---------------------------MENU CONTEXTUAL-------------------------------------

	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.delete_update_users, menu);

	}
	
	

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		final AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
				.getMenuInfo();
		// guardamos un usuario con la informacion de la posicion que pulsamos en
		// la lista usuario.
		final Usuarios user = listaUsuario.get((int) info.id); // info.position
		final String id = listaInformacion.get((int) info.id);
		
		switch (item.getItemId()) {
		case R.id.borrar:
			//CONSTRUIMOS EL CUADRO PARA CONFIRMAR BORRADO
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("¿Estas seguro que desea borrarlo?").setTitle("BORRAR");
			builder.setPositiveButton("Si", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
					borrarSqlite(user);
					borrarArraylist(id);
					
					adaptador.notifyDataSetChanged();
					Toast.makeText(getApplicationContext(), "Se ha eliminado",
							Toast.LENGTH_SHORT).show();
				}
				
			});
			
			builder.setNegativeButton("No", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getApplicationContext(), "Se ha cancelado la acción",
							Toast.LENGTH_SHORT).show();
					
				}
			});
			
			AlertDialog alertDialog = builder.create();
			alertDialog.show();
			
			return true;
		case R.id.modificar:
			Intent i = new Intent(MainActivity.this, ActualizarUsuario.class);
			Bundle bundle = new Bundle();
			bundle.putSerializable("usuario", user);
			i.putExtras(bundle);
			startActivity(i);
			return true;
		default:
			return super.onContextItemSelected(item);
		}

	}
	
	//----------------------FUNCION BORRAR-------------------
	
	public void borrarSqlite(Usuarios user){
		SQLiteDatabase db = conn.getWritableDatabase();
		String[] parametros = { user.getId().toString() };
		//la borramos en la base de datos.
		db.delete(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID + "=?",parametros);
		db.close();
	}
	
	public void borrarArraylist (String id){
		listaInformacion.remove(id);
	}
	//-----------------MENU SIDEBER-----------------------------

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		if (id == R.id.nombreNuevo) {
			Intent i = new Intent(MainActivity.this,
					RegistroUsuariosActivity.class);

			startActivity(i);
		}
		return super.onOptionsItemSelected(item);
	}
}
