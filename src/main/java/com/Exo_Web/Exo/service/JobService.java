package com.Exo_Web.Exo.service;

import com.Exo_Web.Exo.dto.request.JobCreationRequest;
import com.Exo_Web.Exo.dto.request.JobUpdateRequest;
import com.Exo_Web.Exo.dto.response.JobResponse;
import com.Exo_Web.Exo.entity.Job;
import com.Exo_Web.Exo.mapper.JobMapper;
import com.Exo_Web.Exo.repository.JobRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JobService {
    JobRepository jobRepository;
    JobMapper jobMapper;

    public JobResponse createJobRequest(JobCreationRequest request) {

        Job job = jobMapper.toJob(request);
        job = jobRepository.save(job);
        JobResponse response = jobMapper.toJobResponse(job);
        return response;

    }

    public List<JobResponse> getAllJob() {
        log.info("getAllJob");
        return jobRepository.findAll().stream()
                .map(jobMapper::toJobResponse).toList();
    }
    public void deleteJob(String jobId){
        if(!jobRepository.existsById(jobId)){
            throw new RuntimeException("Job not found");
        }

        jobRepository.deleteById(jobId);
    }

    @Transactional
    public JobResponse updateJob(JobUpdateRequest request , String jobId){
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("job not found"));
        jobMapper.updatejob(job,request);
        return jobMapper.toJobResponse(jobRepository.save(job));

    }
}
