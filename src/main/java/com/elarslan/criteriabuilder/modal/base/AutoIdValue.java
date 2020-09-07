package com.elarslan.criteriabuilder.modal.base;


import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@MappedSuperclass
public class AutoIdValue {

    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected Long id;


}
