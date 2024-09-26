class Prenotazione{

    constructor(codice,cfUtente,idColonnina,stato,targa,città,indirizzo){
        this.codice = codice;
        this.cfUtente = cfUtente;
        this.idColonnina = idColonnina;
        this.stato = stato;
        this.targa = targa;
        this.città = città;
        this.indirizzo = indirizzo;
    }
    
    static from(json){
        const prenotazione = Object.assign(new Prenotazione(),json);
        return prenotazione;
    }

}

export default Prenotazione;