@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento processarPagamento(Pagamento pagamento) {
        pagamento.setStatus("PENDENTE");
        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> listarPagamentos() {
        return pagamentoRepository.findAll();
    }

    public Pagamento buscarPagamentoPorId(Long id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
    }

    public void atualizarStatusPagamento(Long id, String status) {
        Pagamento pagamento = buscarPagamentoPorId(id);
        pagamento.setStatus(status);
        pagamentoRepository.save(pagamento);
    }
}
