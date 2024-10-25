package com.company.viewaudit.listener;

import com.company.viewaudit.annotation.IgnoreViewAudit;
import com.company.viewaudit.entity.ViewAuditRecord;
import io.jmix.core.DataManager;
import io.jmix.core.security.SystemAuthenticator;
import io.jmix.core.usersubstitution.CurrentUserSubstitution;
import io.jmix.flowui.event.view.ViewOpenedEvent;
import io.jmix.flowui.view.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.*;

@Component
public class ViewOpenedListener implements ApplicationListener<ViewOpenedEvent> {

    private static final Logger log = LoggerFactory.getLogger(ViewOpenedListener.class);
    private final DataManager dataManager;
    private final CurrentUserSubstitution currentUserSubstitution;
    private final SystemAuthenticator systemAuthenticator;

    public ViewOpenedListener(DataManager dataManager, CurrentUserSubstitution currentUserSubstitution, SystemAuthenticator systemAuthenticator) {
        this.dataManager = dataManager;
        this.currentUserSubstitution = currentUserSubstitution;
        this.systemAuthenticator = systemAuthenticator;
    }

    @Override
    public void onApplicationEvent(ViewOpenedEvent event) {
        View<?> openedView = event.getSource();

        log.info("View opened:{}", openedView.getId());
        UserDetails userDetails = currentUserSubstitution.getEffectiveUser();
        if(openedView.getClass().getAnnotation(IgnoreViewAudit.class) == null) {
            createAndSaveRecord(event, userDetails);
        }
    }

    private void createAndSaveRecord(ViewOpenedEvent event, UserDetails userDetails) {
        systemAuthenticator.begin();
        try {

            ViewAuditRecord record = dataManager.create(ViewAuditRecord.class);

            record.setViewId(event.getSource().getId().orElse(event.getClass().getSimpleName()));

            Instant instant = Instant.now();
            ZoneId systemZone = ZoneId.systemDefault();
            ZoneOffset currentOffsetForSystemZone = systemZone.getRules().getOffset(instant);

            record.setAccessingTimestamp(OffsetDateTime.of(LocalDate.now(), LocalTime.now(), currentOffsetForSystemZone));
            record.setUsername(userDetails.getUsername());

            dataManager.save(record);
        } finally {
            systemAuthenticator.end();
        }
    }
}
