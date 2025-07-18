package br.com.biblioteca.generic;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import jakarta.ws.rs.QueryParam;
import lombok.Data;

@Data
public class PaginacaoDTO {

    @QueryParam("currentPage")
    private int currentPage;

    @QueryParam("pageSize")
    private int pageSize;

    @QueryParam("fielOrder")
    private int fielOrder;

    @QueryParam("typeOrder")
    private int typeOrder;

    private Iterable<?> data;

    public PaginacaoDTO() {
        this.currentPage = 1;
        this.pageSize = 20;
    }

    public PaginacaoDTO(PanacheQuery<?> result, PaginacaoDTO paginacaoDTO) {
        result.page(Page.of(paginacaoDTO.getCurrentPage() -1, paginacaoDTO.getPageSize()));

        if (result.list().isEmpty() || result.pageCount() == 0) {
            result.page(Page.of(0, paginacaoDTO.getPageSize()));
        }

        this.data = result.list();

    }
}
