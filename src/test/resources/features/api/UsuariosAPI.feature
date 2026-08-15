# language: es

Característica: Gestión de Usuarios en API Reqres

  Antecedentes:
    Dado que el usuario configura la base url del servicio de Reqres

  @api @post @smoke
  Esquema del escenario: Validacion del metodo POST para creacion de usuarios
    Cuando el usuario envia una solicitud POST con el nombre "<nombre>" y trabajo "<trabajo>"
    Entonces el servicio deberia responder con el codigo de estado <codigo_respuesta>

    Ejemplos:
      | nombre    | trabajo             | codigo_respuesta |
      | Test User | Automation Engineer | 201              |

  @api @get @smoke
  Esquema del escenario: Validacion del metodo GET para consulta de usuarios
    Cuando el usuario realiza una solicitud GET para consultar el ID recien creado
    Entonces el servicio deberia responder con el codigo de estado <codigo_respuesta>
    Y el cuerpo de la respuesta debe contener el nombre "<nombre>" y el trabajo "<trabajo>"

    Ejemplos:
      | nombre    | trabajo             | codigo_respuesta |
      | Test User | Automation Engineer | 200              |