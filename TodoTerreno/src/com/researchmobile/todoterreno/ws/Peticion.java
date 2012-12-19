package com.researchmobile.todoterreno.ws;

import android.content.Context;

import com.researchmobile.todoterreno.entity.ListaArticulos;
import com.researchmobile.todoterreno.entity.ListaClientes;
import com.researchmobile.todoterreno.entity.LoginEntity;
import com.researchmobile.todoterreno.entity.RespuestaWS;
import com.researchmobile.todoterreno.entity.User;

public class Peticion {
	//Temp
	private RequestWSTemp requestWS = new RequestWSTemp();
	private RequestDBTemp requestDB = new RequestDBTemp();
	
	//private RequestWS requestWS = new RequestWS();
	//private RequestDB requestDB = new RequestDB();
	private RespuestaWS respuesta = new RespuestaWS();

	public RespuestaWS login(Context context) {
		try{
			respuesta = requestDB.verificaLoginDB();
			if(respuesta.isResultado()){
				return respuesta;
			}else{
				LoginEntity loginEntity = new LoginEntity();
				loginEntity = requestWS.login(User.getUsername(), User.getClave());
				respuesta = loginEntity.getRespuesta();
				if (respuesta.isResultado()){
					guardarDatos(context, loginEntity);
					cargarClientes(context, loginEntity);
					cargarArticulos(context, loginEntity);
					return respuesta;
				}else{
					return respuesta;
				}
			}
		}catch(Exception exception){
			
		}
		// TODO Auto-generated method stub
		return null;
	}

	private void cargarArticulos(Context context, LoginEntity loginEntity) {
		ListaArticulos listaArticulos = new ListaArticulos();
		int tamanoPortafolio = loginEntity.getPortafolio().length;
		for (int i = 0; i < tamanoPortafolio; i++){
			listaArticulos = requestWS.listaArticulos(loginEntity.getPortafolio()[i].getIdPortafolio());
			if (listaArticulos.getArticulo().length > 0){
				guardarArticulos(context, listaArticulos);
			}
		}
		
	}

	private void guardarArticulos(Context context, ListaArticulos listaArticulos) {
		requestDB.guardarArticulos(context, listaArticulos);
		
	}

	private void cargarClientes(Context context, LoginEntity loginEntity) {
		ListaClientes listaClientes = new ListaClientes();
		int tamanoRuta = loginEntity.getRuta().length;
		for (int i = 0; i < tamanoRuta; i++){
			listaClientes = requestWS.listaClientes(loginEntity.getRuta()[i].getId());
			if (listaClientes.getCliente().length > 0){
				guardarClientes(context, listaClientes);
			}
		}
	}

	private void guardarClientes(Context context, ListaClientes listaClientes) {
		requestDB.guardarClientes(context, listaClientes);
	}

	private void guardarDatos(Context context, LoginEntity loginEntity) {
		requestDB.guardarUsuario(context, loginEntity.getUsuario());
		requestDB.guardarVendedor(context, loginEntity.getVendedor());
		requestDB.guardarPortafolios(context, loginEntity.getPortafolio());
		requestDB.guardarRuta(context, loginEntity.getRuta());
	}

	private void cargarDatosWS(LoginEntity loginEntity) {
		// TODO Auto-generated method stub
		
	}

}
