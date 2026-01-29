package control.stock.entity; 


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "product")
public class Product{
  @Id
  @GeneratedValue(strategy = GenerationType.UUID) 
  private UUID product_id;
  
  @Column(nullable = false)
  private String name;
  
  @Column(nullable = false, unique = true)
  private String sku;
 
  @ManyToOne(optional = false)
  @JoinColumn(name = "category_id", nullable = false)
  private Category category;

  @OneToMany(targetEntity = ProductSupplier.class, mappedBy = "product")
  private List<ProductSupplier> price_table = new ArrayList<>();

  private float weight;

  private String location;

  private int minstock;

  private boolean active;

  private Timestamp created_at;
  
  private Timestamp updated_at;
}
