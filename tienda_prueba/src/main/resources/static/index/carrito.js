/**
 * 
 */
 
 var total = 0;
 var cantidad = 0;

function addCar(productoCodigo, productoNombre, productoPvp){
	cantidad++;
	document.getElementById("cantidadItems").innerHTML = cantidad;
	total += parseFloat(productoPvp);
	document.getElementById("totalListado").innerHTML = '$'+total.toFixed(2);
	document.getElementById("valorPago").value = '$'+total.toFixed(2);
	
	var ul = document.getElementById("listadoCompra");
  	var li = document.createElement("li");
  	li.setAttribute("class", "list-group-item d-flex justify-content-between lh-sm text-muted");
  	//li.appendChild(document.createTextNode(productoNombre));
  	li.innerHTML='<div> <h6 class="my-0">'+productoNombre+'</h6> </div> <span class="text-muted">$'+productoPvp.toFixed(2)+'</span>';
  	ul.appendChild(li);
}
