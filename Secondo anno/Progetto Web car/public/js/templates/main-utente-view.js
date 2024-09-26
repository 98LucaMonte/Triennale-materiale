"use-strict";

//parte main utente pagina Home
function creaMainUtenteHome(user) {

    return `
    <div class="container margin-top-form-login">
    <h5><strong>Benvenuto ${user.nome} ${user.cognome}!</strong></h5>
    <div class="container text-center mt-5">
        <div class="row">
            <div class="col-sm-3 margin-form-comandi-utente">
                <a class="text-dark" id="OperazioneRicerca" style="cursor: pointer;">
                    <div class="card color-card">
                        <div class="card-body">
                            <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                                class="bi bi-search" viewBox="0 0 16 16">
                                <path
                                    d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
                            </svg>
                        </div>
                        <p><strong>Trova un punto di ricarica</strong></p>
                    </div>
                </a>
            </div>
            <div class="col-sm-3 margin-form-comandi-utente">
                <a class="text-dark" id="OperazioneVisualizzaCariche">
                    <div class="card color-card">
                        <div class="card-body">
                            <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                                class="bi bi-fuel-pump-fill" viewBox="0 0 16 16">
                                <path
                                    d="M1 2a2 2 0 0 1 2-2h6a2 2 0 0 1 2 2v8a2 2 0 0 1 2 2v.5a.5.5 0 0 0 1 0V8h-.5a.5.5 0 0 1-.5-.5V4.375a.5.5 0 0 1 .5-.5h1.495c-.011-.476-.053-.894-.201-1.222a.97.97 0 0 0-.394-.458c-.184-.11-.464-.195-.9-.195a.5.5 0 0 1 0-1c.564 0 1.034.11 1.412.336.383.228.634.551.794.907.295.655.294 1.465.294 2.081V7.5a.5.5 0 0 1-.5.5H15v4.5a1.5 1.5 0 0 1-3 0V12a1 1 0 0 0-1-1v4h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V2Zm2.5 0a.5.5 0 0 0-.5.5v5a.5.5 0 0 0 .5.5h5a.5.5 0 0 0 .5-.5v-5a.5.5 0 0 0-.5-.5h-5Z" />
                            </svg>
                        </div>
                        <p><strong>Visualizza cariche effettuate</strong></p>
                    </div>
                </a>
            </div>
            <div class="col-sm-3 margin-form-comandi-utente">
                <a class="text-dark" id="OperazioneGestioneVeicoli">
                    <div class="card color-card">
                        <div class="card-body">
                            <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                                class="bi bi-car-front-fill" viewBox="0 0 16 16">
                                <path
                                    d="M2.52 3.515A2.5 2.5 0 0 1 4.82 2h6.362c1 0 1.904.596 2.298 1.515l.792 1.848c.075.175.21.319.38.404.5.25.855.715.965 1.262l.335 1.679c.033.161.049.325.049.49v.413c0 .814-.39 1.543-1 1.997V13.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1.338c-1.292.048-2.745.088-4 .088s-2.708-.04-4-.088V13.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1.892c-.61-.454-1-1.183-1-1.997v-.413a2.5 2.5 0 0 1 .049-.49l.335-1.68c.11-.546.465-1.012.964-1.261a.807.807 0 0 0 .381-.404l.792-1.848ZM3 10a1 1 0 1 0 0-2 1 1 0 0 0 0 2Zm10 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2ZM6 8a1 1 0 0 0 0 2h4a1 1 0 1 0 0-2H6ZM2.906 5.189a.51.51 0 0 0 .497.731c.91-.073 3.35-.17 4.597-.17 1.247 0 3.688.097 4.597.17a.51.51 0 0 0 .497-.731l-.956-1.913A.5.5 0 0 0 11.691 3H4.309a.5.5 0 0 0-.447.276L2.906 5.19Z" />
                            </svg>
                        </div>
                        <p><strong>Sezione gestione veicoli</strong></p>
                    </div>
                </a>
            </div>
            <div class="col-sm-3 margin-form-comandi-utente">
                <a class="text-dark" id="OperazioneVisualizzaDatiUtente"> 
                    <div class="card color-card">
                        <div class="card-body">
                            <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                                class="bi bi-person-lines-fill" viewBox="0 0 16 16">
                                <path
                                    d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z" />
                            </svg>
                        </div>
                        <p><strong>Visualizza dati utente</strong></p>
                    </div>
                </a>
            </div>
        </div>
    </div>
    <div id="MessaggioFineOperazioneUtente"></div>
</div>
    `;
}

