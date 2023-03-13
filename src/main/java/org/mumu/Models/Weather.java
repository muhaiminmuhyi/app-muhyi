package org.mumu.Models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "weather")
@NamedQuery(name = "Weather.findall", query = "select w.city, w.date, w.time from Weather w", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
@Cacheable
public class Weather extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;


    public String city;
    public Integer tempLow;
    public Integer tempHigh;
    public float humidity;
    public float windSpeed;
    public float windBearing;
    public float visibility;
    public LocalDate date;
    public LocalTime time;

    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category category;

    @ManyToOne
    @JoinColumn(name = "summary_id")
    public Summary summary;
}
