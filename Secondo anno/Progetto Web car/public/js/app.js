
import Api from "./api.js";
import { creaHeaderAdmin,creaHeader, creaHeaderUtente } from './templates/header-view.js';
import { creaFooter } from './templates/footer-view.js';
import { creaFormLoginRegistrazione } from './templates/login-view.js';
import { creaMainServizi,creaMainContatti,creaMainRicercaRisultati,creaMainRicercaTabella,creaMainRicerca,creaMainPresentazione } from './templates/main-view.js';
import { creaMainAdminRichiesta,creaMainAdminTabellaGestioneRichiestaRisultati,creaMainAdminTabellaGestioneRichieste,creaMainAdminGestioneRichieste,creaMainAdminGestioneStatoColonnineRisultati,creaMainAdminGestioneStatoColonnineTabella,creaMainAdminGestioneStatoColonnine,creaMainAdminFormAggiungiColonnina,creaMainAdminRisultatoRimuoviColonnina,creaMainAdminTabellaRimuoviColonnina,creaMainAdminRimuoviColonnina,creaMainAdmin } from './templates/main-admin-view.js';
import { creaMainUtenteVeicolo, creaMainUtenteFormAggiungiVeicolo, creaMainUtenteInfoVeicoli, creaMainUtenteRicercaRicaricheRisultati, creaMainUtenteRicercaRicaricheTabella, creaMainUtenteRicercaRicariche, creaMainUtenteRicercaRisultati, creaMainUtenteRicercaTabella, creaMainUtenteRicerca, creaMainUtenteDatiUtente, creaMainUtenteHome } from './templates/main-utente-view.js';
import page from '//unpkg.com/page/page.mjs';

class App {

