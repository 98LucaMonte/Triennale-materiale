"use-strict";

//parte main pagina di presentazione
function creaMainPresentazione() {

    return `
    <div class="margin-main-presentazione-top-img border border-secondary">
    <p class="text-center">EVCP <br> Electric Vehicle Charging Point: <br>
        una nuova piattaforma in espansione di oltre 500 punti di ricarica per veicoli elettrici.</p>
</div>

<div class="container text-center margin-form">
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <div class="col">
            <div class="card">
                <div class="mt-2">
                    <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor"
                        class="bi bi-calendar-date" viewBox="0 0 16 16">
                        <path
                            d="M6.445 11.688V6.354h-.633A12.6 12.6 0 0 0 4.5 7.16v.695c.375-.257.969-.62 1.258-.777h.012v4.61h.675zm1.188-1.305c.047.64.594 1.406 1.703 1.406 1.258 0 2-1.066 2-2.871 0-1.934-.781-2.668-1.953-2.668-.926 0-1.797.672-1.797 1.809 0 1.16.824 1.77 1.676 1.77.746 0 1.23-.376 1.383-.79h.027c-.004 1.316-.461 2.164-1.305 2.164-.664 0-1.008-.45-1.05-.82h-.684zm2.953-2.317c0 .696-.559 1.18-1.184 1.18-.601 0-1.144-.383-1.144-1.2 0-.823.582-1.21 1.168-1.21.633 0 1.16.398 1.16 1.23z" />
                        <path
                            d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z" />
                    </svg>
                </div>
                <div class="card-body">
                    <h5>1</h5>
                    <h5 class="card-title">Prenota</h5>
                    <p class="card-text">Prenota in anticipo e agevolmente il punto di ricarica corretto per il
                        tuo veicolo elettrico tramite il nostro sito online 24 ore su 24, 7 giorni su 7</p>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="mt-2">
                    <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor"
                        class="bi bi-lightning-fill" viewBox="0 0 16 16">
                        <path
                            d="M5.52.359A.5.5 0 0 1 6 0h4a.5.5 0 0 1 .474.658L8.694 6H12.5a.5.5 0 0 1 .395.807l-7 9a.5.5 0 0 1-.873-.454L6.823 9.5H3.5a.5.5 0 0 1-.48-.641l2.5-8.5z" />
                    </svg>
                </div>
                <div class="card-body">
                    <h5>2</h5>
                    <h5 class="card-title">Carica</h5>
                    <p class="card-text">I punti di ricarica su strada ti consentono di ricaricare e
                        "parcheggiare" contemporaneamente sulla nostra piattaforma in tutta Italia</p>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="mt-2">
                    <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor"
                        class="bi bi-car-front-fill" viewBox="0 0 16 16">
                        <path
                            d="M2.52 3.515A2.5 2.5 0 0 1 4.82 2h6.362c1 0 1.904.596 2.298 1.515l.792 1.848c.075.175.21.319.38.404.5.25.855.715.965 1.262l.335 1.679c.033.161.049.325.049.49v.413c0 .814-.39 1.543-1 1.997V13.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1.338c-1.292.048-2.745.088-4 .088s-2.708-.04-4-.088V13.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1.892c-.61-.454-1-1.183-1-1.997v-.413a2.5 2.5 0 0 1 .049-.49l.335-1.68c.11-.546.465-1.012.964-1.261a.807.807 0 0 0 .381-.404l.792-1.848ZM3 10a1 1 0 1 0 0-2 1 1 0 0 0 0 2Zm10 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2ZM6 8a1 1 0 0 0 0 2h4a1 1 0 1 0 0-2H6ZM2.906 5.189a.51.51 0 0 0 .497.731c.91-.073 3.35-.17 4.597-.17 1.247 0 3.688.097 4.597.17a.51.51 0 0 0 .497-.731l-.956-1.913A.5.5 0 0 0 11.691 3H4.309a.5.5 0 0 0-.447.276L2.906 5.19Z" />
                    </svg>
                </div>
                <div class="card-body">
                    <h5>3</h5>
                    <h5 class="card-title">Guida</h5>
                    <p class="card-text">Ora sei pronto a partire! Scollega il tuo veicolo dal punto di ricarica
                        EVCP con il pieno di energia e parti verso la tua prossima destinazione</p>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container margin-form">
    <div class="row">
        <div class="col-sm-6">
            <h5><strong>Comodamente posizionato, facile da usare e da prenotare</strong></h5>
            <p>Accesso online alla nostra vasta rete di punti di ricarica su strada.</p>

            <h5><strong>Rete e comunità in continua espansione</strong></h5>
            <p>Supporto e partnership 24 ore su 24, 7 giorni su 7 con comuni, taxi, veicoli a noleggio privati e
                aziende locali.</p>

            <h5><strong>Proteggere l'ambiente guidando la rivoluzione dei veicoli elettrici in Italia</strong>
            </h5>
            <p>Punti di ricarica alimentati al 100% da energia pulita per aiutare gli italiani a diventare
                ecologici.</p>

            <h5><strong>L'accesso su strada ti consente di parcheggiare e ricaricare allo stesso tempo</strong>
            </h5>
            <p>Prenota sia il tuo parcheggio che il punto di ricarica in uno, consentendo un viaggio senza
                interruzioni in città.</p>
        </div>
        <div class="col-sm-6">
            <div class="text-center">
                <img src="../img/imgside1.png" class="img-fluid immagine-side" alt="immagine">
            </div>
        </div>
    </div>
</div>

<div class="container margin-form">
    <div class="row">
        <div class="col-sm-6 order-element1">
            <div class="text-center">
                <img src="../img/imgside2.jpg" class="img-fluid immagine-side" alt="immagine">
            </div>
        </div>
        <div class="col-sm-6 order-element0">
            <h5><strong>Connettore per la ricarica</strong></h5>
            <p> Sulla rete di ricarica per veicoli elettrici EVCP trovi i seguenti connettori standard: <br>
                <strong>- TIPO 1: </strong> chiamato anche "Yazaki", ma non è diffuso in Italia. <br>
                <strong>- TIPO 2: </strong> chiamato anche "Mennekes", questo connettore è praticamente
                installato sulla totalità dei veicoli in circolazione in Italia <br>
                <strong>- TIPO 3A: </strong> chiamato anche "Scame", utilizzato esclusivamente per veicoli
                leggeri come gli scooter
                <br><br>
                Tuttavia se quindi vi interrogavate sulla difficoltà nel trovare sempre una colonnina che abbia
                i connettori compatibili con la vostra automobile,
                il problema con EVCP non sarà tale in quanto ovunque andrete troverete sempre una colonnina
                compatibile di Tipo 2.
                <br><br>
                NOTA: EVCP suggerisce sempre di verificare la compatibilità con la nostra rete di ricarica del
                connettore sul tuo veicolo!
            </p>
        </div>
    </div>
</div>
    `;
}

