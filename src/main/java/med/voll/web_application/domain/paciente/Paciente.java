package med.voll.web_application.domain.paciente;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    public Paciente(DadosCadastroPaciente dados) {
        atualizarDados(dados);
    }

    public Paciente(Long idUsuario, DadosCadastroPaciente dados) {
        this.id = idUsuario;
        atualizarDados(dados);
    }

    public void atualizarDados(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }
}