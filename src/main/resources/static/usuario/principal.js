/**
 * 
 */

function addRow(usuario, correo, rol, estado){
	//Se obtiene la instancia de la tabla
	var tbl			= document.getElementById("tblUsuarios").getElementsByTagName('tbody')[0];
	//Se crea una fila para agregar los datos a vincular
	var fila		= tbl.insertRow();
	//Se crea una celda para el usuario
	var cellId		= fila.insertCell(0);
	var nexText		= document.createTextNode(usuario);
	cellId.setAttribute("class", "hidden");
	cellId.appendChild(nexText);		
	//Se crea una celda para el correo.
	var cellTer0	= fila.insertCell(1);
	var newText0  	= document.createTextNode(correo);
	cellTer0.appendChild(newText0);
	//Se crea una celda para el rol.
	var cellTer1	= fila.insertCell(2);
	var newText1	= document.createTextNode(rol);
	cellTer1.setAttribute("class", "text-right");
	cellTer1.appendChild(newText1);
	//Se crea una celda para el total del estado.
	var cellTer2	= fila.insertCell(3);
	var newText2  = document.createTextNode(estado);
	cellTer2.setAttribute("class", "text-right");
	cellTer2.appendChild(newText2);
}
    
function loadTable(){
    var http = new XMLHttpRequest();
	http.open("GET", "/usuario/listado", true);
	http.setRequestHeader("Content-type", "application/json");
	http.onload = function(){
		if(this.status==200){
			var request = JSON.parse(this.responseText);
			console.log(request);
			for(var i=0; i<request.length; i++){
				var usuario = request[i].usuario;
				var correo	= request[i].correo;
				var rol		= request[i].rol;
				var estado	= request[i].estado;
				addRow(usuario, correo, rol, estado);
			}
		}else{
			alert("error en la operación");		
		}
	}
	http.send();
}
loadTable();
 
 
var modalUsuarioGuardar	= document.getElementById("modalUsuarioGuardar");
modalUsuarioGuardar.onclick = function(){

	var form 	= document.querySelector("#formUsuarioNuevo");	
	var _csrf	= form.querySelector('input[name="_csrf"]').value;
	
	var usuario	= document.getElementById("usuario").value;
	var clave	= document.getElementById("clave").value;
	var correo	= document.getElementById("correo").value;
	var tipo	= document.getElementById("tipo").value;
	
	if(usuario!=null && clave!="" && correo!="" && tipo!=""){
		var http = new XMLHttpRequest();
		http.open("POST", "/usuario/save", true);
		http.setRequestHeader("Content-type", "application/json");
		http.setRequestHeader("X-CSRF-TOKEN", _csrf);
		http.onload = function(){
			if(this.status==200){
				var request = JSON.parse(this.responseText);
				alert(request.mensaje);
				//Ocultamos Modal
				document.getElementById("modalUsuario").click();
				location.reload();
			}else{
				alert("error en la operación");		
			}
		}
		var request = {
			"usuario" : usuario,
			"clave" : clave,
			"correo" : correo,
			"tipo"	: tipo
		}
		http.send(JSON.stringify(request));
	}
}
