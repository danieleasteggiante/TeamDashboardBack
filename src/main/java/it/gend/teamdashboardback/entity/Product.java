package it.gend.teamdashboardback.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Daniele Asteggiante
 */

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product")
public class Product implements Serializable {
    @Id
    private long id;
    private String name;
    private String description;
    @ManyToOne()
    @JsonBackReference
    private Team team;

}
