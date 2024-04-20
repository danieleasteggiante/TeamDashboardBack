package it.gend.teamdashboardback.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Set;
/**
 * @author Daniele Asteggiante
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "table_row")
public class TableRow {
    @Id
    long id;
    LocalDate date;
    String branch;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "table_row_product_version",
            joinColumns = @JoinColumn(name = "table_row_id"),
            inverseJoinColumns = @JoinColumn(name = "product_version_id"))
    Set<ProductVersion> productVersions;
    ReleaseLocation releaseLocation;
}
