package Personal.train.principal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Personal.train.principal.Model.Server;
import java.lang.String;
@Repository
public interface ServerRepository extends JpaRepository<Server, Long>{
	Server findByIpAddress(String ipaddress);
}
