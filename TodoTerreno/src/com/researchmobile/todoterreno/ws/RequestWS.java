package com.researchmobile.todoterreno.ws;

import org.json.JSONArray;
import org.json.JSONObject;

import com.researchmobile.todoterreno.entity.Articulo;
import com.researchmobile.todoterreno.entity.Cliente;
import com.researchmobile.todoterreno.entity.ListaArticulos;
import com.researchmobile.todoterreno.entity.ListaClientes;
import com.researchmobile.todoterreno.entity.LoginEntity;
import com.researchmobile.todoterreno.entity.Portafolio;
import com.researchmobile.todoterreno.entity.Ruta;

public class RequestWS {
	private static String WS_LOGIN = "ws_login.php?";
	private static String WS_CLIENTES = "ws_cliente?";

	// Metodo que llena el Entity del login
	@SuppressWarnings("unused")
	public LoginEntity login(String usuario, String password) {
		String url = WS_LOGIN + "usuario=" + usuario + "&" + "password=" + password; // string de conexi�n

		JSONObject jsonObject = ConnectWS.obtenerJson(url);
		System.out.println("RESPUESTA WS LOGIN:" + jsonObject.toString());
		LoginEntity loginEntity = new LoginEntity();
		try {
			if(jsonObject.has("resultado")){ // si se produjo un error al consumir el WS
				// creamos el LoginEntity y le asignamos el resultado recibido
				
				
				loginEntity.getRespuesta().setResultado(jsonObject.getBoolean("resultado"));
				loginEntity.getRespuesta().setMensaje(jsonObject.getString("mensaje"));
				
				if(jsonObject.getBoolean("resultado")){ //  si existe resultado relleno los campos del usuario
					JSONArray usuarioJsonArray = jsonObject.getJSONArray("usuario");
					JSONObject usuarioJsonObject = usuarioJsonArray.getJSONObject(1);
					loginEntity.getUsuario().setActivo(usuarioJsonObject.getString("activo"));
					loginEntity.getUsuario().setUsuario(usuarioJsonObject.getString("usuario"));
					loginEntity.getUsuario().setPassword(usuarioJsonObject.getString("password"));
					loginEntity.getUsuario().setLastLogin(usuarioJsonObject.getString("lastLogin"));
					loginEntity.getUsuario().setId(usuarioJsonObject.getString("id"));
					
					if(jsonObject.has("vendedor")){ // si viene el Array de vendedor tambien ingreso los resultados al Entity del Login
						JSONArray vendedorJsonArray = jsonObject.getJSONArray("vendedor");
						JSONObject vendedorJsonObject = vendedorJsonArray.getJSONObject(1);
						loginEntity.getVendedor().setVendedor(nullToString(vendedorJsonObject.getString("Vendedor")));
						loginEntity.getVendedor().setNombre(nullToString(vendedorJsonObject.getString("Nombre")));
						loginEntity.getVendedor().setDireccion(nullToString(vendedorJsonObject.getString("Direccion")));
						loginEntity.getVendedor().setTelefono(nullToString(vendedorJsonObject.getString("Telefono")));
						loginEntity.getVendedor().setIdentificacion(nullToString(vendedorJsonObject.getString("Identificacion")));
						loginEntity.getVendedor().setComision(nullToString(vendedorJsonObject.getString("Comision")));
						loginEntity.getVendedor().setRuta(nullToString(vendedorJsonObject.getString("Ruta")));
						loginEntity.getVendedor().setClidesnormal(nullToString(vendedorJsonObject.getString("clidesnormal")));
						loginEntity.getVendedor().setClides1(nullToString(vendedorJsonObject.getString("clides1")));
						loginEntity.getVendedor().setClides2(nullToString(vendedorJsonObject.getString("clides2")));
						loginEntity.getVendedor().setClides3(nullToString(vendedorJsonObject.getString("clides3")));
						loginEntity.getVendedor().setTurno(nullToString(vendedorJsonObject.getString("turno")));
						loginEntity.getVendedor().setOtnumero(nullToString(vendedorJsonObject.getString("otnumero")));
						loginEntity.getVendedor().setIdusuario(nullToString(vendedorJsonObject.getString("idusuario")));
					}else{
						System.out.println("No se obtuvieron datos del vendedor");
					}
					if(jsonObject.has("portafolios")){ // si viene el Array de portafolios asigno los campos al portafolio
						JSONArray portafoliosJsonArray = jsonObject.getJSONArray("portafolios");
						int tamano = portafoliosJsonArray.length();
						Portafolio[] portafolios = new Portafolio[tamano];
						for(int i=0; i < tamano; i++){
						JSONObject portafoliosJsonObject = portafoliosJsonArray.getJSONObject(1);
						Portafolio temp = new Portafolio();
						temp.setIdPortafolio(nullToString(portafoliosJsonObject.getString("IDportafolio")));
						temp.setDescripcion(nullToString(portafoliosJsonObject.getString("descripcion")));
						temp.setFechacreacion(nullToString(portafoliosJsonObject.getString("fechacreacion")));
						temp.setDeshabilitar(nullToString(portafoliosJsonObject.getString("deshabilitar")));
						temp.setAnotaciones(nullToString(portafoliosJsonObject.getString("anotaciones")));
						temp.setUsuario(nullToString(portafoliosJsonObject.getString("usuario")));
						portafolios[i] = temp;
						} loginEntity.setPortafolio(portafolios);
					}else{
						System.out.println("No se obtuvieron datos del portafolios");
					}
					if(jsonObject.has("rutas")){ // si viene el Array de rutas asigno los campos al array de rutas y lo envio al LoginEntity
						JSONArray rutasJsonArray = jsonObject.getJSONArray("rutas");
						int tamano = rutasJsonArray.length();
						Ruta[] rutas = new Ruta[tamano];
						for(int i=0; i < tamano; i++){ // recorro el Array para asignar cada registro a una variable a un objeto temporal y luego agregarlo al Array de listaClientes
						JSONObject rutasJsonObject = rutasJsonArray.getJSONObject(1);
						Ruta temp = new Ruta();
						//temp.setIdPortafolio(nullToString(rutasJsonObject.getString("IDportafolio")));
						temp.setId(nullToString(rutasJsonObject.getString("ID")));
						temp.setDescripcion(nullToString(rutasJsonObject.getString("Descripcion")));
						temp.setTipovehiculo(nullToString(rutasJsonObject.getString("fechadecreacion")));
						temp.setOrigen(nullToString(rutasJsonObject.getString("destino")));
						temp.setDestino(nullToString(rutasJsonObject.getString("destino")));
						temp.setPrecioventa(nullToString(rutasJsonObject.getString("precioventa")));
						temp.setCombustible(nullToString(rutasJsonObject.getString("combustible")));
						temp.setViaticos(nullToString(rutasJsonObject.getString("viaticos")));
						temp.setOtrosgastos(nullToString(rutasJsonObject.getString("otrosgastos")));
						temp.setKilometros(nullToString(rutasJsonObject.getString("kilometros")));
						
						rutas[i] = temp;
						} loginEntity.setRuta(rutas);
						
					}else{
						System.out.println("No se obtuvieron datos de las rutas");
					}
					
				}
				return loginEntity;
			}else{
				System.out.println("No se obtuvo resultado del JSON");	
				return null;    
			}
		} catch (Exception e) {
			System.out.println("OCURRIO UN ERROR AL PARSEAR EL JSON Error: " + e );
			return null;
		}

		
	}
	
