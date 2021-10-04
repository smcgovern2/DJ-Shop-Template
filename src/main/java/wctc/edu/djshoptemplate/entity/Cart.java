package wctc.edu.djshoptemplate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Data
public class Cart {

    private List<CartItem> cartItemList = new ArrayList<CartItem>();

}
