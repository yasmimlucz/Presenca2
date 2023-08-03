package com.MundoSenai.Presenca.Service;

import com.MundoSenai.Presenca.Model.M_Pessoa;
import com.MundoSenai.Presenca.Repository.R_Pessoa;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class S_Pessoa {
    private static R_Pessoa r_pessoa;

    public S_Pessoa(R_Pessoa r_pessoa) {
        this.r_pessoa = r_pessoa;
    }

    public static M_Pessoa getPessoaLogin(String usuario, String senha) {
        return r_pessoa.findByUsuarioESenha(Long.valueOf(usuario), senha);
    }

    public static String cadastrarPessoas(String nome, String email,
                                          String cpf, String telefone, String data_nasc,
                                          String senha, String confisenha) {
        if(!senha.equals(confisenha)) {
            return "A senha e a confirmação de senha devem ser iguais";
        } else if (!CpfValidator.validarCPF(cpf)) {
            return "CPF invalido";
        } else if ((nome == null || nome.trim() == "") &&
                (NumberCleaner.cleanNumber(telefone) == null || NumberCleaner.cleanNumber(telefone).trim() == "")){
        }
        else{
            M_Pessoa m_pessoa = new M_Pessoa();
            m_pessoa.setNome(nome);
            m_pessoa.setCpf(Long.valueOf(cpf));
            m_pessoa.setTelefone(Long.valueOf(telefone));
            m_pessoa.setEmail(email);
            m_pessoa.setData_nasc(LocalDate.parse(data_nasc));
            m_pessoa.setSenha(senha);
            r_pessoa.save(m_pessoa);
        }
        return"Cadastro efetuado com sucesso";
    }
}