    constructor(header, main, footer) {

        this.header = header;
        this.main = main;
        this.footer = footer;
        let user = null;
        let admin = null;
        let response = null;
        let richiesta = null;

        //Inizio pagina di presentazione
        page('/', () => {
            user = null;
            admin = null;
            this.header.innerHTML = '';
            this.main.innerHTML = '';
            this.footer.innerHTML = '';
            console.log("presentazione");
            this.header.insertAdjacentHTML('beforeend', creaHeader());
            this.main.insertAdjacentHTML('beforeend', creaMainPresentazione());
            this.footer.insertAdjacentHTML('beforeend', creaFooter());
        });//inizio pagina di ricerca per utente non loggato
        page('/ricerca', () =>{
            this.header.innerHTML = '';
            this.main.innerHTML = '';
            this.footer.innerHTML = '';
            this.header.insertAdjacentHTML('beforeend', creaHeader());
            this.main.insertAdjacentHTML('beforeend', creaMainRicerca());
            this.footer.insertAdjacentHTML('beforeend', creaFooter());
            document.getElementById("RicercaColonnina").addEventListener("click", async event =>{
                event.preventDefault();
                console.log("ricerca");
                this.ricerca(); //metodo ricerca per utente non loggato 
            });
        });//pagina informativa sui servizi offerti dall'applicazione
        page('/servizi', () =>{
            this.main.innerHTML = '';
            this.footer.innerHTML = '';
            this.main.insertAdjacentHTML('beforeend', creaMainServizi());
            this.footer.insertAdjacentHTML('beforeend', creaFooter());
            console.log("servizi");
        });//inizio pagina contatti
        page('/contatti', () =>{
            this.main.innerHTML = '';
            this.footer.innerHTML = '';
            this.main.insertAdjacentHTML('beforeend', creaMainContatti());
            this.footer.insertAdjacentHTML('beforeend', creaFooter());

            console.log("contatti");

            document.getElementById("InviaRichiesta").addEventListener("click", async event =>{
                event.preventDefault();
                response = await this.registraRichiesta(); //metodo per registrare il messaggio di richiesta dell'utente
                page.redirect('/contatti');
            });

            if(response != null){
                let messaggioRichiestaInviata = document.getElementById("MessaggioRichiestaInviata");
                let buttonInviaRichiesta = document.getElementById("InviaRichiesta");
                buttonInviaRichiesta.disabled = true;
                if(response == 201){
                    messaggioRichiestaInviata.insertAdjacentHTML('beforeend', `<h6 class="alert alert-success">Richiesta inviata con successo</h6>`);                    
                    setTimeout(() => {
                        buttonInviaRichiesta.disabled = false;
                        messaggioRichiestaInviata.innerHTML = '';
                    }, 2000);

                }else{

                    messaggioRichiestaInviata.insertAdjacentHTML('beforeend', `<h6 class="alert alert-danger">Richiesta non inviata riprova per favore</h6>`);                    
                    setTimeout(() => {
                        buttonInviaRichiesta.disabled = false;
                        messaggioRichiestaInviata.innerHTML = '';
                    }, 2000);

                }
                response = null;
            }
            
        });//inizio pagina credenziali per accedere tramite login o tramite registrazione
        page('/accedi', () => {
            
            console.log("accedi");

            this.header.innerHTML = '';
            this.main.innerHTML = '';
            this.footer.innerHTML = '';
            this.header.insertAdjacentHTML('beforeend', creaHeader());
            this.main.insertAdjacentHTML('beforeend', creaFormLoginRegistrazione());
            this.footer.insertAdjacentHTML('beforeend', creaFooter());

            document.getElementById('Accesso').addEventListener('click', async event => {
                event.preventDefault();
                user = await this.login();//inizio login
                /*
                Il sessionStorage è un oggetto disponibile nel browser 
                che consente di memorizzare dati per la durata della sessione corrente dell'utente.
                */
                if (user != undefined && user.tipo == "utente") {
                    sessionStorage.setItem('user', JSON.stringify(user));
                    page.redirect('/utente');
                }
                else if (user != undefined && user.tipo == "admin") {
                    sessionStorage.setItem('admin', JSON.stringify(user));
                    page.redirect('/admin');
                }
                else if(user!=-1){
                    //Stampa errore login
                    let messaggioErrore = document.getElementById("MessaggioErroreAccesso");
                    let buttonAccesso = document.getElementById("Accesso");
                    let buttonRegistrati = document.getElementById("Registrazione");
                    messaggioErrore.innerHTML = '';
                    buttonAccesso.disabled = true;
                    buttonRegistrati.disabled = true;
                    //Messaggio login non riuscito
                    messaggioErrore.insertAdjacentHTML('beforeend', `<h6 class="alert alert-danger">L'operazione di accesso all'account non è andata a buon termine</h6>`);                    
                    setTimeout(() => {
                        buttonAccesso.disabled = false;
                        buttonRegistrati.disabled = false;
                        messaggioErrore.innerHTML = '';
                    }, 2000);
                }

            });

            document.getElementById('Registrazione').addEventListener('click', async event => {
                event.preventDefault();
                user = await this.registrazione();
                /*
                Il sessionStorage è un oggetto disponibile nel browser 
                che consente di memorizzare dati per la durata della sessione corrente dell'utente.
                */
                if (user != undefined && user.tipo == "utente") {
                    sessionStorage.setItem('user', JSON.stringify(user));
                    page.redirect('/utente');
                }
                else if(user == undefined){
                    let messaggioErrore = document.getElementById("MessaggioErroreAccesso");
                    let buttonAccesso = document.getElementById("Accesso");
                    let buttonRegistrati = document.getElementById("Registrazione");
                    messaggioErrore.innerHTML = '';
                    buttonAccesso.disabled = true;
                    buttonRegistrati.disabled = true;
                    //Messaggio registrazione non riuscita
                    messaggioErrore.insertAdjacentHTML('beforeend', `<h6 class="alert alert-danger">L'operazione di registrazione non è andata a buon termine</h6>`);                    
                    setTimeout(() => {
                        buttonAccesso.disabled = false;
                        buttonRegistrati.disabled = false;
                        messaggioErrore.innerHTML = '';
                    }, 2000);
                }
                
            });

        });//inizio pagina utente loggato
        page('/utente', async () => {
            user = JSON.parse(sessionStorage.getItem('user'));
            if (user == null) {
                page.redirect('/accedi');
            }
            this.header.innerHTML = '';
            this.main.innerHTML = '';
            this.footer.innerHTML = '';
            this.header.insertAdjacentHTML('beforeend', creaHeaderUtente());
            this.main.insertAdjacentHTML('beforeend', creaMainUtenteHome(user));
            this.footer.insertAdjacentHTML('beforeend', creaFooter());

            console.log("utente");

            //richiama pagina di ricerca colonnina
            document.getElementById('OperazioneRicerca').addEventListener('click', async event => {
                event.preventDefault();
                page.redirect('/ricercaColonninaUtente');
            });
            
            //richiama pagina di ricerca ricariche fatte e che sono ancora in corso
            document.getElementById('OperazioneVisualizzaCariche').addEventListener('click', async event => {
                event.preventDefault();
                page.redirect('/ricercaRicaricheEffettuate');
            });

            //richiama pagina di gestione dei veicoli in cui sono indicate le informazioni sui veicoli con la possibilità di aggiungerne o rimuoverli
            document.getElementById('OperazioneGestioneVeicoli').addEventListener('click', async event => {
                event.preventDefault();
                page.redirect('/informazioniVeicoli');
            });

            //richiama pagina di visualizzazione dei dati di un certo utente
            document.getElementById('OperazioneVisualizzaDatiUtente').addEventListener('click', async event => {
                event.preventDefault();
                let numeroRicariche = await Api.numeroRicariche(user.cf);
                this.main.innerHTML = '';
                this.main.insertAdjacentHTML('beforeend', creaMainUtenteDatiUtente(user,numeroRicariche));        
            });

            if(response != null){
                let messaggioErrore = document.getElementById("MessaggioFineOperazioneUtente");
                messaggioErrore.innerHTML = '';
                if(response == 201){
                    //Messaggio buona riuscita operazione
                    messaggioErrore.insertAdjacentHTML('beforeend', `<h6 class="alert alert-success">L'operazione appena conclusa è andata a buon termine</h6>`);                    
                    setTimeout(() => {
                        messaggioErrore.innerHTML = '';
                    }, 4000);
                }
                else{
                    //Messaggio non buona riuscita operazione
                    messaggioErrore.insertAdjacentHTML('beforeend', `<h6 class="alert alert-danger">L'operazione appena conclusa non è andata a buon termine</h6>`);                    
                    setTimeout(() => {
                        messaggioErrore.innerHTML = '';
                    }, 4000);
                }
                response = null;
            }

        });//pagina di ricerca di una colonnina per utente loggato
        page('/ricercaColonninaUtente', () => {
            user = JSON.parse(sessionStorage.getItem('user'));
            if (user == null) {
                page.redirect('/accedi');
            }

            console.log("ricercaColonniaUtente");

            this.header.innerHTML = '';
            this.main.innerHTML = '';
            this.footer.innerHTML = '';
            this.header.insertAdjacentHTML('beforeend', creaHeaderUtente());
            this.main.insertAdjacentHTML('beforeend', creaMainUtenteRicerca(user));
            this.footer.insertAdjacentHTML('beforeend', creaFooter());
            
            //avvio ricerca di una colonnina
            document.getElementById("RicercaColonnina").addEventListener("click", async event =>{
                event.preventDefault();
                await this.ricercaColonnina(user);    
                
                //attendo una possibile prenotazione di una colonnina attraverso questo evento
                document.getElementById("DatiTabellaColonnine").addEventListener('click', async (event) => {
                    event.preventDefault();
                    let target = event.target;
                    
                    if (target.tagName === 'BUTTON' && target.hasAttribute('data-id')) {
                      let stringaTarget = target.getAttribute('data-id');
                      
                      if(stringaTarget.includes("Prenota")){
                        let codiceColonnina = stringaTarget.replace("Prenota", "");
                        stringaTarget = '';
                        response = await this.prenotaColonnina(codiceColonnina,user.cf);
                        codiceColonnina = '';
                        page.redirect('/utente');
                      }
                      
                    }
                });

            });

        });//pagina di ricerca delle ricariche effettuate e che sono ancora in corso
        page('/ricercaRicaricheEffettuate', () => {
            user = JSON.parse(sessionStorage.getItem('user'));
            if (user == null) {
                page.redirect('/accedi');
            }
            this.header.innerHTML = '';
            this.main.innerHTML = '';
            this.footer.innerHTML = '';
            this.header.insertAdjacentHTML('beforeend', creaHeaderUtente());
            this.main.insertAdjacentHTML('beforeend', creaMainUtenteRicercaRicariche(user));
            this.footer.insertAdjacentHTML('beforeend', creaFooter());

            console.log("ricercaRicaricheEffettuate");

            //avvio evento di ricerca delle ricariche
            document.getElementById("RicercaRicariche").addEventListener("click", async event =>{
                event.preventDefault();
                await this.ricercaRicaricheEffettuate(user.cf);    

                //avvio evento di termina ricarica
                document.getElementById("DatiTabellaRicariche").addEventListener('click', async (event) => {
                    event.preventDefault();
                    let target = event.target;
                    if (target.tagName === 'BUTTON' && target.hasAttribute('data-id')) {
                      
                      let stringaTarget = target.getAttribute('data-id');
                      
                      if(stringaTarget.includes("Termina")){
                        let codicePrenotazione = stringaTarget.replace("Termina", "");
                        stringaTarget = '';
                        response = await this.terminaPrenotazione(codicePrenotazione);
                        codicePrenotazione = '';
                        page.redirect('/utente');
                      }
                      
                    }
                });

            });

        });//pagina di informazione sui veicoli dell'utente
        page('/informazioniVeicoli', async () => {
            user = JSON.parse(sessionStorage.getItem('user'));
            if (user == null) {
                page.redirect('/accedi');
            }

            this.header.innerHTML = '';
            this.main.innerHTML = '';
            this.footer.innerHTML = '';
            this.header.insertAdjacentHTML('beforeend', creaHeaderUtente());
            this.main.insertAdjacentHTML('beforeend', creaMainUtenteInfoVeicoli(user));
            this.footer.insertAdjacentHTML('beforeend', creaFooter());

            console.log("informazioniVeicoli");

            const messaggioNessunVeicolo = document.getElementById("MessaggioNessunVeicolo");
            messaggioNessunVeicolo.innerHTML = '';

            //stampa dei veicoli che possiede l'utente
            const veicoli = await Api.prelevaVeicoliUtente(user.cf);
            let numeroVeicoli = Object.keys(veicoli).length;
            if (numeroVeicoli != 0) {
                for (let i = 0; i < numeroVeicoli; i++) {
                    let veicolo = veicoli[i];
                    let nomeId = "Veicolo" + i;
                    let formMostraVeicolo = document.getElementById(nomeId);
                    let numeroRicaricheVeicolo = await Api.numeroRicaricheVeicolo(veicolo.targa);
                    formMostraVeicolo.insertAdjacentHTML('beforeend', creaMainUtenteVeicolo(veicolo,numeroRicaricheVeicolo));
                }
            }else{
                messaggioNessunVeicolo.insertAdjacentHTML('beforeend','<h5 class="alert alert-dark" role="alert">Non hai ancora nessun veicolo registrato.</h5>');
            }


            //se il cliente ha tre veicoli non può aggiungerne altri
            if (numeroVeicoli == 3){
                const button = document.getElementById('AggiungiVeicolo');
                button.disabled = true;
            }

            //evento di aggiunta di un veicolo
            document.getElementById('AggiungiVeicolo').addEventListener('click', async event => {
                event.preventDefault();
                page.redirect('/aggiungiVeicolo');
            });

            //evento di rimozione di un veicolo
            this.main.addEventListener('click', async (event) => {
                
                const target = event.target;
                if (target.tagName === 'BUTTON' && target.hasAttribute('data-id')) {
                    event.preventDefault()
                    const targa = target.getAttribute('data-id');
                    response = await this.eliminaVeicolo(targa);
                    page.redirect('/utente');
                }
            });
            
        });//pagina di preparazione di aggiunta di un nuovo veicolo
        page('/aggiungiVeicolo', () => {
            user = JSON.parse(sessionStorage.getItem('user'));
            if (user == null) {
                page.redirect('/accedi');
            }

            this.header.innerHTML = '';
            this.main.innerHTML = '';
            this.footer.innerHTML = '';
            this.header.insertAdjacentHTML('beforeend', creaHeaderUtente());
            this.main.insertAdjacentHTML('beforeend', creaMainUtenteFormAggiungiVeicolo());
            this.footer.insertAdjacentHTML('beforeend', creaFooter());

            console.log("aggiungiVeicolo");

            //dopo aver messo tutti i dati e premeuto il button parte l'evento di aggiunta di un nuovo veicolo
            document.getElementById('Aggiungi').addEventListener('click', async event => {
                event.preventDefault();
                response = await this.aggiungiVeicolo(user);
                page.redirect('/utente');
            });

        });//esecuzione di eliminazione della sessione 
        page('/logout', async () => {
            sessionStorage.setItem('user', null);
            sessionStorage.setItem('admin', null);
            await Api.logout();
            page.redirect('/');
        });//pagina dell'admin loggato
        page('/admin',async () => {
            admin = JSON.parse(sessionStorage.getItem('admin'));
            if (admin == null) {
                page.redirect('/accedi');
            }
            this.header.innerHTML = '';
            this.main.innerHTML = '';
            this.footer.innerHTML = '';
            this.header.insertAdjacentHTML('beforeend', creaHeaderAdmin());
            this.main.insertAdjacentHTML('beforeend', creaMainAdmin(admin));
            this.footer.insertAdjacentHTML('beforeend', creaFooter());

            console.log("admin");

            //richiama pagina di aggiungi colonnina
            document.getElementById('OperazioneAggiungiColonnina').addEventListener('click', async event => {
                event.preventDefault();
                page.redirect('/aggiungiColonnina');
            });
            
            //richiama pagina di rimuovi colonnina
            document.getElementById('OperazioneRimuoviColonnina').addEventListener('click', async event => {
                event.preventDefault();
                page.redirect('/rimuoviColonnina');
            });

            //richiama pagina di gestione stato colonnina
            document.getElementById('OperazioneGestisciColonnina').addEventListener('click', async event => {
                event.preventDefault();
                page.redirect('/gestioneStatoColonnina');
            });

            //richiama pagina di gestione stato colonnina
            document.getElementById('OperazioneRichieste').addEventListener('click', async event => {
                event.preventDefault();
                page.redirect('/gestioneRichieste');
            });

            if(response != null){
                let messaggioErrore = document.getElementById("MessaggioFineOperazioneAdmin");
                messaggioErrore.innerHTML = '';
                if(response == 201){
                    //Messaggio buona riuscita operazione
                    messaggioErrore.insertAdjacentHTML('beforeend', `<h6 class="alert alert-success">L'operazione appena conclusa è andata a buon termine</h6>`);                    
                    setTimeout(() => {
                        messaggioErrore.innerHTML = '';
                    }, 4000);
                }
                else{
                    //Messaggio non buona riuscita operazione
                    messaggioErrore.insertAdjacentHTML('beforeend', `<h6 class="alert alert-danger">L'operazione appena conclusa non è andata a buon termine</h6>`);                    
                    setTimeout(() => {
                        messaggioErrore.innerHTML = '';
                    }, 4000);
                }
                response = null;
            }

        });//pagina aggiungi colonnina
        page('/aggiungiColonnina', () => {
            admin = JSON.parse(sessionStorage.getItem('admin'));
            if (admin == null) {
                page.redirect('/accedi');
            }

            console.log("aggiungiColonnina");

            this.header.innerHTML = '';
            this.main.innerHTML = '';
            this.footer.innerHTML = '';
            this.header.insertAdjacentHTML('beforeend', creaHeaderAdmin());
            this.main.insertAdjacentHTML('beforeend', creaMainAdminFormAggiungiColonnina(admin));
            this.footer.insertAdjacentHTML('beforeend', creaFooter());

            document.getElementById('Aggiungi').addEventListener('click', async event => {
                event.preventDefault();
                response = await this.aggiungiColonnina();
                page.redirect('/admin');
            });

        });//pagina rimuovi colonnina
        page('/rimuoviColonnina', () => {
            admin = JSON.parse(sessionStorage.getItem('admin'));
            if (admin == null) {
                page.redirect('/accedi');
            }

            this.header.innerHTML = '';
            this.main.innerHTML = '';
            this.footer.innerHTML = '';
            this.header.insertAdjacentHTML('beforeend', creaHeaderAdmin());
            this.main.insertAdjacentHTML('beforeend', creaMainAdminRimuoviColonnina(admin));
            this.footer.insertAdjacentHTML('beforeend', creaFooter());

            console.log("rimuoviColonnina");

            //avvio ricerca di una colonnina
            document.getElementById("RicercaColonninaRimuovi").addEventListener("click", async event =>{
                event.preventDefault();
                await this.ricercaColonninaRimuovi();    
                
                //attendo una possibile prenotazione di una colonnina attraverso questo evento
                document.getElementById("DatiTabellaColonnineRimuovi").addEventListener('click', async (event) => {
                    event.preventDefault();
                    let target = event.target;
                    
                    if (target.tagName === 'BUTTON' && target.hasAttribute('data-id')) {
                      let stringaTarget = target.getAttribute('data-id');
                      
                      if(stringaTarget.includes("Rimuovi")){
                        let codiceColonnina = stringaTarget.replace("Rimuovi", "");
                        stringaTarget = '';
                        response = await Api.eliminaColonnina(codiceColonnina);
                        codiceColonnina = '';
                        page.redirect('/admin');
                      }
                      
                    }
                });

            });

        });//pagina gestione stato colonnina
        page('/gestioneStatoColonnina', () => {
            admin = JSON.parse(sessionStorage.getItem('admin'));
            if (admin == null) {
                page.redirect('/accedi');
            }

            console.log("gestioneStatoColonnina");
            this.header.innerHTML = '';
            this.main.innerHTML = '';
            this.footer.innerHTML = '';
            this.header.insertAdjacentHTML('beforeend', creaHeaderAdmin());
            this.main.insertAdjacentHTML('beforeend', creaMainAdminGestioneStatoColonnine(admin));
            this.footer.insertAdjacentHTML('beforeend', creaFooter());

            //avvio ricerca colonnina a cui cambiare stato
            document.getElementById("RicercaColonninaModificaStato").addEventListener("click", async event =>{
                event.preventDefault();
                await this.ricercaColonninaCambiaStato();    
                
                //attendo una possibile prenotazione di una colonnina attraverso questo evento
                document.getElementById("DatiTabellaColonnineModificaStato").addEventListener('click', async (event) => {
                    event.preventDefault();
                    
                    let target = event.target;
                    
                    if (target.tagName === 'BUTTON' && target.hasAttribute('data-id')) {
                      let stringaTarget = target.getAttribute('data-id');
                      
                      if(stringaTarget.includes("Aggiorna")){
                        let codiceColonnina = stringaTarget.replace("Aggiorna", "");
                        stringaTarget = '';
                        response = await this.cambiaStatoColonnina(codiceColonnina);
                        codiceColonnina = '';
                        page.redirect('/admin');
                      }
                      
                    }
                
                });

            });

        });
        page('/gestioneRichieste', async() => {
            admin = JSON.parse(sessionStorage.getItem('admin'));
            if (admin == null) {
                page.redirect('/accedi');
            }

            console.log("gestioneRichieste");

            this.header.innerHTML = '';
            this.main.innerHTML = '';
            this.footer.innerHTML = '';
            this.header.insertAdjacentHTML('beforeend', creaHeaderAdmin());
            this.main.insertAdjacentHTML('beforeend', creaMainAdminGestioneRichieste(admin));
            this.footer.insertAdjacentHTML('beforeend', creaFooter());
            const richieste = await this.prelevaRichieste();            
            //una volta premuto il button gestisci vado a gestire e leggere la richiesta 
            document.getElementById("DatiTabellaRichieste").addEventListener('click', async (event) => {
                event.preventDefault();
                
                let target = event.target;
                
                if (target.tagName === 'BUTTON' && target.hasAttribute('data-id')) {
                  let stringaTarget = target.getAttribute('data-id');
                  
                  if(stringaTarget.includes("Gestisci")){
                    let codiceRichiesta = stringaTarget.replace("Gestisci", "");
                    
                    for (let i = 0; i < richieste.length; i++) {
                        
                        if (richieste[i].codice == codiceRichiesta) {
                            richiesta = richieste[i];
                            break;
                        }
                    }

                    page.redirect('/visualizzaRichiesta');
                  }
                  
                }
            
            });


        });
        page('/visualizzaRichiesta', async() => {
            admin = JSON.parse(sessionStorage.getItem('admin'));
            if (admin == null) {
                page.redirect('/accedi');
            }

            console.log("visualizzazioneRichiesta");

            this.header.innerHTML = '';
            this.main.innerHTML = '';
            this.footer.innerHTML = '';
            this.header.insertAdjacentHTML('beforeend', creaHeaderAdmin());
            this.main.insertAdjacentHTML('beforeend', creaMainAdminRichiesta(admin,richiesta));
            this.footer.insertAdjacentHTML('beforeend', creaFooter());
            
            document.getElementById('RichiestaSoddisfata').addEventListener('click', async event => {
                event.preventDefault();
                response = await Api.richiestaGestita(richiesta.codice);
                richiesta = null;
                page.redirect('/admin');
            });           


        });
        page();

    }

