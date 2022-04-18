package Personal.train.principal.Services;

import java.io.IOException;
import java.util.Collection;

import Personal.train.principal.Model.Server;

public interface IserverServerImpl {
	Server create (Server server);
	Collection <Server> list (int limit);
	Server ping (String ipAddress) throws IOException;
	Server get (Long id);
	Server update (Server server);
	Boolean delete (Long id);
}
