package spring.springboot.JPAExercise;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository receives an Entity class and its index type
public interface UserRepository extends JpaRepository<User, String> {

}
