import org.example.SegurancaNegocio;
import org.example.InterfaceNegocio;
import org.example.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TesteProxySeguranca {

    @Test
    public void testeAutorizaAcesso() {
        Usuario alisson = new Usuario("Alisson");
        alisson.autorizaAcesso("InterfaceNegocio", "ExecutaTransacao");
        NegocioMock mock = new NegocioMock();
        InterfaceNegocio n = new SegurancaNegocio(mock, alisson);
        n.executaTransacao();
        assertTrue(mock.isFoiAcessado());
    }
    @Test
    public void testeNaoAutorizaAcesso() {
        Usuario alisson = new Usuario("Alisson");
        alisson.autorizaAcesso("InterfaceNegocio", "executaTransacao");
        NegocioMock mock = new NegocioMock();
        InterfaceNegocio n = new SegurancaNegocio(mock, alisson);
        try {
            n.cancelaTransacao();
            fail();
        } catch (Exception e) {
            assertFalse(mock.isFoiAcessado());
        }
    }
}
