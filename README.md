# OAUTH2 Server
Este es un servidor de autenticación OAuth2 que se encarga de gestionar los tokens de acceso y refresco de los usuarios.

## Requisitos
- Java 17 o superior
- Maven 3.8.1 o superior

## Configuración
Para que el proyecto corre hasta en la rama client-entity se debe enviar un http post a la siguiente url: http://localhost:9000/auth/create con el siguiente body:
Es raw de tipo JSON
```bash
{
"username": "admin",
"password": "admin",
"roles": ["ROLE_ADMIN", "ROLE_USER"]
}   
```

Y para el cliente un POST a la siguiente url: http://localhost:9000/client/create con el siguiente body:
Es raw de tipo JSON
```bash
{
    "clientId": "client",
    "clientSecret": "secret",
    "authorizationGrantTypes": ["authorization_code", "refresh_token", "client_credentials"],
    "authenticationMethods": ["client_secret_basic"],
    "redirectUris": ["https://oauthdebugger.com/debug"],
    "scopes": ["openid"]
}
```

Y para obtener el token de acceso se debe enviar un POST a la siguiente url: http://localhost:9000/oauth2/token con el siguiente body:
Es un archivo de tipo x-www-form-urlencoded
    
```bash
    {
        "grant_type": "authorization_code",
        "client_id": "client",
        "redirect_uri": "https://oauthdebugger.com/debug",
        "code": "code",
        "code_verifier": "code_verifier"
    }
```