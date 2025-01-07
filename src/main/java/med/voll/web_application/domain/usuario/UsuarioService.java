package med.voll.web_application.domain.usuario;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmailIgnoreCase(username)
                .orElseThrow(() -> new UsernameNotFoundException("O usuário não foi encontrado."));
    }

    public Long salvar(String nome, String email, String senha) {
        String senhaCriptografada = encoder.encode(senha);
        Usuario usuario = repository.save(new Usuario(nome, email, senhaCriptografada));
        return usuario.getId();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
