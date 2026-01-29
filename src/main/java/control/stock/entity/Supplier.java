package control.stock.entity;

import java.sql.Timestamp;
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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "supplier")
@Entity
public class Supplier {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int supplier_id;
  
  @Column(nullable = false)
  private String Name;

  @Column(unique = true, nullable = true,length = 14)
  private String cnpj;

  @Column(unique = true, nullable = false, length = 14)
  private String phone;

  @Column(unique = true, nullable = false)
  private String email;

  @Column(unique = true, length = 9)
  private String cep;
  
  private String adress;

  private boolean active;

  private Timestamp created_at;

  private Timestamp updated_at;

  @OneToMany(targetEntity = ProductSupplier.class, mappedBy = "supplier")
  private List<ProductSupplier> price_table = new ArrayList<>();
}
