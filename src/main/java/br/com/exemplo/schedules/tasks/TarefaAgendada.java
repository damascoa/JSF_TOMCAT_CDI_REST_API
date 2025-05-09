package br.com.exemplo.schedules.tasks;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.time.LocalDateTime;

@Named
@Dependent
public class TarefaAgendada implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("[TarefaAgendada] Executada em: " + LocalDateTime.now());

        // Exemplo: lógica real aqui, como enviar e-mails, limpar registros, etc.
    }
}