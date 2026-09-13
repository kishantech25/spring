package com.kishan.ecom.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String brand;
    @Column
    private BigDecimal price;
    @Column
    private String category;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private Date releaseDate;
    @Column
    private boolean productAvailable;
    @Column
    private int stockQuantity;
    @Column
    private String imageName;
    @Column
    private String imageType;
    @Lob
    private byte[] imageData;


}
