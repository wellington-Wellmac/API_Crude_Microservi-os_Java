@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public Pagamento processarPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.processarPagamento(pagamento);
    }

    @GetMapping
    public List<Pagamento> listarPagamentos() {
        return pagamentoService.listarPagamentos();
    }

    @GetMapping("/{id}")
    public Pagamento buscarPagamentoPorId(@PathVariable Long id) {
        return pagamentoService.buscarPagamentoPorId(id);
    }

    @PutMapping("/{id}/status")
    public void atualizarStatusPagamento(@PathVariable Long id, @RequestBody String status) {
        pagamentoService.atualizarStatusPagamento(id, status);
    }
}
