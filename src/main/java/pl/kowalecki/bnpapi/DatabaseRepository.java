package pl.kowalecki.bnpapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.kowalecki.bnpapi.model.ComputersModel;

import java.util.List;

public interface DatabaseRepository extends JpaRepository<ComputersModel, Integer> {

    @Query(value = "SELECT * FROM computer", nativeQuery = true)
    List<ComputersModel> findComputersModelMyImplementation();
}
