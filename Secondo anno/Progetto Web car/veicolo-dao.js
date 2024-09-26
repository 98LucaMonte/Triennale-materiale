"use strict";

const db = require('./db.js');
const { json } = require('express');


//metodo per aggiungere un veicolo all'interno del Db 
exports.aggiungiVeicolo = function (veicolo) {

    return new Promise((resolve, reject) => {

        const sql = 'INSERT INTO Veicolo (targa, marca, modello, cfProprietario) VALUES(?,?,?,?)';

        db.run(sql, [veicolo.targa,veicolo.marca,veicolo.modello,veicolo.cfProprietario], function (err) {
            
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

//metodo per prelevare i veicoli di un certo utente
exports.prelevaVeicoliUtente = function (cfUtente) {

    return new Promise((resolve, reject) => {

        const sql = 'SELECT targa,marca,modello from Veicolo where cfProprietario=?';

        db.all(sql, [cfUtente], (err, rows) => {
            if (err) {
                reject(err);
                return;
            }

            const veicoli = rows.map((row) => ({ 
                targa: row.targa, 
                marca: row.marca, 
                modello: row.modello, 
            })); 
            
            resolve(veicoli);
        });
    });
}

//metodo per rimuovere un veicolo all'interno del Db 
exports.eliminaVeicolo = function (targa) {

    return new Promise((resolve, reject) => {

        const sql = 'DELETE FROM Veicolo WHERE targa = ?;';

        db.run(sql, [targa], function (err) {
            
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
