# language: es

Necesidad del negocio: Iniciar Sesion

  Antecedentes:
    Dado que el usuario navega a la pagina de inicio

  Esquema del escenario: Iniciar Sesion - Exitoso
    Cuando el usuario intenta iniciar sesion con el usuario "<usuario>"
    Entonces el cliente deberia visualizar el mensaje "<mensaje>"
    @smoke
    Ejemplos:
      | usuario       | mensaje  |
      | standard_user | Products |

  Esquema del escenario: Iniciar Sesion - Contraseña Incorrecta - No Exitoso
    Cuando el usuario intenta iniciar sesion con el usuario "<usuario>" y contraseña "<contrasenia>"
    Entonces el cliente deberia visualizar el mensaje "<mensaje>"
    @smoke
    Ejemplos:
      | usuario       | contrasenia|mensaje                                                                    |
      | standard_user |   pruebas  |Epic sadface: Username and password do not match any user in this service  |

  Esquema del escenario: Iniciar Sesion - Validar Campos Obligatorios - No Exitoso
    Cuando el usuario intenta iniciar sesion con el usuario "<usuario>" y contraseña "<contrasenia>"
    Entonces el cliente deberia visualizar el mensaje "<mensaje>"
    @smoke
    Ejemplos:
      | usuario        | contrasenia|mensaje                            |
      |                |            |Epic sadface: Username is required |
      | standard_user  |            |Epic sadface: Password is required |
      |                |pruebas     |Epic sadface: Username is required |
