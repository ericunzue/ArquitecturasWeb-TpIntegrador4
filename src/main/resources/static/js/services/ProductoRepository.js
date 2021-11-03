const ProductoRepository = () => {


  const addProducto = async (baseUrl, producto) => {

    try {
      let response = await fetch(baseUrl + 'producto', {

        method: "POST",
        headers: {
          "Accept": "application/json",
          "Content-type": "application/json"
        },
        body: JSON.stringify(producto)
      });
      let responseJson = await response.json();
      console.log(responseJson);

    } catch (error) {
      console.log(error);
    }
  }


  const getAll = async (baseUrl) => {
    let productos = [];
    try {
      let response = await fetch(baseUrl + 'producto');
      let json = await response.json();
      productos = json;
      return productos;

    } catch (error) {
      console.log(error);
    }
  };


  const getById = async (baseUrl, id) => {

    let producto;
    try {
      let response = await fetch(baseUrl + 'producto/' + id);
      let json = await response.json();
      producto = json;
      return producto;

    } catch (error) {
      console.log(error);
    }
  }



  return {
    getAll: getAll,
    getById: getById,
    // updateProducto: updateProducto,
    addProducto: addProducto,
  }
}

export default ProductoRepository();