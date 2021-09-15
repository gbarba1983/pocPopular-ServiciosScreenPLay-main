Feature: administrar en el proceso la autorizacion de cuentas
  Yo Como usuario de Tools QA
  quiero administrar en el proceso la autorizacion de cuentas
  para validar el consumo exitoso del servicio

  @AutorizedExitosa
  Scenario Outline: Autorizacion exitosa de una cuenta
    Given el usuario carga la informacion de la url
      |url   | usuario   | contrasena   | respuestaEsperada |
      |<url> | <usuario> | <contrasena> | <respuestaEsperada>|
    When el ingresa los datos
    Then el obtiene una respuesta exitosa
    Examples: Datos de autenticacion
      | url                                      | usuario        | contrasena | respuestaEsperada |
      | /Account/v1/Authorized | PruebaServicio | Prueba123* | 200               |
      | /Account/v1/Authorized | PruebaServicio | Prueba123* | 200               |


