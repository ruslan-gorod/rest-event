package com.epam.v2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "places")
public class Place {
    public static String COMMA_SEPARATOR = ", ";
    @Id
    private Long id;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String building;

    @Column
    private String zipCode;

    @OneToOne(mappedBy = "eventPlace")
    private EventFull event;

    @Override
    public String toString() {
        return zipCode +
                COMMA_SEPARATOR + city +
                COMMA_SEPARATOR + street +
                COMMA_SEPARATOR + building;
    }
}
