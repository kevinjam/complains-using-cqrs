package com.kevinjanvier.democomplaints.repository;

import com.kevinjanvier.democomplaints.entity.ComplaintQueryObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintQueryObjectRepository extends JpaRepository<ComplaintQueryObject, String> {
}
