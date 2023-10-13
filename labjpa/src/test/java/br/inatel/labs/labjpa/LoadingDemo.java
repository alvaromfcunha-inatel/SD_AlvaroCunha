package br.inatel.labs.labjpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.service.NotaCompraService;

@SpringBootTest
public class LoadingDemo {
  @Autowired
  private NotaCompraService notaCompraService;

  @Test
  public void demoPlanejantoCosulta() {
    try {
      NotaCompra nota = notaCompraService.buscarNotaCompraPeloIdComListaItem(1L);
      List<NotaCompraItem> listaNotaCompraItem = nota.getListaNotaCompraItem();

      listaNotaCompraItem.forEach(System.out::println);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void demoLazyLoading() {
    try {
      Optional<NotaCompra> opNota = notaCompraService.buscarNotaCompraPeloid(1L);

      if(opNota.isPresent()) {
        NotaCompra nota = opNota.get();
        int nItems = nota.getListaNotaCompraItem().size();
        System.out.println(nItems);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void demoEagerLoading() {
    try {
      Optional<NotaCompraItem> opItem = notaCompraService.buscarNotaCompraItemPeloId(1L);
      
      if(opItem.isPresent()) {
        NotaCompraItem item = opItem.get();
        LocalDate dataEmissao = item.getNotaCompra().getDataEmissao();
        System.out.println(dataEmissao);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}