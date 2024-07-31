import { hacerPeticion } from "./getDatos.js";




const enviarFormularioBoton = document.getElementById('enviarFormularioBtn');
enviarFormularioBoton.addEventListener('click', enviarLogin);




function enviarLogin() {
    const form = document.getElementById('loginForm');
    const usuario = form.querySelector('[name="usuario"]').value;
    const password = form.querySelector('[name="password"]').value;
    const endpoint = 'auth/login';
    const body = JSON.stringify({
            "username": usuario,
            "password": password
        });
    const respuesta = hacerPeticion(endpoint, body);
    console.log(respuesta);




}


const enviarRegistroBoton = document.getElementById('enviarRegistroBtn');
enviarRegistroBoton.addEventListener('click', enviarRegistro);

function enviarRegistro() {

    const nombre = document.getElementById('nombre').value;
    const apellido = document.getElementById('apellido').value;
    const email = document.getElementById('email').value;
    const usuario = document.getElementById('usuario').value;
    const password = document.getElementById('password').value;
    const confirmarPassword = document.getElementById('confirmarPassword').value;

    const endpoint = 'auth/registro';

    if (password !== confirmarPassword) {
        alert('Las contraseñas no coinciden');
        return;
    }

    const body = JSON.stringify({
        "nombre": nombre,
        "apellido": apellido,
        "email": email,
        "username": usuario,
        "password": password
    });

    const respuesta = fetch('http://localhost:8081/auth/registro', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: body
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            alert('Usuario registrado correctamente');
        })
        .catch(error => {
            console.error(error);
        });


}