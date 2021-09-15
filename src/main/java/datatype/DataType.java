package datatype;

import io.cucumber.java.DataTableType;
import models.newRequest;
import models.body.AuthorizationBody;


import java.util.Map;


public class DataType {

    @DataTableType
    public newRequest request(Map<String,String> datos){
        AuthorizationBody authorizationBody = new AuthorizationBody(datos.get("usuario"),datos.get("contrasena"));
        return new newRequest(datos.get("url"),authorizationBody,datos.get("respuestaEsperada"));
    }

}
