"use-strict";

//parte main admin principale
function creaMainAdmin(admin){
    return `
    <div class="container margin-top-form-login">
            <h5><strong>Benvenuto ${admin.nome} ${admin.cognome}!</strong></h5>
            <div class="container text-center mt-5">
                <div class="row">
                    <div class="col-sm-3 margin-form-comandi-utente">
                        <a class="text-dark" id="OperazioneAggiungiColonnina">
                            <div class="card color-card">
                                <div class="card-body">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                                        class="bi bi-fuel-pump-fill" viewBox="0 0 16 16">
                                        <path
                                            d="M1 2a2 2 0 0 1 2-2h6a2 2 0 0 1 2 2v8a2 2 0 0 1 2 2v.5a.5.5 0 0 0 1 0V8h-.5a.5.5 0 0 1-.5-.5V4.375a.5.5 0 0 1 .5-.5h1.495c-.011-.476-.053-.894-.201-1.222a.97.97 0 0 0-.394-.458c-.184-.11-.464-.195-.9-.195a.5.5 0 0 1 0-1c.564 0 1.034.11 1.412.336.383.228.634.551.794.907.295.655.294 1.465.294 2.081V7.5a.5.5 0 0 1-.5.5H15v4.5a1.5 1.5 0 0 1-3 0V12a1 1 0 0 0-1-1v4h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V2Zm2.5 0a.5.5 0 0 0-.5.5v5a.5.5 0 0 0 .5.5h5a.5.5 0 0 0 .5-.5v-5a.5.5 0 0 0-.5-.5h-5Z" />
                                    </svg>
                                </div>
                                <p><strong>Aggiungi colonnina di ricarica</strong></p>
                            </div>
                        </a>
                    </div>
                    <div class="col-sm-3 margin-form-comandi-utente">
                        <a class="text-dark" id="OperazioneRimuoviColonnina">
                            <div class="card color-card">
                                <div class="card-body">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                                        class="bi bi-fuel-pump-fill" viewBox="0 0 16 16">
                                        <path
                                            d="M1 2a2 2 0 0 1 2-2h6a2 2 0 0 1 2 2v8a2 2 0 0 1 2 2v.5a.5.5 0 0 0 1 0V8h-.5a.5.5 0 0 1-.5-.5V4.375a.5.5 0 0 1 .5-.5h1.495c-.011-.476-.053-.894-.201-1.222a.97.97 0 0 0-.394-.458c-.184-.11-.464-.195-.9-.195a.5.5 0 0 1 0-1c.564 0 1.034.11 1.412.336.383.228.634.551.794.907.295.655.294 1.465.294 2.081V7.5a.5.5 0 0 1-.5.5H15v4.5a1.5 1.5 0 0 1-3 0V12a1 1 0 0 0-1-1v4h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V2Zm2.5 0a.5.5 0 0 0-.5.5v5a.5.5 0 0 0 .5.5h5a.5.5 0 0 0 .5-.5v-5a.5.5 0 0 0-.5-.5h-5Z" />
                                    </svg>
                                </div>
                                <p><strong>Rimuovi colonnina di ricarica</strong></p>
                            </div>
                        </a>
                    </div>
                    <div class="col-sm-3 margin-form-comandi-utente">
                        <a class="text-dark" id="OperazioneGestisciColonnina">
                            <div class="card color-card">
                                <div class="card-body">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                                        class="bi bi-fuel-pump-fill" viewBox="0 0 16 16">
                                        <path
                                            d="M1 2a2 2 0 0 1 2-2h6a2 2 0 0 1 2 2v8a2 2 0 0 1 2 2v.5a.5.5 0 0 0 1 0V8h-.5a.5.5 0 0 1-.5-.5V4.375a.5.5 0 0 1 .5-.5h1.495c-.011-.476-.053-.894-.201-1.222a.97.97 0 0 0-.394-.458c-.184-.11-.464-.195-.9-.195a.5.5 0 0 1 0-1c.564 0 1.034.11 1.412.336.383.228.634.551.794.907.295.655.294 1.465.294 2.081V7.5a.5.5 0 0 1-.5.5H15v4.5a1.5 1.5 0 0 1-3 0V12a1 1 0 0 0-1-1v4h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V2Zm2.5 0a.5.5 0 0 0-.5.5v5a.5.5 0 0 0 .5.5h5a.5.5 0 0 0 .5-.5v-5a.5.5 0 0 0-.5-.5h-5Z" />
                                    </svg>
                                </div>
                                <p><strong>Gestione disponibilità colonnina</strong></p>
                            </div>
                        </a>
                    </div>
                    <div class="col-sm-3 margin-form-comandi-utente">
                        <a class="text-dark" id="OperazioneRichieste">
                            <div class="card color-card">
                                <div class="card-body">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-journal-text" viewBox="0 0 16 16">
                                    <path d="M5 10.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
                                    <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z"/>
                                    <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z"/>
                                    </svg>
                                </div>
                                <p><strong>Gestione richieste</strong></p>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <div id="MessaggioFineOperazioneAdmin"></div>
        </div>
    `;
}

