const ClienteRepository = () => {

  const getAll = async (baseUrl) => {
    let clientes = [];
    try {
      let response = await fetch(baseUrl + 'cliente');
      let json = await response.json();
      clientes = json;
      return clientes;

    } catch (error) {
      console.log(error);
    }
  };

  const reporteMontoTotalPorCliente = async (baseUrl) => {
    let clientes = [];
    try {
      let response = await fetch(baseUrl + 'cliente/totalCompras');
      let json = await response.json();
      clientes = json;
      console.log(clientes);
      return clientes;

    } catch (error) {
      console.log(error);
    }
  };

  const getById = async (baseUrl, id) => {

    let cliente;
    try {
      let response = await fetch(baseUrl + 'cliente/' + id);
      let json = await response.json();
      cliente = json;
      return cliente;

    } catch (error) {
      console.log(error);
    }
  }

  const updateCliente = async (baseUrl, id, cliente) => {
    try {
      let response = await fetch(baseUrl + 'cliente/' + id, {

        method: "PUT",
        headers: {
          "Accept": "application/json",
          "Content-type": "application/json"
        },
        body: JSON.stringify(cliente)
      });
      let responseJson = await response.json();
      console.log(responseJson);
    } catch (error) {
      console.log(error);
    }
  }



  const addCliente = async (baseUrl, cliente) => {

    try {
      let response = await fetch(baseUrl + 'cliente', {

        method: "POST",
        headers: {
          "Accept": "application/json",
          "Content-type": "application/json"
        },
        body: JSON.stringify(cliente)
      });
      let responseJson = await response.json();
      console.log(responseJson);

    } catch (error) {
      console.log(error);
    }
  }

  return {
    getAll: getAll,
    getById: getById,
    updateCliente: updateCliente,
    addCliente: addCliente,
    reporteMontoTotalPorCliente: reporteMontoTotalPorCliente,
  }
};

export default ClienteRepository();