//parte main pagina di ricerca
function creaMainRicerca() {

    return `
    <div class="container margin-top-form-login">
    <div class="row">
        <div class="col-sm-12">
            <p>
                <strong> Benvenuti nella nostra pagina dedicata alla ricerca di colonnine per veicoli elettrici!</strong><br> <br> 
                Siete nel posto giusto per trovare le soluzioni di ricarica più efficienti e convenienti.<br>  <br> 
                Grazie al nostro sistema di ricerca avanzato, potrete individuare rapidamente le colonnine disponibili nella vostra zona<br>
                semplificando il vostro viaggio verso un futuro più sostenibile. <br> <br> 
                Iniziate subito a esplorare le opzioni e preparatevi a vivere l'esperienza senza stress della ricarica elettrica!
            </p>
        </div>                
    </div>

    <form class="row mt-2 margin-table-utente">
        <div class="col-sm-4 mt-3">
            <label for="colFormLabelSm"><strong>Inserisci città</strong></label>
            <input type="text" class="form-control" placeholder="Inserisci città" id="Città">
        </div>
        <div class="col-sm-4 mt-3">
            <label for="colFormLabelSm"><strong>Inserisci indirizzo</strong></label>
            <input type="text" class="form-control" placeholder="Inserisci indirizzo" id="Indirizzo">
        </div>
        <div class="col-sm-4 mt-3">
            
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


    <div class="table-responsive"  id="RisultatiRicerca">
        
    </div>

</div>
    `;
}

