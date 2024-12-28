@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Autenticação fictícia
        if ("user".equals(loginRequest.getUsername()) && "password".equals(loginRequest.getPassword())) {
            return jwtService.gerarToken(loginRequest.getUsername());
        }
        throw new RuntimeException("Credenciais inválidas");
    }
}