    //Metodo per la ricerca di un colonnina da prenotare per la ricarica del veicolo
    ricerca = async () => {
        
        let città = document.getElementById("Città").value;
        let indirizzo = document.getElementById("Indirizzo").value;

        if(città == ''){
            //se è vuoto non fai nulla  
            return 0;          
        }
        else{
            let colonnine;
          
            if(città != '' && indirizzo == ''){
                colonnine = await Api.ricercaTramiteCittà(città);
            }
            else{
                colonnine = await Api.ricercaTramiteCittàIndirizzo(città,indirizzo);
            }

            if(colonnine.length == 0){
                const tabellaRisultatiRicerca = document.getElementById("RisultatiRicerca");
                tabellaRisultatiRicerca.innerHTML='';
                tabellaRisultatiRicerca.insertAdjacentHTML('beforeend', `<h6 class="alert alert-danger">Non è stato trovato nessun risultato</h6>` );
            }
            else{
                const tabellaRisultatiRicerca = document.getElementById("RisultatiRicerca");
                tabellaRisultatiRicerca.innerHTML='';
                tabellaRisultatiRicerca.insertAdjacentHTML('beforeend', creaMainRicercaTabella());
                const dati = document.querySelector('#DatiTabella');                
                for(let colonnina of colonnine) {
                    const datiColonnina = creaMainRicercaRisultati(colonnina);
                    dati.insertAdjacentHTML('beforeend', datiColonnina);
                }
            }
        }

    }

