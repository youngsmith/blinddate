package com.yom.blinddate.model.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "farm")
public class Farm extends AuditBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String owner;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "farm")
    //@JoinColumn(name = "id")
    private List<Animal> animals = new ArrayList<>();

    @Override
    public String toString() {
        return "Farm{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", owner='" + owner + '\'' +
            ", animals=" + animals +
            '}';
    }
}
