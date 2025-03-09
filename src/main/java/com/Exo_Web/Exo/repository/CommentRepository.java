package com.Exo_Web.Exo.repository;

import com.Exo_Web.Exo.entity.Comment;
import com.Exo_Web.Exo.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String> {

}
