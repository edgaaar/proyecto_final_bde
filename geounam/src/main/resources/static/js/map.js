let map;
let circulo;

llenarEstados();

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 5,
        center: new google.maps.LatLng(23.6345005, -102.5527878)
    });

    circulo = new google.maps.Circle({
        strokeColor: '#FF0000',
        strokeOpacity: 0.8,
        strokeWeight: 2,
        fillColor: '#FF0000',
        fillOpacity: 0.35,
        map: null,
        center: { lat: 0, lng: 0 },
        radius: 1
    });
}

function llenarEstados() {

    let nombresEstados = [];
    let clavesEstados = [];

    fetch('http://localhost:3000/entidades')
        .then(response => response.json())
        .then(response => {
            response.forEach(element => {
                nombresEstados.push(element.nombreEntidad);
                clavesEstados.push(element.claveEntidad);
            });

            let select = llenaEstados(nombresEstados, clavesEstados);

            select.addEventListener('change', e =>
                actualizaMunicipios(select.options[select.selectedIndex].value));
        });
}

function llenaEstados(nombresEstados, clavesEstados) {
    let select = document.getElementById('claveEntidad');
    let fragment = document.createDocumentFragment();
    nombresEstados.forEach(function (estado, index) {
        let option = document.createElement('option');
        option.innerHTML = estado;
        option.value = clavesEstados[index];
        select.appendChild(option);
    });
    select.appendChild(fragment);
    return select;
}

function actualizaMunicipios(estadoId) {

    let nombresMunicipios = [];
    let clavesMunicipios = [];
    const uri = 'http://localhost:3000/municipios/' + estadoId;

    fetch(uri)
        .then(response => response.json())
        .then(response => {
            response.forEach(element => {
                nombresMunicipios.push(element.nombre);
                clavesMunicipios.push(element.claveMunicipio);
            });

            let select = document.getElementById('claveMunicipio');
            let fragment = document.createDocumentFragment();

            select.options.length = 0;

            nombresMunicipios.forEach((municipio, index) => {
                let option = document.createElement('option');
                option.innerHTML = municipio;
                option.value = clavesMunicipios[index];
                select.appendChild(option);
            });
            select.appendChild(fragment);

        });
}

function enviaFormBuffer() {
    const form = document.getElementById('formulario');
    const parrafo = document.getElementById('mensaje');
    const url = 'http://localhost:3000/';
    const formData = new FormData(form);
    fetch(url, {
        method: 'POST',
        body: formData
    })
        .then(response => response.json())
        .then(response => {
            const x = response.centro.coordinates[0];
            const y = response.centro.coordinates[1];
            const radio = response.radio;

            circulo.setMap(null);

            circulo = new google.maps.Circle({
                strokeColor: '#FF0000',
                strokeOpacity: 0.8,
                strokeWeight: 2,
                fillColor: '#FF0000',
                fillOpacity: 0.35,
                map: map,
                center: { lat: x, lng: y },
                radius: radio * 1000
            });

            map.panTo(new google.maps.LatLng(x, y));


            const casosConfirmados = response.numPersonasInfectadas;
            const edadPromedio = response.promEdadPersonasInfectadas.toFixed(2);
            const defunciones = response.numPersonasFallecidas;
            const numIntubados = response.numPersonasIntubadas;
            const numCasosDiabetes = response.numPersonasDiabetes;
            const numCasosObesidad = response.numPersonasObesidad;
            const numCasosHipertension = response.numPersonasHipertension;
            const numCasosInmunosupresion = response.numPersonasInmunosupresion;
            const numCasosNeumonia = response.numPersonasNeumonia;
            const numCasosTabaquismo = response.numPersonasTabaquismo;

            console.log(response);

            const textoMensaje =
                `Casos confirmados:\t${casosConfirmados}\t\tDefunciones:\t${defunciones} - ${(defunciones*100/casosConfirmados).toFixed(2)}%
Edad promedio\t\t${edadPromedio}
Personas intubadas\t${numIntubados} - ${(numIntubados*100/casosConfirmados).toFixed(2)}%
Casos con diabetes\t${numCasosDiabetes} - ${(numCasosDiabetes*100/casosConfirmados).toFixed(2)}%
Casos con obesidad\t${numCasosObesidad} - ${(numCasosObesidad*100/casosConfirmados).toFixed(2)}%
Casos con hipertensión\t${numCasosHipertension} - ${(numCasosHipertension*100/casosConfirmados).toFixed(2)}%
Casos con inmunosup.\t${numCasosInmunosupresion} - ${(numCasosInmunosupresion*100/casosConfirmados).toFixed(2)}%
Casos con neumonía\t${numCasosNeumonia} - ${(numCasosNeumonia*100/casosConfirmados).toFixed(2)}%
Casos con tabaquismo\t${numCasosTabaquismo} - ${(numCasosTabaquismo*100/casosConfirmados).toFixed(2)}%`;
            parrafo.textContent = textoMensaje;
        });
}
