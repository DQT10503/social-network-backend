package com.source_interaction.domain.react;

import com.source_interaction.utils.enummerate.ReactionType;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class TblLikeCreateRequest {
    @ApiModelProperty(value = "Loại cảm xúc")
    @NotNull
    private ReactionType reactionType;

    public ReactionType getReactionType() {
        return reactionType;
    }

    public void setReactionType(ReactionType reactionType) {
        this.reactionType = reactionType;
    }
}
