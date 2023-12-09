package com.inventory.productInventory.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GERADOR_SQ_CATEGORY")
    @SequenceGenerator(sequenceName = "category_sq", allocationSize = 1, name = "GERADOR_SQ_CATEGORY")
    private Long id;

    @Column(name="NAME", nullable = false)
    @Size(max = 50)
    private String name;

    @Column(name = "TYPE", nullable = false)
    private Integer type;

    @OneToMany
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "ID_CATEGORY")
    @JsonManagedReference
    private List<Product> products;
}
