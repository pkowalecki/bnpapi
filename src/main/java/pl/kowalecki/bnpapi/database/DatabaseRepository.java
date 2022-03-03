package pl.kowalecki.bnpapi.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.kowalecki.bnpapi.model.ComputersModel;

import java.util.List;

public interface DatabaseRepository extends JpaRepository<ComputersModel, Integer> {

    @Query("SELECT c FROM ComputersModel c WHERE c.name LIKE %?1% OR c.dateAccounting LIKE %?1%")
    List<ComputersModel> search(String name);

}
