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

}