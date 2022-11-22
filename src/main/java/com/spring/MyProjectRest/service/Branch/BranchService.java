package com.spring.MyProjectRest.service.Branch;

import com.spring.MyProjectRest.entity.Branch;

import java.util.List;

public interface BranchService {

    public List<Branch> findAll();

    public Branch findById(int id);

    public void addBranch(Branch Branch);

    public void delete(int id);
}
