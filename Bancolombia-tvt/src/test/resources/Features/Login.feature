# language: es
Característica: Login y búsqueda de cliente en TVT

  @test0
  Escenario: Buscar cliente por Número de identificación
    Dado Ingresamos a la url de TVT
    Cuando Realizamos login en TVT
    Entonces Validamos inicio de sesion exitoso

  @test1
  Escenario: Buscar cliente por Número de identificación
    Dado Ingresamos a la url de TVT
    Cuando Realizamos login en TVT
    Cuando Damos clic en buscar cliente
    Entonces Validamos inicio de sesion exitoso
    Cuando Buscamos cliente con documento 30203 y tipo "Numero de identificacion"

  @test2
  Escenario: Buscar cliente por Id caso
    Dado Ingresamos a la url de TVT
    Cuando Realizamos login en TVT
    Entonces Validamos inicio de sesion exitoso
    Cuando Buscamos cliente con documento 123456 y tipo Id caso

  @test3
  Escenario: Buscar cliente por Id bloque
    Dado Ingresamos a la url de TVT
    Cuando Realizamos login en TVT
    Entonces Validamos inicio de sesion exitoso
    Cuando Buscamos cliente con documento 789012 y tipo Id bloque

