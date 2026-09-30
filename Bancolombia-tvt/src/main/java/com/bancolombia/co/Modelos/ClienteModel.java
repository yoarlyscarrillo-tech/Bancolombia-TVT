package com.bancolombia.co.Modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteModel {

    private String documento;
    private String tipoBusqueda;
}