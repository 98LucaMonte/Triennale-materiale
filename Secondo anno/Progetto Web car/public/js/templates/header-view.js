'use strict';

function creaHeader() {
    return`
    <nav class="navbar navbar-expand-lg style-header fixed-top">
    <a class="navbar-brand ms-3" href="/">
        <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor"
            class="bi bi-fuel-pump-fill" viewBox="0 0 16 16">
            <path
                d="M1 2a2 2 0 0 1 2-2h6a2 2 0 0 1 2 2v8a2 2 0 0 1 2 2v.5a.5.5 0 0 0 1 0V8h-.5a.5.5 0 0 1-.5-.5V4.375a.5.5 0 0 1 .5-.5h1.495c-.011-.476-.053-.894-.201-1.222a.97.97 0 0 0-.394-.458c-.184-.11-.464-.195-.9-.195a.5.5 0 0 1 0-1c.564 0 1.034.11 1.412.336.383.228.634.551.794.907.295.655.294 1.465.294 2.081V7.5a.5.5 0 0 1-.5.5H15v4.5a1.5 1.5 0 0 1-3 0V12a1 1 0 0 0-1-1v4h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V2Zm2.5 0a.5.5 0 0 0-.5.5v5a.5.5 0 0 0 .5.5h5a.5.5 0 0 0 .5-.5v-5a.5.5 0 0 0-.5-.5h-5Z" />
        </svg>
        <strong>EVCP</strong>
    </a>
    <div class="container-fluid container-fluid-center-element">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse mt-4" id="navbarTogglerDemo01">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="btn navbar-brand" href="/servizi">Servizi</a>
                </li>
                <li class="nav-item">
                    <a class="btn navbar-brand" href="/contatti">Contattaci</a>
                </li>
                <li class="nav-item">
                    <a class="btn navbar-brand" href="/ricerca">Trova un punto di ricarica</a>
                </li>

            </ul>
            <div class="ms-lg-2 me-5">
                <div class="dropdown me-5">
                    <a class="btn navbar-brand" type="button" href="/accedi">
                        <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                            class="bi bi-person" viewBox="0 0 16 16">
                            <path
                                d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" />
                        </svg>
                        <Strong>Accedi</Strong>
                    </a>
                </div>
            </div>
        </div>
    </div>
</nav>

    `;
}

function creaHeaderUtente() {
  return`
  <nav class="navbar navbar-expand-lg style-header fixed-top">
  <a class="navbar-brand ms-3" href="/utente">
      <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor"
          class="bi bi-fuel-pump-fill" viewBox="0 0 16 16">
          <path
              d="M1 2a2 2 0 0 1 2-2h6a2 2 0 0 1 2 2v8a2 2 0 0 1 2 2v.5a.5.5 0 0 0 1 0V8h-.5a.5.5 0 0 1-.5-.5V4.375a.5.5 0 0 1 .5-.5h1.495c-.011-.476-.053-.894-.201-1.222a.97.97 0 0 0-.394-.458c-.184-.11-.464-.195-.9-.195a.5.5 0 0 1 0-1c.564 0 1.034.11 1.412.336.383.228.634.551.794.907.295.655.294 1.465.294 2.081V7.5a.5.5 0 0 1-.5.5H15v4.5a1.5 1.5 0 0 1-3 0V12a1 1 0 0 0-1-1v4h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V2Zm2.5 0a.5.5 0 0 0-.5.5v5a.5.5 0 0 0 .5.5h5a.5.5 0 0 0 .5-.5v-5a.5.5 0 0 0-.5-.5h-5Z" />
      </svg>
      <strong>EVCP</strong>
  </a>
  <div class="container-fluid container-fluid-center-element">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
          data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false"
          aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse mt-4" id="navbarTogglerDemo01">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                 <a class="btn navbar-brand"  href="/utente">Torna al menu</a>
              </li>
              <li class="nav-item">
                  <a class="btn navbar-brand"  href="/servizi">Servizi</a>
              </li>
              <li class="nav-item">
                  <a class="btn navbar-brand" href="/contatti">Contattaci</a>
              </li>

          </ul>
          <div class="ms-lg-2 me-5">
              <div class="dropdown me-5">
                  <a class="btn navbar-brand" type="button" href="/logout">
                      <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                          class="bi bi-person" viewBox="0 0 16 16">
                          <path
                              d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" />
                      </svg>
                      <Strong>Esci</Strong>
                  </a>
              </div>
          </div>
      </div>
  </div>
</nav>
        `;
}

function creaHeaderAdmin() {
    return`
    <nav class="navbar navbar-expand-lg style-header fixed-top">
    <a class="navbar-brand ms-3" href="/admin">
        <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor"
            class="bi bi-fuel-pump-fill" viewBox="0 0 16 16">
            <path
                d="M1 2a2 2 0 0 1 2-2h6a2 2 0 0 1 2 2v8a2 2 0 0 1 2 2v.5a.5.5 0 0 0 1 0V8h-.5a.5.5 0 0 1-.5-.5V4.375a.5.5 0 0 1 .5-.5h1.495c-.011-.476-.053-.894-.201-1.222a.97.97 0 0 0-.394-.458c-.184-.11-.464-.195-.9-.195a.5.5 0 0 1 0-1c.564 0 1.034.11 1.412.336.383.228.634.551.794.907.295.655.294 1.465.294 2.081V7.5a.5.5 0 0 1-.5.5H15v4.5a1.5 1.5 0 0 1-3 0V12a1 1 0 0 0-1-1v4h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V2Zm2.5 0a.5.5 0 0 0-.5.5v5a.5.5 0 0 0 .5.5h5a.5.5 0 0 0 .5-.5v-5a.5.5 0 0 0-.5-.5h-5Z" />
        </svg>
        <strong>EVCP</strong>
    </a>
    <div class="container-fluid container-fluid-center-element">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse mt-4" id="navbarTogglerDemo01">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                   <a class="btn navbar-brand"  href="/admin">Torna al menu</a>
                </li>
                <li class="nav-item">
                    <a class="btn navbar-brand"  href="/servizi">Servizi</a>
                </li>
                <li class="nav-item">
                    <a class="btn navbar-brand" href="/contatti">Contattaci</a>
                </li>
  
            </ul>
            <div class="ms-lg-2 me-5">
                <div class="dropdown me-5">
                    <a class="btn navbar-brand" type="button" href="/logout">
                        <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                            class="bi bi-person" viewBox="0 0 16 16">
                            <path
                                d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" />
                        </svg>
                        <Strong>Esci</Strong>
                    </a>
                </div>
            </div>
        </div>
    </div>
  </nav>
          `;
  }

export {creaHeaderAdmin,creaHeader, creaHeaderUtente};