    //Login
    login = async () => {

        const email = document.getElementById("InputEmail1").value;
        const psw = document.getElementById("InputPassword1").value;

        if (email == '' || psw == '') {
            return -1;
        }
        else {
            try {
                let user = await Api.login(email, psw);
                return user;
            } catch (error) {
                if (error) {
                    return undefined;
                }
            }
        }

    }

    //Registrazione
    registrazione = async () => {

        const nome = document.getElementById("InputNome").value;
        const cognome = document.getElementById("InputCognome").value;
        const cf = document.getElementById("InputCf").value;
        const email = document.getElementById("InputEmail2").value;
        const psw = document.getElementById("InputPassword2").value;
        const confermaPsw = document.getElementById("InputPassword3").value;

        if (nome == '' || cognome == '' || cf == '' || email == '' || psw == '' || confermaPsw == '') {
            return -1;
        }
        else if (psw == confermaPsw) {

            const utente = {
                nome: nome,
                cognome: cognome,
                email: email,
                cf: cf,
                psw: psw,
                tipo: "utente"
            }

            let result = await Api.checkEmail(email);

            if (result === undefined) {

                let res = await Api.registra(utente);
                if (res == 200) {
                    let user = await Api.login(email, psw);
                    return user;
                }
                
            }
            
            return undefined;
                
        }

    }

