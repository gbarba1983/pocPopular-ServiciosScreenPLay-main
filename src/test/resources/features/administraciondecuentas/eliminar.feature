Feature: administrar el proceso de generacion de token, creacion, autenticacion, consulta y eliminacion de cuentas
  Yo Como usuario de Tools QA
  quiero administrar el proceso de generacion de token, creacion, autenticacion, consulta y eliminacion de cuentas
  para validar el consumo exitoso de un servicio

  @EliminarCuentaExistenteDeFormaExitosa
  Scenario Outline: Eliminar cuenta existente de forma exitosa
    Given el usuario carga la informacion de la url
      |url   | usuario   | contrasena   | respuestaEsperada |
      |<url> | <usuario> | <contrasena> | <respuestaEsperada>|
    When se realiza la elimnacion
    Then el obtiene una respuesta exitosa
    Examples: Datos de eliminacion
      | url                                                                     | tipoAutenticacion | token                                                                                                                                                                           | respuestaEsperada |usuario        | contrasena|
      | /Account/v1/GenerateToken | Bearer Token      | eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IlBydWViYVNlcnZpY2lvIiwicGFzc3dvcmQiOiJQcnVlYmExMjMqIiwiaWF0IjoxNjIxOTAxNjgxfQ.7UqGVFTQAL53Kun5LMjS-V33istsaWEOZM95gbizjug | 204               | PruebaServicio | Prueba123* |
