package com.researchmobile.todoterreno.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.researchmobile.todoterreno.entity.ListaClientes;
import com.researchmobile.todoterreno.ws.Peticion;

public class Rol extends Activity implements OnClickListener, OnKeyListener, TextWatcher{
	
	private ProgressDialog pd = null;
	
	private ImageButton borrarImageButton;
	private EditText buscarEditText;
	private TextView semanaTextView;
	private TextView diaTextView;
	private SimpleAdapter simpleAdatper;
	private ListView clientesListView;
	private ListaClientes listaClientes;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rol);
        
        setBuscarEditText((EditText)findViewById(R.id.rol_buscar_editText));
        getBuscarEditText().addTextChangedListener(this);
        
        setBorrarImageButton((ImageButton)findViewById(R.id.rol_borrar_imagebutton));
        getBorrarImageButton().setOnClickListener(this);

        setSemanaTextView((TextView)findViewById(R.id.rol_semana_textview));
        setDiaTextView((TextView)findViewById(R.id.rol_dia_textview));
        setClientesListView((ListView)findViewById(R.id.rol_lista_clientes_listView));
        
        new ClientesPendientesAsync().execute("");
        
	}
	@Override
	public boolean onKey(View view, int keyCode, KeyEvent event) {
		if (view == getBorrarImageButton()){
			getBuscarEditText().setText("");
		}
		return false;
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		
	}
	
	// Buscar Clientes Pendientes
	class ClientesPendientesAsync extends AsyncTask<String, Integer, Integer> {

		// Metodo que prepara lo que usara en background, Prepara el progress
		@Override
		protected void onPreExecute() {
			pd = ProgressDialog.show(Rol.this, "VERIFICANDO DATOS", "ESPERE UN MOMENTO");
			pd.setCancelable(false);
		}

		// Metodo con las instrucciones que se realizan en background
		@Override
		protected Integer doInBackground(String... urlString) {
			try {
				llenaListaPendientes();

			} catch (Exception exception) {

			}
			return null;
		}

		private void llenaListaPendientes() {
			Peticion peticion = new Peticion();
			setSimpleAdatper(peticion.listaClientes());
			
		}

		// Metodo con las instrucciones al finalizar lo ejectuado en background
		protected void onPostExecute(Integer resultado) {
			pd.dismiss();
		}
	}
	
	// Buscar Clientes Visitados
	class ClientesVisitadosAsync extends AsyncTask<String, Integer, Integer> {

		// Metodo que prepara lo que usara en background, Prepara el progress
		@Override
		protected void onPreExecute() {
			pd = ProgressDialog.show(Rol.this, "VERIFICANDO DATOS", "ESPERE UN MOMENTO");
			pd.setCancelable(false);
		}

		// Metodo con las instrucciones que se realizan en background
		@Override
		protected Integer doInBackground(String... urlString) {
			try {

			} catch (Exception exception) {

			}
			return null;
		}

		// Metodo con las instrucciones al finalizar lo ejectuado en background
		protected void onPostExecute(Integer resultado) {
			pd.dismiss();
		}
	}

	public ImageButton getBorrarImageButton() {
		return borrarImageButton;
	}
	public void setBorrarImageButton(ImageButton borrarImageButton) {
		this.borrarImageButton = borrarImageButton;
	}
	public EditText getBuscarEditText() {
		return buscarEditText;
	}
	public void setBuscarEditText(EditText buscarEditText) {
		this.buscarEditText = buscarEditText;
	}
	
	public TextView getSemanaTextView() {
		return semanaTextView;
	}
	public void setSemanaTextView(TextView semanaTextView) {
		this.semanaTextView = semanaTextView;
	}
	public TextView getDiaTextView() {
		return diaTextView;
	}
	public void setDiaTextView(TextView diaTextView) {
		this.diaTextView = diaTextView;
	}
	public SimpleAdapter getSimpleAdatper() {
		return simpleAdatper;
	}
	public void setSimpleAdatper(SimpleAdapter simpleAdatper) {
		this.simpleAdatper = simpleAdatper;
	}
	public ListView getClientesListView() {
		return clientesListView;
	}
	public void setClientesListView(ListView clientesListView) {
		this.clientesListView = clientesListView;
	}
	public ListaClientes getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(ListaClientes listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
}