    //Metodo per la ricerca di un colonnina da prenotare per la ricarica del veicolo
    ricercaColonnina = async (user) => {
        
        let città = document.getElementById("Città").value;
        let indirizzo = document.getElementById("Indirizzo").value;
        let codiceColonnina = document.getElementById("CodicePuntoRicarica").value;

        if(città == '' && codiceColonnina == ''){
            //se è vuoto non fai nulla  
            return 0;          
        }
        else{
            let colonnine;
          
            if(codiceColonnina != ''){
                colonnine = await Api.ricercaTramiteCodiceColonnina(codiceColonnina);
            }
            else if(città != '' && indirizzo == ''){
                colonnine = await Api.ricercaTramiteCittà(città);
            }
            else{
                colonnine = await Api.ricercaTramiteCittàIndirizzo(città,indirizzo);
            }

            if(colonnine.length == 0){
                const tabellaRisultatiRicerca = document.getElementById("RisultatiRicerca");
                tabellaRisultatiRicerca.innerHTML='';
                tabellaRisultatiRicerca.insertAdjacentHTML('beforeend', `<h6 class="alert alert-danger">Non è stato trovato nessun risultato</h6>` );
            }
            else{
                const tabellaRisultatiRicerca = document.getElementById("RisultatiRicerca");
                tabellaRisultatiRicerca.innerHTML='';
                tabellaRisultatiRicerca.insertAdjacentHTML('beforeend', creaMainUtenteRicercaTabella());
                const dati = document.querySelector('#DatiTabellaColonnine');
                const veicoli = await Api.prelevaVeicoliUtente(user.cf);
                const targhe = veicoli.map(veicolo => veicolo.targa);
                
                for(let colonnina of colonnine) {
                    const datiColonnina = creaMainUtenteRicercaRisultati(colonnina);
                    dati.insertAdjacentHTML('beforeend', datiColonnina);
                    const select = document.getElementById("Targhe"+colonnina.codice);
                    // Genera le opzioni della select
                    for (let i = 0; i < targhe.length; i++) {
                        let option = document.createElement("option");
                        option.value = targhe[i];  // Imposta il valore dell'opzione
                        option.text = targhe[i];  // Imposta il testo dell'opzione
                        select.appendChild(option);
                    }

                    if(colonnina.stato != "Prenotabile"){
                        let numeroButton = "Button"+colonnina.codice;
                        const button = document.getElementById(numeroButton);
                        button.disabled = true;
                    }
                }
            }
        }

    }