//parte main utente pagina dati utente
function creaMainUtenteDatiUtente(user,numeroRicariche) {

    return `
    <div class="container margin-top-header-main">
    <h5><strong>Benvenuto ${user.nome} ${user.cognome}!</strong></h5><br>
    <div class="row">
        <div class="col-sm-4">
            <a class="btn navbar-brand" href="/utente">
                <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                    class="bi bi-person" viewBox="0 0 16 16">
                    <path
                        d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" />
                </svg>Torna alla tua pagina
            </a>
        </div>
        <div class="col-sm-4"></div>
        <div class="col-sm-4"></div>
    </div>

    <div class="row">
        <div class="col-sm border border-secondary mt-5">
            <h5><strong>Informazioni Utente</strong></h5>
            
            <div>
                <ul class="list-group padding-form-info-utente">
                    <li class="list-group-item color-form-info-utente"><strong>Nome: ${user.nome}</strong></li>
                    <li class="list-group-item color-form-info-utente"><strong>Cognome: ${user.cognome}</strong></li>
                    <li class="list-group-item color-form-info-utente"><strong>Codice fiscale: ${user.cf}</strong></li>
                    <li class="list-group-item color-form-info-utente"><strong>Email: ${user.email}</strong></li>
                    <li class="list-group-item color-form-info-utente"><strong>Numero ricariche effettuate: ${numeroRicariche}</strong></li>
                </ul>
            </div>
        </div>
    </div>

</div>
    `;
}

//parte main utente pagina ricerca punto di ricarica (solo il form di ricerca)
function creaMainUtenteRicerca(user) {

    return `
    <div class="container margin-top-form-login">
    <h5><strong>Benvenuto ${user.nome} ${user.cognome}!</strong></h5><br>
        <div class="row">
            <div class="col-sm-4">
                <a class="btn navbar-brand" href="/utente">
                    <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                        class="bi bi-person" viewBox="0 0 16 16">
                        <path
                            d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" />
                    </svg>Torna alla tua pagina
                </a>
            </div>
            <div class="col-sm-4"></div>
            <div class="col-sm-4"></div>
        </div>

        <form class="row mt-5 margin-table-utente">
            <div class="col-sm-4 mt-3">
                <label for="colFormLabelSm"><strong>Inserisci città</strong></label>
                <input type="text" class="form-control" placeholder="Inserisci città" id="Città">
            </div>
            <div class="col-sm-4 mt-3">
                <label for="colFormLabelSm"><strong>Inserisci indirizzo</strong></label>
                <input type="text" class="form-control" placeholder="Inserisci indirizzo" id="Indirizzo">
            </div>
            <div class="col-sm-4 mt-3">
                <label for="colFormLabelSm"><strong>Inserisci id punto ricarica</strong></label>
                <input type="text" class="form-control" placeholder="Inserisci id punto ricarica" id="CodicePuntoRicarica">
            </div>
            <div class="col-sm-2 mt-3">
                <button type="submit" class="btn btn-secondary" id="RicercaColonnina">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                        class="bi bi-search" viewBox="0 0 16 16">
                        <path
                            d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
                    </svg>
                    Cerca</button>
            </div>
        </form>

        <div class="table-responsive" id="RisultatiRicerca">
        </div>

</div>        
    `;
}

