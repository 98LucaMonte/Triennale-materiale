class Veicolo{

    constructor(targa,marca,modello,cfProprietario){
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
        this.cfProprietario = cfProprietario;
    }
    
    static from(json){
        const veicolo = Object.assign(new Veicolo(),json);
        return veicolo;
    }

}

export default Veicolo;