    //Metodo per la ricerca delle ricariche effettuate da un utente
    ricercaRicaricheEffettuate = async (cfUser) => {
       
        let città = document.getElementById("Città").value;
        let targa = document.getElementById("Targa").value;

        if(città == '' && targa == ''){
            //se è vuoto non fai nulla  
            return 0;          
        }
        else{
            let ricariche;
          
            if(città != '' && targa == ''){
                ricariche = await Api.ricercaRicaricheTramiteCitta(città,cfUser);
            }
            else if(città == '' && targa != ''){
                ricariche = await Api.ricercaRicaricheTramiteTarga(targa,cfUser);
            }
            else{
                ricariche = await Api.ricercaRicaricheTramiteCittaTarga(città,targa,cfUser);
            }

            if(ricariche.length == 0){
                const tabellaRisultatiRicerca = document.getElementById("RisultatiRicerca");
                tabellaRisultatiRicerca.innerHTML='';
                tabellaRisultatiRicerca.insertAdjacentHTML('beforeend', `<h6 class="alert alert-danger">Non è stato trovato nessun risultato</h6>` );
            }
            else{
                const tabellaRisultatiRicerca = document.getElementById("RisultatiRicerca");
                tabellaRisultatiRicerca.innerHTML='';
                tabellaRisultatiRicerca.insertAdjacentHTML('beforeend', creaMainUtenteRicercaRicaricheTabella());
                const dati = document.querySelector('#DatiTabellaRicariche');
                for(let ricarica of ricariche) {
                    const datiColonnina = creaMainUtenteRicercaRicaricheRisultati(ricarica);
                    dati.insertAdjacentHTML('beforeend', datiColonnina);

                    if(ricarica.stato != "in corso"){
                        let numeroButton = "Button"+ricarica.codicePrenotazione;
                        const button = document.getElementById(numeroButton);
                        button.disabled = true;
                    }

                }
            }
        }
        
    }

