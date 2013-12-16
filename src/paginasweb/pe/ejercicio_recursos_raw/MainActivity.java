package paginasweb.pe.ejercicio_recursos_raw;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final TextView t=(TextView) findViewById(R.id.lblTexto);
		Button btn=(Button) findViewById(R.id.btnLeer);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try {
					String texto= ExtraerDatos(getApplicationContext());
					t.setText(texto);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}
	private String ExtraerDatos(Context activity)
			throws IOException
			{
				Resources recurso = activity.getResources();
				InputStream is  = recurso.openRawResource(R.raw.texto);
				String txt = convertirString(is);
				is.close();
				return txt;
			}
	private String convertirString(InputStream is)
			throws IOException
			{
				ByteArrayOutputStream arreglo = new ByteArrayOutputStream();
				int i = is.read();
				while (i != -1)
				{
					arreglo.write(i);
					i = is.read();
				}
				return arreglo.toString();
			}
	
}
