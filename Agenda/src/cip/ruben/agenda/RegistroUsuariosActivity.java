package cip.ruben.agenda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class RegistroUsuariosActivity extends Activity {

	EditText et_id, et_nombre, et_email;
	Button bt_registrar, bt_limpiar, bt_volver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro_usuarios);

		et_id = (EditText) findViewById(R.id.et_id);
		et_nombre = (EditText) findViewById(R.id.et_nombre);
		et_email = (EditText) findViewById(R.id.et_emaail);

		bt_registrar = (Button) findViewById(R.id.b_reg_usuario);
		bt_registrar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (!isValidEmailID(et_email.getText().toString())) {
					Toast.makeText(getApplicationContext(),
							"Introduzca un email valido", Toast.LENGTH_LONG)
							.show();
				} else {
					registrarUsuario();

					et_id.setText("");
					et_nombre.setText("");
					et_email.setText("");

				}

			}
		});
		bt_limpiar = (Button) findViewById(R.id.b_limpiar);
		bt_limpiar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				et_id.setText("");
				et_nombre.setText("");
				et_email.setText("");
			}
		});
		bt_volver = (Button) findViewById(R.id.b_volver);
		bt_volver.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				finish();

			}
		});
	}

	public void registrarUsuario() {
		ConexionSqliteHelper conn = new ConexionSqliteHelper(this,
				"BD_personas", null, 1);

		SQLiteDatabase db = conn.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(Utilidades.CAMPO_ID, et_id.getText().toString());
		values.put(Utilidades.CAMPO_NOMBRE, et_nombre.getText().toString());
		values.put(Utilidades.CAMPO_EMAIL, et_email.getText().toString());

		db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values);

		Toast.makeText(getApplicationContext(), "Registrado",
				Toast.LENGTH_SHORT).show();
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
