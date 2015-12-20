package com.entity;

import com.entity.Profesor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-12-20T18:02:11")
@StaticMetamodel(Facultad.class)
public class Facultad_ { 

    public static volatile SingularAttribute<Facultad, String> nombreFacultad;
    public static volatile CollectionAttribute<Facultad, Profesor> profesorCollection;
    public static volatile SingularAttribute<Facultad, Integer> idFacultad;

}