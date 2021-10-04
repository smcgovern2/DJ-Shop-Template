package wctc.edu.djshoptemplate.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private Double price;
    @Column(name="description")
    private String description;
    @Column(name="inventory")
    private int inventory;
    @Column(name="image_file_name")
    private String imageFileName;
}
