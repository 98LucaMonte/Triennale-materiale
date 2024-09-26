//import
const express = require('express');
const morgan = require('morgan');
const dao = require('./veicolo-dao.js');
const daoUser = require('./user-dao.js');
const daoColonnina = require('./colonnina-dao.js');
const path = require('path');
const passport = require('passport'); // auth middleware
const LocalStrategy = require('passport-local').Strategy; // username and password for login
const session = require('express-session');

//inizializzazioni
const app = express();
const port = 3000;

// set up the middleware
app.use(morgan('tiny'));

// every requests body will be considered as in JSON format
app.use(express.json());

// set up the 'public' component as a static website
app.use(express.static('public'));

/*Codice per passport Login*/

// set up the "username and password" login strategy
// by setting a function to verify username and password

passport.use(new LocalStrategy(
    function (username, password, done) {
        
        daoUser.getUtente(username, password).then(({ user, check }) => {
            if (!user) { return done(null, false, { message: 'Incorrect Username' }); }
            if (!check) { return done(null, false, { message: 'Incorrect password' }); }
            return done(null, user);
        });
        
    }
));

/*
All'interno definiamo una chiave segreta in realtà non andrebbe indicata cosi
*/
app.use(session({
    secret: "QuestaFraseNonèUnSegreto",
    resave: false,
    saveUninitialized: false
}))

passport.serializeUser(function (utente, done) {
    done(null, utente.nome);
});

passport.deserializeUser(function (id, done) {
    daoUser.getUtente(id).then(utente => {
        done(null, utente);
    });
});

//inizializzazione passport
app.use(passport.initialize());
app.use(passport.session());

const isLoggedIn = (req, res, next) => {
    if (req.isAuthenticated()) {
        return next();
    }
    return res.status(401).json({ "statusCode": 401, "message": "not authenticated" });
}

// POST/sessions 
// Login 
app.post('/api/sessions', function (req, res, next) {

    passport.authenticate('local', function (err, user, info) {
        if (err) { 
            return next(err); 
        }
        
        if (!user) {
            return res.status(401).json(info);
        }

        req.login(user, function (err) {
            if (err) { 
                return next(err); 
            }
            
            return res.json(user);
        });
    })(req, res, next);
});

// Logout
app.delete('/api/sessions/current', function(req, res){
    req.logout(function(err) {
        if (err) {
            // Gestisci l'errore se si verifica durante il logout
            res.status(500).json({ error: 'Internal Server Error' });
        } else {
            // Il logout è stato completato con successo
            res.end();
        }
    });
});


//Metodo usato per registrare un nuovo Utente
app.post('/api/registra', function (req, res) {
     
    if (req.body != null) {
            daoUser.nuovoUtente(req.body)
            .then(() => {res.status(200).send();})
            .catch((error) => {
            res.status(500).send();
            res.end();
            })
        }
         
})

//Metodo per andare a verificare se l'email inserita dall'utente che sta cercando di registrarsi non venga già usata da un altro utente 
app.get('/api/checkEmail', function (req, res) {
    
   daoUser.checkEmail(req.query.Email)
        .then((result) =>  {
            if(result === undefined){
                res.status(404).send();
            }
            else{
                res.json(result);
                res.status(200).send(); 
            }
        })
        .catch((error) => res.status(500).json(error));
})

/*fine codice passport, Login e Registrazione*/


app.post('/api/aggiungiVeicolo/', isLoggedIn,(req, res) => {
   
    dao.aggiungiVeicolo(req.body.veicolo)
        .then((result) => res.status(201).header('Location', `/aggiungiVeicolo/${result}`).end())
        .catch(() => res.status(503).json({ error: "Database error: Errore durante la creazione" }));
});

app.get('/api/prelevaVeicoliUtente/', isLoggedIn,(req, res) => {
    
    dao.prelevaVeicoliUtente(req.query.utente)
        .then((veicoli) => res.json(veicoli))
        .catch((error) => res.status(404).json(error));
})

app.get('/api/colonninaCodice', (req, res) => {
    
    daoColonnina.ricercaColonninaTramiteCodice(req.query.codice)
        .then((colonnine) => res.json(colonnine))
        .catch((error) => res.status(404).json(error));
})

app.get('/api/colonninaCitta', (req, res) => {
    
    daoColonnina.ricercaColonninaTramiteCittà(req.query.citta)
        .then((colonnine) => res.json(colonnine))
        .catch((error) => res.status(404).json(error));
})

app.get('/api/colonninaCittaIndirizzo', (req, res) => {
    
    daoColonnina.ricercaColonninaTramiteCittàIndirizzo(req.query.citta,req.query.indirizzo)
        .then((colonnine) => res.json(colonnine))
        .catch((error) => res.status(404).json(error));
})

app.post('/api/statoColonninaOccupato/', isLoggedIn,(req, res) => {
   
    daoColonnina.cambiaStatoColonnina(req.body.codice,"Occupata")
        .then((result) => res.status(201).header('Location', `/statoColonninaOccupato/${result}`).end())
        .catch(() => res.status(503).json({ error: "Database error: Errore durante la creazione" }));
});

app.get('/api/prelevaCittaIndirizzoPrenotazione', (req, res) => {
    
    daoColonnina.ricercaColonninaTramiteCodice(req.query.codice)
        .then((colonnine) => res.json(colonnine))
        .catch((error) => res.status(404).json(error));
})

