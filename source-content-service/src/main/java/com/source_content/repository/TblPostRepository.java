package com.source_content.repository;

import com.source_content.entity.TblPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblPostRepository extends JpaRepository<TblPost, Long> {
}