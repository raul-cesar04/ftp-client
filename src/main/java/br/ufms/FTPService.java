package br.ufms;

import org.apache.commons.net.ftp.FTPClient;

public class FTPService {
    public FTPClient loginFtp(String host, int port, String username, String password) throws Exception {
        FTPClient client = new FTPClient();

        // Command Listener
        client.addProtocolCommandListener(new CommandListener());

        // Conecta e loga no servidor FTP
        client.connect(host, port);
        client.login(username, password);
        return client;
    }
}
