package part2.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import part2.domain.Student;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {
    List<Student> findByName(String name);
    Student findByPhone(String phone);
    @Query("{'address.city' : ?0}")
    List<Student> findStudentFromCity(String city);
}
