package com.card.backend.model.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;


@MappedSuperclass
public abstract class BaseEntityModel implements Serializable {

        @CreatedDate
        @Column(name = "created_date")
        protected LocalDate createdDate;

        @Column(name = "last_updated_date")
        protected LocalDate lastUpdatedDate;

}
