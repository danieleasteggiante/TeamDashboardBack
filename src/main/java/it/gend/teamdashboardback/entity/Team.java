package it.gend.teamdashboardback.entity;

/**
 * @author Daniele Asteggiante
 */

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "team")
public class Team {
    @Id
    private long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "team")
    @JsonManagedReference
    private Set<Member> members;
    @OneToMany(mappedBy = "team")
    private Set<Product> products;

}
