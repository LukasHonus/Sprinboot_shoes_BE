package Service;

import com.example.demo.Shoes;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import repository.ShoesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShoesService {

    private final ShoesRepository shoeRepository;

    public ShoesService(ShoesRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }
    public List<Shoes> searchShoes(String filter, String value) {
        Specification<Shoes> specification = (root, query, criteriaBuilder) -> {
            if (filter == null || value == null) {
                return null;
            }

            Predicate predicate = criteriaBuilder.like(criteriaBuilder.lower(root.get(filter)), "%" + value.toLowerCase() + "%");
            return predicate;
        };
        return shoeRepository.findAll(specification);
    }

    public List<Shoes> getAllShoes() {
        return shoeRepository.findAll();
    }

    public Optional<Shoes> getShoeById(Long id) {
        return shoeRepository.findById(id);
    }

    public Shoes saveShoe(Shoes shoe) {
        return shoeRepository.save(shoe);
    }

    public Shoes updateShoe(Shoes shoe) {
        return shoeRepository.save(shoe);
    }

    public void deleteShoeById(Long id) {
        shoeRepository.deleteById(id);
    }
}
