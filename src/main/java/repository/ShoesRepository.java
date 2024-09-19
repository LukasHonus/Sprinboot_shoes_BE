package repository;



import com.example.demo.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShoesRepository extends JpaRepository<Shoes, Long>, JpaSpecificationExecutor<Shoes> {
}