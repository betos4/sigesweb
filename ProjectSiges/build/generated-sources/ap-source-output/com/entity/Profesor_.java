package com.entity;

import com.entity.Facultad;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "EclipseLink-2.5.0.v20130507-rNA", date = "2015-10-17T23:39:56")
@StaticMetamodel(Profesor.class)
public class Profesor_ {

    public static volatile SingularAttribute<Profesor, Integer> celularProfesor;
    public static volatile SingularAttribute<Profesor, String> correoProfesor;
    public static volatile SingularAttribute<Profesor, Facultad> idFacultad;
    public static volatile SingularAttribute<Profesor, Long> cedulaProfesor;
    public static volatile SingularAttribute<Profesor, String> apellidoProfesor;
    public static volatile SingularAttribute<Profesor, String> nombreProfesor;
    public static volatile SingularAttribute<Profesor, Date> fechanacimientoProfesor;
    public static volatile SingularAttribute<Profesor, Integer> telefonoProfesor;
}