	// Metodo que retorna la lista de clientes obtenidas desde el WS se necesita como parametros el cat�logo y la ruta del vendedor
	public ListaClientes listaClientes(String catalogo, String ruta){
		String url = WS_LOGIN + "a=" + catalogo + "&" + "idruta=" + ruta; // string de conexi�n

		JSONObject jsonObject = ConnectWS.obtenerJson(url);
		System.out.println("RESPUESTA WS LOGIN:" + jsonObject.toString());
		ListaClientes listaClientes = new ListaClientes(); // creamos el objeto que se va a retornar, instanciando la clase ListaClientes
		try {
				if(jsonObject.has("resultado")){ // si se produjo un error al consumir el WS
				// creamos el listaClientes y le asignamos el resultado recibido
					listaClientes.getRespuesta().setResultado(jsonObject.getBoolean("resultado"));
					listaClientes.getRespuesta().setMensaje(jsonObject.getString("mensaje"));
					
					if(jsonObject.has("cliente")){
						JSONArray clientesJsonArray = jsonObject.getJSONArray("cliente"); // obtengo el Array de clientes que viene el el JSON
						Cliente[] clientes = new Cliente[clientesJsonArray.length()];
						for(int i=0;i<clientesJsonArray.length();i++){
							JSONObject clientesJsonObject = clientesJsonArray.getJSONObject(i);
							Cliente temp = new Cliente();
							temp.setCliCodigo(nullToString(clientesJsonObject.getString("clicodigo")));
							temp.setCliCheque(nullToString(clientesJsonObject.getString("clicheque")));
							temp.setCliContacto(nullToString(clientesJsonObject.getString("clicontacto")));
							temp.setCliDes1(nullToString(clientesJsonObject.getString("clides1")));
							temp.setCliDes2(nullToString(clientesJsonObject.getString("clides2")));
							temp.setCliDes3(nullToString(clientesJsonObject.getString("clides3")));
							temp.setCliDesnormal(nullToString(clientesJsonObject.getString("clidesnormal")));
							temp.setCliDireccion(nullToString(clientesJsonObject.getString("clidireccion")));
							temp.setCliDireccionParticular(nullToString(clientesJsonObject.getString("direccionparticular")));
							temp.setCliEmail(nullToString(clientesJsonObject.getString("cliemail")));
							temp.setCliEmpresa(nullToString(clientesJsonObject.getString("cliempresa")));
							temp.setCliFax(nullToString(clientesJsonObject.getString("clifax")));
							temp.setCliLimite(nullToString(clientesJsonObject.getString("clilimite")));
							temp.setCliNit(nullToString(clientesJsonObject.getString("clinit")));
							temp.setCliRuta(nullToString(clientesJsonObject.getString("cliruta")));
							temp.setCliSaldo(nullToString(clientesJsonObject.getString("clisaldo")));
							temp.setCliTelefono(nullToString(clientesJsonObject.getString("clitelefono")));
							temp.setCliTelefonoCasa(nullToString(clientesJsonObject.getString("clitelecasa")));
							temp.setCliTelefonoMovil(nullToString(clientesJsonObject.getString("clitelecel")));
							temp.setCliWeb(nullToString(clientesJsonObject.getString("cliweb")));
							clientes[i]=temp;
							
						} listaClientes.setCliente(clientes);
						
					}else{
						System.out.println("No se obtuvo el Array de clientes");
					}
					return listaClientes;
				}else{
					System.out.println("No se obtuvo resultado del WS");
					return null;
				}
			
			}catch(Exception e){
				System.out.println("OCURRIO UN ERROR AL PARSEAR EL JSON Error: " + e );
				return null;
				}
		
	}
	
/*	// Metodo que retorna la lista de clientes obtenidas desde el WS se necesita como parametros el cat�logo y la ruta del vendedor
		public ListaClientes listaArticulos(String portafolio, String ruta){
			String url = WS_LOGIN + "a=" + portafolio + "&" + "idportafolio=" + ruta; // string de conexi�n

			JSONObject jsonObject = ConnectWS.obtenerJson(url);
			System.out.println("RESPUESTA WS LOGIN:" + jsonObject.toString());
			ListaArticulos listaArticulos = new ListaArticulos(); // creamos el objeto que se va a retornar, instanciando la clase ListaArticulos
			try {
					if(jsonObject.has("resultado")){ // si se produjo un error al consumir el WS
					// creamos el listaArticulos y le asignamos el resultado recibido
						listaArticulos.getRespuesta().setResultado(jsonObject.getBoolean("resultado"));
						listaArticulos.getRespuesta().setMensaje(jsonObject.getString("mensaje"));
						
						if(jsonObject.has("articulos")){
							JSONArray articulosJsonArray = jsonObject.getJSONArray("articulos"); // obtengo el Array de clientes que viene el el JSON
							Articulo[] articulos = new Articulo[articulosJsonArray.length()];
							for(int i=0;i<articulosJsonArray.length();i++){
								JSONObject articulossJsonObject = articulosJsonArray.getJSONObject(i);
								Articulo temp = new Articulo();
								
								articulos[i]=temp;
								
							} listaClientes.setCliente(clientes);
							
						}else{
							System.out.println("No se obtuvo el Array de clientes");
						}
						return listaClientes;
					}else{
						System.out.println("No se obtuvo resultado del WS");
						return null;
					}
				
				}catch(Exception e){
					System.out.println("OCURRIO UN ERROR AL PARSEAR EL JSON Error: " + e );
					return null;
					}
			
		}*/
	
	// Metodo convierte un valor null ingresado a un String y devuelve un espacio en blanco
	public String nullToString(String variable){
		if(variable == null){
			return " ";
		}else{
		return variable;
			}
	}

}
