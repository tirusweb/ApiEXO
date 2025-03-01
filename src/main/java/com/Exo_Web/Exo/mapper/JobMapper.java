package com.Exo_Web.Exo.mapper;


import com.Exo_Web.Exo.dto.request.ContactCreationRequest;
import com.Exo_Web.Exo.dto.request.ContactUpdateRequest;
import com.Exo_Web.Exo.dto.request.JobCreationRequest;
import com.Exo_Web.Exo.dto.request.JobUpdateRequest;
import com.Exo_Web.Exo.dto.response.ContactResponse;
import com.Exo_Web.Exo.dto.response.JobResponse;
import com.Exo_Web.Exo.entity.Contact;
import com.Exo_Web.Exo.entity.Job;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface JobMapper {
    Job toJob(JobCreationRequest jobCreationRequest);
    JobResponse toJobResponse(Job job);
    void updatejob(@MappingTarget Job job , JobUpdateRequest request);

}
