package com.researchmobile.todoterreno.ws;

import java.util.Iterator;
import java.util.List;

import android.content.Context;

import com.android.dataframework.DataFramework;
import com.android.dataframework.Entity;
import com.researchmobile.todoterreno.entity.Articulo;
import com.researchmobile.todoterreno.entity.Cliente;
import com.researchmobile.todoterreno.entity.Portafolio;
import com.researchmobile.todoterreno.entity.Ruta;
import com.researchmobile.todoterreno.entity.Usuario;
import com.researchmobile.todoterreno.entity.Vendedor;


public class RequestDB {
	//guarda usuario
		public void guardarUsuario(Context context, Usuario usuario)
		{
			try
			{
				DataFramework.getInstance().open(context, "com.researchmobile.todoterreno.ws");
				Entity datoUsuario = new Entity("usuario");
				datoUsuario.setValue("id", usuario.getId());
				datoUsuario.setValue("usuario", usuario.getUsuario());
				datoUsuario.setValue("password", usuario.getPassword());
				datoUsuario.setValue("lastlogin", usuario.getLastLogin());
				datoUsuario.setValue("activo", usuario.getActivo());
				datoUsuario.save();
			}
			 catch(Exception msj)
			 {
				 msj.printStackTrace();
			 }
		}
		
		//guarda vendedor
		public void guardarVendedor(Context context, Vendedor vendedor)
		{
			try
			{
				DataFramework.getInstance().open(context, "com.researchmobile.todoterreno.ws");
				Entity datoVendedor = new Entity("vendedor");
				datoVendedor.setValue("vendedor", vendedor.getVendedor());
				datoVendedor.setValue("nombre", vendedor.getNombre());
				datoVendedor.setValue("direccion", vendedor.getDireccion());
				datoVendedor.setValue("telefono",vendedor.getTelefono());
				datoVendedor.setValue("identificacion", vendedor.getIdentificacion());
				datoVendedor.setValue("comision", vendedor.getComision());
				datoVendedor.setValue("ruta", vendedor.getRuta());
				datoVendedor.setValue("clidesnormal", vendedor.getClidesnormal());
				datoVendedor.setValue("clides1", vendedor.getClides1());
				datoVendedor.setValue("clides2", vendedor.getClides2());
				datoVendedor.setValue("clides3", vendedor.getClides3());
				datoVendedor.setValue("turno",vendedor.getTurno());
				datoVendedor.setValue("otnumero", vendedor.getOtnumero());
				datoVendedor.setValue("idusuario", vendedor.getIdusuario());
				datoVendedor.save();
			}
			 catch(Exception msj)
			 {
				 msj.printStackTrace();
			 }
		}
		
		//guarda portafolio
		public void guardarportafolios(Context context, Portafolio[] portafolio)
		{
			try
			{	
				int tamano = portafolio.length;
				 for(int a = 0; a<tamano; a++)
				 {
					 DataFramework.getInstance().open(context,"com.researchmobile.todoterreno.ws");		  	 
					 Entity datoPortafolio = new Entity("portafolio");
					 datoPortafolio.setValue("idportafolio", portafolio[a].getIdPortafolio());
					 datoPortafolio.setValue("descripcion", portafolio[a].getDescripcion());
					 datoPortafolio.setValue("fechacreacion", portafolio[a].getFechacreacion());
					 datoPortafolio.setValue("deshabilitar", portafolio[a].getDeshabilitar());
					 datoPortafolio.setValue("anotaciones", portafolio[a].getAnotaciones());
					 datoPortafolio.setValue("usuario", portafolio[a].getUsuario());
					 datoPortafolio.save();
					 
				 }
			}
			catch(Exception msj)
			{
			 msj.printStackTrace();	
			}
		}
		
		//guarda ruta
		public void guardarrutas(Context context, Ruta[] ruta)
		{
			try
			{
				int longitud = ruta.length;
				 for(int b = 0; b<longitud; b++)
				 {
					 DataFramework.getInstance().open(context,"com.researchmobile.todoterreno.ws");
					 Entity datoruta = new Entity("ruta");
					 datoruta.setValue("id", ruta[b].getId());
					 datoruta.setValue("descripcion", ruta[b].getDescripcion());
					 datoruta.setValue("tipovehiculo", ruta[b].getTipovehiculo());
					 datoruta.setValue("origen", ruta[b].getOrigen());
					 datoruta.setValue("destino", ruta[b].getDestino());
					 datoruta.setValue("precioventa", ruta[b].getPrecioventa());
					 datoruta.setValue("combustible", ruta[b].getCombustible());
					 datoruta.setValue("viaticos", ruta[b].getViaticos());
					 datoruta.setValue("otrosgastos", ruta[b].getOtrosgastos());
					 datoruta.setValue("kilometros", ruta[b].getKilometros());
					 datoruta.save();
				 }
			}	 
				 catch(Exception msj)
				 {
				   msj.printStackTrace();	 
				 }
		}
		
