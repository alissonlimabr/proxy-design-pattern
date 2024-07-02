package org.example;

import org.example.InterfaceNegocio;

public class SegurancaNegocio implements InterfaceNegocio {

    private InterfaceNegocio encapsulado;
    private Usuario u;

    public SegurancaNegocio(InterfaceNegocio encapsulado, Usuario u) {
        this.encapsulado = encapsulado;
        this.u = u;
    }

    @Override
    public void executaTransacao() {
        if(u.verificaPermissao("InterfaceNegocio", "executaTransacao")) {
            encapsulado.executaTransacao();
        } else {
            throw new RuntimeException("Usuario nao tem permissao para executar transacao");
        }
    }

    @Override
    public void cancelaTransacao() {
        if(u.verificaPermissao("InterfaceNegocio", "cancelaTransacao")) {
            encapsulado.cancelaTransacao();
        } else {
            throw new RuntimeException("Usuario nao tem permissao para cancelar transacao");
        }
    }
}
