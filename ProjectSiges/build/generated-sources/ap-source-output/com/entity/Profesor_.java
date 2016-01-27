package com.entity;

import com.entity.Facultad;
import com.entity.Familia;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-26T16:39:57")
@StaticMetamodel(Profesor.class)
public class Profesor_ { 

    public static volatile SingularAttribute<Profesor, Integer> celularProfesor;
    public static volatile SingularAttribute<Profesor, String> correoProfesor;
    public static volatile SingularAttribute<Profesor, String> apellidomaternoProfesor;
    public static volatile CollectionAttribute<Profesor, Familia> familiaCollection;
    public static volatile SingularAttribute<Profesor, String> apellidopaternoProfesor;
    public static volatile SingularAttribute<Profesor, Facultad> idFacultad;
    public static volatile SingularAttribute<Profesor, Integer> codigoProfesor;
    public static volatile SingularAttribute<Profesor, Long> cedulaProfesor;
    public static volatile SingularAttribute<Profesor, Date> fechanacimientoProfesor;
    public static volatile SingularAttribute<Profesor, String> nombreProfesor;
    public static volatile SingularAttribute<Profesor, String> sexoProfesor;
    public static volatile SingularAttribute<Profesor, Integer> telefonoProfesor;

}