//parte main admin rimuovi colonnina
function creaMainAdminRimuoviColonnina(admin){
    return `
    <div class="container margin-top-header-main">
    <h5><strong>Benvenuto ${admin.nome} ${admin.cognome}!</strong></h5>
    <div class="row">
        <div class="col-sm-4 mt-2">
            <a type="button" class="btn" href="/admin">
                <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                    class="bi bi-person" viewBox="0 0 16 16">
                    <path
                        d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" />
                </svg>Torna alla tua pagina
            </a>
        </div>
        <div class="col-sm-4">
            
        </div>
        <div class="col-sm-4">

        </div>
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
            <button type="submit" class="btn btn-secondary" id="RicercaColonninaRimuovi">
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

//parte main admin rimuovi colonnina tabella
function creaMainAdminTabellaRimuoviColonnina(){
    return `
    <table class="table">
    <thead>
        <tr class="table-dark">
            <th scope="col">Città</th>
            <th scope="col">Indirizzo</th>
            <th scope="col">Id colonnina</th>
            <th scope="col">Stato</th>
            <th scope="col">Rimuovi</th>
        </tr>
    </thead>
    <tbody id="DatiTabellaColonnineRimuovi">
       
    </tbody>
</table>
    `;
}

//parte main admin rimuovi colonnina risultati
function creaMainAdminRisultatoRimuoviColonnina(colonnina){
    return `
        <tr class="color-row-table">
            <th scope="row">${colonnina.città}</th>
            <td>${colonnina.indirizzo}</td>
            <td>${colonnina.codice}</td>
            <td>${colonnina.stato}</td>
            <td><button type="button" class="btn btn-secondary btn-sm" id="Button${colonnina.codice}" data-id="Rimuovi${colonnina.codice}">Rimuovi</button></td>
        </tr>
    `;
}

//parte main admin form per aggiungere una nuova colonnina
function creaMainAdminFormAggiungiColonnina(admin){
    return `
    <div class="container margin-top-header-main">
    <h5><strong>Benvenuto ${admin.nome} ${admin.cognome}!</strong></h5>

    <div class="row">
        <div class="col-sm-4 mt-2">
            <a type="button" class="btn" href="/admin">
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
                        <h5 class="text-center mt-5 mb-2"><strong>Aggiungi colonnina</strong></h5>
                        <div class="margin-label-input-form">
                            <label for="exampleInputEmail1" class="form-label"><strong>Inserisci la città</strong></label>
                            <input type="text" class="form-control form-control-sm" id="Città" aria-describedby="emailHelp" placeholder="Inserisci la città">
                        </div>
                        <div class="margin-label-input-form">
                            <label for="exampleInputPassword1" class="form-label"><strong>Inserisci l'indirizzo</strong></label>
                            <input type="text" class="form-control form-control-sm" id="Indirizzo"
                                placeholder="Inserisci l'indirizzo">
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

//parte main admin rimuovi colonnina risultati
function creaMainAdminGestioneStatoColonnine(admin){
    return `
    <div class="container margin-top-header-main">
    <h5><strong>Benvenuto ${admin.nome} ${admin.cognome}!</strong></h5>
    <div class="row">
        <div class="col-sm-4 mt-2">
            <a type="button" class="btn" href="/admin">
                <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                    class="bi bi-person" viewBox="0 0 16 16">
                    <path
                        d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" />
                </svg>Torna alla tua pagina
            </a>
        </div>
        <div class="col-sm-4">
            
        </div>
        <div class="col-sm-4">

        </div>
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
            <input type="text" class="form-control" placeholder="Inserisci id punto ricarica"id="CodicePuntoRicarica">
        </div>
        <div class="col-sm-2 mt-3">
            <button type="submit" class="btn btn-secondary" id="RicercaColonninaModificaStato">
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

//parte main admin rimuovi colonnina risultati
function creaMainAdminGestioneStatoColonnineTabella(){
    return `
    <table class="table">
        <thead>
            <tr class="table-dark">
                <th scope="col">Città</th>
                <th scope="col">Indirizzo</th>
                <th scope="col">Id colonnina</th>
                <th scope="col">Stato attuale</th>
                <th scope="col">Scegli stato</th>
                <th scope="col">Aggiorna stato</th>
            </tr>
        </thead>
        <tbody id="DatiTabellaColonnineModificaStato">
        
        </tbody>
    </table>
    `;
}

//parte main admin rimuovi colonnina risultati
function creaMainAdminGestioneStatoColonnineRisultati(colonnina){
    return `
        <tr class="color-row-table">
            <th scope="row">${colonnina.città}</th>
            <td>${colonnina.indirizzo}</td>
            <td>${colonnina.codice}</td>
            <td>${colonnina.stato}</td>
            <td>
                <select class="form-select form-select-sm" id="Colonnina${colonnina.codice}" aria-label="Default select example">
                    <option selected></option>
                    <option value="1">Guasta</option>
                    <option value="2">Prenotabile</option>
                </select>
            </td>
            <td><button type="button" class="btn btn-secondary btn-sm" id="Button${colonnina.codice}" data-id="Aggiorna${colonnina.codice}">Aggiorna</button></td>
        </tr>
    `;
}

//parte main admin gestione richieste
function creaMainAdminGestioneRichieste(admin){
    return `
    <div class="container margin-top-header-main">
    <h5><strong>Benvenuto ${admin.nome} ${admin.cognome}!</strong></h5>
    <div class="row">
        <div class="col-sm-4 mt-2">
            <a type="button" class="btn" href="/admin">
                <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                    class="bi bi-person" viewBox="0 0 16 16">
                    <path
                        d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" />
                </svg>Torna alla tua pagina
            </a>
        </div>
        <div class="col-sm-4">
            
        </div>
        <div class="col-sm-4">

        </div>
    </div>

    <div id="NessunaRichiesta" class="container-fluid"></div>
    
    <div class="table-responsive mt-5" id="RisultatiRicerca">
        
    </div>

</div>
    `;
}

//parte main admin rimuovi colonnina tabella
function creaMainAdminTabellaGestioneRichieste(){
    return `
    <table class="table">
    <thead>
        <tr class="table-dark">
            <th scope="col">Email</th>
            <th scope="col">Telefono</th>
            <th scope="col">Data</th>
            <th scope="col">Stato</th>
            <th scope="col">Gestisci</th>
        </tr>
    </thead>
    <tbody id="DatiTabellaRichieste">
       
    </tbody>
</table>
    `;
}

//parte main admin rimuovi colonnina risultati
function creaMainAdminTabellaGestioneRichiestaRisultati(richiesta){
    return `
        <tr class="color-row-table">
            <th scope="row">${richiesta.email}</th>
            <td>${richiesta.telefono}</td>
            <td>${richiesta.data}</td>
            <td>${richiesta.statoRichiesta}</td>
            <td><button type="button" class="btn btn-secondary btn-sm" id="Button${richiesta.codice}" data-id="Gestisci${richiesta.codice}">Gestisci</button></td>
        </tr>
    `;
}

//parte main admin gestione richieste
function creaMainAdminRichiesta(admin,richiesta){
    return `    
    <div class="container margin-top-header-main">
        <h5><strong>Benvenuto ${admin.nome} ${admin.cognome}!</strong></h5>
            <div class="row">
                <div class="col-sm-4 mt-2">
                    <a type="button" class="btn" href="utente.html">
                        <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                            class="bi bi-person" viewBox="0 0 16 16">
                            <path
                                d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" />
                        </svg>Torna alla tua pagina
                    </a>
                </div>
                <div class="col-sm-4 ms-2 mt-2">
                </div>
                <div class="col-sm-4">

                </div>
            </div>

            <div class="container">
                <div class="row mt-3">
                    <div class="col-sm-2 mt-3"></div>
                    <div class="col-sm-8 mt-3">
                        <div class="card">
                            <div class="card-body">
                                <h6 class="card-text"><strong>Email richiedente:</strong> ${richiesta.email}</h6><br>
                                <h6 class="card-text"><strong>Contatto telefonico:</strong> ${richiesta.telefono}</h6><br>
                                <h6 class="card-text"><strong>Data richiesta:</strong> ${richiesta.data}</h6><br>
                                <p class="card-text">${richiesta.messaggio}</p><br>
                                <button id="RichiestaSoddisfata" class="btn btn-primary">Richiesta Gestita</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2 mt-3" id="Veicolo2">

                    </div>
                </div>
            </div>


        </div>
    `;
}


export {creaMainAdminRichiesta,creaMainAdminTabellaGestioneRichiestaRisultati,creaMainAdminTabellaGestioneRichieste,creaMainAdminGestioneRichieste,creaMainAdminGestioneStatoColonnineRisultati,creaMainAdminGestioneStatoColonnineTabella,creaMainAdminGestioneStatoColonnine,creaMainAdminFormAggiungiColonnina,creaMainAdminRisultatoRimuoviColonnina,creaMainAdminTabellaRimuoviColonnina,creaMainAdminRimuoviColonnina,creaMainAdmin};