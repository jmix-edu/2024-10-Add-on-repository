package com.company.viewaudit.security;

import com.company.viewaudit.entity.ViewAuditRecord;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "ViewAuditAccessRole", code = ViewAuditAccessRole.CODE, scope = "UI")
public interface ViewAuditAccessRole {
    String CODE = "view-audit-access-role";

    @MenuPolicy(menuIds = "va_ViewAuditRecord.list")
    @ViewPolicy(viewIds = {"va_ViewAuditRecord.list", "va_ViewAuditRecord.detail"})
    void screens();

    @EntityAttributePolicy(entityClass = ViewAuditRecord.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = ViewAuditRecord.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.DELETE})
    void viewAuditRecord();
}