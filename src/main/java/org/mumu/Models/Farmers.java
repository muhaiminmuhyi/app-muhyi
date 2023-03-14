package org.mumu.Models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Farmers extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    public String komoditas;

    public Integer total;

    public LocalDate createdAt;

    public LocalDate updatedAt;

}
