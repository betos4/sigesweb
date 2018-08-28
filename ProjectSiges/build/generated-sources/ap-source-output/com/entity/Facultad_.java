package com.entity;

import com.entity.Profesor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-28T12:23:41")
@StaticMetamodel(Facultad.class)
public class Facultad_ { 

    public static volatile SingularAttribute<Facultad, String> nombreFacultad;
    public static volatile SingularAttribute<Facultad, String> contrasenia;
    public static volatile CollectionAttribute<Facultad, Profesor> profesorCollection;
    public static volatile SingularAttribute<Facultad, String> rol;
    public static volatile SingularAttribute<Facultad, Integer> idFacultad;

}