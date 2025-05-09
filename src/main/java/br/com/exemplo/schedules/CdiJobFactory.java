package br.com.exemplo.schedules;

import org.quartz.spi.TriggerFiredBundle;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.Job;

import javax.enterprise.inject.spi.CDI;

public class CdiJobFactory implements JobFactory {

    @Override
    public Job newJob(TriggerFiredBundle bundle, Scheduler scheduler) throws SchedulerException {
        try {
            // Obtém a classe do Job
            Class<? extends Job> jobClass = bundle.getJobDetail().getJobClass();
            // Pede para o CDI instanciar o Job (com injeções funcionando)
            return CDI.current().select(jobClass).get();
        } catch (Exception e) {
            throw new SchedulerException("Falha ao criar job com CDI", e);
        }
    }
}