//parte main utente pagina ricerca punto di ricarica (tabella dei risultati della ricerca)
function creaMainUtenteRicercaTabella(){
    return `
    <table class="table" id="TabellaRicercaColonnine">
        <thead>
            <tr class="table-dark">
                <th scope="col">Città</th>
                <th scope="col">Indirizzo</th>
                <th scope="col">Stato</th>
                <th scope="col">Targa</th>
                <th scope="col">Prenota</th>
            </tr>
        </thead>
        <tbody id="DatiTabellaColonnine">
        </tbody>
    </table>

    `;
}

//parte main utente pagina ricerca punto di ricarica (risultati della ricerca)
function creaMainUtenteRicercaRisultati(colonnina){
    return `
    <tr class="color-row-table">
        <th scope="row">${colonnina.città}</th>
        <td>${colonnina.indirizzo}</td>
        <td>${colonnina.stato}</td>
        <td>
            <select class="form-select form-select-sm" id="Targhe${colonnina.codice}" aria-label="Floating label select example">
                <option selected></option>
                
            </select>
        </td>
        <td><button type="button" class="btn btn-secondary btn-sm" id="Button${colonnina.codice}" data-id="Prenota${colonnina.codice}">Prenota</button></td>
    </tr>
    `;
}

//parte main utente pagina ricerca ricariche effettuate  (solo il form di ricerca)
function creaMainUtenteRicercaRicariche(user){
    return `
    <div class="container margin-top-form-login">
            <h5><strong>Benvenuto ${user.nome} ${user.cognome}!</strong></h5><br>
            <div class="row">
                <div class="col-sm-4">
                    <a class="btn navbar-brand" href="/utente">
                        <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-person"
                            viewBox="0 0 16 16">
                            <path
                                d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" />
                        </svg>Torna alla tua pagina
                    </a>
                </div>
                <div class="col-sm-4">
                    <a class="btn navbar-brand">
                        <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                            class="bi bi-fuel-pump-fill" viewBox="0 0 16 16">
                            <path
                                d="M1 2a2 2 0 0 1 2-2h6a2 2 0 0 1 2 2v8a2 2 0 0 1 2 2v.5a.5.5 0 0 0 1 0V8h-.5a.5.5 0 0 1-.5-.5V4.375a.5.5 0 0 1 .5-.5h1.495c-.011-.476-.053-.894-.201-1.222a.97.97 0 0 0-.394-.458c-.184-.11-.464-.195-.9-.195a.5.5 0 0 1 0-1c.564 0 1.034.11 1.412.336.383.228.634.551.794.907.295.655.294 1.465.294 2.081V7.5a.5.5 0 0 1-.5.5H15v4.5a1.5 1.5 0 0 1-3 0V12a1 1 0 0 0-1-1v4h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V2Zm2.5 0a.5.5 0 0 0-.5.5v5a.5.5 0 0 0 .5.5h5a.5.5 0 0 0 .5-.5v-5a.5.5 0 0 0-.5-.5h-5Z" />
                        </svg>Ricariche effettuate
                    </a>
                </div>
                <div class="col-sm-4"></div>
            </div>
            

            <form class="row mt-5 margin-table-utente">
                <div class="col-sm-4 mt-3">
                    <label for="colFormLabelSm"><strong>Inserisci targa</strong></label>
                    <input type="text" class="form-control" placeholder="Inserisci targa" id="Targa" required>
                </div>
                <div class="col-sm-4 mt-3">
                    <label for="colFormLabelSm"><strong>Inserisci città</strong></label>
                    <input type="text" class="form-control" placeholder="Inserisci città" id="Città" required>
                </div>
                <div class="col-sm-4 mt-3">
                    
                </div>
                <div class="col-sm-2 mt-3">
                    <button type="submit" class="btn btn-secondary" id="RicercaRicariche">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                            class="bi bi-search" viewBox="0 0 16 16">
                            <path
                                d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
                        </svg>
                        Cerca</button>
                </div>
            </form>


            <div class="table-responsive text-center" id="RisultatiRicerca">
            </div>
        </div>
    `;
}

