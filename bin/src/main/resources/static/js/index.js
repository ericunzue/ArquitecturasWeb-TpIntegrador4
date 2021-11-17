import clienteRepository from "/js/services/ClienteRepository.js";
import productoRepository from "/js/services/ProductoRepository.js";
import compraRepository from "/js/services/CompraRepository.js";
import detalleCompraRepository from "/js/services/DetalleCompraRepository.js";
const baseUrl = "http://localhost:8080/"
let DETALLES = []
window.addEventListener("DOMContentLoaded", async (e) => {
  e.preventDefault();

  cargarClientes();
  cargarProductos();
  addProducto();
  listarCLientesVenta();
  listarProductosVenta();
  agregarAlCarrito();



})


const cargarClientes = async () => {

  let container = document.getElementById("listaClientes");
  let clientes = await clienteRepository.getAll(baseUrl);

  container.innerHTML = "";


  for (const cliente of clientes) {
    let { idCliente, nombre_apellido, direccion } = cliente;


    container.innerHTML += `<tr class=" value="">
    
                <td>${idCliente}</td>
                <td>${nombre_apellido}</td>
                <td>${direccion}</td>
                <td><button type="submit" class="btn btn-primary editarCliente" value="${idCliente}" >Editar</button</td>
                <td><button type="submit" class="btn btn-danger eliminarCliente " value="${idCliente}" >Eliminar</button</td>
                </tr>`;
  }
  eliminarCliente();
  addEventEditarCliente();
  addCliente();
}


const eliminarCliente = (e) => {
  let btnEliminarCliente = document.querySelectorAll(".eliminarCliente");
  btnEliminarCliente.forEach(element => {
    element.addEventListener("click", () => {

    })
  });
}

const addEventEditarCliente = (e) => {

  let btnEditarCliente = document.querySelectorAll(".editarCliente");

  btnEditarCliente.forEach(element => {
    element.addEventListener("click", (e) => {
      e.preventDefault()
      let id = element.value;


      getCliente(id);

    })
  });
}

const getCliente = async (id) => {

  let cliente = await clienteRepository.getById(baseUrl, id);


  let { idCliente, nombre_apellido, direccion } = cliente;
  let clienteNombre = document.getElementById("clienteNombre");
  let clienteDireccion = document.getElementById("clienteDireccion");
  let clienteId = document.getElementById("clienteId");
  clienteNombre.value = nombre_apellido;
  clienteDireccion.value = direccion;
  clienteId.value = idCliente;


}

const addCliente = () => {
  let btnEnviarCliente = document.getElementById("enviarCliente");

  btnEnviarCliente.addEventListener("click", (e) => {
    e.preventDefault();



    let cliente = {
      nombre_apellido: document.getElementById("clienteNombre").value,
      direccion: document.getElementById("clienteDireccion").value,
      idCliente: document.getElementById("clienteId").value

    }


    if (typeof cliente.idCliente.value === "undefined") {

      clienteRepository.addCliente(baseUrl, cliente);

    } else {
      clienteRepository.updateCliente(baseUrl, id, cliente);

    }



  })

}

const cargarProductos = async () => {

  let container = document.getElementById("listaProductos");
  let productos = await productoRepository.getAll(baseUrl);

  container.innerHTML = "";


  for (const producto of productos) {
    let { idProducto, nombre, precio, stock } = producto;


    container.innerHTML += `<tr class=" value="">

                <td>${nombre}</td>
                <td>${precio}</td>
                <td>${stock}</td>
                <td><button type="submit" class="btn btn-primary editarProducto" value="${idProducto}" >Editar</button</td>
                <td><button type="submit" class="btn btn-danger eliminarProducto " value="${idProducto}" >Eliminar</button</td>
                </tr>`;
  }
  // eliminarCliente();
  addEventEditarProducto();
  // addCliente();
}

const addProducto = () => {
  let btnEnviarProducto = document.getElementById("enviarProducto");

  btnEnviarProducto.addEventListener("click", (e) => {
    e.preventDefault();


    let producto = {
      nombre: document.getElementById("productoNombre").value,
      precio: document.getElementById("productoPrecio").value,
      stock: document.getElementById("productoStock").value,
      idProducto: document.getElementById("productoId").value

    }

    if (typeof producto.idProducto.value === "undefined") {

      productoRepository.addProducto(baseUrl, producto);

    } else {
      productoRepository.updateProducto(baseUrl, id, producto);

    }

  })
}
const addEventEditarProducto = (e) => {

  let btnEditarCliente = document.querySelectorAll(".editarProducto");

  btnEditarCliente.forEach(element => {
    element.addEventListener("click", (e) => {
      e.preventDefault()
      let id = element.value;
      getProducto(id);

    })
  });
}


