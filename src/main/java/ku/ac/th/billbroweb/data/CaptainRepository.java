package ku.ac.th.billbroweb.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ku.ac.th.billbroweb.model.Captain;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Integer> {
    Optional<Captain> findBycUsername(String c_username);
}
