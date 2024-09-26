"use strict";

const db = require('./db.js');

//metodo per cercare le colonnine tramite codice
exports.ricercaColonninaTramiteCodice = function (codice) {

    return new Promise((resolve, reject) => {

        const sql = 'SELECT * from Colonnina where codice=?';

        db.all(sql, [codice], (err, rows) => {
            if (err) {
                reject(err);
                return;
            }

            const colonnine = rows.map((row) => ({ 
                codice: row.codice, 
                stato: row.stato, 
                città: row.città,
                indirizzo: row.indirizzo, 
            })); 
            
            resolve(colonnine);
        });
    });
}

//metodo per cercare le colonnine tramite città
exports.ricercaColonninaTramiteCittà = function (citta) {

    return new Promise((resolve, reject) => {

        const sql = 'SELECT * from Colonnina where città LIKE ? order by codice';

        const cittaSql = '%' + citta + '%';

        db.all(sql, [cittaSql], (err, rows) => {
            if (err) {
                reject(err);
                return;
            }

            const colonnine = rows.map((row) => ({ 
                codice: row.codice, 
                stato: row.stato, 
                città: row.città,
                indirizzo: row.indirizzo, 
            })); 
            
            resolve(colonnine);
        });
    });
}

//metodo per cercare le colonnine tramite città e indirizzo
exports.ricercaColonninaTramiteCittàIndirizzo = function (citta,indirizzo) {

    return new Promise((resolve, reject) => {

        const sql = 'SELECT * from Colonnina where città LIKE ? and indirizzo LIKE ? order by codice';

        citta = citta.replace(/^|$/g, "%");
        indirizzo = indirizzo.replace(/^|$/g, "%");

        db.all(sql, [citta,indirizzo], (err, rows) => {
            if (err) {
                reject(err);
                return;
            }

            const colonnine = rows.map((row) => ({ 
                codice: row.codice, 
                stato: row.stato, 
                città: row.città,
                indirizzo: row.indirizzo, 
            })); 
            
            resolve(colonnine);
        });
    });
}

//metodo per cambiare lo stato della colonnina
exports.cambiaStatoColonnina = function (codiceColonnina,stato) {

    return new Promise((resolve, reject) => {

        const sql = 'UPDATE Colonnina SET stato=? WHERE Codice=?';

        db.all(sql, [stato,codiceColonnina], (err) => {
            if (err) {
                reject(err);
                return;
            }

            resolve(this.lastID);
        });
    });
}

//metodo per prenotare la colonnina
exports.prenotaColonnina = function (codiceColonnina,targa,cfUtente,citta,indirizzo) {

    return new Promise((resolve, reject) => {

        const sql = 'INSERT INTO Prenotazione(cfUtente,codiceColonnina,stato,targa,città,indirizzo) VALUES(?,?,?,?,?,?);';
        
        db.run(sql, [cfUtente,codiceColonnina,"in corso",targa,citta,indirizzo], (err) => {
            if (err) {
                reject(err);
                return;
            }

            resolve(this.lastID);
        });
    });
}

//metodo per calcolare il numero di ricariche effettuate da un utente
exports.numeroRicariche = function (cf) {

    return new Promise((resolve, reject) => {

        const sql = 'SELECT count(targa) as "NumeroRicariche" from Prenotazione where cfUtente=? group by cfUtente';

        db.get(sql, [cf], (err, row) => {
            if (err) {
                reject(err);
                return;
            }

            let numeroRicariche = 0;
            if (row) {
                numeroRicariche = row.NumeroRicariche;
            }
            
            resolve(numeroRicariche);
        });
    });
}

//metodo per cercare le prenotazioni tramite la città
exports.ricercaRicaricheTramiteCitta = function (citta,cf) {

    return new Promise((resolve, reject) => {

        const sql = 'SELECT * from Prenotazione where città=? and cfUtente=?';

        db.all(sql, [citta,cf], (err, rows) => {
            if (err) {
                reject(err);
                return;
            }

            const prenotazioni = rows.map((row) => ({ 
                codicePrenotazione: row.codicePrenotazione, 
                cfUtente: row.cfUtente, 
                idColonnina: row.codiceColonnina,
                stato: row.stato,
                targa: row.targa,
                città: row.città,
                indirizzo : row.indirizzo,
            })); 
            
            resolve(prenotazioni);
        });
    });
}

