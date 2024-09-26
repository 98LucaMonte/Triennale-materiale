class Richiesta{

    constructor(email,telefono,messaggio,data,stato,codice){
        this.email = email;
        this.telefono = telefono;
        this.messaggio = messaggio;
        this.data = data;
        this.stato = stato;
        this.codice = codice;

    }
    
    static from(json){
        const richiesta = Object.assign(new Richiesta(),json);
        return richiesta;
    }

}

export default Richiesta;