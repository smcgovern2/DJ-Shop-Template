package wctc.edu.djshoptemplate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name="cart_item")
public class CartItem {
    @Id
    @Column(name="item_id")
    private int itemID;
    @Column(name="quantity")
    private int quantity;
}