const getProducto = async (id) => {
  let producto = await productoRepository.getById(baseUrl, id);

  let { idProducto, nombre, precio, stock } = producto;
  let productoNombre = document.getElementById("productoNombre");
  let productoPrecio = document.getElementById("productoPrecio");
  let productoStock = document.getElementById("productoStock");
  let productoId = document.getElementById("productoId");
  productoNombre.value = nombre;
  productoPrecio.value = precio;
  productoId.value = idProducto;
  productoStock.value = stock;


}

const listarCLientesVenta = async () => {
  let selectCliente = document.getElementById("clienteVenta");
  let clientes = await clienteRepository.getAll(baseUrl);

  for (let cliente of clientes) {
    selectCliente.innerHTML += `<option value=${cliente.idCliente} data-direccion=${cliente.direccion}>${cliente.nombre_apellido}</option>`;
  }
  agregarCliente();
}

const listarProductosVenta = async () => {
  let productos = await productoRepository.getAll(baseUrl);
  let container = document.getElementById("listaProductosVenta");
  container.innerHTML = "";

  for (const producto of productos) {
    let { idProducto, nombre, precio, stock } = producto;
    container.innerHTML += `<tr class="producto" value="">
                <td>${nombre}</td>
                <td>${precio}</td>
                <td>${stock}</td>
                <td><button type="submit" class="btn btn-primary agregarProducto" value="${idProducto}" >Agregar</button</td>
                   
                </tr>`;
  }
  seleccionarProducto()
}

//Arma el cliente para la venta
const agregarCliente = () => {
  let cliente = document.getElementById("clienteVenta");
  cliente.addEventListener("click", () => {

    let option = document.getElementById("clienteVenta");
    let idCliente = document.getElementById("clienteVenta").value;
    let clienteNombre = cliente.options[cliente.selectedIndex].text;
    let direccion = cliente.options[cliente.selectedIndex].dataset.direccion;

    document.getElementById("ventaCliente").value = clienteNombre;
    document.getElementById("ventaIdCliente").value = idCliente;
    document.getElementById("ventaClienteDireccion").value = direccion

  })
  realizarCompra();
}

const seleccionarProducto = async () => {
  let btn = document.querySelectorAll(".agregarProducto");
  btn.forEach(element => {
    element.addEventListener("click", (e) => {
      e.preventDefault();
      let id = element.value
      getProductoVenta(id);

    })
  });
}

const getProductoVenta = async (id) => {
  let producto = await productoRepository.getById(baseUrl, id);
  let { idProducto, nombre, precio } = producto;
  document.getElementById("productoSeleccionadoNombre").value = nombre;
  document.getElementById("productoSeleccionadoPrecio").value = precio;
  document.getElementById("productoSeleccionadoId").value = idProducto;

}

const agregarAlCarrito = () => {

  let carrito = document.getElementById("listaCarritoCompra");

  carrito.innerHTML = "";
  let total = 0;
  let btn = document.getElementById("enviarProductoSeleccionado").addEventListener("click", (e) => {


    let id = document.getElementById("productoSeleccionadoId").value
    let producto = document.getElementById("productoSeleccionadoNombre").value
    let valor = document.getElementById("productoSeleccionadoPrecio").value
    let cuantos = document.getElementById("productoSeleccionadoCantidad").value

    let detalle = {
      producto: {
        idProducto: id,
        nombre: producto,
        precio: valor
      },
      cantidad: cuantos
    }
    e.preventDefault();
    DETALLES.push(detalle);
    console.log(DETALLES);


    carrito.innerHTML += `<tr class="producto" value="">
      <td>${producto}</td>
      <td>${cuantos}</td>
      <td>${valor}</td>  
  <!--agregar el type="hidden" para el idProducto  -->
      </tr>`;

    document.getElementById("productoSeleccionadoNombre").value = "";
    document.getElementById("productoSeleccionadoPrecio").value = "";
    document.getElementById("productoSeleccionadoId").value = "";
    document.getElementById("productoSeleccionadoCantidad").value = "";
    total += valor * cuantos;
    document.getElementById("totalCarrito").value = total;
    // return total;
  })



}
const realizarCompra = () => {
  console.log("clienteID");
  console.log(document.getElementById("ventaIdCliente").value);
  let btnRealizarCompra = document.getElementById("agregarCliente");


  btnRealizarCompra.addEventListener("click", (e) => {
    e.preventDefault();

    let compra = {
      cliente: {
        idCliente: document.getElementById("ventaIdCliente").value,
        nombre_apellido: document.getElementById("ventaCliente").value,
        direccion: document.getElementById("ventaClienteDireccion").value
      },
      detalles: DETALLES,
      total: document.getElementById("totalCarrito").value,
    }
    compraRepository.addCompra(baseUrl, compra);

  });

}

