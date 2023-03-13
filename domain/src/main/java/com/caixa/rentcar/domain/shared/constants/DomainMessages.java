package com.caixa.rentcar.domain.shared.constants;

public class DomainMessages {
    private DomainMessages(){};

    public static final String KEY_NOT_FOUND ="Criterio de búsqueda no encontrado";
    public static final String FILE_EMPTY ="No se encontraron registros para la entidad requerida";
    public static final int OPERATION_OK_CODE =200;
    public static final int OPERATION_KO_CODE =400;
    public static final String OPERATION_OK_TEXT ="Success";
    public static final String OPERATION_KO_TEXT ="Failured";
    public static final String CLIENT_ALREADY_EXISTS ="El Dni ya se encuentra registrado";

    public static final String UNAVAILABLE_CAR_TEXT ="Los siguientes coches no se encuentran disponibles: ";
    public static final String UNKNOWN_CAR_TEXT ="Los siguientes coches no se encuentra en el inventario: ";
    public static final String DUPLICATED_CAR_TEXT ="Los siguientes coches está dulicados en la petición recibida: ";
    public static final String UNKNOWN_CLIENT_TEXT ="Los siguientes dni no se encuentra registrados: ";
    public static final String RENTCAR_ORDER_NOT_FOUND ="El coche no se encuentra en una orden abierta: ";
    public static final String DATES_DIFF_KO ="La fechas indicadas no es posible culminar la operación: ";
    public static final String NEW_RENTAR_ORDER ="OPENNED";
    public static final String CLOSE_RENTCAR_ORDER ="CLOSED";

}
