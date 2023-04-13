package com.project.d11.mapper;


import com.project.d11.jpa.entities.ContestEntity;
import com.project.d11.models.request.CreateContestRequest;
import com.project.d11.models.response.CreateContestResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContestMapper {
ContestEntity map(CreateContestRequest createContestRequest);

CreateContestResponse map(ContestEntity contestEntity);
}
