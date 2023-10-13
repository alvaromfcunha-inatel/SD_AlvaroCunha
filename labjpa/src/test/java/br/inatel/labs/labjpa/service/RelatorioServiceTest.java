package br.inatel.labs.labjpa.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO;

@SpringBootTest
public class RelatorioServiceTest {
  @Autowired
  private RelatorioService relatorioService;

  @Test
  void test() {
    List<TotalCompradoPorFornecedorDTO> listaDTO = relatorioService.pesquisarTotalCompradoPorFornecedor();

    assertFalse(listaDTO.isEmpty());

    listaDTO.forEach(System.out::println);
  }
}