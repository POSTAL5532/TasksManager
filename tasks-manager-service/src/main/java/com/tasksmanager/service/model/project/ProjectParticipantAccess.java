package com.tasksmanager.service.model.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.tasksmanager.service.model.AbstractEntity;

/**
 * Project participant access model.
 *
 * @author SIE
 */
@Entity
@Table(name = "project_participant_access")
public class ProjectParticipantAccess extends AbstractEntity {

    @Column(name = "project_id")
    private String projectId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "is_owner")
    private Boolean isOwner;

    @Column(name = "can_see_team")
    private Boolean canSeeTeam;

    @Column(name = "can_see_project")
    private Boolean canSeeProject;

    @Column(name = "can_edit_project")
    private Boolean canEditProject;

    @Column(name = "can_see_other_tasks")
    private Boolean canSeeOtherTasks;

    @Column(name = "can_edit_other_tasks")
    private Boolean canEditOtherTasks;

    @Column(name = "can_add_tasks")
    private Boolean canAddTasks;

    @Column(name = "can_delete_tasks")
    private Boolean canDeleteTasks;

    public ProjectParticipantAccess() {
        super();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean isOwner() {
        return isOwner;
    }

    public void setIsOwner(Boolean owner) {
        isOwner = owner;
    }

    public Boolean canSeeTeam() {
        return canSeeTeam;
    }

    public void setCanSeeTeam(Boolean canSeeTeam) {
        this.canSeeTeam = canSeeTeam;
    }

    public Boolean canSeeProject() {
        return canSeeProject;
    }

    public void setCanSeeProject(Boolean canSeeProject) {
        this.canSeeProject = canSeeProject;
    }

    public Boolean canEditProject() {
        return canEditProject;
    }

    public void setCanEditProject(Boolean canEditProject) {
        this.canEditProject = canEditProject;
    }

    public Boolean canSeeOtherTasks() {
        return canSeeOtherTasks;
    }

    public void setCanSeeOtherTasks(Boolean canSeeOtherTasks) {
        this.canSeeOtherTasks = canSeeOtherTasks;
    }

    public Boolean canEditOtherTasks() {
        return canEditOtherTasks;
    }

    public void setCanEditOtherTasks(Boolean canEditOtherTasks) {
        this.canEditOtherTasks = canEditOtherTasks;
    }

    public Boolean canAddTasks() {
        return canAddTasks;
    }

    public void setCanAddTasks(Boolean canAddTasks) {
        this.canAddTasks = canAddTasks;
    }

    public Boolean canDeleteTasks() {
        return canDeleteTasks;
    }

    public void setCanDeleteTasks(Boolean canDeleteTasks) {
        this.canDeleteTasks = canDeleteTasks;
    }

    @Override
    public String toString() {
        return "ProjectParticipantAccess{" +
            "projectId='" + projectId + '\'' +
            ", userId='" + userId + '\'' +
            ", isOwner=" + isOwner +
            ", canSeeTeam=" + canSeeTeam +
            ", canSeeProject=" + canSeeProject +
            ", canEditProject=" + canEditProject +
            ", canSeeOtherTasks=" + canSeeOtherTasks +
            ", canEditOtherTasks=" + canEditOtherTasks +
            ", canAddTasks=" + canAddTasks +
            ", canDeleteTasks=" + canDeleteTasks +
            ", id='" + id + '\'' +
            '}';
    }
}
