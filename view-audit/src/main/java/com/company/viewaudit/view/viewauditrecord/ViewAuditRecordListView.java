package com.company.viewaudit.view.viewauditrecord;

import com.company.viewaudit.entity.ViewAuditRecord;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "viewAuditRecords", layout = DefaultMainViewParent.class)
@ViewController("va_ViewAuditRecord.list")
@ViewDescriptor("view-audit-record-list-view.xml")
@LookupComponent("viewAuditRecordsDataGrid")
@DialogMode(width = "64em")
public class ViewAuditRecordListView extends StandardListView<ViewAuditRecord> {
}