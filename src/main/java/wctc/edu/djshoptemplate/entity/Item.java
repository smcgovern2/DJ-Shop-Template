package wctc.edu.djshoptemplate.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name="Item")
public class Item {

    @Id
    @Column(name="item_id")
    private int id;
    @Column(name="Name")
    private String name;
    @Column(name="price")
    private int price;
    @Column(name="description")
    private String description;
    @Column(name="image_file_name")
    private String imageFileName;
}