//metodo per cercare le prenotazioni tramite la targa
exports.ricercaRicaricheTramiteTarga = function (targa,cf) {

    return new Promise((resolve, reject) => {

        const sql = 'SELECT * from Prenotazione where targa=? and cfUtente=?';

        db.all(sql, [targa,cf], (err, rows) => {
            if (err) {
                reject(err);
                return;
            }

            const prenotazioni = rows.map((row) => ({ 
                codicePrenotazione: row.codicePrenotazione, 
                cfUtente: row.cfUtente, 
                idColonnina: row.codiceColonnina,
                stato: row.stato,
                targa: row.targa,
                città: row.città,
                indirizzo : row.indirizzo,
            })); 
            
            resolve(prenotazioni);
        });
    });
}

//metodo per cercare le prenotazioni tramite la città e la targa
exports.ricercaRicaricheTramiteCittaTarga = function (citta,targa,cf) {

    return new Promise((resolve, reject) => {

        const sql = 'SELECT * from Prenotazione where città=? and targa=? and cfUtente=?';

        db.all(sql, [citta,targa,cf], (err, rows) => {
            if (err) {
                reject(err);
                return;
            }

            const prenotazioni = rows.map((row) => ({ 
                codicePrenotazione: row.codicePrenotazione, 
                cfUtente: row.cfUtente, 
                idColonnina: row.codiceColonnina,
                stato: row.stato,
                targa: row.targa,
                città: row.città,
                indirizzo : row.indirizzo,
            })); 
            
            resolve(prenotazioni);
        });
    });
}

//metodo per cercare le prenotazioni tramite la città
exports.ricercaCodiceColonninaTramitePrenotazione = function (codicePrenotazione) {

    return new Promise((resolve, reject) => {

        const sql = 'SELECT * from Prenotazione where codicePrenotazione = ?';

        db.all(sql, [codicePrenotazione], (err, rows) => {
            if (err) {
                reject(err);
                return;
            }

            const prenotazioni = rows.map((row) => ({ 
                codicePrenotazione: row.codicePrenotazione, 
                cfUtente: row.cfUtente, 
                idColonnina: row.codiceColonnina,
                stato: row.stato,
                targa: row.targa,
                città: row.città,
                indirizzo : row.indirizzo,
            })); 
            
            resolve(prenotazioni);
        });
    });
}

//metodo per cambiare lo stato della colonnina
exports.terminaPrenotazione = function (codicePrenotazione) {

    return new Promise((resolve, reject) => {

        const sql = 'UPDATE Prenotazione SET stato=? WHERE codicePrenotazione=?';

        db.all(sql, ["Terminata",codicePrenotazione], (err) => {
            if (err) {
                reject(err);
                return;
            }

            resolve(this.lastID);
        });
    });
}

//metodo per rimuovere una colonnina all'interno del Db 
exports.eliminaColonnina = function (codice) {

    return new Promise((resolve, reject) => {

        const sql = 'DELETE FROM Colonnina WHERE codice = ?;';

        db.run(sql, [codice], function (err) {
            
            if (err) {
                reject(err);
                return;
            }
            else {
                resolve(this.lastID);
            }
        });
    })
}

//metodo per aggiungere una colonnina all'interno del Db 
exports.creaColonnina = function (citta,indirizzo) {

    return new Promise((resolve, reject) => {

        const sql = 'INSERT INTO Colonnina (stato, città, indirizzo) VALUES(?,?,?)';

        db.run(sql, ["Prenotabile",citta,indirizzo], function (err) {
            
            if (err) {
                reject(err);
                return;
            }
            else {
                resolve(this.lastID);
            }
        });
    })
}

//metodo per calcolare il numero di ricariche effettuate da un veicolo
exports.numeroRicaricheVeicolo = function (targa) {

    return new Promise((resolve, reject) => {

        const sql = 'SELECT count(cfUtente) as "NumeroRicariche" from Prenotazione where targa=? group by targa';

        db.get(sql, [targa], (err, row) => {
            if (err) {
                reject(err);
                return;
            }

            let numeroRicariche = 0;
            if (row) {
                numeroRicariche = row.NumeroRicariche;
            }
            
            resolve(numeroRicariche);
        });
    });
}

