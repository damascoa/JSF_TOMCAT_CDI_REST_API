package br.com.exemplo.config;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StartupBean {

    @PostConstruct
    public void init() {
        System.out.println("🚀 Projeto inicializado: executando lógica de inicialização...");

        // Chame seus métodos aqui
        configurarAgendamentos();
        verificarConexoes();
        carregarDadosPadrao();
    }

    private void configurarAgendamentos() {
        System.out.println("Configurando Quartz ou outras tarefas...");
    }

    private void verificarConexoes() {
        System.out.println("Verificando conexões com serviços externos...");
    }

    private void carregarDadosPadrao() {
        System.out.println("Carregando dados padrão na aplicação...");
    }
}
