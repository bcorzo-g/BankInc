
package bank.inc.app.persistencia.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import bank.inc.app.persistencia.entidades.Producto;

public interface ProductoDAO extends JpaRepository<Producto, Integer>{
    
}
