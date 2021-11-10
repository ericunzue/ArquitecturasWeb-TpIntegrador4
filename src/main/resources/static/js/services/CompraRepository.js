const CompraRepository = () => {

    const addCompra = async (baseUrl, compra) => {

        try {
            console.log("entro")
            console.log(compra);
            let response = await fetch(baseUrl + 'compra', {

                method: "POST",
                headers: {
                    "Accept": "application/json",
                    "Content-type": "application/json"
                },
                body: JSON.stringify(compra)
            });
            let responseJson = await response.json();
            return responseJson;


        } catch (error) {
            console.log(error);
        }
    }

    return {

        addCompra: addCompra,
    }



};

export default CompraRepository();