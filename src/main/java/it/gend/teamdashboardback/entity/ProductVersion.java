package it.gend.teamdashboardback.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author Daniele Asteggiante
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product_version")
public class ProductVersion implements Serializable {
    @Id
    long id;
    @ManyToOne
    @JsonManagedReference
    Product product;
    String version;
    String description;
    Boolean active;
    @ManyToOne
    @JsonManagedReference
    Team team;
    @ManyToOne
    TableRow tableRow;
}
