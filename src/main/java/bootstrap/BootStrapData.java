package bootstrap;

import domain.Divulgacao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import repository.DivulgacaoRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final DivulgacaoRepository divulgacaoRepository;

    public BootStrapData(DivulgacaoRepository divulgacaoRepository) {
        this.divulgacaoRepository = divulgacaoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Divulgacao evento1 = new Divulgacao("Evento 1", "Primeiro Evento de Verificação",
                0,9,1,1,2022,
                0,15,1,1,2022);

        System.out.println("Started in bootstrap.");
    }
}
