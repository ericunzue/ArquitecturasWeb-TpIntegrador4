import clienteRepository from "/js/services/ClienteRepository.js";
import productoRepository from "/js/services/ProductoRepository.js";
import compraRepository from "/js/services/CompraRepository.js";
import detalleCompraRepository from "/js/services/DetalleCompraRepository.js";
const baseUrl = "http://localhost:9090/"
let COMPRAS = []
window.addEventListener("DOMContentLoaded", async (e) => {
  e.preventDefault();

  cargarClientes();
  cargarProductos();
  addProducto();
  listarCLientesVenta();
  listarProductosVenta();
  agregarAlCarrito();
  realizarCompra();



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

const agregarCliente = () => {
  let cliente = document.getElementById("clienteVenta");
  cliente.addEventListener("click", () => {

    let option = document.getElementById("clienteVenta");
    let idCliente = document.getElementById("clienteVenta").value;
    let clienteNombre = cliente.options[cliente.selectedIndex].text;
    let direccion = cliente.options[cliente.selectedIndex].dataset.direccion;
    console.log(cliente.options[cliente.selectedIndex].dataset.direccion);
    console.log("direccion");
    console.log(direccion);

    document.getElementById("ventaCliente").value = clienteNombre;
    document.getElementById("ventaIdCliente").value = idCliente;
    document.getElementById("ventaClienteDireccion").value = direccion
  })
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

  let btn = document.getElementById("enviarProductoSeleccionado").addEventListener("click", (e) => {
    let fila = {
      nombre: document.getElementById("productoSeleccionadoNombre").value,
      precio: document.getElementById("productoSeleccionadoPrecio").value,
      idProducto: document.getElementById("productoSeleccionadoId").value,
      cantidad: document.getElementById("productoSeleccionadoCantidad").value,
    }
    e.preventDefault();
    COMPRAS.push(fila);

    let { nombre, precio, idProducto, cantidad } = fila;
    carrito.innerHTML += `<tr class="producto" value="">
      <td>${nombre}</td>
      <td>${cantidad}</td>
      <td>${precio}</td>  
  <!--agregar el type="hidden" para el idProducto  -->
      </tr>`;

    document.getElementById("productoSeleccionadoNombre").value = "";
    document.getElementById("productoSeleccionadoPrecio").value = "";
    document.getElementById("productoSeleccionadoId").value = "";
    document.getElementById("productoSeleccionadoCantidad").value = "";
  })


}
const realizarCompra = () => {

  let btnRealizarCompra = document.getElementById("agregarCliente");
  console.log("entro a realizar compra");
  btnRealizarCompra.addEventListener("click", (e) => {
    e.preventDefault();
    console.log(document.getElementById("ventaIdCliente").value);
    let encabezado = {

      cliente: {
        idCliente: parseInt(document.getElementById("ventaIdCliente").value),
        nombre_apellido: document.getElementById("ventaCliente").value,
        direccion: document.getElementById("ventaClienteDireccion").value
      },
      fecha: new Date().getDate,
      total: 100
    }
    console.log(encabezado);

    let encabezadoCompra = compraRepository.addCompra(baseUrl, encabezado);

    COMPRAS.forEach(element => {
      //DETALLE COMPRA IDCOMPRA IDPRODUCTO CANT
      let detalleCompra = {
        compra: encabezadoCompra,
        producto: {
          idProducto: parseInt(element.idProducto),
          nombre: element.nombre,
          precio: parseInt(element.precio),
          stock: 10

        },
        cantidad: parseInt(element.cantidad),
        total: element.cantidad * element.precio
      }
      console.log("antes del fech");
      console.log(detalleCompra)
      detalleCompraRepository.addDetalleCompra(baseUrl, detalleCompra)

    });

  });

}

