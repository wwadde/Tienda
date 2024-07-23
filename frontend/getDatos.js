const urlBase = "http://localhost:8081";

export function hacerPeticion(endpoint, body) {
  
    const url = `${urlBase}/${endpoint}`;
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: body
    };

    fetch(url, options)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            console.log('prueba');
            return response.json();
        })
        .then(data => {
            // Handle the response from the backend
            console.log('prueba2');
            console.log(data);
            // Aquí podrías redirigir al usuario o mostrar un mensaje de éxito
        })
        .catch(error => {
            // Handle any errors
            console.error(error);
            // Mostrar al usuario un mensaje de error
        });
}