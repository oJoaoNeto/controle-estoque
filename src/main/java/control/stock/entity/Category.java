package control.stock.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int category_id;

  @Column(nullable = false, unique = true)
  private String name;

  @OneToMany(
    targetEntity = Product.class,
    mappedBy = "category"
  )
  private List<Product> products = new ArrayList<>();

  private String description;
}
