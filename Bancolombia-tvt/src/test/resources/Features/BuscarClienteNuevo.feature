# language: es
Característica: Buscar cliente nuevo y crear venta

  @test2
  Escenario: crear caso cliente nuevo seleccionando PCRC
    Dado Ingresamos a la url de TVT
    Cuando Realizamos login en TVT
    Cuando Damos clic en buscar cliente
    Entonces Validamos inicio de sesion exitoso
    Cuando Buscamos cliente no existente numero de consulta y Número de identificación
    Y seleccionamos PCRC y creamos nueva venta