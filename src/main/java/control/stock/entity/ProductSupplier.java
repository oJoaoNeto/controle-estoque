package control.stock.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "product_supplier")
public class ProductSupplier {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int product_supplier_id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @ManyToOne(optional = false)
    @JoinColumn(name = "supplier_id", nullable = false)
  private Supplier supplier;

  @Column(nullable = false)
  private int buy_price;

  @Column(nullable = false)
  private int lead_time;

  @Column(nullable = false)
  private int minimal_qtd;
  
}
