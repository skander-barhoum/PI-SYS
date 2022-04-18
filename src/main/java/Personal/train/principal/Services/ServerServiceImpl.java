package Personal.train.principal.Services;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Personal.train.principal.Model.Server;
import Personal.train.principal.Model.Status;
import Personal.train.principal.Repository.ServerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements IserverServerImpl {

	private final ServerRepository sr;

	public Server create(Server server) {
		log.info("Saving new Server : {}" , server.getName());
		server.setImageURL(setServerimageURL());
		return sr.save(server);
	}

	public Server ping(String ipAddress) throws IOException {

		log.info("Pinging an ipAddress : {}" , ipAddress);
		Server server = sr.findByIpAddress(ipAddress);
		InetAddress address = InetAddress.getByName(ipAddress);
		server.setStatus(address.isReachable(100000) ? Status.SERVER_UP:  Status.SERVER_DOWN);
		sr.save(server);
		return null;
	}

	private String setServerimageURL() {
		return null;
	}

	public Collection<Server> list(int limit) {
		log.info("Fetching all Servers");

		return sr.findAll(PageRequest.of(0 ,limit)).toList();
	}

	public Server get(Long id) {
		log.info("Fetching Server By Id :{}", id);
		return sr.findById(id).get();


	}

	public Server update(Server server) {
		log.info("update Server:{}", server.getName());

		return sr.save(server);
	}

	public Boolean delete(Long id) {
		log.info("Delete Server:{}", id);

		sr.deleteById(id);
		return Boolean.TRUE;
	}

}
