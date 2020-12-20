package ku.ac.th.billbroweb.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ku.ac.th.billbroweb.model.Captain;

import java.util.List;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Integer> {
    List<Captain> findBycUsername(String c_username);
}
