Link collection Postman per test WS:
https://www.getpostman.com/collections/1aaf6541e76485e8cdf2


Esempio Oauth2

Url:
http://websystique.com/spring-security/secure-spring-rest-api-using-oauth2/

Test(usando postman):
1. post => http://localhost:8080/oauth/token?grant_type=password&username=user&password=user
 => ottengo un token
	 {
	    "access_token": "2eeff66d-831c-4a0f-a81b-cd09cbc39274",
	    "token_type": "bearer",
	    "refresh_token": "a01f33f1-510c-421e-be92-79a7c9f604da",
	    "expires_in": 119,
	    "scope": "read write trust"
	}
	
2. per richieste successive
 - richiedo url servizio
 - invio header 'Authorization' con valore 'bearer {TOKEN}'
 