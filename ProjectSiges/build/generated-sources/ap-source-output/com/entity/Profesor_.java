package com.entity;

import com.entity.Facultad;
import com.entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-05T10:38:38")
@StaticMetamodel(Profesor.class)
public class Profesor_ { 

    public static volatile SingularAttribute<Profesor, String> direccion;
    public static volatile SingularAttribute<Profesor, String> nombres;
    public static volatile SingularAttribute<Profesor, Usuario> usuario;
    public static volatile SingularAttribute<Profesor, Facultad> facultad;
    public static volatile SingularAttribute<Profesor, Integer> codigoProfesor;
    public static volatile SingularAttribute<Profesor, String> apellidoPaterno;
    public static volatile SingularAttribute<Profesor, String> apellidoMaterno;
    public static volatile SingularAttribute<Profesor, String> sexo;
    public static volatile SingularAttribute<Profesor, Date> fechaNacimiento;
    public static volatile SingularAttribute<Profesor, Integer> cedula;
    public static volatile SingularAttribute<Profesor, String> correo;

}