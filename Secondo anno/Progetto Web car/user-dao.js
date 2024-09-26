'use strict';

const db = require('./db.js');
const bcrypt = require('bcrypt');

//Metodo per ottenere un utente
exports.getUtente = function(username, password){
    return new Promise((resolve, reject) => {
        
        const sql = "SELECT * FROM Utenti WHERE email=?";
        db.get(sql, [username],(err, row) => {
            
            if (err) {
                reject(err);
            }
            else if(row == undefined){
                resolve({error:'User not found'});
                return;
            }
            else{
                const user = {
                    nome: row.nome,
                    cognome: row.cognome,
                    email: row.email,
                    cf: row.cf,
                    tipo: row.tipo
                };
            
                let check = false;
                
                if(bcrypt.compareSync(password, row.psw))
                  check = true;
    
                resolve({user, check});
            }
        });
    })
}

//Metodo per inserire un nuovo lettore all'interno del DB
exports.nuovoUtente = function(utente){
return new Promise((resolve, reject) => {
    const sql = 'INSERT INTO Utenti (nome, cognome, email, cf, tipo, psw) VALUES (?, ?, ?, ?, ?, ?);';

    const password = bcrypt.hashSync(utente.psw, 10);

    db.run(sql, [utente.nome, utente.cognome, utente.email, utente.cf, utente.tipo, password], (err) => {
        if (err) {
            reject(err);
            return;
        }
        resolve();
    });
       
});
}

/*
*Metodo per verificare che l'utente che sta cercxando di registrarsi non usi una email che è stata già usata da altri utenti
*Importante fare questo controllo altrimenti ci possono essere più utenti con la stessa email 
*/
exports.checkEmail = function(email){
    return new Promise((resolve, reject) => {
        const sql = 'SELECT * FROM Utenti WHERE email = ?';
        db.get(sql, [email], (err, row) => {
            if (err){ 
                reject(err);
            }
            else if(row===undefined){
                resolve(row);
            }
            else{
                resolve(row.Email);
            }
        });
    });
}

//Metodo per registrare una richiesta d'aiuto di un utente
exports.registraRichiesta = function(email,telefono,messaggio){
    return new Promise((resolve, reject) => {
        const sql = 'INSERT INTO Richiesta (email,telefono,messaggio,data,statoRichiesta) VALUES (?, ?, ?,date("now"),?);';
        db.run(sql, [email,telefono,messaggio,"da gestire"], (err) => {
            if (err) {
                reject(err);
                return;
            }
            resolve(this.lastID);
        });
           
    });
}

//metodo per prelevare le richieste
exports.prelevaRichieste = function () {

    return new Promise((resolve, reject) => {

        const sql = 'SELECT * from Richiesta order by statoRichiesta';

        db.all(sql, (err, rows) => {
            if (err) {
                reject(err);
                return;
            }

            const richieste = rows.map((row) => ({ 
                email: row.email, 
                telefono: row.telefono, 
                messaggio: row.messaggio, 
                data: row.data,
                statoRichiesta: row.statoRichiesta,
                codice: row.codiceRichiesta,
            })); 
            
            resolve(richieste);
        });
    });
}

//Metodo per registrare che una richiesta d'aiuto è stata gestita
exports.richiestaGestita = function(codice){
    return new Promise((resolve, reject) => {
        const sql = 'UPDATE Richiesta SET statoRichiesta = ? WHERE codiceRichiesta = ?;';
        db.all(sql, ["Gestita",codice], (err) => {
            if (err) {
                reject(err);
                return;
            }
            resolve(this.lastID);
        });
           
    });
}
