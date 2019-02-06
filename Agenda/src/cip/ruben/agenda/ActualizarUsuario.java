package cip.ruben.agenda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidades.Usuarios;
import utilidades.Utilidades;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActualizarUsuario extends Activity {
	EditText et_id2, et_nombre2, et_email2;
	Button bt_actualizar, bt_volver;
	ConexionSqliteHelper conn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actualizar_usuario);
		
		conn = new ConexionSqliteHelper(getApplicationContext(),  "BD_personas", null, 1);
		
		et_id2 = (EditText) findViewById(R.id.et_id2);
		et_nombre2 = (EditText) findViewById(R.id.et_nombre2);
		et_email2 = (EditText) findViewById(R.id.et_email2);
		
		Bundle objetoEnviado = getIntent().getExtras();
		Usuarios user = null;
		
		if (objetoEnviado!=null){
			user = (Usuarios) objetoEnviado.getSerializable("usuario");
			et_id2.setText(user.getId().toString());
			et_nombre2.setText(user.getNombre().toString());
			et_email2.setText(user.getEmail().toString());
		}
		
		
		bt_actualizar = (Button) findViewById(R.id.bt_actualizar);
		bt_actualizar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!isValidEmailID(et_email2.getText().toString())) {
					Toast.makeText(getApplicationContext(),
							"Introduzca un email valido", Toast.LENGTH_LONG)
							.show();
				} else {
					actualizarUsuario();

				}
			}
		});
		bt_volver = (Button) findViewById(R.id.b_volver2);
		bt_volver.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
	}
	
	public void actualizarUsuario(){
		SQLiteDatabase db = conn.getWritableDatabase();
		String [] parametros = {et_id2.getText().toString()};
		ContentValues values = new ContentValues();
		values.put(Utilidades.CAMPO_NOMBRE, et_nombre2.getText().toString());
		values.put(Utilidades.CAMPO_EMAIL, et_email2.getText().toString());
		
		db.update(Utilidades.TABLA_USUARIO, values, Utilidades.CAMPO_ID+ "=?", parametros);
		
		Toast.makeText(getApplicationContext(), "Ya se actualizó", Toast.LENGTH_SHORT).show();
		db.close();
		
	}


	public boolean isValidEmailID(String email) {
		String PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
}
