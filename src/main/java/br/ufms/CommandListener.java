package br.ufms;

import org.apache.commons.net.ProtocolCommandEvent;
import org.apache.commons.net.ProtocolCommandListener;

public class CommandListener implements ProtocolCommandListener {
    @Override
    public void protocolCommandSent(ProtocolCommandEvent protocolCommandEvent) {
        System.out.printf("[%s][%d] Comando enviado: [%s]-%s\n", Thread.currentThread().getName(), System.currentTimeMillis(), protocolCommandEvent.getCommand(), protocolCommandEvent.getMessage());
    }

    @Override
    public void protocolReplyReceived(ProtocolCommandEvent protocolCommandEvent) {
        System.out.printf("[%s][%d] Comando recebido: [%s]-%s\n", Thread.currentThread().getName(), System.currentTimeMillis(), protocolCommandEvent.getCommand(), protocolCommandEvent.getMessage());
    }
}