    //Metodo per aggiungere un veicolo di un certo utente
    aggiungiVeicolo = async (user) => {

        const targa = document.getElementById("Targa").value;
        const marca = document.getElementById("Marca").value;
        const modello = document.getElementById("Modello").value;

        if(targa == "" || marca == "" || modello == ""){
            return 0;
        }

        const veicolo = {
            targa: targa,
            marca: marca,
            modello: modello,
            cfProprietario: user.cf,
        }

        const response = await Api.aggiungiVeicolo(veicolo);
        
        return response;
    }

    //Metodo per effettuare la prenotazione ad una colonnina
    prenotaColonnina = async (codiceColonnina,cfUser) => {

        let targaElement = document.getElementById("Targhe"+codiceColonnina);
        let targa = targaElement.value;
        
        if(targa == ''){
            return -1;
        }

        const response1 = await Api.statoColonninaOccupato(codiceColonnina);
        if(response1 == 201){
            const colonnina = await Api.prelevaCittàIndirizzoPrenotazione(codiceColonnina);
            if(colonnina != 404){
                const response3 = await Api.prenotaColonnina(codiceColonnina,targa,cfUser,colonnina[0].città,colonnina[0].indirizzo);
                if(response3 == 201){
                    return response3;
                }
                else{
                    return -1;//errore prenotaColonnina
                }
                
            }
            else{
                return -1; //errore prelevaCittàIndirizzoPrenotazione
            }
        }
        return -1; //errore statoColonninaOccupato
        
    }

    //Metodo per terminare la ricarica
    terminaPrenotazione = async (codicePrenotazione) =>{

        if(codicePrenotazione == ''){
            return;
        }
        let codiceColonnina
        const prenotazione = await Api.ricercaCodiceColonninaTramitePrenotazione(codicePrenotazione);
        if(prenotazione != ''){
            codiceColonnina = prenotazione[0].idColonnina;
        }
        else{
            return -1;
        }

        const response = await Api.terminaPrenotazione(codicePrenotazione);
        if(response == 201){
            const response1 = await Api.statoColonninaPrenotabile(codiceColonnina);
            if(response1 == 201){
                return response1;
            }
            return -1;
        }
        
        return -1;

    }

    //Metodo elimina veicolo di un certo utente
    eliminaVeicolo = async (targa) =>{

        if(targa == ''){
            return;
        }

        let response = Api.eliminaVeicolo(targa);
        return response; 
    }

    //Metodo aggiungi colonnina
    aggiungiColonnina = async () =>{
        const citta = document.getElementById("Città").value;
        const indirizzo = document.getElementById("Indirizzo").value;
        
        if(citta == "" || indirizzo == ""){
            return 0;
        }

        const response = await Api.creaColonnina(citta,indirizzo);
        
        return response;
    }
    
    //Metodo per la ricerca di un colonnina da rimuovere
    ricercaColonninaRimuovi = async () => {
        
        let città = document.getElementById("Città").value;
        let indirizzo = document.getElementById("Indirizzo").value;
        let codiceColonnina = document.getElementById("CodicePuntoRicarica").value;

        if(città == '' && codiceColonnina == ''){
            //se è vuoto non fai nulla  
            return 0;          
        }
        else{
            let colonnine;
          
            if(codiceColonnina != ''){
                colonnine = await Api.ricercaTramiteCodiceColonnina(codiceColonnina);
            }
            else if(città != '' && indirizzo == ''){
                colonnine = await Api.ricercaTramiteCittà(città);
            }
            else{
                colonnine = await Api.ricercaTramiteCittàIndirizzo(città,indirizzo);
            }

            if(colonnine.length == 0){
                const tabellaRisultatiRicerca = document.getElementById("RisultatiRicerca");
                tabellaRisultatiRicerca.innerHTML='';
                tabellaRisultatiRicerca.insertAdjacentHTML('beforeend', `<h6 class="alert alert-danger">Non è stato trovato nessun risultato</h6>` );
            }
            else{
                const tabellaRisultatiRicerca = document.getElementById("RisultatiRicerca");
                tabellaRisultatiRicerca.innerHTML='';
                tabellaRisultatiRicerca.insertAdjacentHTML('beforeend', creaMainAdminTabellaRimuoviColonnina());
                const dati = document.querySelector('#DatiTabellaColonnineRimuovi');
                
                for(let colonnina of colonnine) {
                    const datiColonnina = creaMainAdminRisultatoRimuoviColonnina(colonnina);
                    dati.insertAdjacentHTML('beforeend', datiColonnina);
                   
                    if(colonnina.stato != "Guasta"){
                        let numeroButton = "Button"+colonnina.codice;
                        const button = document.getElementById(numeroButton);
                        button.disabled = true;
                    }
                }
            }
        }

    }

