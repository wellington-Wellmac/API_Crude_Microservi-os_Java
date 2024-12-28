@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criarPedido(Pedido pedido) {
        pedido.setDataCriacao(LocalDateTime.now());
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> listarPedidosPorUsuario(Long usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId);
    }

    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    @Autowired
    private PagamentoFeignClient pagamentoFeignClient;

    public Pedido criarPedidoComPagamento(Pedido pedido) {
        Pedido novoPedido = criarPedido(pedido);
        Pagamento pagamento = new Pagamento();
        pagamento.setPedidoId(novoPedido.getId());
        pagamento.setValor(novoPedido.getTotal());
        pagamento.setMetodoPagamento("Cartão");
        pagamentoFeignClient.processarPagamento(pagamento);
        return novoPedido;
    }

}
