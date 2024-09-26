"use-strict";

function creaFormLoginRegistrazione() {
    return`
    <div class="container margin-top-form-login" >
    <div id="MessaggioErroreAccesso"></div>
    <div class="row" style="padding: 5%;">
        <div class="col-sm-5 border border-secondary color-form">
            <form>
                <h5 class="text-center mt-5 mb-2"><strong>Accesso all'area riservata</strong></h5>
                <div class="text-center">
                    <svg xmlns="http://www.w3.org/2000/svg" width="45" height="45" fill="currentColor"
                        class="bi bi-person" viewBox="0 0 16 16">
                        <path
                            d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" />
                    </svg>
                </div>
                <div class="margin-label-input-form">
                    <label for="exampleInputEmail1" class="form-label"><strong>Email</strong></label>
                    <input type="email" class="form-control form-control-sm" id="InputEmail1"
                        aria-describedby="emailHelp" placeholder="Inserisci la tua email">
                </div>
                <div class="margin-label-input-form">
                    <label for="exampleInputPassword1" class="form-label"><strong>Password</strong></label>
                    <input type="password" class="form-control form-control-sm" id="InputPassword1"
                        placeholder="Inserisci la tua password">
                </div>
                <div class="text-center margin-label-input-form">
                    <button type="submit" class="btn btn-secondary" id="Accesso">Accedi</button>
                </div>
            </form>
        </div>
        <div class="col-sm-2"></div>
        <div class="col-sm-5 border border-secondary color-form ">
            <form>
                <h5 class="text-center mt-5 mb-2"><strong>Crea il tuo profilo</strong></h5>
                <h6 class="text-center mb-5"><strong>Inserisci i tuoi dati personali e scegli la tua
                        password</strong></h6>
                <div class="margin-label-input-form">
                    <label for="exampleInputEmail1" class="form-label"><strong>Nome</strong></label>
                    <input type="text" class="form-control form-control-sm" id="InputNome"
                        aria-describedby="emailHelp" placeholder="Inserisci il tuo nome">
                </div>
                <div class="margin-label-input-form">
                    <label for="exampleInputPassword1" class="form-label"><strong>Cognome</strong></label>
                    <input type="text" class="form-control form-control-sm" id="InputCognome"
                        placeholder="Inserisci il tuo cognome">
                </div>
                <div class="margin-label-input-form">
                    <label for="exampleInputPassword1" class="form-label"><strong>Codice
                            fiscale</strong></label>
                    <input type="text" class="form-control form-control-sm" id="InputCf"
                        placeholder="Inserisci il tuo codice fiscale">
                </div>
                <div class="margin-label-input-form">
                    <label for="exampleInputEmail1" class="form-label"><strong>Email</strong></label>
                    <input type="email" class="form-control form-control-sm" id="InputEmail2"
                        aria-describedby="emailHelp" placeholder="Inserisci la tua email">
                </div>
                <div class="margin-label-input-form">
                    <label for="exampleInputPassword1" class="form-label"><strong>Password</strong></label>
                    <input type="password" class="form-control form-control-sm" id="InputPassword2"
                        placeholder="Inserisci la tua password">
                </div>
                <div class="margin-label-input-form">
                    <label for="exampleInputPassword1" class="form-label"><strong>Conferma
                            password</strong></label>
                    <input type="password" class="form-control form-control-sm" id="InputPassword3"
                        placeholder="Conferma la tua password">
                </div>
                <div class="text-center margin-label-input-form">
                    <button type="submit" class="btn btn-secondary" id="Registrazione">Registrati</button>
                </div>
            </form>
        </div>
    </div>
</div>`;
}

export {creaFormLoginRegistrazione};