//parte main utente pagina ricerca punto di ricarica (tabella dei risultati della ricerca)
function creaMainUtenteRicercaRicaricheTabella(){
    return `
    <table class="table" id="TabellaRicercaRicariche">
        <thead>
            <tr class="table-dark">
                <th scope="col">Targa</th>
                <th scope="col">Città</th>
                <th scope="col">Indirizzo</th>
                <th scope="col">Id Colonnina</th>
                <th scope="col">Stato Ricarica</th>
                <th scope="col">Termina</th>
            </tr>
        </thead>
        <tbody id="DatiTabellaRicariche">
        </tbody>
    </table>

    `;
}

//parte main utente pagina ricerca punto di ricarica (risultati della ricerca)
function creaMainUtenteRicercaRicaricheRisultati(ricarica){
    return `
    <tr class="color-row-table">
        <th scope="row">${ricarica.targa}</th>
        <td>${ricarica.città}</td>
        <td>${ricarica.indirizzo}</td>
        <td>${ricarica.idColonnina}</td>
        <td>${ricarica.stato}</td>
        <td><button type="button" class="btn btn-secondary btn-sm" id="Button${ricarica.codicePrenotazione}" data-id="Termina${ricarica.codicePrenotazione}">Termina</button></td>
    </tr>
    `;
}

//parte main utente pagina veicoli
function creaMainUtenteInfoVeicoli(user){
    return `
    <div class="container margin-top-header-main">
            <h5><strong>Benvenuto ${user.nome} ${user.cognome}!</strong></h5><br>
            <div class="row">
                <div class="col-sm-4 mt-2">
                <a class="btn navbar-brand" href="/utente">
                        <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                            class="bi bi-person" viewBox="0 0 16 16">
                            <path
                                d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" />
                        </svg>Torna alla tua pagina
                </a>
                </div>
                <div class="col-sm-4 mt-2">
                    <button class="btn navbar-brand" id="AggiungiVeicolo">
                        <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                            class="bi bi-car-front" viewBox="0 0 16 16">
                            <path
                                d="M4 9a1 1 0 1 1-2 0 1 1 0 0 1 2 0Zm10 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0ZM6 8a1 1 0 0 0 0 2h4a1 1 0 1 0 0-2H6ZM4.862 4.276 3.906 6.19a.51.51 0 0 0 .497.731c.91-.073 2.35-.17 3.597-.17 1.247 0 2.688.097 3.597.17a.51.51 0 0 0 .497-.731l-.956-1.913A.5.5 0 0 0 10.691 4H5.309a.5.5 0 0 0-.447.276Z" />
                            <path
                                d="M2.52 3.515A2.5 2.5 0 0 1 4.82 2h6.362c1 0 1.904.596 2.298 1.515l.792 1.848c.075.175.21.319.38.404.5.25.855.715.965 1.262l.335 1.679c.033.161.049.325.049.49v.413c0 .814-.39 1.543-1 1.997V13.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1.338c-1.292.048-2.745.088-4 .088s-2.708-.04-4-.088V13.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1.892c-.61-.454-1-1.183-1-1.997v-.413a2.5 2.5 0 0 1 .049-.49l.335-1.68c.11-.546.465-1.012.964-1.261a.807.807 0 0 0 .381-.404l.792-1.848ZM4.82 3a1.5 1.5 0 0 0-1.379.91l-.792 1.847a1.8 1.8 0 0 1-.853.904.807.807 0 0 0-.43.564L1.03 8.904a1.5 1.5 0 0 0-.03.294v.413c0 .796.62 1.448 1.408 1.484 1.555.07 3.786.155 5.592.155 1.806 0 4.037-.084 5.592-.155A1.479 1.479 0 0 0 15 9.611v-.413c0-.099-.01-.197-.03-.294l-.335-1.68a.807.807 0 0 0-.43-.563 1.807 1.807 0 0 1-.853-.904l-.792-1.848A1.5 1.5 0 0 0 11.18 3H4.82Z" />
                        </svg>
                        <strong>Aggiungi veicolo</strong>
                    </button>
                </div>
                <div class="col-sm-4" id="RisultatoOperazione">

                </div>
            </div>

            <div class="mt-5" id="MessaggioNessunVeicolo"> 
            </div>

            <div class="container">
                <div class="row mt-3">
                    <div class="col-sm-4 mt-3" id="Veicolo0">
                        
                    </div>
                    <div class="col-sm-4 mt-3" id="Veicolo1">
                        
                    </div>
                    <div class="col-sm-4 mt-3" id="Veicolo2">
                        
                    </div>
                </div>
            </div>

        </div>
    `;
}

