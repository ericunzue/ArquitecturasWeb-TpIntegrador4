import clienteRepository from "/js/services/ClienteRepository.js";
import productoRepository from "/js/services/ProductoRepository.js";
const baseUrl = "http://localhost:8080/"
// header('Access-Control-Allow-Origin: *');
// header('Access-Control-Allow-Methods: GET, POST, PATCH, PUT, DELETE, OPTIONS');
// header('Access-Control-Allow-Headers: Origin, Content-Type, X-Auth-Token');

window.addEventListener("DOMContentLoaded", async (e) => {
  e.preventDefault();

  cargarClientes();
  cargarProductos();
  addProducto();



})


const cargarClientes = async () => {

  let container = document.getElementById("listaClientes");
  let clientes = await clienteRepository.getAll(baseUrl);

  container.innerHTML = "";


  for (const cliente of clientes) {
    let { idCliente, nombre_apellido, direccion } = cliente;
    console.log(idCliente);

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
      console.log(element.value);
      console.log(element);
    })
  });
}

const addEventEditarCliente = (e) => {

  let btnEditarCliente = document.querySelectorAll(".editarCliente");

  btnEditarCliente.forEach(element => {
    element.addEventListener("click", (e) => {
      e.preventDefault()
      let id = element.value;
      console.log(id);

      getCliente(id);

    })
  });
}

const getCliente = async (id) => {
  console.log(id);
  let cliente = await clienteRepository.getById(baseUrl, id);
  console.log(cliente);

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

    let id = document.getElementById("clienteId").value;
    console.log(id);

    let cliente = {
      nombre_apellido: document.getElementById("clienteNombre").value,
      direccion: document.getElementById("clienteDireccion").value
    }


    if (id === undefined) {
      console.log(cliente);
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
    console.log(idProducto);

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

    let id = document.getElementById("productoId").value;

    let producto = {
      nombre: document.getElementById("productoNombre").value,
      precio: document.getElementById("productoPrecio").value,
      stock: document.getElementById("productoStock").value
    }
    console.log(id.value);
    if (typeof id === "undefined") {
      console.log(producto);
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
      console.log(element.value);
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