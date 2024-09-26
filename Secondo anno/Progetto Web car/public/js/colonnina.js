class Colonnina{

    constructor(codice,stato,città,indirizzo){
        this.codice = codice;
        this.stato = stato;
        this.città = città;
        this.indirizzo = indirizzo;
    }
    
    static from(json){
        const colonnina = Object.assign(new Colonnina(),json);
        return colonnina;
    }

}

export default Colonnina;