//parte main utente form per aggiungere un veicolo
function creaMainUtenteFormAggiungiVeicolo(){
    return `
    <div class="container margin-top-header-main">
            <div class="row">
                <div class="col-sm-4 mt-2">
                    <a type="button" class="btn" href="/utente">
                        <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                            class="bi bi-person" viewBox="0 0 16 16">
                            <path
                                d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" />
                        </svg>Torna alla tua pagina
                    </a>
                </div>
                <div class="col-sm-4 mt-2" id="MessaggioErrore">
                </div>
                <div class="col-sm-4">
    
                </div>
            </div>
            
            <div class="row margin-top-header-main-aggiungi-veicolo padding-aggiungi-veicolo">
                <div class="col-sm-12">
                    <div class="small-form">
                        <div class="border border-secondary color-form">
                            <form>
                                <h5 class="text-center mt-5 mb-2"><strong>Aggiungi veicolo</strong></h5>
                                <div class="margin-label-input-form">
                                    <label for="exampleInputEmail1" class="form-label"><strong>Inserisci la targa</strong></label>
                                    <input type="text" class="form-control form-control-sm" id="Targa"
                                        aria-describedby="emailHelp" placeholder="Inserisci la targa">
                                </div>
                                <div class="margin-label-input-form">
                                    <label for="exampleInputPassword1" class="form-label"><strong>Inserisci la marca</strong></label>
                                    <input type="text" class="form-control form-control-sm" id="Marca"
                                        placeholder="Inserisci la marca">
                                </div>
                                <div class="margin-label-input-form">
                                    <label for="exampleInputPassword1" class="form-label"><strong>Inserisci il modello</strong></label>
                                    <input type="text" class="form-control form-control-sm" id="Modello"
                                        placeholder="Inserisci il modello">
                                </div>
                                <div class="text-center margin-label-input-form">
                                    <button type="submit" class="btn btn-secondary" id="Aggiungi">Aggiungi</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
            
    `;
}


//parte main utente veicolo
function creaMainUtenteVeicolo(veicolo,numeroRicaricheVeicolo){
    return `
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Informazioni veicolo</h5>
            <div>
                <ul class="list-group padding-form-info-utente">
                    <li class="list-group-item color-form-info-utente"><strong>Targa: ${veicolo.targa}</strong></li>
                    <li class="list-group-item color-form-info-utente"><strong>Marca: ${veicolo.marca}</strong></li>
                    <li class="list-group-item color-form-info-utente"><strong>Modello: ${veicolo.modello}</strong></li>
                    <li class="list-group-item color-form-info-utente"><strong>Ricariche effettuate: ${numeroRicaricheVeicolo}</strong></li>
                </ul>
                <button type="button" class="btn btn-secondary" data-id="${veicolo.targa}">Rimuovi</button>
            </div>
        </div>
    </div>
    `;
}

export {creaMainUtenteVeicolo,creaMainUtenteFormAggiungiVeicolo,creaMainUtenteInfoVeicoli,creaMainUtenteRicercaRicaricheRisultati,creaMainUtenteRicercaRicaricheTabella,creaMainUtenteRicercaRicariche,creaMainUtenteRicercaRisultati,creaMainUtenteRicercaTabella,creaMainUtenteRicerca,creaMainUtenteDatiUtente, creaMainUtenteHome };