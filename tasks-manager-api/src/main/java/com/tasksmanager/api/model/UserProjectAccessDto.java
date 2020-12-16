package com.tasksmanager.api.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Project access dto model.
 *
 * @author SIE
 */
@Getter
@Setter
@ToString
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
}