    //Metodo per la ricerca di un colonnina a cui si dovrà cambiare lo stato da prenotabile a guasto o viceversa
    ricercaColonninaCambiaStato = async () => {
    
        let città = document.getElementById("Città").value;
        let indirizzo = document.getElementById("Indirizzo").value;
        let codiceColonnina = document.getElementById("CodicePuntoRicarica").value;

        if(città == '' && codiceColonnina == ''){
            //se è vuoto non fai nulla  
            return 0;          
        }
        else{
            let colonnine;
            
            if(codiceColonnina != ''){
                colonnine = await Api.ricercaTramiteCodiceColonnina(codiceColonnina);
            }
            else if(città != '' && indirizzo == ''){
                colonnine = await Api.ricercaTramiteCittà(città);
            }
            else{
                colonnine = await Api.ricercaTramiteCittàIndirizzo(città,indirizzo);
            }

            if(colonnine.length == 0){
                const tabellaRisultatiRicerca = document.getElementById("RisultatiRicerca");
                tabellaRisultatiRicerca.innerHTML='';
                tabellaRisultatiRicerca.insertAdjacentHTML('beforeend', `<h6 class="alert alert-danger">Non è stato trovato nessun risultato</h6>` );
            }
            else{
                const tabellaRisultatiRicerca = document.getElementById("RisultatiRicerca");
                tabellaRisultatiRicerca.innerHTML='';
                tabellaRisultatiRicerca.insertAdjacentHTML('beforeend',creaMainAdminGestioneStatoColonnineTabella());
                const dati = document.querySelector('#DatiTabellaColonnineModificaStato');
                
                for(let colonnina of colonnine) {
                    const datiColonnina = creaMainAdminGestioneStatoColonnineRisultati(colonnina);
                    dati.insertAdjacentHTML('beforeend', datiColonnina);
                    
                    if(colonnina.stato == "Occupata"){
                        let numeroButton = "Button"+colonnina.codice;
                        const button = document.getElementById(numeroButton);
                        button.disabled = true;
                    }
                }
            }
        }

    }

    //Metodo per cambiare stato di una colonnina
    cambiaStatoColonnina = async (codiceColonnina) => {

        let statoColonninaElement = document.getElementById("Colonnina"+codiceColonnina);
        let statoScelto = statoColonninaElement.value;
        
        if(statoScelto == ''){
            return -1;
        }

        let response;

        //significa che l'utente ha selezionato Prenotabile come opzione
        if(statoScelto == 2){
            response = Api.statoColonninaPrenotabile(codiceColonnina);
        }
        else if(statoScelto == 1){//significa che l'utente ha selezionato Guasta come opzione
            response = Api.statoColonninaGuasta(codiceColonnina);
        }   

        return response;

    }

    //Metodo registra messaggio di richiesta d'aiuto
    registraRichiesta = async () =>{

        let email = document.getElementById("Email").value;
        let telefono = document.getElementById("Telefono").value;
        let messaggio = document.getElementById("MessaggioRichiesta").value;

        if(messaggio == '' || email == '' || telefono == ''){
            return;
        }

        let response = await Api.registraRichiesta(email,telefono,messaggio);
        return response;
    }

    prelevaRichieste = async () =>{
        let richieste = await Api.prelevaRichieste();

        if(richieste.length == 0){
            const nessunRisultatoTrovato = document.getElementById("NessunaRichiesta");
            nessunRisultatoTrovato.innerHTML='';
            nessunRisultatoTrovato.insertAdjacentHTML('beforeend', `<h6 class="alert alert-danger">Non è presente nessuna richiesta da gestire</h6>` );
        }
        else{
            const tabellaRisultatiRicerca = document.getElementById("RisultatiRicerca");
            tabellaRisultatiRicerca.innerHTML='';
            tabellaRisultatiRicerca.insertAdjacentHTML('beforeend', creaMainAdminTabellaGestioneRichieste());
            const dati = document.querySelector('#DatiTabellaRichieste');
            
            for(let richiesta of richieste) {
                const datiColonnina = creaMainAdminTabellaGestioneRichiestaRisultati(richiesta);
                dati.insertAdjacentHTML('beforeend', datiColonnina);
                
                if(richiesta.statoRichiesta == "Gestita"){
                    let numeroButton = "Button"+richiesta.codice;
                    const button = document.getElementById(numeroButton);
                    button.disabled = true;
                }
            }
        }

        return richieste;
    }

}

export default App;