//parte main pagina ricerca punto di ricarica (tabella dei risultati della ricerca)
function creaMainRicercaTabella(){
    return `
    <table class="table">
        <thead>
            <tr class="table-dark">
                <th scope="col">Città</th>
                <th scope="col">Indirizzo</th>
                <th scope="col">Stato</th>
                <th scope="col">Prenota</th>
            </tr>
        </thead>
        <tbody id="DatiTabella">
        </tbody>
    </table>
    `;
}

//parte main pagina ricerca punto di ricarica (risultati della ricerca)
function creaMainRicercaRisultati(colonnina){
    return `
    <tr class="color-row-table">
        <th scope="row">${colonnina.città}</th>
        <td>${colonnina.indirizzo}</td>
        <td>${colonnina.stato}</td>
        <td><a type="button" class="btn btn-secondary btn-sm" href="/accedi">Prenota</a></td>
    </tr>
    `;
}

//parte main pagina ricerca punto di ricarica (tabella dei risultati della ricerca)
function creaMainContatti(){
    return `
    <div class="container margin-top-form-login">
    <div class="row">
      <div class="col-sm-5 mt-2">
            <h3>Contattaci</h3> <br>
            <p>
                Se hai bisogno di contattarci, ti preghiamo di compilare i dettagli richiesti di seguito prima di inviare il tuo messaggio. 
                <br><br>
                Il nostro team risponderà alla tua richiesta il prima possibile.
                <br><br>
                Se la tua richiesta è urgente, il nostro servizio clienti è disponibile 24 ore su 24 al numero <br> 0123 456 789.
            </p>
            <div id="MessaggioRichiestaInviata">
            </div>
      </div>
      <div class="col-sm-7 mt-2">
        <form>
            <h5 class="text-center"><strong>Inserisci i tuoi contatti, ti contatteremo il prima possibile</strong></h5>
            <div class="margin-label-input-form">
                <label for="exampleInputEmail1" class="form-label"><strong>Email</strong></label>
                <input type="email" class="form-control form-control-sm" id="Email"
                    aria-describedby="emailHelp" placeholder="Inserisci la tua email">
            </div>
            <div class="margin-label-input-form">
                <label for="exampleInputPassword1" class="form-label"><strong>Telefono</strong></label>
                <input type="text" class="form-control form-control-sm" id="Telefono"
                    placeholder="Inserisci il tuo contatto telefonico">
            </div>
            <div class="margin-label-input-form">
                <label for="exampleFormControlTextarea1" class="form-label"><strong>Scrivi qui il tuo messaggio</strong></label>
                <textarea class="form-control" id="MessaggioRichiesta"></textarea>
            </div>
            <div class="margin-label-input-form">
                <button type="submit" class="btn btn-secondary" id="InviaRichiesta">Invia</button>
            </div>
        </form>
      </div>
    </div>
</div>
    `;
}


//parte main pagina servizi 
function creaMainServizi(){
    return `
    <div class="container margin-top-header-main">
    <div class="row">
    <div class="col-sm-5 mt-5">
        <h2>Scopri i nostri servizi</h2>
        <br>
        <p>
            Questa applicazione offre agli utenti un modo comodo per gestire le loro esigenze di ricarica per veicoli elettrici. 
            <br><br>Facilita la prenotazione delle colonnine di ricarica offrendo un'esperienza user-friendly per gli utenti che desiderano gestire in modo efficiente 
            la ricarica dei loro veicoli elettrici.

            <br><br>Gli utenti possono cercare e visualizzare un elenco delle colonnine di ricarica disponibili nella loro zona o in una località specifica. 
            <br><br>Possono quindi selezionare una colonna di loro interesse e prenotarla per effettuare la ricarica. 
            L'applicazione tiene traccia delle prenotazioni effettuate,
            in modo che gli utenti possano vedere quali colonnine sono disponibili.

            <br><br>Gli utenti possono aggiungere fino a tre veicoli al proprio account. 
            Possono inserire informazioni specifiche su ciascun veicolo, come modello e tipo di batteria. 
            Questa funzionalità consente agli utenti di tenere traccia dei loro veicoli e quante ricariche hanno effettuato.
        </p>
    </div>
    <div class="col-sm-7 mt-5">
        <img src="img/img servizi.png" class="img-fluid" alt="immagine">
    </div>
    </div>
</div>
    `;
}

export {creaMainServizi,creaMainContatti,creaMainRicercaRisultati,creaMainRicercaTabella,creaMainRicerca,creaMainPresentazione};