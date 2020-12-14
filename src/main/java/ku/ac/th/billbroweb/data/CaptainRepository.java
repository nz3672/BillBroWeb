package ku.ac.th.billbroweb.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ku.ac.th.billbroweb.model.Captain;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Integer> {
}