		//guarda articulo
		public void guardararticulo(Context context, Articulo[] articulo)
		{
			try
			{
				int longitud1 = articulo.length;
				for (int c= 0; c<longitud1; c++)
				{
					DataFramework.getInstance().open(context, "com.researchmobile.todoterreno.ws");
					Entity datoarticulo = new Entity("articulo");
					datoarticulo.setValue("artCodigo", articulo[c].getArtCodigo());
					datoarticulo.setValue("categoria", articulo[c].getCategoria());
					datoarticulo.setValue("sector", articulo[c].getSector());
					datoarticulo.setValue("division", articulo[c].getDivision());
					datoarticulo.setValue("artDescripcion", articulo[c].getArtDescripcion());
					datoarticulo.setValue("artIngrediente", articulo[c].getArtIngrediente());
					datoarticulo.setValue("precioVenta", articulo[c].getPrecioVenta());
					datoarticulo.setValue("precioDes1", articulo[c].getPrecioDes1());
					datoarticulo.setValue("precioDes2", articulo[c].getPrecioDes2());
					datoarticulo.setValue("precioDes3", articulo[c].getPrecioDes3());
					datoarticulo.setValue("ofertado", articulo[c].isOfertado());//cuando es boolean
					datoarticulo.setValue("precioOferta",articulo[c].getPrecioOferta());
					datoarticulo.setValue("foto",articulo[c].getFoto());
					datoarticulo.setValue("observacion",articulo[c].getObservaciones());
					datoarticulo.setValue("catalogo",articulo[c].getCatalogo());
					datoarticulo.setValue("unidadesFardo",articulo[c].getUnidadesFardo());
					datoarticulo.setValue("link",articulo[c].getLink());
					datoarticulo.setValue("artOfertaFecha",articulo[c].getArtOfertaFecha());
					datoarticulo.save();
				}
			}	
				 catch(Exception msj)
				 {
					 msj.printStackTrace();
				 }
			
		}
		//guarda cliente
		public void guardacliente (Context context, Cliente[] cliente)
		{
			try
			{			
			 int longitud2 = cliente.length;
			 for(int d=0; d<longitud2; d++)
			 {
				DataFramework.getInstance().open(context, "com.researchmobile.todoterreno.ws");
				Entity datocliente = new Entity("cliente");
				datocliente.setValue("cliCodigo", cliente[d].getCliCodigo());
				datocliente.setValue("cliEmpresa", cliente[d].getCliEmpresa());
				datocliente.setValue("cliContacto", cliente[d].getCliContacto());
				datocliente.setValue("codCatCliete", cliente[d].getCodCatCliete());
				datocliente.setValue("cliDireccion", cliente[d].getCliDireccion());
				datocliente.setValue("cliTelefono", cliente[d].getCliTelefono());
				datocliente.setValue("cliFax", cliente[d].getCliFax());
				datocliente.setValue("cliEmail", cliente[d].getCliEmail());
				datocliente.setValue("cliWeb", cliente[d].getCliWeb());
				datocliente.setValue("fingreso", cliente[d].getFingreso());
				datocliente.setValue("cliDesnormal", cliente[d].getCliDesnormal());
				datocliente.setValue("cliDes1", cliente[d].getCliDes1());
				datocliente.setValue("cliDes2", cliente[d].getCliDes2());
				datocliente.setValue("cliDes3", cliente[d].getCliDes3());
				datocliente.setValue("clilimite", cliente[d].getCliLimite());
				datocliente.setValue("cliSaldo", cliente[d].getCliSaldo());
				datocliente.setValue("cliCheque", cliente[d].getCliCheque());
				datocliente.setValue("cliRuta", cliente[d].getCliRuta());
				datocliente.setValue("cliDireccionParticular", cliente[d].getCliDireccionParticular());
				datocliente.setValue("cliTelefonoCasa", cliente[d].getCliTelefonoCasa());
				datocliente.setValue("cliTelefonoMovil", cliente[d].getCliTelefonoMovil());
				datocliente.setValue("cliNit", cliente[d].getCliNit());
				datocliente.setValue("Semana", cliente[d].getSemana());
				datocliente.setValue("diaVisita", cliente[d].getDiaVisita());
				datocliente.setValue("visitado", cliente[d].isVisitado());
				datocliente.save();
			 }
			
			}
			 catch(Exception msj)
			 {
				 msj.printStackTrace();
			 }
		}
		//recorriendo tabla usuario
		public Usuario usuarioDB()
		{
			Usuario usuario = new Usuario();
			 	List<Entity> categories = DataFramework.getInstance().getEntityList("usuario");
			 	{
			 		Iterator iter = categories.iterator();
			 		while(iter.hasNext())
			 		{
			 			Entity ent = (Entity)iter.next();
			 			usuario.setId(ent.getString("id"));
			 			usuario.setUsuario(ent.getString("usuario"));
			 			usuario.setPassword(ent.getString("password"));
			 			usuario.setLastLogin(ent.getString("lastLogin"));
			 			usuario.setActivo(ent.getString("activo"));
			 			
			 		}
			 	}
			
			return usuario;
		}
		
		  
	//ultima llave
	}

