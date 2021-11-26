const CompraRepository = () => {

    const addCompra = async (baseUrl, compra) => {
        console.log(compra);
        try {

            let response = await fetch(baseUrl + 'compra', {

                method: "POST",
                headers: {
                    "Accept": "application/json",
                    "Content-type": "application/json"
                },
                body: JSON.stringify(compra),

            });
            let responseJson = await response.json();
            console.log("responseJson Compra Repository");
            console.log(responseJson);
            return responseJson;


        } catch (error) {
            console.log(error);
        }
    }

    const reporteComprasDiarias = async (baseUrl) => {
        let compras = [];
        try {
            let response = await fetch(baseUrl + 'compra/comprasDiarias');
            let json = await response.json();
            compras = json;
            console.log(compras);
            return compras;

        } catch (error) {
            console.log(error);
        }
    };

    return {

        addCompra: addCompra,
        reporteComprasDiarias: reporteComprasDiarias
    }



};

export default CompraRepository();