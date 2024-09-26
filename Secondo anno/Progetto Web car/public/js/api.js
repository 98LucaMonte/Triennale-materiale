import Veicolo from './veicolo.js'
import Colonnina from './colonnina.js'
import Prenotazione from './prenotazione.js'
import Richiesta from './richiesta.js'


class Api {

    //Login
    static login = async(username, password)=>{
       
        let response = await fetch('/api/sessions', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({username, password}),
        });
        if(response.ok){
            const user = await response.json();
            return user;
        }else{
            try{
                const errDetail = await response.json();
                throw errDetail.message;
            }catch(err){
                throw err;
            }
        }
    }

    //Metodo per controllare se una email è già usata da un altro utente
    static checkEmail = async (email) =>{
        
        let url = `/api/checkEmail/?Email=` + email;
        let response = await fetch(url);
        if(response.status == 200){
            const risultato = await response.json();
            return risultato;
        }
        else{ 
            return undefined;
        }
    }

    //Metodo per registrazione nuovo utente
    static registra = async (utente) =>{
        let response = await fetch("/api/registra", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(utente)
        })

        return response.status;
    }

    //Logout
    static logout = async () =>{
        await fetch('/api/sessions/current', { method: 'DELETE' });
    }

    //Metodo per aggiungere un veicolo
    static aggiungiVeicolo = async (veicolo) =>{

        let response = await fetch("/api/aggiungiVeicolo/", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                veicolo: veicolo
            })
        })

        return response.status;
    }

    //Metodo che serve per prelevare i veicoli di un certo utente
    static prelevaVeicoliUtente = async (cfUtente) =>{
        let url = `/api/prelevaVeicoliUtente/?utente=`+cfUtente;
        
        let response = await fetch(url);

        if (response.ok) {
            const veicoliJson = await response.json();
            return veicoliJson.map((veicolo) => Veicolo.from(veicolo));
        } else {
            throw response.status;  // un oggetto con un errore che arriva dal server
        }
    }

    //Metodo per cercare le colonnine tramite codice
    static ricercaTramiteCodiceColonnina = async (codice) => {

        let url = `/api/colonninaCodice/?codice=`+codice;
        let response = await fetch(url);

        if (response.ok) {
            const colonninaJson = await response.json();
            return colonninaJson.map((colonnina) => Colonnina.from(colonnina));
        } else {
            throw response.status;  // un oggetto con un errore che arriva dal server
        }
    }

    //Metodo per cercare le colonnine tramite città
    static ricercaTramiteCittà = async (citta) => {

        let url = `/api/colonninaCitta/?citta=`+citta;
        let response = await fetch(url);

        if (response.ok) {
            const colonninaJson = await response.json();
            return colonninaJson.map((colonnina) => Colonnina.from(colonnina));
        } else {
            throw response.status;  // un oggetto con un errore che arriva dal server
        }
    }

    //Metodo per cercare le colonnine tramite città e indirizzo
    static ricercaTramiteCittàIndirizzo = async (citta,indirizzo) => {

        let url = `/api/colonninaCittaIndirizzo/?citta=` + citta + `&indirizzo=` + indirizzo;
        let response = await fetch(url);

        if (response.ok) {
            const colonninaJson = await response.json();
            return colonninaJson.map((colonnina) => Colonnina.from(colonnina));
        } else {
            throw response.status;  // un oggetto con un errore che arriva dal server
        }
    }

    //Metodo per settare lo stato occupato della colonnina
    static statoColonninaOccupato = async (codiceColonnina) => {

        let response = await fetch("/api/statoColonninaOccupato/", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                codice: codiceColonnina
            })
        })

        return response.status;
    }

    //Metodo per cercare le colonnine tramite città e indirizzo
    static prelevaCittàIndirizzoPrenotazione = async (codice) => {

        let url = `/api/prelevaCittaIndirizzoPrenotazione/?codice=` + codice;
        let response = await fetch(url);

        if (response.ok) {
            const colonninaJson = await response.json();
            return colonninaJson.map((colonnina) => Colonnina.from(colonnina));
        } else {
            throw response.status;  // un oggetto con un errore che arriva dal server
        }
    }

    //Metodo per prenotare la colonnina
    static prenotaColonnina = async (codiceColonnina,targa,cfUser,citta,indirizzo) => {

        let response = await fetch("/api/prenotaColonnina/", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                codice: codiceColonnina,
                targa: targa,
                cf: cfUser,
                citta: citta,
                indirizzo: indirizzo
            })
        })

        return response.status;
    }
    
    
    //Metodo per cercare le ricariche tramite la città
    static ricercaRicaricheTramiteCitta = async (citta,cfUser) => {

        let url = `/api/ricercaRicaricheTramiteCitta/?citta=` + citta + `&cf=` + cfUser;
        let response = await fetch(url);

        if (response.ok) {
            const prenotazioneJson = await response.json();
            return prenotazioneJson.map((prenotazione) => Prenotazione.from(prenotazione));
        } else {
            throw response.status;  // un oggetto con un errore che arriva dal server
        }
    }

    //Metodo per cercare le ricariche tramite la targa
    static ricercaRicaricheTramiteTarga = async (targa,cfUser) => {

        let url = `/api/ricercaRicaricheTramiteTarga/?targa=` + targa + `&cf=` + cfUser;
        let response = await fetch(url);

        if (response.ok) {
            const prenotazioneJson = await response.json();
            return prenotazioneJson.map((prenotazione) => Prenotazione.from(prenotazione));
        } else {
            throw response.status;  // un oggetto con un errore che arriva dal server
        }
    }

    //Metodo cercare le ricariche tramite città e targa
    static ricercaRicaricheTramiteCittaTarga = async (citta,targa,cfUser) => {

        let url = `/api/ricercaRicaricheTramiteCittaTarga/?citta=` + citta +`&targa=`+ targa +`&cf=` + cfUser;
        let response = await fetch(url);

        if (response.ok) {
            const prenotazioneJson = await response.json();
            return prenotazioneJson.map((prenotazione) => Prenotazione.from(prenotazione));
        } else {
            throw response.status;  // un oggetto con un errore che arriva dal server
        }
    }
    
    //Metodo cercare le ricariche tramite città e targa
    static ricercaCodiceColonninaTramitePrenotazione = async (codicePrenotazione) => {

        let url = `/api/ricercaCodiceColonninaTramitePrenotazione/?codicePrenotazione=` + codicePrenotazione;
        let response = await fetch(url);

        if (response.ok) {
            const prenotazioneJson = await response.json();
            return prenotazioneJson.map((prenotazione) => Prenotazione.from(prenotazione));
        } else {
            throw response.status;  // un oggetto con un errore che arriva dal server
        }
    }

    //Metodo per settare lo stato prenotabile della colonnina
    static terminaPrenotazione = async (codicePrenotazione) => {

        let response = await fetch("/api/terminaPrenotazione/", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                codicePrenotazione: codicePrenotazione
            })
        })

        return response.status;
    }

    //Metodo per settare lo stato prenotabile della colonnina
    static statoColonninaPrenotabile = async (codiceColonnina) => {

        let response = await fetch("/api/statoColonninaPrenotabile/", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                codice: codiceColonnina
            })
        })

        return response.status;
    }

    //Metodo calcolare il numero di ricariche effettuate da un utente
    static numeroRicariche = async (cfUser) => {

        let url = `/api/numeroRicariche/?cfUser=` + cfUser;
        let response = await fetch(url);
    
        if (response.ok) {
            const prenotazioneJson = await response.json();
            return prenotazioneJson; 
        } else {
            throw new Error(response.status); 
        }
    }
    
    //Metodo per eliminare un veicolo
    static eliminaVeicolo = async (targa) => {

        let response = await fetch("/api/eliminaVeicolo/", {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                targa: targa
            })
        })

        return response.status;
    }

    //Metodo per settare lo stato guasto della colonnina
    static statoColonninaGuasta = async (codiceColonnina) => {

        let response = await fetch("/api/statoColonninaGuasta/", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                codice: codiceColonnina
            })
        })

        return response.status;
    }

    //Metodo per eliminare una colonnina
    static eliminaColonnina = async (codiceColonnina) => {

        let response = await fetch("/api/eliminaColonnina/", {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                codice: codiceColonnina
            })
        })

        return response.status;
    }

    //Metodo per prenotare la colonnina
    static creaColonnina = async (citta,indirizzo) => {

        let response = await fetch("/api/creaColonnina/", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                citta: citta,
                indirizzo: indirizzo
            })
        })

        return response.status;
    }

    //Metodo per registrare una richiesta di aiuto che sarà da gestire
    static registraRichiesta = async (email,telefono,messaggio) => {

        let response = await fetch("/api/registraRichiesta/", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                email: email,
                telefono: telefono,
                messaggio: messaggio
            })
        })

        return response.status;
    }

    //Metodo calcolare il numero di ricariche effettuate da un certo Veicolo
    static numeroRicaricheVeicolo = async (targa) => {

        let url = `/api/numeroRicaricheVeicolo/?targa=` + targa;
        let response = await fetch(url);
    
        if (response.ok) {
            const prenotazioneJson = await response.json();
            return prenotazioneJson; 
        } else {
            throw new Error(response.status); 
        }
    }

    
    //Metodo per registrare una richiesta di aiuto che sarà da gestire
    static richiestaGestita = async (codice) => {

        let response = await fetch("/api/richiestaGestita/", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                codice: codice
            })
        })

        return response.status;
    }

    //Metodo per registrare una richiesta di aiuto che sarà da gestire
    static prelevaRichieste = async () => {

        let url = `/api/prelevaRichieste/`;
        let response = await fetch(url);
    
        if (response.ok) {
            const richiesteJson = await response.json();
            return richiesteJson.map((colonnina) => Richiesta.from(colonnina));
 
        } else {
            throw new Error(response.status); 
        }
    }

}

export default Api;