app.post('/api/prenotaColonnina/', isLoggedIn,(req, res) => {
   
    daoColonnina.prenotaColonnina(req.body.codice,req.body.targa,req.body.cf,req.body.citta,req.body.indirizzo)
        .then((result) => res.status(201).header('Location', `/prenotaColonnina/${result}`).end())
        .catch(() => res.status(503).json({ error: "Database error: Errore durante la creazione" }));
});

app.get('/api/ricercaRicaricheTramiteCitta', (req, res) => {
    
    daoColonnina.ricercaRicaricheTramiteCitta(req.query.citta,req.query.cf)
        .then((prenotazioni) => res.json(prenotazioni))
        .catch((error) => res.status(404).json(error));
})

app.get('/api/ricercaRicaricheTramiteTarga', (req, res) => {
    
    daoColonnina.ricercaRicaricheTramiteTarga(req.query.targa,req.query.cf)
        .then((prenotazioni) => res.json(prenotazioni))
        .catch((error) => res.status(404).json(error));
})

app.get('/api/ricercaRicaricheTramiteCittaTarga', (req, res) => {
    
    daoColonnina.ricercaRicaricheTramiteCittaTarga(req.query.citta,req.query.targa,req.query.cf)
        .then((prenotazioni) => res.json(prenotazioni))
        .catch((error) => res.status(404).json(error));
})

app.get('/api/ricercaCodiceColonninaTramitePrenotazione', (req, res) => {
    
    daoColonnina.ricercaCodiceColonninaTramitePrenotazione(req.query.codicePrenotazione)
        .then((prenotazioni) => res.json(prenotazioni))
        .catch((error) => res.status(404).json(error));
})

app.post('/api/terminaPrenotazione/', isLoggedIn,(req, res) => {
   
    daoColonnina.terminaPrenotazione(req.body.codicePrenotazione)
        .then((result) => res.status(201).header('Location', `/terminaPrenotazione/${result}`).end())
        .catch(() => res.status(503).json({ error: "Database error: Errore durante la creazione" }));
});

app.post('/api/statoColonninaPrenotabile/', isLoggedIn,(req, res) => {
   
    daoColonnina.cambiaStatoColonnina(req.body.codice,"Prenotabile")
        .then((result) => res.status(201).header('Location', `/statoColonninaPrenotabile/${result}`).end())
        .catch(() => res.status(503).json({ error: "Database error: Errore durante la creazione" }));
});

app.get('/api/numeroRicariche/', isLoggedIn, (req, res) => {
    daoColonnina.numeroRicariche(req.query.cfUser)
        .then((result) => res.json(result))
        .catch((error) => res.status(404).json(error));
});

app.delete('/api/eliminaVeicolo/', isLoggedIn,(req, res) => {
   
    dao.eliminaVeicolo(req.body.targa)
        .then((result) => res.status(201).header('Location', `/eliminaVeicolo/${result}`).end())
        .catch(() => res.status(503).json({ error: "Database error: Errore durante la creazione" }));
});

app.post('/api/statoColonninaGuasta/', isLoggedIn,(req, res) => {
   
    daoColonnina.cambiaStatoColonnina(req.body.codice,"Guasta")
        .then((result) => res.status(201).header('Location', `/statoColonninaGuasto/${result}`).end())
        .catch(() => res.status(503).json({ error: "Database error: Errore durante la creazione" }));
});

app.delete('/api/eliminaColonnina/', isLoggedIn,(req, res) => {
   
    daoColonnina.eliminaColonnina(req.body.codice)
        .then((result) => res.status(201).header('Location', `/eliminaColonnina/${result}`).end())
        .catch(() => res.status(503).json({ error: "Database error: Errore durante la creazione" }));
});

app.post('/api/creaColonnina/', isLoggedIn,(req, res) => {
   
    daoColonnina.creaColonnina(req.body.citta,req.body.indirizzo)
        .then((result) => res.status(201).header('Location', `/creaColonnina/${result}`).end())
        .catch(() => res.status(503).json({ error: "Database error: Errore durante la creazione" }));
});

app.post('/api/registraRichiesta/', (req, res) => {
   
    daoUser.registraRichiesta(req.body.email,req.body.telefono,req.body.messaggio)
        .then((result) => res.status(201).header('Location', `/registraRichiesta/${result}`).end())
        .catch(() => res.status(503).json({ error: "Database error: Errore durante la creazione" }));
});

app.post('/api/richiestaGestita/', (req, res) => {
   
    daoUser.richiestaGestita(req.body.codice)
        .then((result) => res.status(201).header('Location', `/richiestaGestita/${result}`).end())
        .catch(() => res.status(503).json({ error: "Database error: Errore durante la creazione" }));
});

app.get('/api/prelevaRichieste/', isLoggedIn, (req, res) => {
   
    daoUser.prelevaRichieste()
        .then((result) => res.json(result))
        .catch((error) => res.status(404).json(error));
});

app.get('/api/numeroRicaricheVeicolo/', isLoggedIn, (req, res) => {
    daoColonnina.numeroRicaricheVeicolo(req.query.targa)
        .then((result) => res.json(result))
        .catch((error) => res.status(404).json(error));
});


app.get('*', function (request, response) {
    response.sendFile(path.resolve(__dirname, 'public/index.html'));
});

//start server
app.listen(port, () => {
    console.log(`Example app listening on port ${port}`);
})