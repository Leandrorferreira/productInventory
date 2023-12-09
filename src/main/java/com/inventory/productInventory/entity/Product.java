package com.inventory.productInventory.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GERADOR_SQ_PRODUCT")
    @SequenceGenerator(sequenceName = "product_sq", allocationSize = 1, name = "GERADOR_SQ_PRODUCT")
    private Long id;

    @Column(name="NAME", nullable = false)
    @Size(max = 50)
    private String name;

    @Column(name = "DESCRIPTION")
    @Size(max = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORY", referencedColumnName = "ID")
    @JsonBackReference
    private Category category;
}
