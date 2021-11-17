const DetalleCompraRepository = () => {
    const addDetalleCompra = async (baseUrl, detalle) => {

        try {

            let response = await fetch(baseUrl + 'detalle', {

                method: "POST",
                headers: {
                    "Accept": "application/json",
                    "Content-type": "application/json"
                },
                body: JSON.stringify(detalle)
            });
            let responseJson = await response.json();
            console.log(responseJson);


        } catch (error) {
            console.log(error);
        }
    }

    return {

        addDetalleCompra: addDetalleCompra,
    }


}

export default DetalleCompraRepository();

