package br.com.exemplo.schedules;

import br.com.exemplo.schedules.tasks.TarefaAgendada;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuartzStartup {

    @PostConstruct
    public void init() {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            JobDetail job = JobBuilder.newJob(TarefaAgendada.class)
                    .withIdentity("job1").build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?")) // a cada 1 minuto
                    .build();

            scheduler.scheduleJob(job, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
