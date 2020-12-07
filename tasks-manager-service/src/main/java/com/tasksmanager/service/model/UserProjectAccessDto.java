package com.tasksmanager.service.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Project access dto model.
 *
 * @author SIE
 */
public class UserProjectAccessDto {

    private String id;

    @NotBlank
    private String projectId;

    @NotBlank
    private String userId;

    @NotNull
    private Boolean isOwner;

    @NotNull
    private Boolean canSeeTeam;

    @NotNull
    private Boolean canSeeProject;

    @NotNull
    private Boolean canEditProject;

    @NotNull
    private Boolean canSeeOtherTasks;

    @NotNull
    private Boolean canAddTasks;

    @NotNull
    private Boolean canDeleteTasks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "UserProjectAccessDto{" +
            "id='" + id + '\'' +
            ", projectId='" + projectId + '\'' +
            ", userId='" + userId + '\'' +
            ", isOwner=" + isOwner +
            ", canSeeTeam=" + canSeeTeam +
            ", canSeeProject=" + canSeeProject +
            ", canEditProject=" + canEditProject +
            ", canSeeOtherTasks=" + canSeeOtherTasks +
            ", canAddTasks=" + canAddTasks +
            ", canDeleteTasks=" + canDeleteTasks +
            '}';
    }
}
