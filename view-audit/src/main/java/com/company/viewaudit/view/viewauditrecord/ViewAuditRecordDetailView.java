package com.company.viewaudit.view.viewauditrecord;

import com.company.viewaudit.entity.ViewAuditRecord;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "viewAuditRecords/:id", layout = DefaultMainViewParent.class)
@ViewController("va_ViewAuditRecord.detail")
@ViewDescriptor("view-audit-record-detail-view.xml")
@EditedEntityContainer("viewAuditRecordDc")
public class ViewAuditRecordDetailView extends StandardDetailView<ViewAuditRecord> {
}